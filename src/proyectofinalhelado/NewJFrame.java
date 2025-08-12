package proyectofinalhelado;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */



import java.sql.Connection;

import conexionBD.ConexionDB;
import java.awt.Dimension;
import java.awt.Font;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import proyectofinalhelado.Cliente;
import proyectofinalhelado.Pedido;
import proyectofinalhelado.PedidoDao;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JTable;
import proyectofinalhelado.Pedido;
import proyectofinalhelado.Pedido;
import proyectofinalhelado.PedidoDao;
import proyectofinalhelado.PedidoDao;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import proyectofinalhelado.OrdenPreview;


/**
 *
 * @author domif
 */
public class NewJFrame extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    
    public NewJFrame() {
        initComponents();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
model.setRowCount(0); 

 agregarEventoEliminarArticulo();
 pack();
  
  JOptionPane.showMessageDialog(this, "Recuerde registrar un producto a la vez");
 

    }
   

private String generarFactura(String cliente) {
    StringBuilder factura = new StringBuilder();
    factura.append("---------------------------------------\n");
    factura.append("       HELADERÍA \"BLIZZ\"\n");
    factura.append("---------------------------------------\n\n");

    factura.append("Cliente: ").append(cliente).append("    ");
    factura.append("Fecha: ").append(java.time.LocalDate.now().toString()).append("\n\n");

   

    factura.append("-------------------------------------------------------\n");
    factura.append(String.format("%-20s %5s %15s %12s\n", "Producto", "Cant.", "Precio Unit.", "Subtotal"));
    factura.append("-------------------------------------------------------\n");

    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
    int total = 0;
    for (int i = 0; i < model.getRowCount(); i++) {
        String producto = model.getValueAt(i, 0).toString();
        int cantidad = Integer.parseInt(model.getValueAt(i, 3).toString());
        int subtotal = Integer.parseInt(model.getValueAt(i, 4).toString());
        int precioUnit = subtotal / cantidad;

        factura.append(String.format("%-20s %5d %15s %12s\n", producto, cantidad, "RD$ " + precioUnit, "RD$ " + subtotal));
    }

    factura.append("-------------------------------------------------------\n");
    factura.append(String.format("%48s %12s\n", "Total:", "RD$ " + jTextField1.getText()));
    factura.append("-------------------------------------------------------\n\n");
    factura.append("¡Gracias por preferirnos!\n");

    return factura.toString();
}
    private void agregarEventoEliminarArticulo() {
    jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
        @Override
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            int filaSeleccionada = jTable1.getSelectedRow();
            if (filaSeleccionada != -1) {
                int confirmacion = JOptionPane.showConfirmDialog(
                    null,
                    "¿Deseas eliminar este producto del pedido?",
                    "Confirmar",
                    JOptionPane.YES_NO_OPTION
                );

                if (confirmacion == JOptionPane.YES_OPTION) {
                    var model = (DefaultTableModel) jTable1.getModel();
                    model.removeRow(filaSeleccionada);
                }
            }
        }
    });
}

    
  private Pedido pedidoActual;

// Lista global para almacenar todos los pedidos
private final List<Pedido> listaPedidos = new ArrayList<>();

// Contador para asignar IDs únicos a cada pedido
private int contadorPedidos = 1;


private int obtenerPrecioDesdeDB(Connection con, String nombreProducto) throws SQLException {
    int precio = 0;
    String sql = "SELECT precio FROM producto WHERE nombre = ?";
    PreparedStatement ps = con.prepareStatement(sql);
    ps.setString(1, nombreProducto);
    ResultSet rs = ps.executeQuery();
    if (rs.next()) {
        precio = rs.getInt("precio");
    }
    return precio;
}

private void restarInventario(Connection con, String nombreProducto, int cantidad) throws SQLException {
    String sql = "UPDATE producto SET stock = stock - ? WHERE nombre = ?";
    PreparedStatement ps = con.prepareStatement(sql);
    ps.setInt(1, cantidad);
    ps.setString(2, nombreProducto);
    ps.executeUpdate();
}

