/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectofinalhelado;

import com.sun.jdi.connect.spi.Connection;
import java.sql.SQLException;

/**
 *
 * @author domif
 */

   public  abstract class Producto {
  
    protected String nombre;
    protected int cantidad;

    public abstract int calcularPrecio(Connection con) throws SQLException;
    
    public Producto() {
    }

    public Producto(String nombre, int cantidad) {
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    int calcularPrecio(java.sql.Connection con) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    

  
} 

