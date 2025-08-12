/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectofinalhelado;

import com.sun.jdi.connect.spi.Connection;
import java.util.List;

import java.sql.SQLException;

public class HeladoCono extends Producto {
    private final List<String> sabores;
    private final String tamaño;
    private final List<String> toppings;

    public HeladoCono(List<String> sabores, String tamaño, List<String> toppings, int cantidad) {
        super(String.join(" ", sabores), cantidad);
        this.sabores = sabores;
        this.tamaño = tamaño;
        this.toppings = toppings;
    }

    @Override
    public int calcularPrecio(Connection con) throws SQLException {
        int precio = 0;

       
        for (String sabor : sabores) {
            precio += NewJFrame.obtenerPrecioDesdeDB((java.sql.Connection) con, sabor);
        }

      
        switch (tamaño) {
            case "Pequeño" -> precio += 0;
            case "Mediano" -> precio += 35;
            case "Grande" -> precio += 50;
        }

        
        for (String topping : toppings) {
            precio += NewJFrame.obtenerPrecioDesdeDB((java.sql.Connection) con, "Topping " + topping);
        }

     
        return precio * cantidad;
    }

    public String getTamaño() {
        return tamaño;
    }

    public String getToppingsDescripcion() {
        return String.join(" ", toppings);
    }
}