private void limpiarCampos() {
    buttonGroup1.clearSelection();
    jCheckBox1.setSelected(false);
    jCheckBox2.setSelected(false);
    jCheckBox3.setSelected(false);
    jCheckBox4.setSelected(false);
    jCheckBox5.setSelected(false);
    jCheckBox6.setSelected(false);
    buttonGroup1.clearSelection();
    jCheckBox7.setSelected(false);
    jCheckBox8.setSelected(false);
    jCheckBox9.setSelected(false);
    jSpinner1.setValue(1);
    
    jCheckBox10.setSelected(false);
    jCheckBox11.setSelected(false);
    jCheckBox12.setSelected(false);
    jCheckBox13.setSelected(false);
    jCheckBox14.setSelected(false);
    jCheckBox15.setSelected(false);
    buttonGroup2.clearSelection();
    jCheckBox16.setSelected(false);
    jCheckBox17.setSelected(false);
    jCheckBox18.setSelected(false);
    jSpinner3.setValue(1);
    
    buttonGroup2.clearSelection();
    jSpinner2.setValue(1);
}


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jSeparator12 = new javax.swing.JSeparator();
        buttonGroup3 = new javax.swing.ButtonGroup();
        jScrollPane2 = new javax.swing.JScrollPane();
        background = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        logolabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jLabel17 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jCheckBox4 = new javax.swing.JCheckBox();
        jCheckBox5 = new javax.swing.JCheckBox();
        jCheckBox6 = new javax.swing.JCheckBox();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jLabel13 = new javax.swing.JLabel();
        jCheckBox7 = new javax.swing.JCheckBox();
        jCheckBox8 = new javax.swing.JCheckBox();
        jCheckBox9 = new javax.swing.JCheckBox();
        jSeparator10 = new javax.swing.JSeparator();
        jSeparator11 = new javax.swing.JSeparator();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();
        jSeparator13 = new javax.swing.JSeparator();
        jSeparator14 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jCheckBox10 = new javax.swing.JCheckBox();
        jCheckBox11 = new javax.swing.JCheckBox();
        jCheckBox12 = new javax.swing.JCheckBox();
        jCheckBox13 = new javax.swing.JCheckBox();
        jCheckBox14 = new javax.swing.JCheckBox();
        jCheckBox15 = new javax.swing.JCheckBox();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jRadioButton10 = new javax.swing.JRadioButton();
        jRadioButton11 = new javax.swing.JRadioButton();
        jRadioButton12 = new javax.swing.JRadioButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jCheckBox16 = new javax.swing.JCheckBox();
        jCheckBox17 = new javax.swing.JCheckBox();
        jCheckBox18 = new javax.swing.JCheckBox();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jSpinner3 = new javax.swing.JSpinner();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jButton4 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jRadioButton4 = new javax.swing.JRadioButton();
        jRadioButton5 = new javax.swing.JRadioButton();
        jRadioButton6 = new javax.swing.JRadioButton();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jRadioButton7 = new javax.swing.JRadioButton();
        jRadioButton8 = new javax.swing.JRadioButton();
        jRadioButton9 = new javax.swing.JRadioButton();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel27 = new javax.swing.JLabel();
        jSpinner2 = new javax.swing.JSpinner();
        jSeparator8 = new javax.swing.JSeparator();
        jSeparator9 = new javax.swing.JSeparator();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        background.setBackground(new java.awt.Color(255, 255, 255));
        background.setPreferredSize(new java.awt.Dimension(560, 3700));
        background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 153, 102));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 80, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2320, Short.MAX_VALUE)
        );

        background.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 80, 2320));

        logolabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectofinalhelado/imagenn/Adobe Express - file (1).png"))); // NOI18N
        background.add(logolabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, -10, 140, 140));

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 153, 255));
        jLabel1.setText("NUEVO PEDIDO");
        background.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 120, -1, -1));

        jTable1.setBackground(new java.awt.Color(204, 153, 255));
        jTable1.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jTable1.setForeground(new java.awt.Color(207, 111, 15));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "SABOR", "TAMAÑO", "TOPPINGS", "CANTIDAD", "SUBTOTAL"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        background.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 1020, 340, 230));

        jTextField1.setForeground(new java.awt.Color(153, 0, 0));
        jTextField1.setEnabled(false);
        background.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 1310, 140, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(204, 153, 255));
        jLabel12.setText("TOTAL:");
        background.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 1310, -1, -1));

        jButton2.setBackground(new java.awt.Color(204, 204, 255));
        jButton2.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 153, 102));
        jButton2.setText("ENVIAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        background.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 1440, -1, -1));

        jSeparator6.setForeground(new java.awt.Color(255, 153, 102));
        background.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 1280, 460, 20));

        jSeparator7.setForeground(new java.awt.Color(255, 153, 102));
        background.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 1340, 460, 20));

        jLabel17.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 153, 102));
        jLabel17.setText("NOMBRE:");
        background.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 1390, -1, -1));

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        background.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 1390, 240, -1));

        jTabbedPane1.setBackground(new java.awt.Color(255, 153, 102));
        jTabbedPane1.setForeground(new java.awt.Color(0, 0, 0));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jLabel18.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(204, 153, 255));
        jLabel18.setText("HELADOS DE CONO");

        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 153, 102));
        jLabel2.setText("SABORES:");

        jCheckBox1.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jCheckBox1.setForeground(new java.awt.Color(204, 153, 255));
        jCheckBox1.setText("Vainilla");

        jCheckBox2.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jCheckBox2.setForeground(new java.awt.Color(204, 153, 255));
        jCheckBox2.setText("Chocolate");

        jCheckBox3.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jCheckBox3.setForeground(new java.awt.Color(204, 153, 255));
        jCheckBox3.setText("Fresa");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectofinalhelado/imagenn/Adobe Express - file (2).png"))); // NOI18N

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectofinalhelado/imagenn/Adobe Express - file (3).png"))); // NOI18N

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectofinalhelado/imagenn/Adobe Express - file (5).png"))); // NOI18N

        jCheckBox4.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jCheckBox4.setForeground(new java.awt.Color(204, 153, 255));
        jCheckBox4.setText("Pistacho");

        jCheckBox5.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jCheckBox5.setForeground(new java.awt.Color(204, 153, 255));
        jCheckBox5.setText("Ron pasa");

        jCheckBox6.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jCheckBox6.setForeground(new java.awt.Color(204, 153, 255));
        jCheckBox6.setText("Arandano");
        jCheckBox6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox6ActionPerformed(evt);
            }
        });

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectofinalhelado/imagenn/Adobe Express - file (4).png"))); // NOI18N

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectofinalhelado/imagenn/Adobe Express - file (2).png"))); // NOI18N

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectofinalhelado/imagenn/Adobe Express - file (6).png"))); // NOI18N

        jLabel9.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 153, 102));
        jLabel9.setText("CANTIDAD DE PINTAS:");

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jRadioButton1.setForeground(new java.awt.Color(204, 153, 255));
        jRadioButton1.setText("1 pinta");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jRadioButton2.setForeground(new java.awt.Color(204, 153, 255));
        jRadioButton2.setText("2 pintas");

        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jRadioButton3.setForeground(new java.awt.Color(204, 153, 255));
        jRadioButton3.setText("3 pintas");

        jLabel13.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 153, 102));
        jLabel13.setText("TOPPING: ");

        jCheckBox7.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jCheckBox7.setForeground(new java.awt.Color(204, 153, 255));
        jCheckBox7.setText("Oreo");
        jCheckBox7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox7ActionPerformed(evt);
            }
        });

        jCheckBox8.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jCheckBox8.setForeground(new java.awt.Color(204, 153, 255));
        jCheckBox8.setText("Chispas");

        jCheckBox9.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jCheckBox9.setForeground(new java.awt.Color(204, 153, 255));
        jCheckBox9.setText("Frutas");

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectofinalhelado/imagenn/Adobe Express - file (7).png"))); // NOI18N

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectofinalhelado/imagenn/Adobe Express - file (8).png"))); // NOI18N

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectofinalhelado/imagenn/Adobe Express - file (9).png"))); // NOI18N

        jLabel10.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 153, 102));
        jLabel10.setText("CANTIDAD: ");

        jButton1.setBackground(new java.awt.Color(204, 204, 255));
        jButton1.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 153, 102));
        jButton1.setText("Añadir al pedido");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator10)
            .addComponent(jSeparator11)
            .addComponent(jSeparator13)
            .addComponent(jSeparator14)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addGap(31, 31, 31)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel5Layout.createSequentialGroup()
                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jCheckBox1)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel3))
                                    .addGap(54, 54, 54)
                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jCheckBox2)
                                        .addGroup(jPanel5Layout.createSequentialGroup()
                                            .addGap(21, 21, 21)
                                            .addComponent(jLabel6))))
                                .addGroup(jPanel5Layout.createSequentialGroup()
                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel5Layout.createSequentialGroup()
                                            .addComponent(jCheckBox4)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                            .addGap(21, 21, 21)
                                            .addComponent(jLabel5)
                                            .addGap(56, 56, 56)))
                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jCheckBox5)
                                        .addGroup(jPanel5Layout.createSequentialGroup()
                                            .addGap(21, 21, 21)
                                            .addComponent(jLabel4)))
                                    .addGap(7, 7, 7)))
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel5Layout.createSequentialGroup()
                                    .addGap(51, 51, 51)
                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jCheckBox3)
                                        .addComponent(jCheckBox6)))
                                .addGroup(jPanel5Layout.createSequentialGroup()
                                    .addGap(64, 64, 64)
                                    .addComponent(jLabel7))))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jRadioButton1)
                                            .addComponent(jCheckBox7))
                                        .addGap(37, 37, 37)
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jRadioButton2)
                                            .addComponent(jCheckBox8)))
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel14)
                                            .addComponent(jLabel13))
                                        .addGap(64, 64, 64)
                                        .addComponent(jLabel15))
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addGap(18, 18, 18)
                                        .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(59, 59, 59)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel16)
                                    .addComponent(jCheckBox9)
                                    .addComponent(jRadioButton3)))))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(137, 137, 137)
                        .addComponent(jButton1))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(129, 129, 129)
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(64, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(37, 37, 37)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jCheckBox1)
                                    .addComponent(jCheckBox2)
                                    .addComponent(jCheckBox3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel8)))
                            .addComponent(jLabel6))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jCheckBox4)
                            .addComponent(jCheckBox5)
                            .addComponent(jCheckBox6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4))))
                .addGap(18, 18, 18)
                .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2)
                    .addComponent(jRadioButton3))
                .addGap(14, 14, 14)
                .addComponent(jSeparator11, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox7)
                    .addComponent(jCheckBox8)
                    .addComponent(jCheckBox9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator13, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator14, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("HELADO CONO", jPanel2);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jCheckBox10.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jCheckBox10.setForeground(new java.awt.Color(204, 153, 255));
        jCheckBox10.setText("Vainilla");

        jCheckBox11.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jCheckBox11.setForeground(new java.awt.Color(204, 153, 255));
        jCheckBox11.setText("Chocolate");

        jCheckBox12.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jCheckBox12.setForeground(new java.awt.Color(204, 153, 255));
        jCheckBox12.setText("Fresa");

        jCheckBox13.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jCheckBox13.setForeground(new java.awt.Color(204, 153, 255));
        jCheckBox13.setText("Pistacho");

        jCheckBox14.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jCheckBox14.setForeground(new java.awt.Color(204, 153, 255));
        jCheckBox14.setText("Ron pasa");

        jCheckBox15.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jCheckBox15.setForeground(new java.awt.Color(204, 153, 255));
        jCheckBox15.setText("Arandano");

        jLabel28.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(204, 153, 255));
        jLabel28.setText("HELADO DE CAJITA");

        jLabel29.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 153, 102));
        jLabel29.setText("SABORES:");

        jLabel30.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 153, 102));
        jLabel30.setText("TAMAÑO:");

        buttonGroup3.add(jRadioButton10);
        jRadioButton10.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jRadioButton10.setForeground(new java.awt.Color(204, 153, 255));
        jRadioButton10.setText("Pequeño");
        jRadioButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton10ActionPerformed(evt);
            }
        });

        buttonGroup3.add(jRadioButton11);
        jRadioButton11.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jRadioButton11.setForeground(new java.awt.Color(204, 153, 255));
        jRadioButton11.setText("Mediano");

        buttonGroup3.add(jRadioButton12);
        jRadioButton12.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jRadioButton12.setForeground(new java.awt.Color(204, 153, 255));
        jRadioButton12.setText("Grande");

        jLabel31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectofinalhelado/imagenn/Adobe Express - file (7).png"))); // NOI18N

        jLabel32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectofinalhelado/imagenn/Adobe Express - file (8).png"))); // NOI18N

        jLabel33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectofinalhelado/imagenn/Adobe Express - file (9).png"))); // NOI18N

        jLabel34.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 153, 102));
        jLabel34.setText("TOPPING:");

        jCheckBox16.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jCheckBox16.setForeground(new java.awt.Color(204, 153, 255));
        jCheckBox16.setText("Oreo");
        jCheckBox16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox16ActionPerformed(evt);
            }
        });

        jCheckBox17.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jCheckBox17.setForeground(new java.awt.Color(204, 153, 255));
        jCheckBox17.setText("chispas");

        jCheckBox18.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jCheckBox18.setForeground(new java.awt.Color(204, 153, 255));
        jCheckBox18.setText("Frutas");

        jLabel35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectofinalhelado/imagenn/Adobe Express - file (20).png"))); // NOI18N

        jLabel36.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectofinalhelado/imagenn/Adobe Express - file (25).png"))); // NOI18N

        jLabel37.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectofinalhelado/imagenn/Adobe Express - file (21).png"))); // NOI18N

        jLabel38.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectofinalhelado/imagenn/Adobe Express - file (24).png"))); // NOI18N

        jLabel39.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectofinalhelado/imagenn/Adobe Express - file (19).png"))); // NOI18N

        jLabel40.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectofinalhelado/imagenn/Adobe Express - file (23).png"))); // NOI18N

        jLabel41.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(255, 153, 102));
        jLabel41.setText("CANTIDAD: ");

        jButton4.setBackground(new java.awt.Color(204, 204, 255));
        jButton4.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 153, 102));
        jButton4.setText("Añadir al pedido");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCheckBox16, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel31))
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addGap(17, 17, 17)
                                        .addComponent(jLabel32)
                                        .addGap(73, 73, 73)
                                        .addComponent(jLabel33))
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jCheckBox17, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(32, 32, 32)
                                        .addComponent(jCheckBox18, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(130, 130, 130)
                                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addComponent(jLabel35)
                                .addGap(74, 74, 74)
                                .addComponent(jLabel36)
                                .addGap(54, 54, 54)
                                .addComponent(jLabel37))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jCheckBox10, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jCheckBox13, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel29))
                                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel6Layout.createSequentialGroup()
                                                .addGap(26, 26, 26)
                                                .addComponent(jCheckBox11, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(28, 28, 28)
                                                .addComponent(jCheckBox12, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel6Layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(jCheckBox14, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jCheckBox15, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addComponent(jLabel30)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addComponent(jRadioButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jRadioButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jRadioButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(55, 55, 55)
                                .addComponent(jLabel39)
                                .addGap(55, 55, 55)
                                .addComponent(jLabel40)))
                        .addGap(0, 57, Short.MAX_VALUE))
                    .addComponent(jSeparator4))
                .addContainerGap())
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator3)
                    .addComponent(jSeparator5)))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel34)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel41)
                                .addGap(18, 18, 18)
                                .addComponent(jSpinner3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(138, 138, 138)
                        .addComponent(jButton4)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel28)
                .addGap(9, 9, 9)
                .addComponent(jLabel29)
                .addGap(26, 26, 26)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox10)
                    .addComponent(jCheckBox11)
                    .addComponent(jCheckBox12))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel35)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jCheckBox13)
                            .addComponent(jCheckBox14)
                            .addComponent(jCheckBox15))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1))
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel6Layout.createSequentialGroup()
                            .addComponent(jLabel37)
                            .addGap(46, 46, 46)
                            .addComponent(jLabel40))
                        .addGroup(jPanel6Layout.createSequentialGroup()
                            .addComponent(jLabel36)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel39))))
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel30)
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton10)
                    .addComponent(jRadioButton12)
                    .addComponent(jRadioButton11))
                .addGap(30, 30, 30)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel34)
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox16)
                    .addComponent(jCheckBox17)
                    .addComponent(jCheckBox18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel31)
                    .addComponent(jLabel32)
                    .addComponent(jLabel33))
                .addGap(18, 18, 18)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel41)
                    .addComponent(jSpinner3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4)
                .addGap(114, 114, 114)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 787, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("HELADO CAJITA", jPanel3);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        jLabel19.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(204, 153, 255));
        jLabel19.setText("HELADO DE PALETA");

        jLabel20.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 153, 102));
        jLabel20.setText("SABORES:");

        buttonGroup2.add(jRadioButton4);
        jRadioButton4.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jRadioButton4.setForeground(new java.awt.Color(204, 153, 255));
        jRadioButton4.setText("Frutos del bosque");
        jRadioButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton4ActionPerformed(evt);
            }
        });

        buttonGroup2.add(jRadioButton5);
        jRadioButton5.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jRadioButton5.setForeground(new java.awt.Color(204, 153, 255));
        jRadioButton5.setText("Naranja");

        buttonGroup2.add(jRadioButton6);
        jRadioButton6.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jRadioButton6.setForeground(new java.awt.Color(204, 153, 255));
        jRadioButton6.setText("Quiki");

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectofinalhelado/imagenn/Adobe Express - file (11).png"))); // NOI18N

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectofinalhelado/imagenn/Adobe Express - file (12).png"))); // NOI18N

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectofinalhelado/imagenn/Adobe Express - file (13).png"))); // NOI18N

        buttonGroup2.add(jRadioButton7);
        jRadioButton7.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jRadioButton7.setForeground(new java.awt.Color(204, 153, 255));
        jRadioButton7.setText("Sandia");

        buttonGroup2.add(jRadioButton8);
        jRadioButton8.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jRadioButton8.setForeground(new java.awt.Color(204, 153, 255));
        jRadioButton8.setText("Limon");

        buttonGroup2.add(jRadioButton9);
        jRadioButton9.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jRadioButton9.setForeground(new java.awt.Color(204, 153, 255));
        jRadioButton9.setText("Frutos rojos");

        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectofinalhelado/imagenn/Adobe Express - file (15).png"))); // NOI18N

        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectofinalhelado/imagenn/Adobe Express - file (16).png"))); // NOI18N

        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectofinalhelado/imagenn/Adobe Express - file (17).png"))); // NOI18N

        jButton3.setBackground(new java.awt.Color(204, 204, 255));
        jButton3.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 153, 102));
        jButton3.setText("Añadir al pedido");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel27.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 153, 102));
        jLabel27.setText("CANTIDAD: ");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jRadioButton4)
                                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel27)
                                        .addComponent(jRadioButton7)
                                        .addComponent(jLabel21)
                                        .addComponent(jLabel24)))
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addGap(24, 24, 24)
                                        .addComponent(jLabel22))
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jRadioButton5)
                                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jLabel25)
                                                .addComponent(jRadioButton8)))))
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addGap(39, 39, 39)
                                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel7Layout.createSequentialGroup()
                                                .addGap(21, 21, 21)
                                                .addComponent(jLabel23))
                                            .addComponent(jRadioButton6)
                                            .addComponent(jRadioButton9)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                        .addComponent(jLabel26)
                                        .addGap(33, 33, 33))))))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(148, 148, 148)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton3)
                            .addComponent(jSpinner2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(56, Short.MAX_VALUE))
            .addComponent(jSeparator8, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jSeparator9, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel19)
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel24)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioButton4)
                            .addComponent(jRadioButton5)
                            .addComponent(jRadioButton6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel22)
                            .addComponent(jLabel21)
                            .addComponent(jLabel23))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButton7)
                            .addComponent(jRadioButton8)
                            .addComponent(jRadioButton9))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel26)
                            .addComponent(jLabel25))))
                .addGap(53, 53, 53)
                .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(jSpinner2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addContainerGap(230, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("HELADO PALETA", jPanel4);

        background.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 180, 430, 790));

        jLabel11.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 153, 102));
        jLabel11.setText("Tu lista de pedidos agregados");
        background.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 990, -1, -1));

        jScrollPane2.setViewportView(background);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 2028, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton4ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jCheckBox7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox7ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
     if (jTextField2.getText().isEmpty()){  
         JOptionPane.showMessageDialog(this, "por favor, igrese su nombre");
        return;
         
     }
         
         if (jTable1.getRowCount() == 0) {
        JOptionPane.showMessageDialog(this, "No hay productos en el pedido");
        return;
    }
         
      DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

    String sqlPedido = "INSERT INTO pedido (cliente, fecha,estado, total) VALUES (?, ?, ?, ?)";
    String sqlDetalle = "INSERT INTO detalle_pedido (id_pedido, producto, cantidad, tamaño, sabor, topping, subtotal) VALUES (?, ?, ?, ?, ?, ?, ?)";

    Connection conn = null;
    PreparedStatement psPedido = null;
    PreparedStatement psDetalle = null;

    try {
        conn = ConexionDB.conectar();

        if (conn == null) {
            JOptionPane.showMessageDialog(null, "No se pudo conectar a la base de datos.");
            return;
        }

        conn.setAutoCommit(false); // Iniciar transacción

   
        psPedido = conn.prepareStatement(sqlPedido, Statement.RETURN_GENERATED_KEYS);

        String cliente = jTextField2.getText();
        String total = jTextField1.getText();
        String estado = "pendiente";
        java.sql.Date fechaActual = new java.sql.Date(System.currentTimeMillis());

        psPedido.setString(1, cliente);
        psPedido.setDate(2, fechaActual);
        psPedido.setString(3, estado);
        psPedido.setString(4, total);

        int affectedRows = psPedido.executeUpdate();

        if (affectedRows == 0) {
            throw new SQLException("No se pudo insertar el pedido.");
        }

        
        ResultSet generatedKeys = psPedido.getGeneratedKeys();
        int idPedido = 0;
        if (generatedKeys.next()) {
            idPedido = generatedKeys.getInt(1);
        } else {
            throw new SQLException("No se pudo obtener el ID del pedido.");
        }

      
        psDetalle = conn.prepareStatement(sqlDetalle);

        for (int i = 0; i < model.getRowCount(); i++) {
            String producto = model.getValueAt(i, 0).toString();
            int cantidad = Integer.parseInt(model.getValueAt(i, 3).toString());
            String tamaño = model.getValueAt(i, 1) != null ? model.getValueAt(i, 1).toString() : "";
            String sabor = ""; 
            String topping = model.getValueAt(i, 2) != null ? model.getValueAt(i, 2).toString() : "";
            double subtotal = Double.parseDouble(model.getValueAt(i, 4).toString()); // columna 4 = subtotal

            psDetalle.setInt(1, idPedido);
            psDetalle.setString(2, producto);
            psDetalle.setInt(3, cantidad);
            psDetalle.setString(4, tamaño);
            psDetalle.setString(5, sabor);
            psDetalle.setString(6, topping);
            psDetalle.setDouble(7, subtotal);

            psDetalle.executeUpdate();
        }

        conn.commit(); // Confirmar transacción

        JOptionPane.showMessageDialog(null, "Datos enviados exitosamente.");

    } catch (SQLException e) {
        try {
            if (conn != null) {
                conn.rollback(); // Revertir transacción en error
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        JOptionPane.showMessageDialog(null, "Error al insertar datos: " + e.getMessage());
    } finally {
        try {
            if (psDetalle != null) psDetalle.close();
            if (psPedido != null) psPedido.close();
            if (conn != null) {
                conn.setAutoCommit(true);
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
      String cliente = jTextField1.getText(); 
    

    String facturaTexto = generarFactura(cliente);

    JTextArea areaFactura = new JTextArea(facturaTexto);
    areaFactura.setEditable(false);
    areaFactura.setFont(new Font("Monospaced", Font.PLAIN, 12));
    JScrollPane scroll = new JScrollPane(areaFactura);
    scroll.setPreferredSize(new Dimension(500, 400));

    JOptionPane.showMessageDialog(this, scroll, "Resumen de Pedido", JOptionPane.INFORMATION_MESSAGE);

    
    
    
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      int countSabores = 0;
    boolean esPaleta = false;
    String producto = "";
    int precioProducto = 0;
    String tamaño = "";
    String topping = "";

    try (Connection con = ConexionDB.conectar()) {

      
        if (jRadioButton4.isSelected()) { 
            esPaleta = true; 
            producto = "frutos del bosque"; 
        } else if (jRadioButton5.isSelected()) { 
            esPaleta = true; 
            producto = "Naranja"; 
        } else if (jRadioButton6.isSelected()){
            esPaleta = true; 
            producto = "Kiwi"; 
        } else if (jRadioButton7.isSelected()){
            esPaleta = true; 
            producto = "Sandía"; 
        } else if (jRadioButton8.isSelected()){
            esPaleta = true; 
            producto = "Limón"; 
        } else if (jRadioButton9.isSelected()){
            esPaleta = true; 
            producto = "Frutos rojos"; 
        }

        
        if (esPaleta) {
            precioProducto = obtenerPrecioDesdeDB(con, producto);
        } else {
            // Helado: contar y validar sabores
            if (jCheckBox1.isSelected()) countSabores++;
            if (jCheckBox2.isSelected()) countSabores++;
            if (jCheckBox3.isSelected()) countSabores++;
            if (jCheckBox4.isSelected()) countSabores++;
            if (jCheckBox5.isSelected()) countSabores++;
            if (jCheckBox6.isSelected()) countSabores++;

            if (countSabores > 2) {
                JOptionPane.showMessageDialog(this, "Solo puedes seleccionar hasta 2 sabores.");
                return;
            }

            if (jCheckBox1.isSelected()) { producto += "Vainilla "; precioProducto += obtenerPrecioDesdeDB(con, "Vainilla"); }
            if (jCheckBox2.isSelected()) { producto += "Chocolate "; precioProducto += obtenerPrecioDesdeDB(con, "Chocolate"); }
            if (jCheckBox3.isSelected()) { producto += "Fresa "; precioProducto += obtenerPrecioDesdeDB(con, "Fresa"); }
            if (jCheckBox4.isSelected()) { producto += "Pistacho "; precioProducto += obtenerPrecioDesdeDB(con, "Pistacho"); }
            if (jCheckBox5.isSelected()) { producto += "Ron pasa "; precioProducto += obtenerPrecioDesdeDB(con, "Ron pasa"); }
            if (jCheckBox6.isSelected()) { producto += "Arándano "; precioProducto += obtenerPrecioDesdeDB(con, "Arándano"); }

           
           if (jRadioButton1.isSelected()) { tamaño = "Pequeño"; precioProducto += 0; }
        else if (jRadioButton2.isSelected()) { tamaño = "Mediano"; precioProducto += 35; }
        else if (jRadioButton3.isSelected()) { tamaño = "Grande"; precioProducto += 50; }
        else {
            JOptionPane.showMessageDialog(this, "Selecciona la cantidad de pintas porfavor.");
            return;
        }

            // Topping opcional
            if (jCheckBox7.isSelected()) { topping += "Oreo "; precioProducto += obtenerPrecioDesdeDB(con, "Topping Oreo"); }
            if (jCheckBox8.isSelected()) { topping += "Chispas "; precioProducto += obtenerPrecioDesdeDB(con, "Topping Chispas"); }
            if (jCheckBox9.isSelected()) { topping += "Frutas "; precioProducto += obtenerPrecioDesdeDB(con, "Topping Frutas"); }
        }

        // Cantidad
        int cantidad = Integer.parseInt(jSpinner1.getValue().toString());
        if (cantidad <= 0) {
            JOptionPane.showMessageDialog(this, "Cantidad debe ser mayor que 0.");
            return;
        }

        
        int subtotal = precioProducto * cantidad;

       
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        if (esPaleta) {
            model.addRow(new Object[]{producto.trim(), "", "", cantidad, subtotal});
            
            restarInventario(con, producto, cantidad);
        } else {
            model.addRow(new Object[]{producto.trim(), tamaño, topping.trim(), cantidad, subtotal});
        }

        // Actualizar total
        int total = 0;
        for (int i = 0; i < jTable1.getRowCount(); i++) {
            Object valor = jTable1.getValueAt(i, 4);
            if (valor != null) {
                total += Integer.parseInt(valor.toString());
            }
        }
        jTextField1.setText(String.valueOf(total));

        // Limpiar selección
        limpiarCampos();
        

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error al procesar el pedido: " + e.getMessage());
    }


    }//GEN-LAST:event_jButton1ActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jCheckBox6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox6ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
 int countSabores = 0;
    boolean esPaleta = false;
    String producto = "";
    int precioProducto = 0;

    // Detectar si es paleta
    if (jRadioButton4.isSelected()) { 
        esPaleta = true; 
        producto = "frutos del bosque"; 
        precioProducto = 55; 
    } else if (jRadioButton5.isSelected()) { 
        esPaleta = true; 
        producto = "Naranja"; 
        precioProducto = 40; 
    } else if (jRadioButton6.isSelected()){
        esPaleta = true; 
        producto = "quiwi"; 
        precioProducto = 45; 
    } else if (jRadioButton7.isSelected()){
        esPaleta = true; 
        producto = "sandia"; 
        precioProducto = 40; 
    } else if (jRadioButton8.isSelected()){
        esPaleta = true; 
        producto = "limon"; 
        precioProducto = 40; 
    } else if (jRadioButton9.isSelected()){
        esPaleta = true; 
        producto = "frutos rojos"; 
        precioProducto = 55; 
    }

    String tamaño = "";
    String topping = "";

    if (!esPaleta) {
        // Es helado: contar y validar sabores
        if (jCheckBox1.isSelected()) countSabores++;
        if (jCheckBox2.isSelected()) countSabores++;
        if (jCheckBox3.isSelected()) countSabores++;
        if (jCheckBox4.isSelected()) countSabores++;
        if (jCheckBox5.isSelected()) countSabores++;
        if (jCheckBox6.isSelected()) countSabores++;

        if (countSabores > 2) {
            JOptionPane.showMessageDialog(this, "Solo puedes seleccionar hasta 2 sabores.");
            return;
        }

        if (jCheckBox1.isSelected()) { producto += "Vainilla "; precioProducto += 50; }
        if (jCheckBox2.isSelected()) { producto += "Chocolate "; precioProducto += 60; }
        if (jCheckBox3.isSelected()) { producto += "Fresa "; precioProducto += 40; }
        if (jCheckBox4.isSelected()) { producto += "Pistacho "; precioProducto += 70; }
        if (jCheckBox5.isSelected()) { producto += "Ron pasa "; precioProducto += 65; }
        if (jCheckBox6.isSelected()) { producto += "Arándano "; precioProducto += 55; }

        // Tamaño obligatorio
        if (jRadioButton1.isSelected()) { tamaño = "Pequeño"; precioProducto += 0; }
        else if (jRadioButton2.isSelected()) { tamaño = "Mediano"; precioProducto += 35; }
        else if (jRadioButton3.isSelected()) { tamaño = "Grande"; precioProducto += 50; }
        else {
            JOptionPane.showMessageDialog(this, "Selecciona un tamaño.");
            return;
        }

        // Topping opcional
        if (jCheckBox7.isSelected()) { topping += "Oreo "; precioProducto += 15; }
        if (jCheckBox8.isSelected()) { topping += "Chispas "; precioProducto += 10; }
        if (jCheckBox9.isSelected()) { topping += "Frutas "; precioProducto += 20; }
    }

    int cantidad = Integer.parseInt(jSpinner2.getValue().toString());
    if (cantidad <= 0) {
        JOptionPane.showMessageDialog(this, "Cantidad debe ser mayor que 0.");
        return;
    }

    int subtotal = precioProducto * cantidad;

    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

    // Agregar fila con tamaño y topping solo si es helado
    if (esPaleta) {
        model.addRow(new Object[]{producto.trim(), "", "", cantidad, subtotal});
    } else {
        model.addRow(new Object[]{producto.trim(), tamaño, topping.trim(), cantidad, subtotal});
    }

    // Actualizar total
    int total = 0;
    for (int i = 0; i < jTable1.getRowCount(); i++) {
        Object valor = jTable1.getValueAt(i, 4);
        if (valor != null) {
            total += Integer.parseInt(valor.toString());
        }
    }
     
    buttonGroup2.clearSelection();


jSpinner2.setValue(1);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jCheckBox16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox16ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox16ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
       int countSabores = 0;
    boolean esPaleta = false;
    String producto = "";
    int precioProducto = 0;
    String tamaño = "";
    String topping = "";

    try (Connection con = ConexionDB.conectar()) {

      
        if (jRadioButton4.isSelected()) { 
            esPaleta = true; 
            producto = "frutos del bosque"; 
        } else if (jRadioButton5.isSelected()) { 
            esPaleta = true; 
            producto = "Naranja"; 
        } else if (jRadioButton6.isSelected()){
            esPaleta = true; 
            producto = "Kiwi"; 
        } else if (jRadioButton7.isSelected()){
            esPaleta = true; 
            producto = "Sandía"; 
        } else if (jRadioButton8.isSelected()){
            esPaleta = true; 
            producto = "Limón"; 
        } else if (jRadioButton9.isSelected()){
            esPaleta = true; 
            producto = "Frutos rojos"; 
        }

        
        if (esPaleta) {
            precioProducto = obtenerPrecioDesdeDB(con, producto);
        } else {
            // Helado: contar y validar sabores
            if (jCheckBox10.isSelected()) countSabores++;
            if (jCheckBox11.isSelected()) countSabores++;
            if (jCheckBox12.isSelected()) countSabores++;
            if (jCheckBox13.isSelected()) countSabores++;
            if (jCheckBox14.isSelected()) countSabores++;
            if (jCheckBox15.isSelected()) countSabores++;

            if (countSabores > 2) {
                JOptionPane.showMessageDialog(this, "Solo puedes seleccionar hasta 2 sabores.");
                return;
            }

            if (jCheckBox10.isSelected()) { producto += "Vainilla "; precioProducto += obtenerPrecioDesdeDB(con, "Vainilla"); }
            if (jCheckBox11.isSelected()) { producto += "Chocolate "; precioProducto += obtenerPrecioDesdeDB(con, "Chocolate"); }
            if (jCheckBox12.isSelected()) { producto += "Fresa "; precioProducto += obtenerPrecioDesdeDB(con, "Fresa"); }
            if (jCheckBox13.isSelected()) { producto += "Pistacho "; precioProducto += obtenerPrecioDesdeDB(con, "Pistacho"); }
            if (jCheckBox14.isSelected()) { producto += "Ron pasa "; precioProducto += obtenerPrecioDesdeDB(con, "Ron pasa"); }
            if (jCheckBox15.isSelected()) { producto += "Arándano "; precioProducto += obtenerPrecioDesdeDB(con, "Arándano"); }

           
           if (jRadioButton10.isSelected()) { tamaño = "Pequeño"; precioProducto += 0; }
        else if (jRadioButton11.isSelected()) { tamaño = "Mediano"; precioProducto += 35; }
        else if (jRadioButton12.isSelected()) { tamaño = "Grande"; precioProducto += 50; }
        else {
            JOptionPane.showMessageDialog(this, "Selecciona un tamaño.");
            return;
        }

            // Topping opcional
            if (jCheckBox16.isSelected()) { topping += "Oreo "; precioProducto += obtenerPrecioDesdeDB(con, "Topping Oreo"); }
            if (jCheckBox17.isSelected()) { topping += "Chispas "; precioProducto += obtenerPrecioDesdeDB(con, "Topping Chispas"); }
            if (jCheckBox18.isSelected()) { topping += "Frutas "; precioProducto += obtenerPrecioDesdeDB(con, "Topping Frutas"); }
        }

        // Cantidad
        int cantidad = Integer.parseInt(jSpinner3.getValue().toString());
        if (cantidad <= 0) {
            JOptionPane.showMessageDialog(this, "Cantidad debe ser mayor que 0.");
            return;
        }

        // Calcular subtotal
        int subtotal = precioProducto * cantidad;

        // Agregar fila
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        if (esPaleta) {
            model.addRow(new Object[]{producto.trim(), "", "", cantidad, subtotal});
            // Restar inventario si es paleta
            restarInventario(con, producto, cantidad);
        } else {
            model.addRow(new Object[]{producto.trim(), tamaño, topping.trim(), cantidad, subtotal});
        }

        // Actualizar total
        int total = 0;
        for (int i = 0; i < jTable1.getRowCount(); i++) {
            Object valor = jTable1.getValueAt(i, 4);
            if (valor != null) {
                total += Integer.parseInt(valor.toString());
            }
        }
        jTextField1.setText(String.valueOf(total));

        // Limpiar selección
        limpiarCampos();
        jSpinner1.setValue(1);
        jSpinner2.setValue(1);
        jSpinner3.setValue(1);

    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error al procesar el pedido: " + e.getMessage());
    }




    }//GEN-LAST:event_jButton4ActionPerformed

    private void jRadioButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton10ActionPerformed

    /**
     * @param args the command line arguments
     */
     public static void main(String[] args) {
 java.awt.EventQueue.invokeLater(() -> {
new NewJFrame().setVisible(true);
 });
    }





    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel background;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox10;
    private javax.swing.JCheckBox jCheckBox11;
    private javax.swing.JCheckBox jCheckBox12;
    private javax.swing.JCheckBox jCheckBox13;
    private javax.swing.JCheckBox jCheckBox14;
    private javax.swing.JCheckBox jCheckBox15;
    private javax.swing.JCheckBox jCheckBox16;
    private javax.swing.JCheckBox jCheckBox17;
    private javax.swing.JCheckBox jCheckBox18;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JCheckBox jCheckBox6;
    private javax.swing.JCheckBox jCheckBox7;
    private javax.swing.JCheckBox jCheckBox8;
    private javax.swing.JCheckBox jCheckBox9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton10;
    private javax.swing.JRadioButton jRadioButton11;
    private javax.swing.JRadioButton jRadioButton12;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JRadioButton jRadioButton6;
    private javax.swing.JRadioButton jRadioButton7;
    private javax.swing.JRadioButton jRadioButton8;
    private javax.swing.JRadioButton jRadioButton9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator14;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JSpinner jSpinner2;
    private javax.swing.JSpinner jSpinner3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLabel logolabel;
    // End of variables declaration//GEN-END:variables


}
