/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexionBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author domif
 */
public class ConexionDB {

    private static final String URL = "jdbc:mysql://localhost:3306/heladeria";
    private static final String USER = "root";
    private static final String PASSWORD = "Bel.ua205";

    public static Connection conectar() {
        Connection con = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Muy importante
            con = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexión exitosa a la base de datos heladeria.");
        } catch (ClassNotFoundException e) {
            System.err.println("Error: No se encontró el driver JDBC.");
        } catch (SQLException e) {
            System.err.println("Error al conectar con la base de datos:");
        }

        return con;
    }
}