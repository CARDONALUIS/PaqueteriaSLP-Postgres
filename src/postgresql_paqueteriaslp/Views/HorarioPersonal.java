
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

public class HorarioPersonal extends javax.swing.JFrame {
    Connection conexion;
    String pass="postgres";
    String user ="postgres";
    DefaultTableModel modelo = new DefaultTableModel();
    int idPersonal;
    
    public HorarioPersonal() {
        initComponents();
        estableceConexion();
        modelo_tabla();
        fillTabla();
        limpiaControlesYAddLlaves();
    }
    
    public void estableceConexion()
    {
        try {
            conexion = DriverManager.getConnection("jdbc:postgresql://localhost:5432/paqueteriaSLP",user, pass);            
        }catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al establecer conexion!!!"+ ex);
        }
    }
    
    public void limpiaControlesYAddLlaves()
    {
        JCBLunes.setSelected(false);
        JCBMartes.setSelected(false);
        JCBMiercoles.setSelected(false);
        JCBJueves.setSelected(false);
        JCBViernes.setSelected(false);
        JCBSabado.setSelected(false);
        JCBDomingo.setSelected(false);
        agregaComboBox();
        JTHoras.setText("");         
    }
    
    public void agregaComboBox()
    {
        String datos[] = new String[3];
        JCBPersonal.removeAllItems();
                
        try {
            Statement at = conexion.createStatement();
            ResultSet rs = at.executeQuery("SELECT * FROM paqueteria.personal");
            while(rs.next())
            {
                datos[0] = rs.getString("nss");
                datos[1] = rs.getString("nombre");
                
                JCBPersonal.addItem(datos[0]+ "-" +datos[1]);
            }
            
            rs.close();
            at.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No pudimos agregar los items");
        }
    }
    
    public void modelo_tabla()
    {
        modelo.addColumn("Id Personal");
        modelo.addColumn("Horas");
        modelo.addColumn("Horario");
        JTHorarioPersonal.setModel(modelo);
    }
    
    public void fillTabla()
    {
        modelo.setRowCount(0);
        String datos[] = new String[3];
        
        try {
            Statement at = conexion.createStatement();
            ResultSet rs = at.executeQuery("SELECT * FROM paqueteria.horariopersonal");
            while(rs.next())
            {
                datos[0] = rs.getString("idPersonal");
                datos[1] = rs.getString("Horas");
                datos[2] = rs.getString("Horario");

                modelo.addRow(datos);
            }           
            rs.close();
            at.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No pudimos actualizar tu tabla");
        }
    }
    
    public String obtenDias()
    {
        String horarios = "";
        
        if(JCBLunes.isSelected())
        {
            horarios += "Lunes,";
        }
        
        if (JCBMartes.isSelected())
        {
            horarios += "Martes,";
        }

        if (JCBMiercoles.isSelected())
        {
            horarios += "Miercoles,";
        }

        if (JCBJueves.isSelected())
        {
            horarios += "Jueves,";
        }

        if (JCBViernes.isSelected())
        {
            horarios += "Viernes,";
        }

        if (JCBSabado.isSelected())
        {
            horarios += "Sabado,";
        }

        if (JCBDomingo.isSelected())
        {
            horarios += "Domingo,";
        }

            return horarios;
    }
    
    public void ChequeaBoxHorario(String _Horari)
    {
        int i = 0;
        String cadTem = "";

        while (i < _Horari.length())
        {
            cadTem += _Horari.charAt(i);

            switch (cadTem)
            {
                case "Lu":
                    JCBLunes.setSelected(true);
                    cadTem = "";
                    i += 4;
                    break;
                case "Ma":
                    JCBMartes.setSelected(true);
                    cadTem = "";
                    i += 5;
                    break;
                case "Mi":
                    JCBMiercoles.setSelected(true);
                    cadTem = "";
                    i += 8;
                    break;
                case "Ju":
                    JCBJueves.setSelected(true);
                    cadTem = "";
                    i += 5;
                    break;
                case "Vi":
                    JCBViernes.setSelected(true);
                    cadTem = "";
                    i += 6;
                    break;
                case "Sa":
                    JCBSabado.setSelected(true);
                    cadTem = "";
                    i += 5;
                    break;
                case "Do":
                    JCBDomingo.setSelected(true);
                    cadTem = "";
                    i += 6;
                    break;

            }
            i++;
        }
    }
    
    public void obtenIDComboBox()
    {  
        String it = (String)JCBPersonal.getSelectedItem();
        
        try {
            Statement at = conexion.createStatement();
            ResultSet rs = at.executeQuery("SELECT * FROM paqueteria.personal WHERE nss = '"+it.split("-")[0]+"'");
            while(rs.next())
            {
                idPersonal = Integer.parseInt(rs.getString("idpersonal"));
            }
            
            rs.close();
            at.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No pudimos econtrar la paersona a agregar");
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

        jScrollPane1 = new javax.swing.JScrollPane();
        JTHorarioPersonal = new javax.swing.JTable();
        JCBPersonal = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        JCBLunes = new javax.swing.JCheckBox();
        JCBMartes = new javax.swing.JCheckBox();
        JCBMiercoles = new javax.swing.JCheckBox();
        JCBJueves = new javax.swing.JCheckBox();
        JCBViernes = new javax.swing.JCheckBox();
        JCBSabado = new javax.swing.JCheckBox();
        JCBDomingo = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();
        JTHoras = new javax.swing.JTextField();
        JBInsertar = new javax.swing.JButton();
        JTEliminar = new javax.swing.JButton();
        JBActualizar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        JTHorarioPersonal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        JTHorarioPersonal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTHorarioPersonalMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(JTHorarioPersonal);

        JCBPersonal.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel1.setText("Horario");

        JCBLunes.setText("Lunes");

        JCBMartes.setText("Martes");

        JCBMiercoles.setText("Miercoles");

        JCBJueves.setText("Jueves");

        JCBViernes.setText("Viernes");

        JCBSabado.setText("Sabado");

        JCBDomingo.setText("Domingo");

        jLabel2.setText("Horas:");

        JBInsertar.setText("Insertar");
        JBInsertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBInsertarActionPerformed(evt);
            }
        });

        JTEliminar.setText("Eliminar");
        JTEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTEliminarActionPerformed(evt);
            }
        });

        JBActualizar.setText("Actualizar");
        JBActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBActualizarActionPerformed(evt);
            }
        });

        jLabel3.setText("Personal:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(JTHoras, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(JCBLunes)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(JCBMartes)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(JCBMiercoles)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(JCBJueves)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(JCBViernes))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabel3)
                                        .addGap(18, 18, 18)
                                        .addComponent(JCBPersonal, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(JBInsertar)
                                        .addGap(18, 18, 18)
                                        .addComponent(JTEliminar))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(JCBSabado)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(JCBDomingo))))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 685, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(31, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JBActualizar)
                        .addGap(288, 288, 288))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JCBPersonal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JBInsertar)
                    .addComponent(JTEliminar)
                    .addComponent(jLabel3))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JBActualizar)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JCBLunes)
                    .addComponent(JCBMartes)
                    .addComponent(JCBMiercoles)
                    .addComponent(JCBJueves)
                    .addComponent(JCBViernes)
                    .addComponent(JCBSabado)
                    .addComponent(JCBDomingo))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(JTHoras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        Home vH = new Home();
        vH.setVisible(true);
        this.dispose();     
    }//GEN-LAST:event_formWindowClosing

    private void JBInsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBInsertarActionPerformed
        try {
            
            String cadDias = obtenDias();
            Statement st = conexion.createStatement();
            obtenIDComboBox();
            String sql = "INSERT INTO paqueteria.horariopersonal(idPersonal,horario, horas)"
                    +"VALUES("+idPersonal+",'"+cadDias+"','"+JTHoras.getText()+"')";
            
            st.executeUpdate(sql);
            st.close();
            fillTabla();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al insertar "+e);
        }
        limpiaControlesYAddLlaves();
    }//GEN-LAST:event_JBInsertarActionPerformed

    private void JTEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTEliminarActionPerformed
        // TODO add your handling code here:
        JCBPersonal.setEnabled(true);
        try {
            Statement st = conexion.createStatement();
            String sql = "DELETE FROM paqueteria.horariopersonal WHERE idpersonal = "+idPersonal+"";                              
            st.executeUpdate(sql);
            st.close();
            fillTabla();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar "+e);
        }
        
        limpiaControlesYAddLlaves();
    }//GEN-LAST:event_JTEliminarActionPerformed

    private void JBActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBActualizarActionPerformed
        JCBPersonal.setEnabled(true);
        try {
            Statement st = conexion.createStatement();
            String sql = "UPDATE paqueteria.horariopersonal SET horario = '"+obtenDias()+"', horas"
                    + " = '"+JTHoras.getText()+"' WHERE idpersonal = "+idPersonal+" ";
            st.executeUpdate(sql);
            st.close();
            fillTabla();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar "+e);
        }
        
        limpiaControlesYAddLlaves();
    }//GEN-LAST:event_JBActualizarActionPerformed

    private void JTHorarioPersonalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTHorarioPersonalMouseClicked
        // TODO add your handling code here:
        limpiaControlesYAddLlaves();
        JCBPersonal.setEnabled(false);
        
        int seleccionar = JTHorarioPersonal.rowAtPoint(evt.getPoint());
        
        idPersonal = Integer.parseInt(String.valueOf(JTHorarioPersonal.getValueAt(seleccionar, 0)));
        
        JTHoras.setText(String.valueOf(JTHorarioPersonal.getValueAt(seleccionar, 1)));
        
        String cadDias = String.valueOf(JTHorarioPersonal.getValueAt(seleccionar, 2));
        
        ChequeaBoxHorario(cadDias);
                      
    }//GEN-LAST:event_JTHorarioPersonalMouseClicked

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
            java.util.logging.Logger.getLogger(HorarioPersonal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HorarioPersonal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HorarioPersonal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HorarioPersonal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HorarioPersonal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBActualizar;
    private javax.swing.JButton JBInsertar;
    private javax.swing.JCheckBox JCBDomingo;
    private javax.swing.JCheckBox JCBJueves;
    private javax.swing.JCheckBox JCBLunes;
    private javax.swing.JCheckBox JCBMartes;
    private javax.swing.JCheckBox JCBMiercoles;
    private javax.swing.JComboBox<String> JCBPersonal;
    private javax.swing.JCheckBox JCBSabado;
    private javax.swing.JCheckBox JCBViernes;
    private javax.swing.JButton JTEliminar;
    private javax.swing.JTable JTHorarioPersonal;
    private javax.swing.JTextField JTHoras;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
