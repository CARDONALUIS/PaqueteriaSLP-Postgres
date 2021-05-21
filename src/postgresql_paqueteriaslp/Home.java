package postgresql_paqueteriaslp;
import javax.swing.JOptionPane;
import postgresql_paqueteriaslp.Views.*;

public class Home extends javax.swing.JFrame {

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
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        VenTabSucursal = new javax.swing.JMenuItem();
        jMenuTelefono = new javax.swing.JMenuItem();
        Prueba = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
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
        Prueba.add(jMenuItem2);

        jMenuItem3.setText("HorarioPersonal");
        Prueba.add(jMenuItem3);

        jMenuItem4.setText("Asistencia");
        Prueba.add(jMenuItem4);

        jMenuBar1.add(Prueba);

        jMenu2.setText("Camion");

        jMenuItem6.setText("Camion");
        jMenu2.add(jMenuItem6);

        jMenuItem7.setText("Comprado");
        jMenu2.add(jMenuItem7);

        jMenuItem8.setText("Arrendado");
        jMenu2.add(jMenuItem8);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Pago");

        jMenuItem11.setText("Pago");
        jMenu3.add(jMenuItem11);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Ruta");

        jMenuItem9.setText("Ruta");
        jMenu4.add(jMenuItem9);

        jMenuItem10.setText("AsignacionDeRutas");
        jMenu4.add(jMenuItem10);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(169, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(167, 167, 167))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(125, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(140, 140, 140))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //De esta manera se abre una JFrame que seria la ventan de la tabla de sucursal
    private void VenTabSucursalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VenTabSucursalActionPerformed
        TablaSucursal vSuc = new TablaSucursal();
        vSuc.setVisible(true);
        vSuc.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_VenTabSucursalActionPerformed

    private void PruebaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PruebaActionPerformed
        JOptionPane.showMessageDialog(null,"Probando");
    }//GEN-LAST:event_PruebaActionPerformed

    private void jMenuTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuTelefonoActionPerformed
        TablaTelefono vTel = new TablaTelefono();
        vTel.setVisible(true);
        vTel.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_jMenuTelefonoActionPerformed

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
    private javax.swing.JMenu Prueba;
    private javax.swing.JMenuItem VenTabSucursal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JMenuItem jMenuTelefono;
    // End of variables declaration//GEN-END:variables
}
