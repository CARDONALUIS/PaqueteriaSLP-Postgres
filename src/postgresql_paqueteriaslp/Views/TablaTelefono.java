package postgresql_paqueteriaslp.Views;
import javax.swing.JOptionPane;
import postgresql_paqueteriaslp.Home;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.Statement;
import java.sql.ResultSet;

public class TablaTelefono extends javax.swing.JFrame {

    Connection conexion;
    String pass;
    String user;
    DefaultTableModel modelo = new DefaultTableModel();
    int idSucursalAct;
    int idTelefono;
    public boolean permiso = true;
    String rol;
    
    public TablaTelefono() {
        initComponents();
        
    }
    
    public void getRoleofUser(){
        String datos[] = new String[2];
        try {
            Statement at = conexion.createStatement();
            ResultSet rs = at.executeQuery("SELECT r.rolname, ARRAY(SELECT b.rolname FROM pg_catalog.pg_auth_members m JOIN pg_catalog.pg_roles b ON (m.roleid = b.oid) " +
                "WHERE m.member = r.oid) as memberof FROM pg_catalog.pg_roles r WHERE r.rolname = "+"'"+user+"'"+"");
            while(rs.next())
            {
                datos[0] = rs.getString("rolname");
                datos[1] = rs.getString("memberof");
                rol = datos[1];
            }
            rs.close();
            at.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No pudimos obtener el rol: "+e);
            permiso = false;
        }
    }
    
    public void setUserYCon(String _user,String _pass)
    {
        pass = _pass;
        user = _user;
         
        estableceConexion();
        modelo_tabla();
        fillTabla();
        getRoleofUser();
        desactivaComponentes();
        agregaComboBoxSucursales();         
    }
    
