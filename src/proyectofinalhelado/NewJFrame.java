package proyectofinalhelado;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */



import java.sql.Connection;

import conexionBD.ConexionDB;
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


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jScrollPane2 = new javax.swing.JScrollPane();
        background = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        logolabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        jCheckBox5 = new javax.swing.JCheckBox();
        jCheckBox6 = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel10 = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();
        jButton1 = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jSeparator5 = new javax.swing.JSeparator();
        jTextField1 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jCheckBox7 = new javax.swing.JCheckBox();
        jCheckBox8 = new javax.swing.JCheckBox();
        jCheckBox9 = new javax.swing.JCheckBox();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jLabel17 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jRadioButton4 = new javax.swing.JRadioButton();
        jRadioButton5 = new javax.swing.JRadioButton();
        jRadioButton6 = new javax.swing.JRadioButton();
        jRadioButton7 = new javax.swing.JRadioButton();
        jRadioButton8 = new javax.swing.JRadioButton();
        jRadioButton9 = new javax.swing.JRadioButton();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        background.setBackground(new java.awt.Color(255, 255, 255));
        background.setPreferredSize(new java.awt.Dimension(560, 2450));
        background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 153, 102));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 83, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1960, Short.MAX_VALUE)
        );

        background.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 1960));

        logolabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectofinalhelado/imagenn/Adobe Express - file (1).png"))); // NOI18N
        background.add(logolabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, -10, 140, 140));

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 153, 255));
        jLabel1.setText("NUEVO PEDIDO");
        background.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 120, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 153, 102));
        jLabel2.setText("SABORES:");
        background.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 160, -1, -1));

        jCheckBox1.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jCheckBox1.setForeground(new java.awt.Color(204, 153, 255));
        jCheckBox1.setText("Vainilla");
        background.add(jCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 160, -1, -1));

        jCheckBox2.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jCheckBox2.setForeground(new java.awt.Color(204, 153, 255));
        jCheckBox2.setText("Chocolate");
        background.add(jCheckBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 160, -1, -1));

        jCheckBox3.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jCheckBox3.setForeground(new java.awt.Color(204, 153, 255));
        jCheckBox3.setText("Fresa");
        background.add(jCheckBox3, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 160, -1, -1));

        jCheckBox4.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jCheckBox4.setForeground(new java.awt.Color(204, 153, 255));
        jCheckBox4.setText("Pistacho");
        background.add(jCheckBox4, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 280, -1, -1));

        jCheckBox5.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jCheckBox5.setForeground(new java.awt.Color(204, 153, 255));
        jCheckBox5.setText("Ron pasa");
        background.add(jCheckBox5, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 280, -1, -1));

        jCheckBox6.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jCheckBox6.setForeground(new java.awt.Color(204, 153, 255));
        jCheckBox6.setText("Arandano");
        jCheckBox6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox6ActionPerformed(evt);
            }
        });
        background.add(jCheckBox6, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 280, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectofinalhelado/imagenn/Adobe Express - file (2).png"))); // NOI18N
        background.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 190, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectofinalhelado/imagenn/Adobe Express - file (2).png"))); // NOI18N
        background.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 310, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectofinalhelado/imagenn/Adobe Express - file (4).png"))); // NOI18N
        background.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 310, -1, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectofinalhelado/imagenn/Adobe Express - file (3).png"))); // NOI18N
        background.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 190, -1, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectofinalhelado/imagenn/Adobe Express - file (6).png"))); // NOI18N
        background.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 310, -1, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectofinalhelado/imagenn/Adobe Express - file (5).png"))); // NOI18N
        background.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(396, 190, 50, 80));

        jLabel9.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 153, 102));
        jLabel9.setText("TAMANO:");
        background.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 750, -1, 20));

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jRadioButton1.setForeground(new java.awt.Color(204, 153, 255));
        jRadioButton1.setText("Pequeno");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });
        background.add(jRadioButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 750, -1, -1));

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jRadioButton2.setForeground(new java.awt.Color(204, 153, 255));
        jRadioButton2.setText("Mediano");
        background.add(jRadioButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 750, -1, -1));

        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jRadioButton3.setForeground(new java.awt.Color(204, 153, 255));
        jRadioButton3.setText("Grande");
        background.add(jRadioButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 750, -1, -1));

        jSeparator1.setForeground(new java.awt.Color(255, 153, 102));
        background.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 740, 460, 10));

        jSeparator2.setForeground(new java.awt.Color(255, 153, 102));
        background.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 780, 460, 30));

        jLabel10.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(204, 153, 255));
        jLabel10.setText("CANTIDAD: ");
        background.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 870, -1, -1));
        background.add(jSpinner1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 870, -1, -1));

        jButton1.setBackground(new java.awt.Color(204, 204, 255));
        jButton1.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 153, 102));
        jButton1.setText("Añadir al pedido");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        background.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 920, -1, -1));

        jSeparator4.setForeground(new java.awt.Color(255, 153, 102));
        background.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 900, 460, 20));

        jLabel11.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 153, 102));
        jLabel11.setText("Tu lista de pedidos agregados");
        background.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 960, -1, -1));

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

        background.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 990, 340, 230));

        jSeparator5.setForeground(new java.awt.Color(255, 153, 102));
        background.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 950, 460, 20));

        jTextField1.setForeground(new java.awt.Color(153, 0, 0));
        jTextField1.setEnabled(false);
        background.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 1260, 140, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(204, 153, 255));
        jLabel12.setText("TOTAL:");
        background.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 1260, -1, -1));

        jButton2.setBackground(new java.awt.Color(204, 204, 255));
        jButton2.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 153, 102));
        jButton2.setText("ENVIAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        background.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 1370, -1, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 153, 102));
        jLabel13.setText("TOPPING: ");
        background.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 790, -1, -1));

        jCheckBox7.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jCheckBox7.setForeground(new java.awt.Color(204, 153, 255));
        jCheckBox7.setText("Oreo");
        jCheckBox7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox7ActionPerformed(evt);
            }
        });
        background.add(jCheckBox7, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 790, -1, -1));

        jCheckBox8.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jCheckBox8.setForeground(new java.awt.Color(204, 153, 255));
        jCheckBox8.setText("Chispas");
        background.add(jCheckBox8, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 790, -1, -1));

        jCheckBox9.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jCheckBox9.setForeground(new java.awt.Color(204, 153, 255));
        jCheckBox9.setText("Frutas");
        background.add(jCheckBox9, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 790, -1, -1));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectofinalhelado/imagenn/Adobe Express - file (7).png"))); // NOI18N
        background.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 820, -1, -1));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectofinalhelado/imagenn/Adobe Express - file (8).png"))); // NOI18N
        background.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 810, -1, -1));

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectofinalhelado/imagenn/Adobe Express - file (9).png"))); // NOI18N
        background.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 820, -1, -1));

        jSeparator6.setForeground(new java.awt.Color(255, 153, 102));
        background.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 1240, 460, 20));

        jSeparator7.setForeground(new java.awt.Color(255, 153, 102));
        background.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 1290, 460, 20));

        jLabel17.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 153, 102));
        jLabel17.setText("NOMBRE:");
        background.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 1320, -1, -1));

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        background.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 1320, 240, -1));

        jLabel18.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(204, 153, 255));
        jLabel18.setText("HELADOS");
        background.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 110, -1, -1));
        background.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 420, 480, 20));

        jLabel19.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(204, 153, 255));
        jLabel19.setText("PALETAS");
        background.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 450, -1, -1));

        jLabel20.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 153, 102));
        jLabel20.setText("SABORES:");
        background.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 480, -1, -1));

        buttonGroup2.add(jRadioButton4);
        jRadioButton4.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jRadioButton4.setForeground(new java.awt.Color(204, 153, 255));
        jRadioButton4.setText("Frutos del bosque");
        jRadioButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton4ActionPerformed(evt);
            }
        });
        background.add(jRadioButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 480, -1, -1));

        buttonGroup2.add(jRadioButton5);
        jRadioButton5.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jRadioButton5.setForeground(new java.awt.Color(204, 153, 255));
        jRadioButton5.setText("Naranja");
        background.add(jRadioButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 480, -1, -1));

        buttonGroup2.add(jRadioButton6);
        jRadioButton6.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jRadioButton6.setForeground(new java.awt.Color(204, 153, 255));
        jRadioButton6.setText("Quiki");
        background.add(jRadioButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 480, -1, -1));

        buttonGroup2.add(jRadioButton7);
        jRadioButton7.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jRadioButton7.setForeground(new java.awt.Color(204, 153, 255));
        jRadioButton7.setText("Sandia");
        background.add(jRadioButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 600, -1, -1));

        buttonGroup2.add(jRadioButton8);
        jRadioButton8.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jRadioButton8.setForeground(new java.awt.Color(204, 153, 255));
        jRadioButton8.setText("Limon");
        background.add(jRadioButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 600, -1, -1));

        buttonGroup2.add(jRadioButton9);
        jRadioButton9.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jRadioButton9.setForeground(new java.awt.Color(204, 153, 255));
        jRadioButton9.setText("Frutos rojos");
        background.add(jRadioButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 600, -1, -1));

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectofinalhelado/imagenn/Adobe Express - file (11).png"))); // NOI18N
        background.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 510, -1, -1));

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectofinalhelado/imagenn/Adobe Express - file (12).png"))); // NOI18N
        background.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 510, -1, -1));

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectofinalhelado/imagenn/Adobe Express - file (13).png"))); // NOI18N
        background.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 510, -1, -1));

        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectofinalhelado/imagenn/Adobe Express - file (15).png"))); // NOI18N
        background.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 640, -1, -1));

        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectofinalhelado/imagenn/Adobe Express - file (16).png"))); // NOI18N
        background.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 640, -1, -1));

        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectofinalhelado/imagenn/Adobe Express - file (17).png"))); // NOI18N
        background.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 640, -1, -1));

        jScrollPane2.setViewportView(background);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 6, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1592, javax.swing.GroupLayout.PREFERRED_SIZE))
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
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
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

    int cantidad = Integer.parseInt(jSpinner1.getValue().toString());
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
    jTextField1.setText(String.valueOf(total));
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jCheckBox6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox6ActionPerformed

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
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JCheckBox jCheckBox1;
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton1;
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
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLabel logolabel;
    // End of variables declaration//GEN-END:variables


}
