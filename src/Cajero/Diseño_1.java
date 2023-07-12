
package Cajero;

import javax.swing.JButton;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import  javax.swing.JPanel;    

import javax.swing.JOptionPane;

public class Diseño_1 extends javax.swing.JFrame {
    private int fondo;

    public Diseño_1() {
        initComponents();
        fondo = 0;
    }

    private void initComponents() {
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnRetirar = new javax.swing.JButton();
        btnDepositar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cajero Automático");

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24));
        jLabel1.setText("Fondo: $0");

        btnRetirar.setFont(new java.awt.Font("Tahoma", 1, 18));
        btnRetirar.setText("Retirar");
        btnRetirar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRetirarActionPerformed(evt);
            }
        });

        btnDepositar.setFont(new java.awt.Font("Tahoma", 1, 18));
        btnDepositar.setText("Depositar");
        btnDepositar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDepositarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnRetirar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(btnDepositar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(63, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRetirar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDepositar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(83, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }                         

    private void btnRetirarActionPerformed(java.awt.event.ActionEvent evt) {                                           
        String cantidadStr = JOptionPane.showInputDialog(this, "Ingrese la cantidad a retirar:");
        if (cantidadStr != null && !cantidadStr.isEmpty()) {
            try {
                int cantidad = Integer.parseInt(cantidadStr);
                if (cantidad > 0) {
                    if (cantidad <= fondo) {
                        fondo -= cantidad;
                        actualizarFondo();
                        JOptionPane.showMessageDialog(this, "Retire su dinero");
                    } else {
                        JOptionPane.showMessageDialog(this, "Fondos insuficientes");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Ingrese una cantidad válida");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Ingrese una cantidad válida");
            }
        }
    }                                          

    private void btnDepositarActionPerformed(java.awt.event.ActionEvent evt) {                                             
        String claveStr = JOptionPane.showInputDialog(this, "Ingrese la clave:");
        if (claveStr != null && !claveStr.isEmpty()) {
            try {
                int clave = Integer.parseInt(claveStr);
                if (clave == 1234) {  // Supongamos que la clave es 1234
                    String montoStr = JOptionPane.showInputDialog(this, "Ingrese el monto a depositar:");
                    if (montoStr != null && !montoStr.isEmpty()) {
                        try {
                            int monto = Integer.parseInt(montoStr);
                            if (monto > 0) {
                                fondo += monto;
                                actualizarFondo();
                                JOptionPane.showMessageDialog(this, "Depósito realizado");
                            } else {
                                JOptionPane.showMessageDialog(this, "Ingrese un monto válido");
                            }
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(this, "Ingrese un monto válido");
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Clave incorrecta");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Ingrese una clave válida");
            }
        }
    }                                            

    private void actualizarFondo() {
        jLabel1.setText("Fondo: $" + fondo);
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Diseño_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Diseño_1().setVisible(true);
            }
        });
        
        Cliente cliente1 = new Cliente("Michellin", new int[]{2, 2, 1, 5, 2});
        Cliente cliente2 = new Cliente("Juana", new int[]{1, 1, 6, 2, 2});

        Cajera cajera1 = new Cajera("Luisa");
        Cajera cajera2 = new Cajera("Mario Francisco");

        long initialTime = System.currentTimeMillis();

        cajera1.procesarCompra(cliente1, initialTime);
        cajera2.procesarCompra(cliente2, initialTime);
    }

    private javax.swing.JButton btnDepositar;
    private javax.swing.JButton btnRetirar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
}