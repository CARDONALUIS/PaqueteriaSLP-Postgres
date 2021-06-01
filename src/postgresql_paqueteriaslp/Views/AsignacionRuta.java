/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package postgresql_paqueteriaslp.Views;

import com.toedter.calendar.JDateChooser;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import postgresql_paqueteriaslp.Home;

/**
 *
 * @author prisc
 */
public class AsignacionRuta extends javax.swing.JFrame {

    Connection conexion;
    String pass;
    String user;
    DefaultTableModel modelo = new DefaultTableModel();
    int idasignacionruta = -1;
    public boolean permiso = true;
    
    public AsignacionRuta() {
        initComponents();
        
    }
    
    public void setUserYCon(String _user,String _pass)
    {
        pass = _pass;
        user = _user;
         
        estableceConexion();
        cargaPersonal();
        cargaRutas();
        modelo_tabla();
        fillTabla();

    }
    
    public void modelo_tabla()
    {
        modelo.addColumn("idAsignacionRuta");
        modelo.addColumn("nss");
        modelo.addColumn("nombrePersonal");
        modelo.addColumn("idRuta");
        modelo.addColumn("Direcciones");
        modelo.addColumn("fechaInicio");
        modelo.addColumn("fechaFin");
        tbAsignacionRutas.setModel(modelo);
    }
    
    public void fillTabla()
    {
        modelo.setRowCount(0);
        String datos[] = new String[12];
        
        try {
            Statement at = conexion.createStatement();
            ResultSet rs = at.executeQuery("SELECT ar.idasignacionruta,\n" +
"   p.nss,\n" +
"   p.nombre as nombrepersonal,\n" +
"   r.idruta,\n" +
"   SO.nombresucursal  || ' - '  || SD.nombresucursal  || ' '  || R.horasalida as ruta,\n" +
"   ar.fechainicio,\n" +
"   ar.fechafin\n" +                
"   FROM PAQUETERIA.asignacionDeRutas ar\n" +
"   inner join PAQUETERIA.personal p on p.idpersonal = ar.idpersonal\n" +
"   inner join PAQUETERIA.ruta r on r.idruta = ar.idruta\n" +
"   inner join paqueteria.sucursal SO ON SO.idsucursal = r.idsucursalorigen\n" +
"   inner join paqueteria.sucursal SD on SD.idsucursal = r.idsucursaldestino;");
            while(rs.next())
            {
                datos[0] = rs.getString("idasignacionruta");
                datos[1] = rs.getString("nss");
                datos[2] = rs.getString("nombrepersonal");
                datos[3] = rs.getString("idruta");
                datos[4] = rs.getString("ruta");
                datos[5] = rs.getString("fechainicio");
                datos[6] = rs.getString("fechafin");

                modelo.addRow(datos);
            }           
            rs.close();
            at.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No pudimos actualizar tu tabla "+ e);
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
    
     public void cargaRutas()
    {
        String datos[] = new String[4];
        cmbRuta.removeAllItems();
                
        try {
            Statement at = conexion.createStatement();
            ResultSet rs = at.executeQuery("select R.idruta, SO.nombresucursal as SOrigen,\n" +
"   SD.nombresucursal as SDestino,\n" +
"   R.horasalida\n" +
"   from paqueteria.ruta R\n" +
"   inner join paqueteria.sucursal SO ON SO.idsucursal = R.idsucursalorigen\n" +
"   inner join paqueteria.sucursal SD on SD.idsucursal = R.idsucursaldestino; ");
            while(rs.next())
            {
                datos[0] = rs.getString("idruta");
                datos[1] = rs.getString("SOrigen");
                datos[2] = rs.getString("SDestino");
                datos[3] = rs.getString("horasalida");
                
                cmbRuta.addItem(datos[0]+ " - " +datos[1] + " - " + datos[2] + " - " + datos[3]);
            }
            
            rs.close();
            at.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No pudimos agregar el personal");
            permiso = false;
           
        }
    }
    
    public void cargaPersonal()
    {
        String datos[] = new String[3];
        cmbPersonal1.removeAllItems();
                
        try {
            Statement at = conexion.createStatement();
            ResultSet rs = at.executeQuery("SELECT * FROM paqueteria.personal where tipoempleado = 'Camionero'");
            while(rs.next())
            {
                datos[0] = rs.getString("nss");
                datos[1] = rs.getString("nombre");
                
                cmbPersonal1.addItem(datos[0] + " - " + datos[1]);
            }
            
            rs.close();
            at.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No pudimos agregar el personal");
            permiso = false;
            
        }
    }
    
    public int getIdPersonal(String NSS)
    {
        int idPersonal = -1;
        String datos[] = new String[3];
        cmbPersonal1.removeAllItems();
                
        try {
            Statement at = conexion.createStatement();
            ResultSet rs = at.executeQuery("SELECT idpersonal FROM paqueteria.personal where nss = '" + NSS + "'");
            while(rs.next())
            {
                idPersonal = rs.getInt("idpersonal");
            }
            
            rs.close();
            at.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No pudimos obtener el idpersonal");
            permiso = false;
            
        }
        
        return idPersonal;
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
        cmbRuta = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cmbPersonal1 = new javax.swing.JComboBox<>();
        btnInsertar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbAsignacionRutas = new javax.swing.JTable();
        txtFechaFinal = new com.toedter.calendar.JDateChooser();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setText("Ruta:");

        cmbRuta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbRutaActionPerformed(evt);
            }
        });