    public void desactivaComponentes()
    {
        switch(rol){
            case "{secretario}":
            {
                JBInsertarTel.setEnabled(false);
                JBModTel.setEnabled(false);
                JBElimTel.setEnabled(false);
                JCboxSuc.setEnabled(false);
                JTextTelefono.setEnabled(false);
            }
            case "{camionero}":
            {
                JBInsertarTel.setEnabled(false);
                JBModTel.setEnabled(false);
                JBElimTel.setEnabled(false);
                JCboxSuc.setEnabled(false);
                JTextTelefono.setEnabled(false);
            }
        }
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelTel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTableTelefono = new javax.swing.JTable();
        JCboxSuc = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        JTextTelefono = new javax.swing.JTextField();
        JBInsertarTel = new javax.swing.JButton();
        JBModTel = new javax.swing.JButton();
        JBElimTel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabelTel.setText("TABLA DE TELEFONO");

        JTableTelefono.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        JTableTelefono.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTableTelefonoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(JTableTelefono);

        JCboxSuc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel1.setText("Sucursal");

        jLabel2.setText("Telefono");

        JBInsertarTel.setText("Insertar");
        JBInsertarTel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBInsertarTelActionPerformed(evt);
            }
        });

        JBModTel.setText("Modificar");
        JBModTel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBModTelActionPerformed(evt);
            }
        });

        JBElimTel.setText("Eliminar");
        JBElimTel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBElimTelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelTel)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(50, 50, 50)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(JCboxSuc, 0, 125, Short.MAX_VALUE)
                                .addComponent(JTextTelefono))
                            .addGap(47, 47, 47)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(JBModTel, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                                .addComponent(JBInsertarTel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(JBElimTel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabelTel)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JCboxSuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(JBInsertarTel))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(JTextTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JBModTel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JBElimTel)
                        .addGap(59, 59, 59)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JTableTelefonoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTableTelefonoMouseClicked
        // TODO add your handling code here:
        int seleccionar = JTableTelefono.rowAtPoint(evt.getPoint());
        idTelefono = Integer.parseInt(String.valueOf(JTableTelefono.getValueAt(seleccionar, 0)));
        JTextTelefono.setText(String.valueOf(JTableTelefono.getValueAt(seleccionar, 3)));
        JCboxSuc.setSelectedItem(String.valueOf(JTableTelefono.getValueAt(seleccionar, 1))+"-"+String.valueOf(JTableTelefono.getValueAt(seleccionar, 2)));
    }//GEN-LAST:event_JTableTelefonoMouseClicked

    private void JBInsertarTelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBInsertarTelActionPerformed
        obtenIDSucursalComboBox();
        try {
            Statement st = conexion.createStatement();
            String sql = "INSERT INTO paqueteria.telefono(idSucursal,telefono)"
                    +"VALUES('"+idSucursalAct+"','"+JTextTelefono.getText()+"')";
            
            st.executeUpdate(sql);
            st.close();
            fillTabla();
            limpiaFormulario();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al insertar "+e);
        }
    }//GEN-LAST:event_JBInsertarTelActionPerformed

    private void JBElimTelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBElimTelActionPerformed
        try {
            Statement st = conexion.createStatement();
            String sql = "DELETE FROM paqueteria.telefono WHERE idTelefono = "+idTelefono+"";                              
            st.executeUpdate(sql);
            st.close();
            fillTabla();
            limpiaFormulario();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar "+e);
        }
    }//GEN-LAST:event_JBElimTelActionPerformed

    private void JBModTelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBModTelActionPerformed
        obtenIDSucursalComboBox();
        try {
            Statement st = conexion.createStatement();
            String sql = "UPDATE paqueteria.telefono SET idSucursal = '"+idSucursalAct+"', telefono"
                    + " = '"+JTextTelefono.getText()+"' WHERE idTelefono = '"+idTelefono+"'";
            st.executeUpdate(sql);
            st.close();
            fillTabla();
            limpiaFormulario();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar "+e);
        }
       
    }//GEN-LAST:event_JBModTelActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        Home vH = new Home();
        vH.setVisible(true);
        this.dispose(); 
    }//GEN-LAST:event_formWindowClosing

     public void obtenIDSucursalComboBox()
    {  
        String it = (String)JCboxSuc.getSelectedItem();
        
        try {
            Statement at = conexion.createStatement();
            ResultSet rs = at.executeQuery("SELECT * FROM paqueteria.sucursal WHERE idSucursal = '"+it.split("-")[0]+"'");
            while(rs.next())
            {
                idSucursalAct = Integer.parseInt(rs.getString("idSucursal"));
            }
            
            rs.close();
            at.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No pudimos econtrar la sucursal a agregar "+ e);
            permiso = false;
        }
    }
     public void estableceConexion()
    {
        try {
            conexion = DriverManager.getConnection("jdbc:postgresql://localhost:5432/paqueteriaSLP",user, pass);            
        }catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al establecer conexion!!!"+ ex);
        }
    }
     
     public void modelo_tabla()
    {
        modelo.addColumn("ID Telefono");
        modelo.addColumn("ID Sucursal");
        modelo.addColumn("Nombre Sucursal");
        modelo.addColumn("Telefono");
        JTableTelefono.setModel(modelo);
    }
     
    public void limpiaFormulario(){
         JTextTelefono.setText("");
    }
     
     public void fillTabla()
    {
        modelo.setRowCount(0);
        String datos[] = new String[4];
        
        try {
            Statement at = conexion.createStatement();
            ResultSet rs = at.executeQuery("SELECT * FROM paqueteria.telefono "
                    + "INNER JOIN paqueteria.sucursal "
                    + "ON paqueteria.telefono.idSucursal = paqueteria.sucursal.idSucursal");
            while(rs.next())
            {
                datos[0] = rs.getString("idTelefono");
                datos[1] = rs.getString("idSucursal");
                datos[2] = rs.getString("nombreSucursal");
                datos[3] = rs.getString("telefono");

                modelo.addRow(datos);
            }           
            rs.close();
            at.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No pudimos actualizar tu tabla: "+e);
            permiso = false;
        }
    }
     
      public void agregaComboBoxSucursales()
    {
        String datos[] = new String[2];
        JCboxSuc.removeAllItems();
                
        try {
            Statement at = conexion.createStatement();
            ResultSet rs = at.executeQuery("SELECT * FROM paqueteria.sucursal");
            while(rs.next())
            {
                datos[0] = rs.getString("idsucursal");
                datos[1] = rs.getString("nombresucursal");
                
                JCboxSuc.addItem(datos[0]+ "-" +datos[1]);
            }
            
            rs.close();
            at.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No pudimos agregar los items");
            permiso = false;
        }
    }
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
            java.util.logging.Logger.getLogger(TablaTelefono.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TablaTelefono.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TablaTelefono.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TablaTelefono.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TablaTelefono().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBElimTel;
    private javax.swing.JButton JBInsertarTel;
    private javax.swing.JButton JBModTel;
    private javax.swing.JComboBox<String> JCboxSuc;
    private javax.swing.JTable JTableTelefono;
    private javax.swing.JTextField JTextTelefono;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelTel;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
