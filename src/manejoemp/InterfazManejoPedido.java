/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package manejoemp;

import manejoemp.InterfazAgregarProducto;
import manejoemp.AgregarProveedor;
import manejoemp.AgregarProducto;
import EmpleadoPack.LoginEmpleado;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.io.IOException;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AbstractDocument.Content;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
import conexionBD.ConexionDB;


import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


import javax.swing.Timer;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.*;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;

import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.TableModelEvent;
import javax.swing.table.TableColumn;


/**
 *
 * @author domif
 */
public class InterfazManejoPedido extends javax.swing.JFrame {

   private TableRowSorter<DefaultTableModel> sorterProveedores;
private TableRowSorter<DefaultTableModel> sorterProductos;
    private Timer refrescoTimer;
private final int INTERVALO_MS = 5000;
    /**
     * Creates new form InterfazManejoPedido
     */
    public InterfazManejoPedido() {
        initComponents();
         configurarSelectionListener();
    cargarPedidos();        // carga inicial
    // si quieres cargar detalles del primer pedido por defecto:
    if (jTablePedidos.getRowCount() > 0) {
        jTablePedidos.setRowSelectionInterval(0, 0);
    }
    iniciarRefrescoAutomatico();
    
    
    TableColumn colEstado = jTablePedidos.getColumnModel().getColumn(4);
        JComboBox<String> comboEstado = new JComboBox<>(new String[]{"Pendiente", "Procesando", "Entregado"});
        colEstado.setCellEditor(new DefaultCellEditor(comboEstado));
        
        
 DefaultTableModel modelo = (DefaultTableModel) jTablePedidos.getModel();

modelo.addTableModelListener(e -> {
    if (e.getType() == TableModelEvent.UPDATE) {
        int fila = e.getFirstRow();
        int columna = e.getColumn();

        // Cambia 4 por el índice correcto en tu modelo
        if (columna == 4) {
            String nuevoEstado = modelo.getValueAt(fila, columna).toString();
            int idPedido = Integer.parseInt(modelo.getValueAt(fila, 0).toString());

            // Actualizar en la BD
            actualizarEstadoEnBD(idPedido, nuevoEstado);

           
        }
    }
});
       
    }

    
  
    
    private void cargarPedidos() {
    DefaultTableModel model = (DefaultTableModel) jTablePedidos.getModel();

    // Guardar id seleccionado actual (si hay)
    int filaSeleccionada = jTablePedidos.getSelectedRow();
    int idSeleccionado = -1;
    if (filaSeleccionada >= 0) {
        Object val = jTablePedidos.getValueAt(filaSeleccionada, 0);
        if (val != null) {
            try { idSeleccionado = Integer.parseInt(val.toString()); } catch (NumberFormatException ex) { idSeleccionado = -1; }
        }
    }

    model.setRowCount(0); // limpiar

    String sql = "SELECT id_pedido, cliente, fecha, total, estado " +
             "FROM pedido " +
             "WHERE estado IN ('Pendiente', 'Procesando') " +
             "ORDER BY id_pedido DESC";
    
    try (Connection conn = ConexionDB.conectar();
         PreparedStatement ps = conn.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {

        while (rs.next()) {
            int idPedido = rs.getInt("id_pedido");
            String cliente = rs.getString("cliente");
            Date fecha = rs.getDate("fecha");
             double total = rs.getDouble("total");
            String estado = rs.getString("estado");

            model.addRow(new Object[]{idPedido, cliente, fecha,total, estado});
            
         
        }

    } catch (SQLException e) {
        // Manejo de error
        System.err.println("Error al cargar pedidos: " + e.getMessage());
    }

 
    if (idSeleccionado != -1) {
        for (int r = 0; r < jTablePedidos.getRowCount(); r++) {
            Object v = jTablePedidos.getValueAt(r, 0);
            if (v != null) {
                try {
                    int id = Integer.parseInt(v.toString());
                    if (id == idSeleccionado) {
                        jTablePedidos.setRowSelectionInterval(r, r);
                       
                        jTablePedidos.scrollRectToVisible(jTablePedidos.getCellRect(r, 0, true));
                        break;
                    }
                } catch (NumberFormatException ex) { /* ignorar */ }
            }
        }
    }
}
    
    
    
    
    private void cargarDetalles(int idPedido) {
    DefaultTableModel model = (DefaultTableModel) jTableDetalles.getModel();
    model.setRowCount(0);

    String sql = "SELECT producto, cantidad, tamaño, sabor, topping, subtotal " +
                 "FROM detalle_pedido WHERE id_pedido = ?";

    try (Connection conn = ConexionDB.conectar();
         PreparedStatement ps = conn.prepareStatement(sql)) {

        ps.setInt(1, idPedido);
        try (ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                String producto = rs.getString("producto");
                 int cantidad = rs.getInt("cantidad");
                String tamaño = rs.getString("tamaño");
                String sabor = rs.getString("sabor");
                String topping = rs.getString("topping");
               
                double subtotal = rs.getDouble("subtotal");

                model.addRow(new Object[]{producto, cantidad, tamaño, sabor, topping, subtotal});
            }
        }

    } catch (SQLException e) {
        System.err.println("Error al cargar detalles: " + e.getMessage());
    }
}
    
