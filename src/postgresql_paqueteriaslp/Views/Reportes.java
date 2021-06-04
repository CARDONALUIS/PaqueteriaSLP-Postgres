/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package postgresql_paqueteriaslp.Views;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import postgresql_paqueteriaslp.Home;

/**
 *
 * @author Luis Pablo Rocha
 */
public class Reportes extends javax.swing.JFrame {
    String pass = "postgres";
    String user = "postgres";
    Connection conexion;
    DefaultTableModel modelo = new DefaultTableModel();
    DefaultTableModel modeloconsulta2 = new DefaultTableModel();
    /**
     * Creates new form Reportes
     */
    public Reportes() {
        initComponents();
        estableceConexion();
        rellenaCombos();
    }
    
    public void estableceConexion()
    {
        try {
            conexion = DriverManager.getConnection("jdbc:postgresql://localhost:5432/paqueteriaSLP",user, pass);            
        }catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al establecer conexion!!!"+ ex);
        }
    }
    
    public void rellenaCombos()
    {
        String datos[] = new String[3];
        JCBSucursal.removeAllItems();
        JCBTipo.removeAllItems();
        JCBSucursales.removeAllItems();
        
        JCBTipo.addItem("Comprado");
        JCBTipo.addItem("Arrendado");
                
        try {
            Statement at = conexion.createStatement();
            ResultSet rs = at.executeQuery("SELECT * FROM paqueteria.sucursal");
            while(rs.next())
            {
                datos[0] = rs.getString("idsucursal");
                datos[1] = rs.getString("nombresucursal");

                JCBSucursal.addItem(datos[0]+ "-" +datos[1]);
                JCBSucursales.addItem(datos[0]+ "-" +datos[1]);
            }           
            rs.close();
            at.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No pudimos agregar los items");
        }
    }
    
    
    public void modelo_tabla_Arrendado()
    {
        //JTCamiones.setAutoCreateColumnsFromModel(false);
        
        modelo.setColumnCount(0);
        
        modelo.addColumn("Tiempo de Contrato");
        modelo.addColumn("Cantidad de Camiones");
       
        JTCamiones.setModel(modelo);
    }
    
    public void modelo_tabla_Comprado()
    {
        modelo.setColumnCount(0);
                
        modelo.addColumn("Cantidad");
        modelo.addColumn("año de compra");
       
        JTCamiones.setModel(modelo);
    }
    
    public void modelo_tabla_Pago()
    {
        modeloconsulta2.setColumnCount(0);
                
        modeloconsulta2.addColumn("Sucursal");
        modeloconsulta2.addColumn("Monto total pagado");
       
        JTPagos.setModel(modeloconsulta2);
    }
    
    public String obtenFechaInicio()
    {
        int año = JCInicio.getCalendar().get(Calendar.YEAR);
        int mes = JCInicio.getCalendar().get(Calendar.MARCH)+1;
        int dia = JCInicio.getCalendar().get(Calendar.DAY_OF_MONTH);
                
        return (año+"-"+mes+"-"+dia);
    }
    
    public String obtenFechaFin()
    {
        int año = JCFin.getCalendar().get(Calendar.YEAR);
        int mes = JCFin.getCalendar().get(Calendar.MARCH)+1;
        int dia = JCFin.getCalendar().get(Calendar.DAY_OF_MONTH);
                
        return (año+"-"+mes+"-"+dia);
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        JCBSucursal = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        JCBTipo = new javax.swing.JComboBox<>();
        JBEjecutaC1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTCamiones = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        JTPagos = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        JCBSucursales = new javax.swing.JComboBox<>();
        JCInicio = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        JCFin = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        JBEjecutaC2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("CONSULTA 1 CAMIONES");

        JCBSucursal.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel2.setText("Sucursal");

        jLabel3.setText("TipoCamion");

        JCBTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        JBEjecutaC1.setText("Ejecutar");
        JBEjecutaC1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBEjecutaC1ActionPerformed(evt);
            }
        });

        JTCamiones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(JTCamiones);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("CONSULTA 2 PAGOS");

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
        jScrollPane2.setViewportView(JTPagos);

        jLabel5.setText("Sucursal");

        JCBSucursales.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel6.setText("fecha Inicio");

        jLabel7.setText("fecha Fin");

        JBEjecutaC2.setText("Ejecutar");
        JBEjecutaC2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBEjecutaC2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(224, 224, 224)
                                        .addComponent(JBEjecutaC1))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 479, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(JCBSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel3)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(JCBTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addComponent(jLabel4)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(226, 226, 226)
                                .addComponent(JBEjecutaC2)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(JCBSucursales, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addGap(14, 14, 14)
                        .addComponent(JCInicio, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JCFin, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JCBSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(JCBTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addComponent(JBEjecutaC1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(JCBSucursales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(JCInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(JCFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addComponent(JBEjecutaC2)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        Home vH = new Home();
        vH.setVisible(true);
        this.dispose();           // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosing

    private void JBEjecutaC1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBEjecutaC1ActionPerformed
        // TODO add your handling code here:
        modelo.setRowCount(0);
        
        String datos[] = new String[3];
        
        String idSucursal = ((String)JCBSucursal.getSelectedItem()).substring(0, 1);        
                        
        String tipo = (String)JCBTipo.getSelectedItem();
        
        if(tipo == "Arrendado")
        {
            modelo_tabla_Arrendado();
            try {
            Statement at = conexion.createStatement();
            ResultSet rs = at.executeQuery("SELECT Paqueteria.Arrendado.tiempoContrato, COUNT(Paqueteria.Arrendado.tiempoContrato) FROM Paqueteria.Camion "
                    + "INNER JOIN Paqueteria.Arrendado ON Paqueteria.Camion.idCamion = Paqueteria.Arrendado.idCamion " 
                    + "WHERE Paqueteria.Camion.idSucursal = "+idSucursal+" GROUP BY(Paqueteria.Arrendado.tiempoContrato) ");
            while(rs.next())
            {
                datos[0] = rs.getString("tiempoContrato");
                datos[1] = rs.getString("count");

                modelo.addRow(datos);
            }           
            rs.close();
            at.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "No pudimos obtener los datos");
            }
        }
        else{

            modelo_tabla_Comprado();
           try {
            Statement at = conexion.createStatement();
            ResultSet rs = at.executeQuery("SELECT COUNT(Paqueteria.comprado.fechacompra), EXTRACT (YEAR FROM Paqueteria.comprado.fechacompra) as cs\n" +
            "FROM Paqueteria.Comprado INNER JOIN Paqueteria.camion ON Paqueteria.Comprado.idCamion = Paqueteria.camion.idCamion\n" +
            "WHERE Paqueteria.camion.idSucursal = "+idSucursal+" GROUP BY (cs)");
            while(rs.next())
            {
                datos[0] = rs.getString("count");
                datos[1] = rs.getString("cs");

                modelo.addRow(datos);
            }           
            rs.close();
            at.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "No pudimos obtener los datos");
            } 
        }                
    }//GEN-LAST:event_JBEjecutaC1ActionPerformed

    private void JBEjecutaC2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBEjecutaC2ActionPerformed
        // TODO add your handling code here:
        modeloconsulta2.setRowCount(0);
        
        String datos[] = new String[3];
        
        String idSucursal = ((String)JCBSucursales.getSelectedItem()).substring(0, 1);        
                            
        String fechaInicio = obtenFechaInicio();
        
        String fechaFin = obtenFechaFin();
        
        modelo_tabla_Pago();
        try {
         Statement at = conexion.createStatement();
         ResultSet rs = at.executeQuery("SELECT *, COALESCE((SELECT SUM(monto) FROM paqueteria.pago T1 WHERE T0.idsucursal = T1.idsucursal AND " +
                                    "fechainicioperiodo >= '"+obtenFechaInicio()+"' AND fechafinperiodo <= '"+obtenFechaFin()+"'),0) " +
                                    "as montoPago FROM paqueteria.sucursal T0 WHERE T0.idsucursal = "+idSucursal+" ");
         while(rs.next())
         {
             datos[0] = rs.getString("nombresucursal");
             datos[1] = rs.getString("montopago");

             modeloconsulta2.addRow(datos);
         }           
         rs.close();
         at.close();
         } catch (Exception e) {
             JOptionPane.showMessageDialog(null, "No pudimos obtener los datos");
         }                       
    }//GEN-LAST:event_JBEjecutaC2ActionPerformed

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
            java.util.logging.Logger.getLogger(Reportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Reportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Reportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Reportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Reportes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBEjecutaC1;
    private javax.swing.JButton JBEjecutaC2;
    private javax.swing.JComboBox<String> JCBSucursal;
    private javax.swing.JComboBox<String> JCBSucursales;
    private javax.swing.JComboBox<String> JCBTipo;
    private com.toedter.calendar.JDateChooser JCFin;
    private com.toedter.calendar.JDateChooser JCInicio;
    private javax.swing.JTable JTCamiones;
    private javax.swing.JTable JTPagos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
