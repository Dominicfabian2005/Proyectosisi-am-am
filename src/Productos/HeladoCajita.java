/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Productos;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author 20242260
 */


public class HeladoCajita extends Producto{
       private final List<String> sabores;
    private final String tamaño;
    private final List<String> toppings;

    public HeladoCajita(List<String> sabores, String tamaño, List<String> toppings, int cantidad) {
        super(String.join(" ", sabores), cantidad); // Guarda la cantidad en Producto
        this.sabores = sabores;
        this.tamaño = tamaño;
        this.toppings = toppings;
    }

    @Override
    public int calcularPrecio(Connection con) throws SQLException {
        ProductoDao dao = new ProductoDao();
        int precio = 0;

        // Precio por sabores
        for (String sabor : sabores) {
            precio += dao.obtenerPrecioDesdeDB(con, sabor);
        }

        // Precio por tamaño
        switch (tamaño) {
            case "Pequeño" -> precio += 0;
            case "Mediano" -> precio += 35;
            case "Grande" -> precio += 50;
        }

        // Precio por toppings
        for (String topping : toppings) {
            precio += dao.obtenerPrecioDesdeDB(con, "Topping " + topping);
        }

        return precio * cantidad; // Multiplica por la cantidad
    }

    public String getTamaño() {
        return tamaño;
    }

    public String getToppingsDescripcion() {
        return String.join(" ", toppings);
    }
   
}
