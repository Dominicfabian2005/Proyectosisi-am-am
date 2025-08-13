/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectofinalhelado;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



/**
 *
 * @author domif
 */
public class ProductoDao {
    public int obtenerPrecioDesdeDB(Connection con, String nombreProducto) throws SQLException {
        String sql = "SELECT precio FROM producto WHERE nombre = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, nombreProducto);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("precio");
                }
            }
        }
        return 0;
    }

    public void restarInventario(Connection con, String nombreProducto, int cantidad) throws SQLException {
        String sql = "UPDATE producto SET stock = stock - ? WHERE nombre = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, cantidad);
            ps.setString(2, nombreProducto);
            ps.executeUpdate();
        }
    }

}
