/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectofinalhelado;

import com.sun.jdi.connect.spi.Connection;
import java.sql.SQLException;
/**
 *
 * @author 20242260
 */

public class HeladoPaleta extends Producto {
   public HeladoPaleta(String sabor, int cantidad) {
        super(sabor, cantidad);
    }

    @Override
    public int calcularPrecio(Connection con) throws SQLException {
      
        return NewJFrame.obtenerPrecioDesdeDB((java.sql.Connection) con, nombre) * cantidad;
    }
}

