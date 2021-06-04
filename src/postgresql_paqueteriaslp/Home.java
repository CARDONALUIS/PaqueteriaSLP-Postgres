package postgresql_paqueteriaslp;
import javax.swing.JOptionPane;
import postgresql_paqueteriaslp.Views.*;

public class Home extends javax.swing.JFrame {
    public boolean cerrarVentana; 
    
    public Home() {
        initComponents();
        setLocationRelativeTo(null);//Centrar la ventana       
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        JTUsuario = new javax.swing.JTextField();
        JTContraseña = new javax.swing.JPasswordField();
        jButtonReportes = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        VenTabSucursal = new javax.swing.JMenuItem();
        jMenuTelefono = new javax.swing.JMenuItem();
        Prueba = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        btnViewCamion = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();

        jMenuItem5.setText("jMenuItem5");

        jMenu5.setText("jMenu5");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setText("PAQUETERIA SLP");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Usuario:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Contraseña:");

        JTUsuario.setText("arturo");

        JTContraseña.setText("arturo123");

        jButtonReportes.setText("REPORTES");
        jButtonReportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonReportesActionPerformed(evt);
            }
        });

        jMenu1.setText("Sucursal");

        VenTabSucursal.setText("Sucursal");
        VenTabSucursal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VenTabSucursalActionPerformed(evt);
            }
        });
        jMenu1.add(VenTabSucursal);

        jMenuTelefono.setText("Telefono");
        jMenuTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuTelefonoActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuTelefono);

        jMenuBar1.add(jMenu1);

        Prueba.setText("Personal");
        Prueba.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PruebaActionPerformed(evt);
            }
        });

        jMenuItem2.setText("Personal");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VentanaPersonal(evt);
            }
        });
        Prueba.add(jMenuItem2);

        jMenuItem3.setText("HorarioPersonal");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VentanaHorarioPersonal(evt);
            }
        });
        Prueba.add(jMenuItem3);

        jMenuItem4.setText("Asistencia");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        Prueba.add(jMenuItem4);

        jMenuBar1.add(Prueba);

        btnViewCamion.setText("Camion");
        btnViewCamion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewCamionActionPerformed(evt);
            }
        });

        jMenuItem1.setText("Camion");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        btnViewCamion.add(jMenuItem1);

        jMenuBar1.add(btnViewCamion);

        jMenu3.setText("Pago");

        jMenuItem11.setText("Pago");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VentanaPago(evt);
            }
        });
        jMenu3.add(jMenuItem11);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Ruta");

        jMenuItem9.setText("Ruta");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem9);

        jMenuItem10.setText("AsignacionDeRutas");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem10);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(177, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(JTUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                            .addComponent(JTContraseña))
                        .addGap(242, 242, 242))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(159, 159, 159))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButtonReportes, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonReportes)
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JTUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(JTContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(118, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //De esta manera se abre una JFrame que seria la ventan de la tabla de sucursal
    private void VenTabSucursalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VenTabSucursalActionPerformed
        String user = JTUsuario.getText();
        String pass = JTContraseña.getText();
        TablaSucursal vSuc = new TablaSucursal();
        vSuc.setVisible(true);
        vSuc.setLocationRelativeTo(null);
        this.dispose();
        
        vSuc.setUserYCon(user, pass);
        
        if(!vSuc.permiso)
        {
            this.setVisible(true);
            vSuc.dispose();
        } 
    }//GEN-LAST:event_VenTabSucursalActionPerformed

    private void PruebaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PruebaActionPerformed
        JOptionPane.showMessageDialog(null,"Probando");
    }//GEN-LAST:event_PruebaActionPerformed


    private void jMenuTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuTelefonoActionPerformed
        String user = JTUsuario.getText();
        String pass = JTContraseña.getText();
        TablaTelefono vTel = new TablaTelefono();
        vTel.setVisible(true);
        vTel.setLocationRelativeTo(null);
        this.dispose();
        
        vTel.setUserYCon(user, pass);
        
        if(!vTel.permiso)
        {
            this.setVisible(true);
            vTel.dispose();
        }
    }//GEN-LAST:event_jMenuTelefonoActionPerformed

    private void VentanaHorarioPersonal(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VentanaHorarioPersonal
        // TODO add your handling code here:
        String user = JTUsuario.getText();
        String pass = JTContraseña.getText();
        HorarioPersonal vHoPer = new HorarioPersonal();
        vHoPer.setVisible(true);
        vHoPer.setLocationRelativeTo(null);
        this.dispose();
        
        vHoPer.setUserYCon(user, pass);
        
        if(!vHoPer.permiso)
        {
            this.setVisible(true);
            vHoPer.dispose();
        } 
    }//GEN-LAST:event_VentanaHorarioPersonal

    private void VentanaPersonal(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VentanaPersonal
        // TODO add your handling code here:
        String user = JTUsuario.getText();
        String pass = JTContraseña.getText();
        Personal vPer = new Personal();          
        vPer.setVisible(true);
        vPer.setLocationRelativeTo(null);
        this.dispose();
        
        vPer.setUserYCon(user, pass);
        
        if(!vPer.permiso)
        {
            this.setVisible(true);
            vPer.dispose();
        }        
    }//GEN-LAST:event_VentanaPersonal

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        String user = JTUsuario.getText();
        String pass = JTContraseña.getText();
        Asistencia vAsi = new Asistencia();
        vAsi.setVisible(true);
        vAsi.setLocationRelativeTo(null);
        this.dispose();
        
        vAsi.setUserYCon(user, pass);
        if(!vAsi.permiso)
        {
            this.setVisible(true);
            vAsi.dispose();
        } 
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void VentanaPago(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VentanaPago
        String user = JTUsuario.getText();
        String pass = JTContraseña.getText();
        Pago vPag = new Pago();
        vPag.setVisible(true);
        vPag.setLocationRelativeTo(null);
        this.dispose();
        
        vPag.setUserYCon(user, pass);
        
        if(!vPag.permiso)
        {
            this.setVisible(true);
            vPag.dispose();
        } 
        
    }//GEN-LAST:event_VentanaPago

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        String user = JTUsuario.getText();
        String pass = JTContraseña.getText();
        
        TablaRuta tRuta = new TablaRuta();
        tRuta.setVisible(true);
        tRuta.setLocationRelativeTo(null);
        this.dispose();
        
        tRuta.setUserYCon(user, pass);
        
        if(!tRuta.permiso)
        {
            this.setVisible(true);
            tRuta.dispose();
        } 
        
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void btnViewCamionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewCamionActionPerformed
         //ESTA EVENTO NO SIRVE
        /*
        Camion vAsi = new Camion();
        vAsi.setVisible(true);
        vAsi.setLocationRelativeTo(null);
        this.dispose();
        
        vAsi.setUserYCon(user, pass);
        
        JOptionPane.showMessageDialog(null, "PANTALLA DESPUES" + vAsi.permiso);
        if(!vAsi.permiso)
        {
            JOptionPane.showMessageDialog(null, "Entre a ocultarla");
            this.setVisible(true);
            vAsi.dispose();
        } */
    }//GEN-LAST:event_btnViewCamionActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        String user = JTUsuario.getText();
        String pass = JTContraseña.getText();
        Camion vAsi = new Camion();
        vAsi.setVisible(true);
        vAsi.setLocationRelativeTo(null);
        this.dispose();
        
        vAsi.setUserYCon(user, pass);
        
        if(!vAsi.permiso)
        {
            this.setVisible(true);
            vAsi.dispose();
        } 
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        String user = JTUsuario.getText();
        String pass = JTContraseña.getText();
        AsignacionRuta vRuta = new AsignacionRuta();  
        vRuta.setVisible(true);
        vRuta.setLocationRelativeTo(null);
        this.dispose();
        
        vRuta.setUserYCon(user, pass);
        if(!vRuta.permiso)
        {
            this.setVisible(true);
            vRuta.dispose();
        } 
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jButtonReportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonReportesActionPerformed
        Reportes vRep = new Reportes();
        vRep.setVisible(true);
        vRep.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_jButtonReportesActionPerformed


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
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField JTContraseña;
    private javax.swing.JTextField JTUsuario;
    private javax.swing.JMenu Prueba;
    private javax.swing.JMenuItem VenTabSucursal;
    private javax.swing.JMenu btnViewCamion;
    private javax.swing.JButton jButtonReportes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JMenuItem jMenuTelefono;
    // End of variables declaration//GEN-END:variables
}
