package proyectofinalhelado;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */



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
import proyectofinalhelado.Pedido;
import proyectofinalhelado.Pedido;
import proyectofinalhelado.PedidoDao;
import proyectofinalhelado.PedidoDao;


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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        background.setBackground(new java.awt.Color(255, 255, 255));
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
            .addGap(0, 1260, Short.MAX_VALUE)
        );

        background.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 1260));

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
        background.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 190, -1, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 153, 102));
        jLabel9.setText("TAMANO:");
        background.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 410, -1, 20));

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jRadioButton1.setForeground(new java.awt.Color(204, 153, 255));
        jRadioButton1.setText("Pequeno");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });
        background.add(jRadioButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 410, -1, -1));

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jRadioButton2.setForeground(new java.awt.Color(204, 153, 255));
        jRadioButton2.setText("Mediano");
        background.add(jRadioButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 410, -1, -1));

        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jRadioButton3.setForeground(new java.awt.Color(204, 153, 255));
        jRadioButton3.setText("Grande");
        background.add(jRadioButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 410, -1, -1));

        jSeparator1.setForeground(new java.awt.Color(255, 153, 102));
        background.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 393, 460, 10));

        jSeparator2.setForeground(new java.awt.Color(255, 153, 102));
        background.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 450, 460, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(204, 153, 255));
        jLabel10.setText("CANTIDAD: ");
        background.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 590, -1, -1));
        background.add(jSpinner1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 590, -1, -1));

        jButton1.setBackground(new java.awt.Color(204, 204, 255));
        jButton1.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 153, 102));
        jButton1.setText("Añadir al pedido");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        background.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 640, -1, -1));

        jSeparator4.setForeground(new java.awt.Color(255, 153, 102));
        background.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 620, 460, 20));

        jLabel11.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 153, 102));
        jLabel11.setText("Tu lista de pedidos agregados");
        background.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 690, -1, -1));

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

        background.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 730, 340, 230));

        jSeparator5.setForeground(new java.awt.Color(255, 153, 102));
        background.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 680, 460, 20));
        background.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 1020, -1, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(204, 153, 255));
        jLabel12.setText("TOTAL:");
        background.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 1020, -1, -1));

        jButton2.setBackground(new java.awt.Color(204, 204, 255));
        jButton2.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 153, 102));
        jButton2.setText("ENVIAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        background.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 1140, -1, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 153, 102));
        jLabel13.setText("TOPPING: ");
        background.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 470, -1, -1));

        jCheckBox7.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jCheckBox7.setForeground(new java.awt.Color(204, 153, 255));
        jCheckBox7.setText("Oreo");
        jCheckBox7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox7ActionPerformed(evt);
            }
        });
        background.add(jCheckBox7, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 470, -1, -1));

        jCheckBox8.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jCheckBox8.setForeground(new java.awt.Color(204, 153, 255));
        jCheckBox8.setText("Chispas");
        background.add(jCheckBox8, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 470, -1, -1));

        jCheckBox9.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jCheckBox9.setForeground(new java.awt.Color(204, 153, 255));
        jCheckBox9.setText("Frutas");
        background.add(jCheckBox9, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 470, -1, -1));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectofinalhelado/imagenn/Adobe Express - file (7).png"))); // NOI18N
        background.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 500, -1, -1));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectofinalhelado/imagenn/Adobe Express - file (8).png"))); // NOI18N
        background.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 490, -1, -1));

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectofinalhelado/imagenn/Adobe Express - file (9).png"))); // NOI18N
        background.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 500, -1, -1));

        jSeparator6.setForeground(new java.awt.Color(255, 153, 102));
        background.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 1000, 460, 20));

        jSeparator7.setForeground(new java.awt.Color(255, 153, 102));
        background.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 1060, 460, 20));

        jLabel17.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 153, 102));
        jLabel17.setText("NOMBRE:");
        background.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 1090, -1, -1));

        jTextField2.setText(".");
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        background.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 1090, 240, -1));

        jScrollPane2.setViewportView(background);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1248, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jCheckBox6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox6ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
  int countSabores = 0;
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
    
  
    String sabor = "";
    int precioSabores = 0;
    if (jCheckBox1.isSelected()) { sabor += "Vainilla "; precioSabores += 50; }
    if (jCheckBox2.isSelected()) { sabor += "Chocolate "; precioSabores += 60; }
    if (jCheckBox3.isSelected()) { sabor += "Fresa "; precioSabores += 40; }
    if (jCheckBox4.isSelected()) { sabor += "Pistacho "; precioSabores += 70; }
    if (jCheckBox5.isSelected()) { sabor += "Ron pasa "; precioSabores += 65; }
    if (jCheckBox6.isSelected()) { sabor += "Arándano "; precioSabores += 55; }
    
  
    String tamaño = "";
    int precioTamaño = 0;
    if (jRadioButton1.isSelected()) { tamaño = "Pequeño"; precioTamaño = 20; }
    else if (jRadioButton2.isSelected()) { tamaño = "Mediano"; precioTamaño = 35; }
    else if (jRadioButton3.isSelected()) { tamaño = "Grande"; precioTamaño = 50; }
    else {
        JOptionPane.showMessageDialog(this, "Selecciona un tamaño.");
        return;
    }
    
    
    String topping = "";
    int precioToppings = 0;
    if (jCheckBox7.isSelected()) { topping += "Oreo "; precioToppings += 15; }
    if (jCheckBox8.isSelected()) { topping += "Chispas "; precioToppings += 10; }
    if (jCheckBox9.isSelected()) { topping += "Frutas "; precioToppings += 20; }
    
  
    int cantidad = Integer.parseInt(jSpinner1.getValue().toString());
    if (cantidad <= 0) {
        JOptionPane.showMessageDialog(this, "Cantidad debe ser mayor que 0.");
        return;
    }
    
  
    int subtotal = (precioSabores + precioTamaño + precioToppings) * cantidad;
    
   
    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
    model.addRow(new Object[]{sabor.trim(), tamaño, topping.trim(), cantidad, subtotal});
    
   
    int total = 0;
    for (int i = 0; i < jTable1.getRowCount(); i++) {
        Object valor = jTable1.getValueAt(i, 4);
        if (valor != null) {
            total += Integer.parseInt(valor.toString());
        }
    }
    jTextField1.setText(String.valueOf(total));
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jCheckBox7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox7ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
         String nombreCliente = jTextField2.getText().trim();

    if (nombreCliente.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Por favor, escribe tu nombre.");
        return;
    }

    // Asumiendo que pedidoActual es un objeto Pedido con la lista de detalles ya armada
    pedidoActual.setEstado("Pendiente");
    pedidoActual.setFecha(new Date());
    // Si no tienes setCliente, agrégalo o usa otra forma para guardar cliente
    // Aquí simplifico, asumo que tienes un setter o lo haces así:
    // pedidoActual.setCliente(nombreCliente);

        var dao = new PedidoDao();
    try {
        // Insertar pedido y obtener su ID generado
        int idPedido = dao.insertarPedido(nombreCliente);

        // Insertar los detalles del pedido
        dao.insertarDetalles(idPedido, pedidoActual.getDetalles());

        JOptionPane.showMessageDialog(this, "¡Pedido enviado con éxito!");

        // Limpiar formulario y variables para nuevo pedido
        jTextField2.setText("");
        // Aquí limpia tus checkboxes, spinner, etc.
        // Reiniciar pedidoActual si quieres:
        pedidoActual = new Pedido(0, new Date(), "Pendiente");

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error al enviar pedido: " + e.getMessage());
        e.printStackTrace();
    }

    }//GEN-LAST:event_jButton2ActionPerformed

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
    private javax.swing.JLabel jLabel2;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
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