        jLabel2.setText("Personal:");

        jLabel4.setText("Fecha final:");

        cmbPersonal1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnInsertar.setText("Insertar");
        btnInsertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertarActionPerformed(evt);
            }
        });

        tbAsignacionRutas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tbAsignacionRutas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbAsignacionRutasMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbAsignacionRutas);

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 636, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnInsertar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                                .addComponent(btnActualizar)
                                .addGap(41, 41, 41)
                                .addComponent(btnEliminar)
                                .addGap(15, 15, 15))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(txtFechaFinal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addGap(29, 29, 29)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cmbRuta, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cmbPersonal1, 0, 269, Short.MAX_VALUE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cmbRuta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cmbPersonal1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel4))
                    .addComponent(txtFechaFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInsertar)
                    .addComponent(btnActualizar)
                    .addComponent(btnEliminar))
                .addGap(56, 56, 56)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                .addGap(58, 58, 58))
        );

        cmbRuta.getAccessibleContext().setAccessibleName("cmbRuta");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbRutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbRutaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbRutaActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        Home vH = new Home();
        vH.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_formWindowClosing

    private void buscaPersonal(String findNSSPersonal)
    {
        int i = 0;
        String str;
        for(i = 0; i < cmbPersonal1.getItemCount(); i++)
        {
            str = cmbPersonal1.getItemAt(i);
            String[] arrPersonal = (str).split("-");
            String NSS = arrPersonal[0].trim();
            if(NSS == findNSSPersonal)
            {
                cmbPersonal1.setSelectedIndex(i);
                break;
            }
            
        }
    }
    
    private void buscaRuta(int findIdRuta)
    {
        int i = 0;
        String str;
        for(i = 0; i < cmbRuta.getItemCount(); i++)
        {
            str = cmbRuta.getItemAt(i);
            String[] arrRuta = (str).split("-");
            int idRuta = Integer.parseInt(arrRuta[0].trim());
            if(idRuta == findIdRuta)
            {
                cmbRuta.setSelectedIndex(i);
                break;
            }
            
        }
    }
    
    private void tbAsignacionRutasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbAsignacionRutasMouseClicked
        int seleccionar = tbAsignacionRutas.rowAtPoint(evt.getPoint());

        idasignacionruta = Integer.parseInt(String.valueOf(tbAsignacionRutas.getValueAt(seleccionar, 0)));
        
        String NSS = String.valueOf(tbAsignacionRutas.getValueAt(seleccionar, 1));
        buscaPersonal(NSS);
        
        int idRuta = Integer.parseInt(String.valueOf(tbAsignacionRutas.getValueAt(seleccionar, 3)));
        buscaRuta(idRuta);

        try
        {
            String input = String.valueOf(tbAsignacionRutas.getValueAt(seleccionar, 6));
            SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");
            Date date = parser.parse(input);
            txtFechaFinal.setDate(date);
        }
        catch(Exception ex)
        {
        }
    }//GEN-LAST:event_tbAsignacionRutasMouseClicked

    public String obtenFecha(JDateChooser control)
    {
        int año = control.getCalendar().get(Calendar.YEAR);
        int mes = control.getCalendar().get(Calendar.MONTH);
        mes++;
        int dia = control.getCalendar().get(Calendar.DAY_OF_MONTH);
        
        return (dia+"-"+mes+"-"+año);
    }
    
    private void btnInsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertarActionPerformed
        try {
            Statement st = conexion.createStatement();
            
            String[] arrRuta = ((String)cmbRuta.getSelectedItem()).split("-");
            int idRuta = Integer.parseInt(arrRuta[0].trim());
            
            String[] arrPersonal = ((String)cmbPersonal1.getSelectedItem()).split("-");
            String nss = arrPersonal[0].trim();
            int idPersonal = getIdPersonal(nss);
            
            // String strFechaInicio = obtenFecha(txtFechaInicio);
            String strFechaFinal = obtenFecha(txtFechaFinal);
            
            
            String sql = "INSERT INTO PAQUETERIA.asignacionDeRutas(idruta, idpersonal, fechainicio, fechafin)"
                    +"VALUES("+idRuta+","+idPersonal+", CURRENT_DATE, '"+ strFechaFinal + "')";
            
            st.executeUpdate(sql);
            st.close();
            fillTabla();
            
            limpiaControlesYAddLlaves();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al insertar "+e);
        }
    }//GEN-LAST:event_btnInsertarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        try {
            Statement st = conexion.createStatement();
            
            String[] arrRuta = ((String)cmbRuta.getSelectedItem()).split("-");
            int idRuta = Integer.parseInt(arrRuta[0].trim());
            
            String[] arrPersonal = ((String)cmbPersonal1.getSelectedItem()).split("-");
            String nss = arrPersonal[0].trim();
            int idPersonal = getIdPersonal(nss);
            
            // String strFechaInicio = obtenFecha(txtFechaInicio);
            String strFechaFinal = obtenFecha(txtFechaFinal);
            
            String sql = "UPDATE PAQUETERIA.asignacionDeRutas SET idruta = " + idRuta + ","
                    + "idpersonal = " + idPersonal + ", fechainicio= CURRENT_DATE,"+ " fechafin = '" + strFechaFinal + "'"
                    +"WHERE idasignacionruta = " + idasignacionruta;
            
            st.executeUpdate(sql);
            st.close();
            fillTabla();
            
            limpiaControlesYAddLlaves();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar "+e);
        }
        
    }//GEN-LAST:event_btnActualizarActionPerformed

    public void limpiaControlesYAddLlaves()
    {
        idasignacionruta = -1;
        //txtFechaInicio.setCalendar(null);
        txtFechaFinal.setCalendar(null);
        cmbRuta.removeAllItems();
        cmbPersonal1.removeAllItems();
        
        cargaPersonal();
        cargaRutas();
    }
    
    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        try {
            Statement st = conexion.createStatement();
            
            String sql = "DELETE FROM PAQUETERIA.asignacionDeRutas WHERE idasignacionruta = " + idasignacionruta;
            
            st.executeUpdate(sql);
            st.close();
            fillTabla();
            
            limpiaControlesYAddLlaves();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar "+e);
        }
        
    }//GEN-LAST:event_btnEliminarActionPerformed

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
            java.util.logging.Logger.getLogger(AsignacionRuta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AsignacionRuta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AsignacionRuta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AsignacionRuta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AsignacionRuta().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnInsertar;
    private javax.swing.JComboBox<String> cmbPersonal1;
    private javax.swing.JComboBox<String> cmbRuta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbAsignacionRutas;
    private com.toedter.calendar.JDateChooser txtFechaFinal;
    // End of variables declaration//GEN-END:variables
}
