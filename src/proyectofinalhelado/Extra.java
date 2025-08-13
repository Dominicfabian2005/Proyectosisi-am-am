/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectofinalhelado;

/**
 *
 * @author domif
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class Extra extends Producto{
     public Extra(String nombre, int cantidad) {
        super(nombre, cantidad);
    }

    @Override
    public int calcularPrecio(Connection con) throws SQLException {
        ProductoDao dao = new ProductoDao();
        return dao.obtenerPrecioDesdeDB(con, nombre) * cantidad;
    }
}
