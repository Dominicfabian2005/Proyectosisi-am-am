/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package conexionBD;

import java.sql.Connection;


/**
 *
 * @author domif
 */

public class TestConexion {
    public static void main(String[] args) {
        try {
            Connection con = ConexionDB.conectar();
            if (con != null) {
                System.out.println("¡Todo listo para trabajar con la base de datos!");
            } else {
                System.out.println("No se pudo establecer la conexión.");
            }
        } catch (Exception e) {
            System.err.println("ERROR al conectar:");
        }
    }
}