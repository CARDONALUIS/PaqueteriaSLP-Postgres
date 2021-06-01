
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

public class Personal extends javax.swing.JFrame {
    Home a = new Home();
    Connection conexion;
    String pass;
    String user;
    DefaultTableModel modelo = new DefaultTableModel();
    int idPersonal;
    public boolean permiso = true;
    
        
    public Personal() {
        initComponents();               
    }
    
    public void setUserYCon(String _user,String _pass)
    {
        pass = _pass;
        user = _user;
         
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
    
    public void agregaComboBox()
    {
        String datos[] = new String[3];
        JCBSucursal.removeAllItems();
        JCBTipoEmpleado.removeAllItems();
        
        JCBTipoEmpleado.addItem("Administrativo");
        JCBTipoEmpleado.addItem("Camionero");
        JCBTipoEmpleado.addItem("Secretario");
        
        try {
            Statement at = conexion.createStatement();
            ResultSet rs = at.executeQuery("SELECT * FROM paqueteria.sucursal");
            while(rs.next())
            {
                datos[0] = rs.getString("idsucursal");
                datos[1] = rs.getString("nombresucursal");

                JCBSucursal.addItem(datos[0]+ "-" +datos[1]);
            }           
            rs.close();
            at.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No pudimos agregar los items");
            permiso = false;
        }
    }
    
    public void limpiaControlesYAddLlaves()
    {
        
        JTNombre.setText("");
        JTNumCelular.setText("");
        JTNss.setText("");
        //JCNacimiento.cle
        JTDireccion.setText("");
        JTEmail.setText("");
        JTCuenta.setText("");
        agregaComboBox();
        JCNacimiento.setCalendar(null);
               
    }
    
    public void modelo_tabla()
    {
        modelo.addColumn("IdPersonal");
        modelo.addColumn("NSS");
        modelo.addColumn("IdSucursal");
        modelo.addColumn("Nombre");
        modelo.addColumn("NumeroCelular");
        modelo.addColumn("Edad");
        modelo.addColumn("FechaNacimiento");
        modelo.addColumn("Direccion");
        modelo.addColumn("Email");
        modelo.addColumn("TipoEmpleado");
        modelo.addColumn("Salario");
        modelo.addColumn("Cuenta");
        JTPersonal.setModel(modelo);
    }
    
    public void fillTabla()
    {
        modelo.setRowCount(0);
        String datos[] = new String[12];
        
        try {
            Statement at = conexion.createStatement();
            ResultSet rs = at.executeQuery("SELECT * FROM paqueteria.personal");
            while(rs.next())
            {
                datos[0] = rs.getString("idpersonal");
                datos[1] = rs.getString("nss");
                datos[2] = rs.getString("idsucursal");
                datos[3] = rs.getString("nombre");
                datos[4] = rs.getString("numerocelular");
                datos[5] = rs.getString("edad");
                datos[6] = rs.getString("fechaNacimiento");
                datos[7] = rs.getString("direccion");
                datos[8] = rs.getString("email");
                datos[9] = rs.getString("tipoempleado");
                datos[10] = rs.getString("salario");
                datos[11] = rs.getString("cuenta");                

                modelo.addRow(datos);
            }           
            rs.close();
            at.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No pudimos actualizar tu tabla "+ e);
            permiso = false;
        }
    }
    
    public String obtenFecha()
    {
        int año = JCNacimiento.getCalendar().get(Calendar.YEAR);
        int mes = JCNacimiento.getCalendar().get(Calendar.MARCH);
        int dia = JCNacimiento.getCalendar().get(Calendar.DAY_OF_MONTH);
        
        return (dia+"-"+mes+"-"+año);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        JTPersonal = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        JCBSucursal = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        JTNombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        JTNumCelular = new javax.swing.JTextField();
        JTNss = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        JTDireccion = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        JTEmail = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        JCBTipoEmpleado = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        JTCuenta = new javax.swing.JTextField();
        JBInsertar = new javax.swing.JButton();
        JBEliminar = new javax.swing.JButton();
        JBActualizar = new javax.swing.JButton();
        JCNacimiento = new com.toedter.calendar.JDateChooser();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        JTPersonal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        JTPersonal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTPersonalMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(JTPersonal);

        jLabel1.setText("Sucursal: ");

        JCBSucursal.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel2.setText("Nombre:");

        jLabel3.setText("NSS:");

        jLabel4.setText("Num_Celular:");

        jLabel5.setText("Fecha_Nacimiento:");

        jLabel6.setText("Direccion:");

        jLabel7.setText("Email:");

        jLabel8.setText("Tipo_Empleado");

        JCBTipoEmpleado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel9.setText("Cuenta Bancaria:");

        JBInsertar.setText("Insertar");
        JBInsertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBInsertarActionPerformed(evt);
            }
        });

        JBEliminar.setText("Eliminar");
        JBEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBEliminarActionPerformed(evt);
            }
        });

        JBActualizar.setText("Actualizar");
        JBActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBActualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(JCNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(JTNumCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel9)
                                .addGap(18, 18, 18)
                                .addComponent(JTCuenta))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(JTNombre))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(JCBSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(18, 18, 18)
                                        .addComponent(JTNss)))
                                .addGap(60, 60, 60)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel7))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(JTDireccion, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                                            .addComponent(JTEmail)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addGap(18, 18, 18)
                                        .addComponent(JCBTipoEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(58, 58, 58)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JBInsertar)
                            .addComponent(JBEliminar)
                            .addComponent(JBActualizar)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 938, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(JCBSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6)
                                    .addComponent(JTDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(JBInsertar)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(JTNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(JTEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(JTNss, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8)
                                    .addComponent(JCBTipoEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(JBEliminar)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(JTNumCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(JTCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JBActualizar))
                        .addGap(6, 6, 6)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(JCNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        Home vH = new Home();
        vH.setVisible(true);
        this.dispose();     
    }//GEN-LAST:event_formWindowClosing

    private void JBInsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBInsertarActionPerformed
        
        try {
            Statement st = conexion.createStatement();
            String sql = "INSERT INTO paqueteria.personal(nss, idsucursal, nombre, numerocelular, fechaNacimiento, direccion, email, tipoempleado, cuenta)"
                    +"VALUES("+JTNss.getText()+","+((String)JCBSucursal.getSelectedItem()).substring(0, 1)+",'"+JTNombre.getText()+"','"+JTNumCelular.getText()+"','"+
                    obtenFecha()+"','"+JTDireccion.getText()+"','"+JTEmail.getText()+"','"+(String)JCBTipoEmpleado.getSelectedItem()+"','"+JTCuenta.getText()+"')";
            
            st.executeUpdate(sql);
            st.close();
            fillTabla();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al insertar "+e);
        }
        limpiaControlesYAddLlaves();
        
    }//GEN-LAST:event_JBInsertarActionPerformed

    private void JTPersonalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTPersonalMouseClicked
        // TODO add your handling code here:
        JCBSucursal.removeAllItems();
        JCBTipoEmpleado.removeAllItems();
        
        int seleccionar = JTPersonal.rowAtPoint(evt.getPoint());
                       
        idPersonal = Integer.parseInt(String.valueOf(JTPersonal.getValueAt(seleccionar, 0)));
        
        JTNss.setText(String.valueOf(JTPersonal.getValueAt(seleccionar, 1)));
        JCBSucursal.addItem(JTPersonal.getValueAt(seleccionar, 2).toString());
        JTNombre.setText(String.valueOf(JTPersonal.getValueAt(seleccionar, 3)));
        JTNumCelular.setText(String.valueOf(JTPersonal.getValueAt(seleccionar, 4)));
        JTDireccion.setText(String.valueOf(JTPersonal.getValueAt(seleccionar, 7)));
        JTEmail.setText(String.valueOf(JTPersonal.getValueAt(seleccionar, 8)));
        JCBTipoEmpleado.addItem(JTPersonal.getValueAt(seleccionar, 9).toString());
        JTCuenta.setText(String.valueOf(JTPersonal.getValueAt(seleccionar, 11)));
        //JCNacimiento.(String.valueOf(JTPersonal.getValueAt(seleccionar, 4)));
        
    }//GEN-LAST:event_JTPersonalMouseClicked

    private void JBEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBEliminarActionPerformed
        // TODO add your handling code here:
         try {
            Statement st = conexion.createStatement();
            String sql = "DELETE FROM paqueteria.personal WHERE idpersonal = "+idPersonal+"";                              
            st.executeUpdate(sql);
            st.close();
            fillTabla();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar "+e);
        }
        
        limpiaControlesYAddLlaves();
    }//GEN-LAST:event_JBEliminarActionPerformed

    private void JBActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBActualizarActionPerformed
        // TODO add your handling code here:        
                
        try {
            Statement st = conexion.createStatement();
            String sql = "UPDATE paqueteria.personal SET nss = "+JTNss.getText()+", nombre = '"+JTNombre.getText()+"', numerocelular = '"+JTNumCelular.getText()+"'"
                    + ", direccion = '"+JTDireccion.getText()+"', email = '"+JTEmail.getText()+"', cuenta ='"+JTCuenta.getText()+"'  WHERE idpersonal = "+idPersonal+" ";
            st.executeUpdate(sql);
            st.close();
            fillTabla();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar "+e);
        }
        
        limpiaControlesYAddLlaves();
    }//GEN-LAST:event_JBActualizarActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Personal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBActualizar;
    private javax.swing.JButton JBEliminar;
    private javax.swing.JButton JBInsertar;
    private javax.swing.JComboBox<String> JCBSucursal;
    private javax.swing.JComboBox<String> JCBTipoEmpleado;
    private com.toedter.calendar.JDateChooser JCNacimiento;
    private javax.swing.JTextField JTCuenta;
    private javax.swing.JTextField JTDireccion;
    private javax.swing.JTextField JTEmail;
    private javax.swing.JTextField JTNombre;
    private javax.swing.JTextField JTNss;
    private javax.swing.JTextField JTNumCelular;
    private javax.swing.JTable JTPersonal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
