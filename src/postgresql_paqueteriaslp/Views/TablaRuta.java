
package postgresql_paqueteriaslp.Views;
import javax.swing.JOptionPane;
import postgresql_paqueteriaslp.Home;
import java.awt.*;  
import java.awt.event.*; 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.Statement;
import java.sql.ResultSet;
/**
 *
 * @author Luis Pablo Rocha
 */
public class TablaRuta extends javax.swing.JFrame {
    Connection conexion;
    String pass="postgres";
    String user ="postgres";
    DefaultTableModel modelo = new DefaultTableModel();
    public int idRuta=0;
    public int sucOrSelected=0;
    public int sucDesSelected=0;
    public int idCamion=0;

    public TablaRuta() {
        initComponents();
        estableceConexion();
        modelo_tabla();
        fillTabla();
        agregaComboBoxSucursales();
        agregaComboBoxCamiones();
        jComboBoxSucOr.addActionListener (new ActionListener () {
        public void actionPerformed(ActionEvent e) {
        cambiaItemsComboBoxDestino();
        }
        });
    }
    
    public void cambiaItemsComboBoxDestino(){
        String x = String.valueOf(jComboBoxSucOr.getSelectedItem());
        String[] idSucursal = x.split(("-"));
        sucOrSelected = Integer.parseInt(idSucursal[0]);
        agregaComboBoxSucursales();
    }
    