    private void configurarSelectionListener() {
    jTablePedidos.getSelectionModel().addListSelectionListener((ListSelectionEvent ev) -> {
        if (!ev.getValueIsAdjusting()) {
            int fila = jTablePedidos.getSelectedRow();
            if (fila >= 0) {
                Object val = jTablePedidos.getValueAt(fila, 0);
                if (val != null) {
                    try {
                        int idPedido = Integer.parseInt(val.toString());
                        cargarDetalles(idPedido);
                    } catch (NumberFormatException ex) { /* ignorar */ }
                }
            } else {
               
                ((DefaultTableModel) jTableDetalles.getModel()).setRowCount(0);
            }
        }
    });
}
   private void iniciarRefrescoAutomatico() {
    if (refrescoTimer != null && refrescoTimer.isRunning()) return;

    refrescoTimer = new Timer(INTERVALO_MS, e -> {
        // Actualiza pedidos; si hay selección, la restauración ya hará que se vuelvan a cargar los detalles
        cargarPedidos();

        // Si hay una fila seleccionada actual (después de reload), cargar detalles
        int fila = jTablePedidos.getSelectedRow();
        if (fila >= 0) {
            Object val = jTablePedidos.getValueAt(fila, 0);
            if (val != null) {
                try {
                    int idPedido = Integer.parseInt(val.toString());
                    cargarDetalles(idPedido);
                } catch (NumberFormatException ex) { /* ignorar */ }
            }
        }
    });

    refrescoTimer.start();
}

private void detenerRefrescoAutomatico() {
    if (refrescoTimer != null) {
        refrescoTimer.stop();
    }
} 



private boolean actualizarEstadoEnBD(int idPedido, String nuevoEstado) {

    int fila = tablaproveedor.getSelectedRow();
    if (fila >= 0) {
        int idProveedor = (int) tablaproveedor.getValueAt(fila, 0);
        String nombre = tablaproveedor.getValueAt(fila, 1).toString();
        String producto = tablaproveedor.getValueAt(fila, 2).toString();
        double precio = (double) tablaproveedor.getValueAt(fila, 3);
        String telefono = tablaproveedor.getValueAt(fila, 4).toString();

        // Puedes crear una nueva ventana o un cuadro de diálogo para la edición
        // Por ahora, lo haremos directamente en la base de datos
        // ... (Aquí iría la lógica para editar y actualizar en la BD)
        
        // Ejemplo de diálogo para actualizar
        String nuevoNombre = JOptionPane.showInputDialog(this, "Nuevo nombre:", nombre);
        if (nuevoNombre != null && !nuevoNombre.trim().isEmpty()) {
            actualizarProveedorEnBD(idProveedor, nuevoNombre, producto, precio, telefono);
            // Vuelve a cargar los datos después de actualizar
            try {
                mostrarProveedores();
            } catch (IOException ex) {
                Logger.getLogger(InterfazManejoPedido.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    } else {
        JOptionPane.showMessageDialog(this, "Seleccione un proveedor para actualizar.");
    }
       return false;
}

// Método para actualizar en la base de datos
private void actualizarProveedorEnBD(int id, String nombre, String producto, double precio, String telefono) {
    String sql = "UPDATE proveedores SET nombre = ?, producto = ?, precio = ?, telefono = ? WHERE id = ?";
    try (Connection con = ConexionDB.conectar();
         PreparedStatement ps = con.prepareStatement(sql)) {
        
        ps.setString(1, nombre);
        ps.setString(2, producto);
        ps.setDouble(3, precio);
        ps.setString(4, telefono);
        ps.setInt(5, id);
        
        int filasAfectadas = ps.executeUpdate();
        if (filasAfectadas > 0) {
            JOptionPane.showMessageDialog(this, "Proveedor actualizado correctamente.");
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this, "Error al actualizar proveedor: " + ex.getMessage());
    }
}










private void mostrarProveedores() throws IOException {
    DefaultTableModel modelo = new DefaultTableModel();
    modelo.addColumn("ID");
    modelo.addColumn("Nombre");
    modelo.addColumn("Producto");
    modelo.addColumn("Precio");
    modelo.addColumn("Teléfono");

    tablaproveedor.setModel(modelo);

    String sql = "SELECT * FROM proveedores";

    try {
        try (Connection con = (Connection) ConexionDB.conectar()) {
            if (con == null) {
                System.err.println("Conexión fallida.");
                return;
            }
            
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                
                while (rs.next()) {
                    Object[] fila = {
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("producto"),
                        rs.getDouble("precio"),
                        rs.getString("telefono")
                    };
                    modelo.addRow(fila);
                }
                
                rs.close();
            }
        }
 sorterProveedores = new TableRowSorter<>(modelo);
        tablaproveedor.setRowSorter(sorterProveedores);
    } catch (SQLException e) {
        System.err.println("Error al cargar proveedores: " + e.getMessage());
    }
}

    

/**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSlider1 = new javax.swing.JSlider();
        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        btnpedido = new javax.swing.JButton();
        btnproducto = new javax.swing.JButton();
        btninventario = new javax.swing.JButton();
        btnproveedores = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        Productos = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableproductos = new javax.swing.JTable();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        txtBuscarProducto = new javax.swing.JTextField();
        actualizarProducto = new javax.swing.JButton();
        borrarProducto = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        Inventario = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        Proveedores = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablaproveedor = new javax.swing.JTable();
        jButton7 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        btnagregarprov = new javax.swing.JButton();
        actualizarbtn = new javax.swing.JButton();
        borrarbtn = new javax.swing.JButton();
        Pedidos = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTablePedidos = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableDetalles = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 153, 102));

        btnpedido.setText("PEDIDOS");
        btnpedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpedidoActionPerformed(evt);
            }
        });

        btnproducto.setText("PRODUCTOS");
        btnproducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnproductoActionPerformed(evt);
            }
        });

        btninventario.setText("INVENTARIO");
        btninventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btninventarioActionPerformed(evt);
            }
        });

        btnproveedores.setText("PROVEEDORES");
        btnproveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnproveedoresActionPerformed(evt);
            }
        });

        jButton5.setText("SALIR");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnproveedores)
                    .addComponent(btninventario)
                    .addComponent(btnproducto)
                    .addComponent(btnpedido)
                    .addComponent(jButton5))
                .addContainerGap(13, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(btnpedido)
                .addGap(64, 64, 64)
                .addComponent(btnproducto)
                .addGap(57, 57, 57)
                .addComponent(btninventario)
                .addGap(76, 76, 76)
                .addComponent(btnproveedores)
                .addGap(64, 64, 64)
                .addComponent(jButton5)
                .addContainerGap(198, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 130, 640));
        jPanel3.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-30, 80, 740, 10));

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 153, 102));
        jLabel1.setText("SISTEMA HELADERIA BLIZZ- EMPLEADO");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, -1, -1));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 570, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 605, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("PEDIDOS", jPanel5);

        Productos.setBackground(new java.awt.Color(255, 255, 255));

        tableproductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "id", "nombre", "categoria", "precio"
            }
        ));
        jScrollPane2.setViewportView(tableproductos);

        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 153, 255));
        jLabel2.setText("Buscar 🔍:");

        jButton4.setText("AGREGAR +");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton8.setText("MOSTRAR PRODUCTOS");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        txtBuscarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarProductoActionPerformed(evt);
            }
        });

        actualizarProducto.setText("ACTUALIZAR");
        actualizarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualizarProductoActionPerformed(evt);
            }
        });

        borrarProducto.setText("BORRAR");
        borrarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borrarProductoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ProductosLayout = new javax.swing.GroupLayout(Productos);
        Productos.setLayout(ProductosLayout);
        ProductosLayout.setHorizontalGroup(
            ProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ProductosLayout.createSequentialGroup()
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 643, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(ProductosLayout.createSequentialGroup()
                .addGroup(ProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ProductosLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBuscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ProductosLayout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ProductosLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jButton4)
                        .addGap(18, 18, 18)
                        .addComponent(actualizarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(borrarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ProductosLayout.setVerticalGroup(
            ProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ProductosLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(ProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtBuscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(ProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(actualizarProducto)
                    .addComponent(borrarProducto))
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 469, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Productos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Productos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("PRODUCTOS", jPanel6);

        Inventario.setBackground(new java.awt.Color(255, 255, 255));

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "id", "Nombre", "Producto", "cantidad", "fecha_ingreso", "fecha_exp"
            }
        ));
        jScrollPane3.setViewportView(jTable3);

        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 153, 255));
        jLabel3.setText("Buscar:");

        jButton6.setText("AGREGAR +");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton2.setText("ACTUALIZAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("BORRAR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout InventarioLayout = new javax.swing.GroupLayout(Inventario);
        Inventario.setLayout(InventarioLayout);
        InventarioLayout.setHorizontalGroup(
            InventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InventarioLayout.createSequentialGroup()
                .addGroup(InventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 577, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(InventarioLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(InventarioLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(InventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(InventarioLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(86, 86, 86)
                                .addGroup(InventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addContainerGap(69, Short.MAX_VALUE))
        );
        InventarioLayout.setVerticalGroup(
            InventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InventarioLayout.createSequentialGroup()
                .addGroup(InventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(InventarioLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(InventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(InventarioLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                        .addComponent(jButton2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(62, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(Inventario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Inventario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("INVENTARIO", jPanel7);

        Proveedores.setBackground(new java.awt.Color(255, 255, 255));

        tablaproveedor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "id", "Nombre", "producto", "precio", "telefono"
            }
        ));
        jScrollPane4.setViewportView(tablaproveedor);

        jButton7.setText("AGREGAR +");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 153, 255));
        jLabel4.setText("BUSCAR:");

        txtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarActionPerformed(evt);
            }
        });

        btnagregarprov.setText("MOSTRAR PROVEEDORES");
        btnagregarprov.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnagregarprovActionPerformed(evt);
            }
        });

        actualizarbtn.setText("ACTUALIZAR");
        actualizarbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualizarbtnActionPerformed(evt);
            }
        });

        borrarbtn.setText("BORRAR");
        borrarbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borrarbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ProveedoresLayout = new javax.swing.GroupLayout(Proveedores);
        Proveedores.setLayout(ProveedoresLayout);
        ProveedoresLayout.setHorizontalGroup(
            ProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ProveedoresLayout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(ProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(ProveedoresLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(jButton7))
                    .addGroup(ProveedoresLayout.createSequentialGroup()
                        .addComponent(btnagregarprov)
                        .addGap(31, 31, 31)
                        .addComponent(actualizarbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(borrarbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(66, Short.MAX_VALUE))
        );
        ProveedoresLayout.setVerticalGroup(
            ProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ProveedoresLayout.createSequentialGroup()
                .addGroup(ProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ProveedoresLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(ProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ProveedoresLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton7)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(ProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnagregarprov)
                    .addComponent(actualizarbtn)
                    .addComponent(borrarbtn))
                .addContainerGap(189, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Proveedores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Proveedores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("PROVEEDORES", jPanel8);

        Pedidos.setBackground(new java.awt.Color(255, 255, 255));

        jTablePedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "id", "Cliente", "fecha", "total", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(jTablePedidos);

        jTableDetalles.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Producto", "cantidad", "Tamano", "Sabor", "Topping", "subtotal"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableDetalles);

        jLabel5.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 153, 255));
        jLabel5.setText("MANEJO DE PEDIDOS");

        jLabel6.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 153, 255));
        jLabel6.setText("DETALLES DEL PEDIDO SELECCIONADO");

        javax.swing.GroupLayout PedidosLayout = new javax.swing.GroupLayout(Pedidos);
        Pedidos.setLayout(PedidosLayout);
        PedidosLayout.setHorizontalGroup(
            PedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PedidosLayout.createSequentialGroup()
                .addGroup(PedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PedidosLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(PedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 522, Short.MAX_VALUE)
                            .addComponent(jScrollPane5)))
                    .addGroup(PedidosLayout.createSequentialGroup()
                        .addGap(153, 153, 153)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PedidosLayout.createSequentialGroup()
                        .addGap(204, 204, 204)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        PedidosLayout.setVerticalGroup(
            PedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PedidosLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addGap(19, 19, 19)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(70, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab5", Pedidos);

        jPanel3.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 90, 570, 640));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectofinalhelado/imagenn/Adobe_Express_-_file__1_-removebg-preview_1.png"))); // NOI18N
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, -20, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 847, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnpedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpedidoActionPerformed
       jTabbedPane1.setSelectedIndex(0);
    }//GEN-LAST:event_btnpedidoActionPerformed

    private void btnproveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnproveedoresActionPerformed
         jTabbedPane1.setSelectedIndex(3);
    }//GEN-LAST:event_btnproveedoresActionPerformed

    private void btnproductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnproductoActionPerformed
       jTabbedPane1.setSelectedIndex(1);
    }//GEN-LAST:event_btnproductoActionPerformed

    private void btninventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btninventarioActionPerformed
        jTabbedPane1.setSelectedIndex(2);
    }//GEN-LAST:event_btninventarioActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
          LoginEmpleado nuevaVentana = new LoginEmpleado();
    
    
    nuevaVentana.setVisible(true);
    
   
    this.dispose();      
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
   AgregarProveedor nuevaVentana = new AgregarProveedor();
    
    
    nuevaVentana.setVisible(true);       
    }//GEN-LAST:event_jButton7ActionPerformed

    private void btnagregarprovActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnagregarprovActionPerformed
        try {
            mostrarProveedores();
        } catch (IOException ex) {
            Logger.getLogger(InterfazManejoPedido.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnagregarprovActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
try {
    try (Connection con = ConexionDB.conectar()) {
        String sql = "SELECT * FROM producto";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("ID");
            model.addColumn("Nombre");
            model.addColumn("Categoría");
            model.addColumn("Precio");
            
            while (rs.next()) {
                Object[] fila = new Object[4];
                fila[0] = rs.getInt("id");
                fila[1] = rs.getString("nombre");
                fila[2] = rs.getString("categoria");
                fila[3] = rs.getString("precio");
                model.addRow(fila);
            }
            
            tableproductos.setModel(model);
            
            
            sorterProductos = new TableRowSorter<>(model);
            tableproductos.setRowSorter(sorterProductos);
            rs.close();
        }
    }
    
} catch (SQLException e) {
    JOptionPane.showMessageDialog(null, "Error al cargar los productos desde la base de datos.");
}


    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
         AgregarProducto nuevaVentana = new AgregarProducto();
    
    
    nuevaVentana.setVisible(true);
    
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
       InterfazAgregarProducto nuevaVentana = new InterfazAgregarProducto();
    
    
    nuevaVentana.setVisible(true);
    
    }//GEN-LAST:event_jButton6ActionPerformed

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        txtBuscar.getDocument().addDocumentListener(new DocumentListener() {
    @Override
    public void insertUpdate(DocumentEvent e) {
        filtrar();
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        filtrar();
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        filtrar();
    }

    private void filtrar() {
        String texto = txtBuscar.getText();
        if (texto.trim().length() == 0) {
            sorterProveedores.setRowFilter(null);
        } else {
            sorterProveedores.setRowFilter(RowFilter.regexFilter("(?i)" + texto));
        }
    }
});
    }//GEN-LAST:event_txtBuscarActionPerformed

    private void txtBuscarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarProductoActionPerformed
    txtBuscarProducto.getDocument().addDocumentListener(new DocumentListener() {
    @Override
    public void insertUpdate(DocumentEvent e) {
        filtrar();
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        filtrar();
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        filtrar();
    }

    private void filtrar() {
        String texto = txtBuscarProducto.getText();
        if (texto.trim().length() == 0) {
            sorterProductos.setRowFilter(null);
        } else {
            sorterProductos.setRowFilter(RowFilter.regexFilter("(?i)" + texto));
        }
    }
});
    }//GEN-LAST:event_txtBuscarProductoActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int fila = jTable3.getSelectedRow();
    if (fila >= 0) {
        int idInventario = (int) jTable3.getValueAt(fila, 0);
        // ... obtener otros datos de la fila ...
        
        // Lógica para actualizar en la base de datos
        // actualizarInventarioEnBD(idInventario, ...);
        
        JOptionPane.showMessageDialog(this, "Funcionalidad de actualizar inventario no implementada.");
    } else {
        JOptionPane.showMessageDialog(this, "Seleccione un item del inventario para actualizar.");
    }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void actualizarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualizarProductoActionPerformed
      int filaSeleccionada = tableproductos.getSelectedRow();
    
    if (filaSeleccionada != -1) {
        try {
            // Se obtienen los datos de la fila seleccionada
            int idProducto = Integer.parseInt(tableproductos.getValueAt(filaSeleccionada, 0).toString());
            String nuevoNombre = tableproductos.getValueAt(filaSeleccionada, 1).toString();
            String nuevaCategoria = tableproductos.getValueAt(filaSeleccionada, 2).toString();
            double nuevoPrecio = Double.parseDouble(tableproductos.getValueAt(filaSeleccionada, 3).toString());

            String sql = "UPDATE productos SET nombre = ?, categoria = ?, precio = ? WHERE id = ?";
            
            try (Connection con = ConexionDB.conectar();
                 PreparedStatement ps = con.prepareStatement(sql)) {
                
                ps.setString(1, nuevoNombre);
                ps.setString(2, nuevaCategoria);
                ps.setDouble(3, nuevoPrecio);
                ps.setInt(4, idProducto);

                int filasAfectadas = ps.executeUpdate();
                
                if (filasAfectadas > 0) {
                    JOptionPane.showMessageDialog(this, "Producto actualizado correctamente.");
                    mostrarProductos(); // Recarga la tabla para mostrar los cambios
                } else {
                    JOptionPane.showMessageDialog(this, "No se pudo actualizar el producto.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (SQLException | NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Error al actualizar el producto: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    } else {
        JOptionPane.showMessageDialog(this, "Por favor, seleccione una fila para actualizar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
    }
    }//GEN-LAST:event_actualizarProductoActionPerformed

    private void borrarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrarProductoActionPerformed
        int filaSeleccionada = tableproductos.getSelectedRow();
    if (filaSeleccionada != -1) {
        int confirmacion = JOptionPane.showConfirmDialog(this, "¿Está seguro de que desea borrar este producto?", "Confirmar Borrado", JOptionPane.YES_NO_OPTION);
        if (confirmacion == JOptionPane.YES_OPTION) {
            try {
                // Obtiene el ID del producto de la primera columna de la fila seleccionada.
                int idProducto = Integer.parseInt(tableproductos.getValueAt(filaSeleccionada, 0).toString());
                String sql = "DELETE FROM productos WHERE id = ?";
                try (Connection con = ConexionDB.conectar();
                     PreparedStatement ps = con.prepareStatement(sql)) {
                    ps.setInt(1, idProducto);
                    int filasAfectadas = ps.executeUpdate();
                    if (filasAfectadas > 0) {
                        JOptionPane.showMessageDialog(this, "Producto borrado correctamente.");
                        // Refresca la tabla para reflejar el cambio.
                        mostrarProductos();
                    }
                }
            } catch (SQLException | NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Error al borrar el producto: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    } else {
        JOptionPane.showMessageDialog(this, "Por favor, seleccione una fila para borrar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
    }
    }//GEN-LAST:event_borrarProductoActionPerformed

    private void actualizarbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualizarbtnActionPerformed
        int fila = tablaproveedor.getSelectedRow();
    if (fila >= 0) {
        int idProveedor = (int) tablaproveedor.getValueAt(fila, 0);
        String nombre = tablaproveedor.getValueAt(fila, 1).toString();
        String producto = tablaproveedor.getValueAt(fila, 2).toString();
        double precio = (double) tablaproveedor.getValueAt(fila, 3);
        String telefono = tablaproveedor.getValueAt(fila, 4).toString();

        // Puedes crear una nueva ventana o un cuadro de diálogo para la edición
        // Por ahora, lo haremos directamente en la base de datos
        // ... (Aquí iría la lógica para editar y actualizar en la BD)
        
        // Ejemplo de diálogo para actualizar
        String nuevoNombre = JOptionPane.showInputDialog(this, "Nuevo nombre:", nombre);
        if (nuevoNombre != null && !nuevoNombre.trim().isEmpty()) {
            actualizarProveedorEnBD(idProveedor, nuevoNombre, producto, precio, telefono);
            // Vuelve a cargar los datos después de actualizar
            try {
                mostrarProveedores();
            } catch (IOException ex) {
                Logger.getLogger(InterfazManejoPedido.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    } else {
        JOptionPane.showMessageDialog(this, "Seleccione un proveedor para actualizar.");
    }
    }//GEN-LAST:event_actualizarbtnActionPerformed

    private void borrarbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrarbtnActionPerformed
        int fila = tablaproveedor.getSelectedRow();
    if (fila >= 0) {
        int idProveedor = (int) tablaproveedor.getValueAt(fila, 0);
        int opcion = JOptionPane.showConfirmDialog(this, "¿Estás seguro de que deseas borrar este proveedor?", "Confirmar borrado", JOptionPane.YES_NO_OPTION);
        if (opcion == JOptionPane.YES_OPTION) {
            borrarProveedorEnBD(idProveedor);
            try {
                mostrarProveedores();
            } catch (IOException ex) {
                Logger.getLogger(InterfazManejoPedido.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    } else {
        JOptionPane.showMessageDialog(this, "Seleccione un proveedor para borrar.");
    }
}

// Método para borrar en la base de datos
private void borrarProveedorEnBD(int id) {
    String sql = "DELETE FROM proveedores WHERE id = ?";
    try (Connection con = ConexionDB.conectar();
         PreparedStatement ps = con.prepareStatement(sql)) {
        
        ps.setInt(1, id);
        int filasAfectadas = ps.executeUpdate();
        if (filasAfectadas > 0) {
            JOptionPane.showMessageDialog(this, "Proveedor borrado correctamente.");
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this, "Error al borrar proveedor: " + ex.getMessage());
    }
    }//GEN-LAST:event_borrarbtnActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int fila = jTable3.getSelectedRow();
    if (fila >= 0) {
        int idInventario = (int) jTable3.getValueAt(fila, 0);
        int opcion = JOptionPane.showConfirmDialog(this, "¿Estás seguro de que deseas borrar este item del inventario?", "Confirmar borrado", JOptionPane.YES_NO_OPTION);
        if (opcion == JOptionPane.YES_OPTION) {
            // Lógica para borrar en la base de datos
            // borrarInventarioEnBD(idInventario);
            
            JOptionPane.showMessageDialog(this, "Funcionalidad de borrar inventario no implementada.");
        }
    } else {
        JOptionPane.showMessageDialog(this, "Seleccione un item del inventario para borrar.");
    }
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InterfazManejoPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfazManejoPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfazManejoPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfazManejoPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfazManejoPedido().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Inventario;
    private javax.swing.JPanel Pedidos;
    private javax.swing.JPanel Productos;
    private javax.swing.JPanel Proveedores;
    private javax.swing.JButton actualizarProducto;
    private javax.swing.JButton actualizarbtn;
    private javax.swing.JButton borrarProducto;
    private javax.swing.JButton borrarbtn;
    private javax.swing.JButton btnagregarprov;
    private javax.swing.JButton btninventario;
    private javax.swing.JButton btnpedido;
    private javax.swing.JButton btnproducto;
    private javax.swing.JButton btnproveedores;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTableDetalles;
    private javax.swing.JTable jTablePedidos;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTable tablaproveedor;
    private javax.swing.JTable tableproductos;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtBuscarProducto;
    // End of variables declaration//GEN-END:variables

    private void mostrarProductos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
