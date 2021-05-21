
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
import java.util.Calendar;
import java.util.Date;

public class Asistencia extends javax.swing.JFrame {
    Connection conexion;
    String pass="postgres";
    String user ="postgres";
    DefaultTableModel modelo = new DefaultTableModel();
    int idPersonal;
    
    public Asistencia() {
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
        agregaComboBox();        
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
        modelo.addColumn("HoraLlegada");
        modelo.addColumn("HoraSalida");
        modelo.addColumn("fecha");
        JTAsistencias.setModel(modelo);
    }
    
    public void fillTabla()
    {
        modelo.setRowCount(0);
        String datos[] = new String[4];
        
        try {
            Statement at = conexion.createStatement();
            ResultSet rs = at.executeQuery("SELECT * FROM paqueteria.asistencia");
            while(rs.next())
            {
                datos[0] = rs.getString("idPersonal");
                datos[1] = rs.getString("HorarioLlegada");
                datos[2] = rs.getString("HorarioSalida");
                datos[3] = rs.getString("fecha");    
                
                modelo.addRow(datos);
            }           
            rs.close();
            at.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No pudimos actualizar tu tabla");
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
    
    public String obtenHoraActual()
    {
        String cadHora ="";
        
        Calendar calendario = Calendar.getInstance();
        int hora, minutos, segundos;
        hora = calendario.get(Calendar.HOUR_OF_DAY);
        minutos = calendario.get(Calendar.MINUTE);
        segundos = calendario.get(Calendar.SECOND);
        
        cadHora = hora+":"+minutos+":"+segundos;
        
        return cadHora;
    }
    
    /*public Date obtenFechaEntrada()
    {
        String cadHora ="";
        
        Date fecha = new Date();
        Calendar c1 = Calendar.getInstance();
        String dia = Integer.toString(c1.get(Calendar.DATE));
        String mes = Integer.toString(c1.get(Calendar.MONTH));
        String annio = Integer.toString(c1.get(Calendar.YEAR));
        
        return cadHora;
    }*/
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        JTAsistencias = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        JCBPersonal = new javax.swing.JComboBox<>();
        JBRegLlegada = new javax.swing.JButton();
        JBRegSalida = new javax.swing.JButton();
        JBEliminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        JTAsistencias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        JTAsistencias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTAsistenciasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(JTAsistencias);

        jLabel1.setText("Personal:");

        JCBPersonal.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        JBRegLlegada.setText("Registrar Llegada");
        JBRegLlegada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBRegLlegadaActionPerformed(evt);
            }
        });

        JBRegSalida.setText("Registrar Salida");
        JBRegSalida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBRegSalidaActionPerformed(evt);
            }
        });

        JBEliminar.setText("Eliminar");
        JBEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(JCBPersonal, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(98, 98, 98)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JBRegSalida)
                            .addComponent(JBRegLlegada))
                        .addGap(22, 22, 22)
                        .addComponent(JBEliminar))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 541, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(JCBPersonal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JBEliminar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JBRegLlegada)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(JBRegSalida)
                        .addGap(18, 18, 18)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        Home vH = new Home();
        vH.setVisible(true);
        this.dispose();   
    }//GEN-LAST:event_formWindowClosing

    private void JBRegLlegadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBRegLlegadaActionPerformed
        // TODO add your handling code here:
        try {
            
            String horEntr = obtenHoraActual();
            Date fecha = new Date();
            Statement st = conexion.createStatement();
            obtenIDComboBox();
            String sql = "INSERT INTO paqueteria.asistencia(idPersonal,horarioLlegada,fecha)"
                    +"VALUES("+idPersonal+",'"+horEntr+"','"+fecha+"')";
            
            st.executeUpdate(sql);
            st.close();
            fillTabla();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al insertar "+e);
        }
        limpiaControlesYAddLlaves();
    }//GEN-LAST:event_JBRegLlegadaActionPerformed

    private void JBRegSalidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBRegSalidaActionPerformed
        //ACTUALIZAR
        JCBPersonal.setEnabled(true);
        Date fechaHoy = new Date();
        try {
            Statement st = conexion.createStatement();
            String sql = "UPDATE paqueteria.asistencia SET horariosalida = '"+obtenHoraActual()+"'"
                    + "WHERE idpersonal = "+idPersonal+" AND horariosalida is null AND fecha = '"+fechaHoy+"' ";
            st.executeUpdate(sql);
            st.close();
            fillTabla();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar "+e);
        }
        
        
    }//GEN-LAST:event_JBRegSalidaActionPerformed

    private void JBEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBEliminarActionPerformed
        JCBPersonal.setEnabled(true);
        try {
            Statement st = conexion.createStatement();
            String sql = "DELETE FROM paqueteria.asistencia WHERE idpersonal = "+idPersonal+"";                              
            st.executeUpdate(sql);
            st.close();
            fillTabla();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar "+e);
        }
        
        limpiaControlesYAddLlaves();
    }//GEN-LAST:event_JBEliminarActionPerformed

    private void JTAsistenciasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTAsistenciasMouseClicked
        limpiaControlesYAddLlaves();
        JCBPersonal.setEnabled(false);
        
        int seleccionar = JTAsistencias.rowAtPoint(evt.getPoint());
        
        idPersonal = Integer.parseInt(String.valueOf(JTAsistencias.getValueAt(seleccionar, 0)));        
    }//GEN-LAST:event_JTAsistenciasMouseClicked

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
            java.util.logging.Logger.getLogger(Asistencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Asistencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Asistencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Asistencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Asistencia().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBEliminar;
    private javax.swing.JButton JBRegLlegada;
    private javax.swing.JButton JBRegSalida;
    private javax.swing.JComboBox<String> JCBPersonal;
    private javax.swing.JTable JTAsistencias;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
