/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectofinalhelado;


import conexionBD.ConexionDB;
import java.sql.*;
import java.util.List;

/**
 *
 * @author domif
 */
public class PedidoDao {
  public int insertarPedido(String cliente) throws SQLException {
        int idPedido = -1;
        String sql = "INSERT INTO pedido (cliente, estado) VALUES (?, 'Pendiente')";
        try (Connection con = (Connection) ConexionDB.conectar();
             PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, cliente);
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                idPedido = rs.getInt(1);
            }
        }
        return idPedido;
    }

    public void insertarDetalle(int idPedido, DetallePedido detalle) throws SQLException {
        String sql = "INSERT INTO detalle_pedido (id_pedido, producto, cantidad, precio) VALUES (?, ?, ?, ?)";
        try (Connection con = ConexionDB.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idPedido);
           // ps.setString(2, detalle.getProducto().getNombre());
           // ps.setInt(3, detalle.getCantidad());
            
            
          //  ps.setDouble(4, detalle.getProducto().getPrecio());
          
          
          
            ps.executeUpdate();
        }
    }

    public void insertarDetalles(int idPedido, List<DetallePedido> detalles) throws SQLException {
        for (DetallePedido d : detalles) {
            insertarDetalle(idPedido, d);
        }
    }

    int insertarPedido(Pedido pedidoActual) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    void actualizarTotal(int idPedido, double total) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}