package postgresql_paqueteriaslp.Views;
import javax.swing.JOptionPane;
import postgresql_paqueteriaslp.Home;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import java.sql.Statement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Pago extends javax.swing.JFrame {
    Connection conexion;
    String pass="postgres";
    String user ="postgres";
    DefaultTableModel modelo = new DefaultTableModel();
    int idPersonal;
    int idPagoActual;
    double salarioPersonal;
    int idSucursal;
    int diasAPagar;
    String firstDayMonth;
    String lastDayMonth;
    
    public Pago() {
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
        String datos[] = new String[2];
        JCBPersonal.removeAllItems();
        JCBIniPeriodo.removeAllItems();
        JCBFinPeriodo.removeAllItems();
                        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");  
        
        Calendar c = Calendar.getInstance();    
        c.add(Calendar.MONTH, 0);
        c.set (Calendar.DAY_OF_MONTH, 1); // Establecido en el 1, la fecha actual es el primer día del mes 
        firstDayMonth = sdf.format(c.getTime());

        JCBIniPeriodo.addItem(firstDayMonth);
        JCBIniPeriodo.setEnabled(false);
      
        // Obtener el último día del mes actual
        Calendar ca = Calendar.getInstance();    
        ca.set(Calendar.DAY_OF_MONTH, ca.getActualMaximum(Calendar.DAY_OF_MONTH));  
        lastDayMonth = sdf.format(ca.getTime());

        
        JCBFinPeriodo.addItem(lastDayMonth);
        JCBFinPeriodo.setEnabled(false);
        
        //int milisecondsByDay = 86400000;long finMS = fin.getTimeInMillis();
        long finMS = ca.getTimeInMillis();
        long inicioMS = c.getTimeInMillis();
 
        diasAPagar = (int) ((Math.abs(finMS - inicioMS)) / (86400000));
        
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
        modelo.addColumn("Id Pago");
        modelo.addColumn("sucursal");
        modelo.addColumn("personal");
        modelo.addColumn("Monto");
        modelo.addColumn("FechaInicioPeriodo");
        modelo.addColumn("FechaFinPeriodo");
        modelo.addColumn("asistencias");
        JTPagos.setModel(modelo);
    }
    
    public void fillTabla()
    {
        modelo.setRowCount(0);
        String datos[] = new String[7];
        
        try {
            Statement at = conexion.createStatement();
            ResultSet rs = at.executeQuery("SELECT * FROM paqueteria.pago INNER JOIN paqueteria.sucursal ON paqueteria.pago.idSucursal = paqueteria.sucursal.idsucursal INNER JOIN paqueteria.personal ON paqueteria.pago.idPersonal = paqueteria.personal.idpersonal");
            while(rs.next())
            {
                datos[0] = rs.getString("idpago");
                datos[1] = rs.getString("idsucursal") +"-"+ rs.getString("nombreSucursal");
                datos[2] = rs.getString("nss") +"-"+ rs.getString("nombre");
                datos[3] = rs.getString("monto");
                datos[4] = rs.getString("fechainicioperiodo");
                datos[5] = rs.getString("fechafinperiodo"); 
                datos[6] = rs.getString("asistencias");
                
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
                idSucursal = Integer.parseInt(rs.getString("idsucursal"));
                salarioPersonal = Integer.parseInt(rs.getString("salario"));
            }
            
            rs.close();
            at.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No pudimos econtrar la paersona a agregar");
        }
        

    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JBRealizaPagos = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        JCBIniPeriodo = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        JCBFinPeriodo = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        JCBPersonal = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTPagos = new javax.swing.JTable();
        JBEliminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        JBRealizaPagos.setText("Realizar pagos");
        JBRealizaPagos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBRealizaPagosActionPerformed(evt);
            }
        });

        jLabel2.setText("Periodo de");

        JCBIniPeriodo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel3.setText("al");

        JCBFinPeriodo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel4.setText("Personal:");

        JCBPersonal.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        JTPagos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        JTPagos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTPagosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(JTPagos);

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
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 959, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JBRealizaPagos)
                        .addGap(45, 45, 45)
                        .addComponent(JBEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JCBPersonal, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JCBIniPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(JCBFinPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(JCBIniPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(JCBFinPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(JCBPersonal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBRealizaPagos)
                    .addComponent(JBEliminar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        Home vH = new Home();
        vH.setVisible(true);
        this.dispose(); 
    }//GEN-LAST:event_formWindowClosing

    private void JBRealizaPagosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBRealizaPagosActionPerformed
        // TODO add your handling code here:         
        String datos[] = new String[7];
        obtenIDComboBox(); 
        int contAsis = 0;
        
        //JOptionPane.showMessageDialog(null, "Personal: "+ idPersonal);
        
        try {
            Statement at = conexion.createStatement();
            ResultSet rs = at.executeQuery("SELECT * FROM paqueteria.asistencia WHERE idpersonal = '"+idPersonal+"' AND fecha BETWEEN '"+firstDayMonth+"' AND '"+lastDayMonth+"' ");
            while(rs.next())
            {
                contAsis++;
            }    
            rs.close();
            at.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No pudimos obtener las asistencias");
        }
        
        double monto = salarioPersonal/diasAPagar*contAsis;
        //JOptionPane.showMessageDialog(null, "Dias: "+ diasAPagar)
                
        try {
            
            Statement st = conexion.createStatement();
            obtenIDComboBox();
            String sql = "INSERT INTO paqueteria.pago(idsucursal,idpersonal, monto, fechainicioperiodo, fechafinperiodo, asistencias)"
                    +"VALUES("+idSucursal+","+idPersonal+",'"+monto+"' ,'"+firstDayMonth+"', '"+lastDayMonth+"', "+contAsis+" )";
            
            st.executeUpdate(sql);
            st.close();
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al insertar pago "+e);
        }
        
        try {
            Statement st = conexion.createStatement();
            String sql = "DELETE FROM paqueteria.asistencia WHERE idpersonal = "+idPersonal+" AND fecha BETWEEN '"+firstDayMonth+"' AND '"+lastDayMonth+"' ";                              
            st.executeUpdate(sql);
            st.close();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar "+e);
        }
        
        fillTabla();
        
        limpiaControlesYAddLlaves();
    }//GEN-LAST:event_JBRealizaPagosActionPerformed

    private void JBEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBEliminarActionPerformed
        // TODO add your handling code here:
        JCBPersonal.setEnabled(true);
        try {
            Statement st = conexion.createStatement();
            String sql = "DELETE FROM paqueteria.pago WHERE idpago = "+idPagoActual+"";                              
            st.executeUpdate(sql);
            st.close();
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar "+e);
        }
        
        
        fillTabla();
        
        limpiaControlesYAddLlaves();
    }//GEN-LAST:event_JBEliminarActionPerformed

    private void JTPagosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTPagosMouseClicked
        // TODO add your handling code here:
        limpiaControlesYAddLlaves();
        JCBPersonal.setEnabled(false);
        
        int seleccionar = JTPagos.rowAtPoint(evt.getPoint());
        
        idPagoActual = Integer.parseInt(String.valueOf(JTPagos.getValueAt(seleccionar, 0)));
        
    }//GEN-LAST:event_JTPagosMouseClicked

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
            java.util.logging.Logger.getLogger(Pago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pago().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBEliminar;
    private javax.swing.JButton JBRealizaPagos;
    private javax.swing.JComboBox<String> JCBFinPeriodo;
    private javax.swing.JComboBox<String> JCBIniPeriodo;
    private javax.swing.JComboBox<String> JCBPersonal;
    private javax.swing.JTable JTPagos;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
