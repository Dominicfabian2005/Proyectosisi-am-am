/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EmpleadoPack;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author domif
 */
public class UsuarioDao {
     private final  Connection conexion;

    public UsuarioDao(Connection conexion) {
        this.conexion = conexion;
    }

    public Usuario login(String correo, String contrasena) {
        Usuario usuario = null;
        String sql = "SELECT u.*, e.nombre FROM Usuario u " +
                     "JOIN Empleado e ON u.idEmpleado = e.idEmpleado " +
                     "WHERE u.correo = ? AND u.contrasena = ?";

       try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, correo);
            stmt.setString(2, contrasena);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    usuario = new Usuario();
                    usuario.setIdUsuario(rs.getInt("idUsuario"));
                    usuario.setCorreo(rs.getString("correo"));
                    usuario.setContrasena(rs.getString("contrasena"));
                    usuario.setRol(rs.getString("rol"));
                    usuario.setIdEmpleado(rs.getInt("idEmpleado"));
                   
                }
            }

        } catch (SQLException e) {
        }

        return usuario;
    }
}