    public void estableceConexion()
    {
        try {
            conexion = DriverManager.getConnection("jdbc:postgresql://localhost:5432/paqueteriaSLP",user, pass);            
        }catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al establecer conexion!!!"+ ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelTel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        JTextHora = new javax.swing.JTextField();
        JCboxCamion = new javax.swing.JComboBox<>();
        JBInsertarRuta = new javax.swing.JButton();
        JBModRuta = new javax.swing.JButton();
        JBElimRuta = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTableRuta = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jComboBoxSucOr = new javax.swing.JComboBox<>();
        jComboBoxSucDes = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabelTel.setText("TABLA DE RUTA");

        jLabel1.setText("Camión");

        jLabel2.setText("Hora");

        JCboxCamion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        JBInsertarRuta.setText("Insertar");
        JBInsertarRuta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBInsertarRutaActionPerformed(evt);
            }
        });

        JBModRuta.setText("Modificar");
        JBModRuta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBModRutaActionPerformed(evt);
            }
        });

        JBElimRuta.setText("Eliminar");
        JBElimRuta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBElimRutaActionPerformed(evt);
            }
        });

        JTableRuta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        JTableRuta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTableRutaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(JTableRuta);

        jLabel3.setText("Sucursal Origen");

        jLabel4.setText("Sucursal Destino");

        jComboBoxSucOr.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBoxSucDes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

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
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3)
                                .addComponent(jLabel4))
                            .addGap(30, 30, 30)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(JCboxCamion, 0, 125, Short.MAX_VALUE)
                                .addComponent(JTextHora)
                                .addComponent(jComboBoxSucOr, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jComboBoxSucDes, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(JBModRuta, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(JBInsertarRuta, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(49, 49, 49)
                            .addComponent(JBElimRuta, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 698, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabelTel)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JCboxCamion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(JBInsertarRuta))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(JTextHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jComboBoxSucOr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(JBModRuta)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jComboBoxSucDes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                        .addComponent(JBElimRuta)
                        .addGap(96, 96, 96)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JBInsertarRutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBInsertarRutaActionPerformed
        obtenIDSucursalComboBox();
        obtenIDCamion();
        if(sucOrSelected==0 || sucDesSelected==0 || idCamion==0){
            if(sucOrSelected==0){
                JOptionPane.showMessageDialog(null, "Selecciona la sucursal origen");       
            }
            if(sucDesSelected==0){
                JOptionPane.showMessageDialog(null, "Selecciona la sucursal destino");
            }   
            if(idCamion==0){
                 JOptionPane.showMessageDialog(null, "Selecciona un camión");
            }
        }
        else{
            try {
            Statement st = conexion.createStatement();
            String sql = "INSERT INTO paqueteria.ruta(idCamion,horaSalida,idSucursalOrigen,idSucursalDestino)"
            +"VALUES('"+idCamion+"','"+JTextHora.getText()+"','"+sucOrSelected+"','"+sucDesSelected+"')";

            st.executeUpdate(sql);
            st.close();
            fillTabla();
            limpiaFormulario();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al insertar "+e);
        }
        }  
    }//GEN-LAST:event_JBInsertarRutaActionPerformed

    public void modelo_tabla()
    {
        modelo.addColumn("ID Ruta");
        modelo.addColumn("ID Camión");
        modelo.addColumn("Camión");
        modelo.addColumn("Hora");
        modelo.addColumn("ID Suc. Origen");
        modelo.addColumn("Nombre S.O");
        modelo.addColumn("ID Suc. Destino");
        modelo.addColumn("Nombre S.D");
        JTableRuta.setModel(modelo); 
    }
    
    public void fillTabla()
    {
        modelo.setRowCount(0);
        String datos[] = new String[17];
        
        try {
            Statement at = conexion.createStatement();
            ResultSet rs = at.executeQuery("SELECT * FROM PAQUETERIA.ruta AS R " +
            "INNER JOIN PAQUETERIA.camion AS C ON R.idCamion = C.idCamion " +
            "INNER JOIN PAQUETERIA.sucursal AS SO ON R.idSucursalOrigen = SO.idSucursal " +
            "INNER JOIN PAQUETERIA.sucursal AS SD ON R.idSucursalDestino = SD.idSucursal ORDER BY idRuta ASC;");
            while(rs.next())
            {
                datos[0] = rs.getString("idRuta");
                datos[1] = rs.getString("idCamion");
                String placa = rs.getString("placa");
                String marca = rs.getString("marca");
                String ano = rs.getString("ano");
                datos[2] = placa+"/"+marca+"/"+ano;
                datos[3] = rs.getString("horaSalida");
                datos[4] = rs.getString("idSucursalOrigen");
                datos[5] = rs.getString(14);
                datos[6] = rs.getString("idSucursalDestino");
                datos[7] = rs.getString(17);
                
                modelo.addRow(datos);
                
            }           
            rs.close();
            at.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No pudimos actualizar tu tabla");
        }
    }
    public void obtenIDSucursalComboBox(){
        if(jComboBoxSucOr.getSelectedIndex()>0 && jComboBoxSucDes.getSelectedIndex()>0 ){
            String xO = String.valueOf(jComboBoxSucOr.getSelectedItem());
            String[] idSucursalO = xO.split(("-"));
            sucOrSelected = Integer.parseInt(idSucursalO[0]);
            String xD = String.valueOf(jComboBoxSucDes.getSelectedItem());
            String[] idSucursalD = xD.split(("-"));
            sucDesSelected = Integer.parseInt(idSucursalD[0]);
        }
    }
    
    public void limpiaFormulario(){
        JCboxCamion.getModel().setSelectedItem("");
        jComboBoxSucOr.getModel().setSelectedItem(0);
        JTextHora.setText("");
        sucOrSelected=0;
        sucDesSelected=0;
        idCamion=0;
        idRuta =0;
    }
    
    public void obtenIDCamion(){
        if(JCboxCamion.getSelectedIndex()>0){
            String camion = String.valueOf(JCboxCamion.getSelectedItem());
            String[] placa = camion.split(("/"));
            try {
                    Statement at = conexion.createStatement();
                    ResultSet rs = at.executeQuery("SELECT * FROM paqueteria.camion WHERE placa = '"+placa[0]+"'");
                    while(rs.next())
                    {
                        idCamion = Integer.parseInt(rs.getString("idCamion"));
                    }  
                    rs.close();
                    at.close();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "No pudimos econtrar el camion a agregar");
                }
            }
        }
    
    
    private void JBModRutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBModRutaActionPerformed
        obtenIDCamion();
        obtenIDSucursalComboBox();
        try {
            Statement st = conexion.createStatement();
            String sql = "UPDATE paqueteria.ruta SET idCamion = '"+idCamion+"', horaSalida = '"+JTextHora.getText()+"', idSucursalOrigen ='"+sucOrSelected+"', idSucursalDestino = '"+sucDesSelected+"'WHERE idRuta = '"+idRuta+"'";
            st.executeUpdate(sql);
            st.close();
            fillTabla();
            limpiaFormulario();
            idRuta =0;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar "+e);
        }
        
    }//GEN-LAST:event_JBModRutaActionPerformed

    private void JBElimRutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBElimRutaActionPerformed
        if(idRuta>0){
           try {
            Statement st = conexion.createStatement();
            String sql = "DELETE FROM paqueteria.ruta WHERE idRuta = "+idRuta+"";
            st.executeUpdate(sql);
            st.close();
            fillTabla();
            limpiaFormulario();
            idRuta =0;

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al eliminar "+e);
            } 
        }  
        else{
            JOptionPane.showMessageDialog(null, "Selecciona una ruta");
        }
    }//GEN-LAST:event_JBElimRutaActionPerformed

    private void JTableRutaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTableRutaMouseClicked
        // TODO add your handling code here:
        int seleccionar = JTableRuta.rowAtPoint(evt.getPoint());
        idRuta = Integer.parseInt(String.valueOf(JTableRuta.getValueAt(seleccionar, 0)));
        JTextHora.setText(String.valueOf(JTableRuta.getValueAt(seleccionar, 3)));
        JCboxCamion.setSelectedItem(String.valueOf(JTableRuta.getValueAt(seleccionar, 2))); 
        jComboBoxSucOr.setSelectedItem(String.valueOf(JTableRuta.getValueAt(seleccionar, 4)+"-"+JTableRuta.getValueAt(seleccionar, 5))); 
        jComboBoxSucDes.setSelectedItem(String.valueOf(JTableRuta.getValueAt(seleccionar, 6)+"-"+JTableRuta.getValueAt(seleccionar, 7)));
    }//GEN-LAST:event_JTableRutaMouseClicked

    public void agregaComboBoxSucursales()
    {
        String datos[] = new String[2];
        if(sucOrSelected==0){
            jComboBoxSucOr.removeAllItems();
            jComboBoxSucOr.insertItemAt("", 0);
        }
    
        jComboBoxSucDes.removeAllItems();
        jComboBoxSucDes.insertItemAt("", 0);
    
                
        try {
            Statement at = conexion.createStatement();
            ResultSet rs = at.executeQuery("SELECT * FROM paqueteria.sucursal");
            while(rs.next())
            {
                datos[0] = rs.getString("idsucursal");
                datos[1] = rs.getString("nombresucursal");
                
                if(sucOrSelected==0){
                    jComboBoxSucOr.addItem(datos[0]+ "-" +datos[1]);
                }
                
                if(sucOrSelected>-1){
                    if(Integer.parseInt(datos[0])!=sucOrSelected)
                    jComboBoxSucDes.addItem(datos[0]+ "-" +datos[1]);
                }
                
            }
            
            rs.close();
            at.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No pudimos agregar los items");
        }
    }
    
    public void agregaComboBoxCamiones()
    {
        String datos[] = new String[3];
        JCboxCamion.removeAllItems();
        JCboxCamion.insertItemAt("", 0);
                
        try {
            Statement at = conexion.createStatement();
            ResultSet rs = at.executeQuery("SELECT * FROM paqueteria.camion");
            while(rs.next())
            {
                datos[0] = rs.getString("placa");
                datos[1] = rs.getString("marca");
                datos[2] = rs.getString("ano");
                
                JCboxCamion.addItem(datos[0]+ "/" +datos[1]+ "/" +datos[2]);
            }
            
            rs.close();
            at.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No pudimos agregar los items");
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
            java.util.logging.Logger.getLogger(TablaRuta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TablaRuta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TablaRuta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TablaRuta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TablaRuta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBElimRuta;
    private javax.swing.JButton JBInsertarRuta;
    private javax.swing.JButton JBModRuta;
    private javax.swing.JComboBox<String> JCboxCamion;
    private javax.swing.JTable JTableRuta;
    private javax.swing.JTextField JTextHora;
    private javax.swing.JComboBox<String> jComboBoxSucDes;
    private javax.swing.JComboBox<String> jComboBoxSucOr;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelTel;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
