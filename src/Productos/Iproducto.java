/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Productos;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author domif
 */
public interface Iproducto {
    
     String getNombre();
    int getCantidad();
    int calcularPrecio(Connection con) throws SQLException;
    
}
