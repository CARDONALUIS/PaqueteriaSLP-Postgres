
package postgresql_paqueteriaslp.Views;
import java.awt.Point;
import postgresql_paqueteriaslp.Home;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.Statement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class Camion extends javax.swing.JFrame {
    Connection conexion;
    String pass="Nada2254";
    String user ="postgres";
    DefaultTableModel modelo = new DefaultTableModel();
    int idCamion;
    
    public Camion() {
        initComponents();
        estableceConexion();
        modelo_tabla();
        fillTabla();
        agregaComboBox();
        btnEditar.setVisible(false);
        PanelArrendado.setVisible(false);
        PanelComprado.setVisible(false);
        PanelComprado.setLocation(PanelArrendado.getLocation());
        Point p = PanelArrendado.getLocation();
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
        modelo.addColumn("Id Camion");
        modelo.addColumn("Placa");
        modelo.addColumn("Sucursal");
        modelo.addColumn("Modelo");
        modelo.addColumn("Marca");
        modelo.addColumn("Año");
        modelo.addColumn("Estado");
        gridCamion.setModel(modelo);
    }
    
    public void agregaComboBox()
    {
        String datos[] = new String[3];
                
        try {
            Statement at = conexion.createStatement();
            ResultSet rs = at.executeQuery("SELECT * FROM paqueteria.sucursal");
            while(rs.next())
            {
                datos[0] = rs.getString("idsucursal");
                datos[1] = rs.getString("nombresucursal");
                
                ddlSucursal.addItem(datos[0]+ "-" +datos[1]);
            }
            
            rs.close();
            at.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public void SetComprado(int id)
    {
        String datos[] = new String[3];
                
        try {
            Statement at = conexion.createStatement();
            ResultSet rs = at.executeQuery("SELECT * FROM paqueteria.comprado where idCamion = " + id);
            while(rs.next())
            {
                ntxtCostoComp.setValue(Integer.parseInt(rs.getString("pago")));
                Date date = rs.getDate("fechacompra");
                dateCompra.setDate(date);
            }
            
            rs.close();
            at.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public void SetArrendado(int id)
    {
        try {
            Statement at = conexion.createStatement();
            ResultSet rs = at.executeQuery("SELECT * FROM paqueteria.arrendado where idCamion = " + id);
            while(rs.next())
            {
                ddlContrato.setSelectedItem(rs.getString("tiempocontrato"));
                ntxtPagoMensual.setValue(Integer.parseInt(rs.getString("pagomensual")));
                ntxtCostoArr.setValue(Integer.parseInt(rs.getString("pagomensual")));
                txtProveedor.setText(rs.getString("proveedor"));
            }
            
            rs.close();
            at.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public void CleanControls()
    {
        txtPlaca.setText("");
        ddlSucursal.setSelectedIndex(0);
        txtMarca.setText("");
        txtModelo.setText("");
        ntxtAno.setValue(0);
        btnArrendado.setSelected(false);
        btnComprado.setSelected(false);
        PanelComprado.setVisible(false);
        PanelArrendado.setVisible(false);
        ddlContrato.setSelectedIndex(0);
        ntxtPagoMensual.setValue(0);
        ntxtCostoArr.setValue(0);
        txtProveedor.setText("");
        ntxtCostoComp.setValue(0);
        Date d = new Date();
        dateCompra.setDate(d);
    }
    public String obtenFecha()
    {
        int año = dateCompra.getCalendar().get(Calendar.YEAR);
        int mes = dateCompra.getCalendar().get(Calendar.MARCH);
        int dia = dateCompra.getCalendar().get(Calendar.DAY_OF_MONTH);
        
        return (dia+"-"+mes+"-"+año);
    }
    
    public void fillTabla()
    {
        modelo.setRowCount(0);
        String datos[] = new String[7];
        
        try {
             String query = "SELECT T0.*, T1.nombresucursal Sucursal, "
                     + "COALESCE((SELECT idCamion from PAQUETERIA.comprado WHERE idCamion = T0.idCamion), 0) Estado "
                     + "FROM paqueteria.camion T0 "
                     + "JOIN PAQUETERIA.sucursal T1 on T0.idSucursal = T1.idSucursal";
            Statement at = conexion.createStatement();
            ResultSet rs = at.executeQuery(query);
            while(rs.next())
            {
                datos[0] = rs.getString("idCamion");
                datos[1] = rs.getString("placa");
                datos[2] = rs.getString("idsucursal") + "-" + rs.getString("Sucursal");
                datos[3] = rs.getString("modelo");
                datos[4] = rs.getString("marca");
                datos[5] = rs.getString("ano");
                datos[6] = rs.getString("estado");
                if(datos[6].equals("0"))
                    datos[6] = "Arrendado";
                else
                    datos[6] = "Comprado";
                modelo.addRow(datos);
            }           
            rs.close();
            at.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        gridCamion = new javax.swing.JTable();
        btnAdd = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        ddlSucursal = new javax.swing.JComboBox<>();
        txtPlaca = new javax.swing.JTextField();
        txtModelo = new javax.swing.JTextField();
        txtMarca = new javax.swing.JTextField();
        ntxtAno = new javax.swing.JSpinner();
        jSeparator1 = new javax.swing.JSeparator();
        PanelArrendado = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        ddlContrato = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        ntxtPagoMensual = new javax.swing.JSpinner();
        jLabel8 = new javax.swing.JLabel();
        ntxtCostoArr = new javax.swing.JSpinner();
        jLabel9 = new javax.swing.JLabel();
        txtProveedor = new javax.swing.JTextField();
        btnComprado = new javax.swing.JRadioButton();
        btnArrendado = new javax.swing.JRadioButton();
        PanelComprado = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        ntxtCostoComp = new javax.swing.JSpinner();
        dateCompra = new com.toedter.calendar.JDateChooser();
        jLabel11 = new javax.swing.JLabel();
        btnEditar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        gridCamion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        gridCamion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                gridCamionMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(gridCamion);

        btnAdd.setText("Añadir");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnDelete.setText("Eliminar");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        jLabel1.setText("Placa");

        jLabel2.setText("Sucursal");

        jLabel3.setText("Modelo");

        jLabel4.setText("Marca");

        jLabel5.setText("Año");

        ddlSucursal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ddlSucursalActionPerformed(evt);
            }
        });

        PanelArrendado.setMinimumSize(new java.awt.Dimension(0, 0));

        jLabel6.setText("Tiempo contrato");

        ddlContrato.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "12", "24", "36", "48", "60" }));

        jLabel7.setText("Pago mensual");

        ntxtPagoMensual.setEnabled(false);

        jLabel8.setText("Costo total");

        jLabel9.setText("Proveedor");

        javax.swing.GroupLayout PanelArrendadoLayout = new javax.swing.GroupLayout(PanelArrendado);
        PanelArrendado.setLayout(PanelArrendadoLayout);
        PanelArrendadoLayout.setHorizontalGroup(
            PanelArrendadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelArrendadoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelArrendadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelArrendadoLayout.createSequentialGroup()
                        .addGroup(PanelArrendadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(PanelArrendadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ddlContrato, 0, 79, Short.MAX_VALUE)
                            .addComponent(ntxtPagoMensual)
                            .addComponent(ntxtCostoArr)))
                    .addGroup(PanelArrendadoLayout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtProveedor)))
                .addContainerGap())
        );
        PanelArrendadoLayout.setVerticalGroup(
            PanelArrendadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelArrendadoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelArrendadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(ddlContrato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelArrendadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(ntxtPagoMensual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelArrendadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(ntxtCostoArr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelArrendadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        buttonGroup1.add(btnComprado);
        btnComprado.setText("Comprado");
        btnComprado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCompradoActionPerformed(evt);
            }
        });

        buttonGroup1.add(btnArrendado);
        btnArrendado.setText("Arrendado");
        btnArrendado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnArrendadoActionPerformed(evt);
            }
        });

        jLabel10.setText("Costo total");

        jLabel11.setText("Fecha compra");

        javax.swing.GroupLayout PanelCompradoLayout = new javax.swing.GroupLayout(PanelComprado);
        PanelComprado.setLayout(PanelCompradoLayout);
        PanelCompradoLayout.setHorizontalGroup(
            PanelCompradoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCompradoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelCompradoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ntxtCostoComp)
                    .addGroup(PanelCompradoLayout.createSequentialGroup()
                        .addGroup(PanelCompradoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(dateCompra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        PanelCompradoLayout.setVerticalGroup(
            PanelCompradoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCompradoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ntxtCostoComp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dateCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        btnEditar.setText("Guardar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 541, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEditar)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(ddlSucursal, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(33, 33, 33)
                                .addComponent(txtPlaca))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(24, 24, 24)
                                .addComponent(txtModelo))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(29, 29, 29)
                                .addComponent(txtMarca))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(39, 39, 39)
                                .addComponent(ntxtAno))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnComprado)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnArrendado))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnAdd)
                                        .addGap(41, 41, 41)
                                        .addComponent(btnDelete)))
                                .addGap(0, 24, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(PanelArrendado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(10, 10, 10))
                            .addComponent(PanelComprado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(10, 10, 10))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAdd)
                            .addComponent(btnDelete))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(ddlSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(ntxtAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnComprado)
                            .addComponent(btnArrendado))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(PanelArrendado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(PanelComprado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(0, 0, 0)
                        .addComponent(btnEditar)
                        .addGap(5, 5, 5))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        Home vH = new Home();
        vH.setVisible(true);
        this.dispose();   
    }//GEN-LAST:event_formWindowClosing

    private void ddlSucursalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ddlSucursalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ddlSucursalActionPerformed

    private void btnCompradoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCompradoActionPerformed
        PanelArrendado.setVisible(false);
        PanelComprado.setVisible(true);
        Point p = PanelArrendado.getLocation();
        PanelArrendado.setLocation(9999,9999);
        PanelComprado.setLocation(557, 276);
    }//GEN-LAST:event_btnCompradoActionPerformed

    private void btnArrendadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnArrendadoActionPerformed
        PanelArrendado.setVisible(true);
        PanelComprado.setVisible(false);
        Point p = PanelArrendado.getLocation();
        PanelArrendado.setLocation(9999,9999);
        PanelComprado.setLocation(553, 276);
    }//GEN-LAST:event_btnArrendadoActionPerformed

    private void gridCamionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gridCamionMouseClicked
        
        int row = gridCamion.rowAtPoint(evt.getPoint());
        idCamion = Integer.parseInt(String.valueOf(gridCamion.getValueAt(row, 0)));
        String placa = String.valueOf(gridCamion.getValueAt(row, 1));
        txtPlaca.setText(placa);
        String modelo = String.valueOf(gridCamion.getValueAt(row, 3));
        txtModelo.setText(modelo);
        String marca = String.valueOf(gridCamion.getValueAt(row, 4));
        txtMarca.setText(marca);
        int anio = Integer.parseInt(String.valueOf(gridCamion.getValueAt(row, 5)));
        ntxtAno.setValue(anio);
        String estado = String.valueOf(gridCamion.getValueAt(row, 6));
        if(estado.equals("Arrendado")){
            btnArrendado.setSelected(true);
            PanelArrendado.setVisible(true);
            PanelComprado.setVisible(false);
            PanelArrendado.setLocation(9999,9999);
            PanelComprado.setLocation(553, 276);
            SetArrendado(idCamion);
        }
        else{
            btnComprado.setSelected(true);
            PanelArrendado.setVisible(false);
            PanelComprado.setVisible(true);
            PanelArrendado.setLocation(9999,9999);
            PanelComprado.setLocation(553, 276);
            SetComprado(idCamion);
        }
        btnEditar.setVisible(true);
    }//GEN-LAST:event_gridCamionMouseClicked

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        if(idCamion == 0){
            JOptionPane.showMessageDialog(null, "Seleccione un camion antes de continuar editando");
            return;
        }
        String placa = txtPlaca.getText();
        int sucursal = Integer.parseInt(ddlSucursal.getSelectedItem().toString().split("-")[0]);
        String modelo = txtModelo.getText();
        String marca = txtMarca.getText();
        int anio = Integer.parseInt(ntxtAno.getValue().toString());
        try {
            Statement st = conexion.createStatement();
            String query = "UPDATE paqueteria.camion SET placa = '" + placa + "', idsucursal=" + sucursal + ", modelo = '" + modelo + "', marca = '" + marca + "', ano = " + anio;                              
            st.executeUpdate(query);
            if(PanelArrendado.isVisible())
            {
                int contrato = Integer.parseInt(ddlContrato.getSelectedItem().toString());
                int costo = Integer.parseInt(ntxtCostoArr.getValue().toString());
                String proveedor = txtProveedor.getText();
                query = "UPDATE PAQUETERIA.Arrendado SET tiempocontrato = " + contrato + ", costototal = " + costo + ", proveedor = '" + proveedor+ "' WHERE idcamion = " + idCamion;
                st.executeUpdate(query);
            }
            else
            {
                int costo = Integer.parseInt(ntxtCostoComp.getValue().toString());
                Date date = dateCompra.getDate();
                query = "UPDATE PAQUETERIA.comprado SET pago = " + costo + ", fechacompra = '" + obtenFecha() + "'";
                st.executeUpdate(query);
            }
            st.close();
            fillTabla();
            CleanControls();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        String placa = txtPlaca.getText();
        int sucursal = Integer.parseInt(ddlSucursal.getSelectedItem().toString().split("-")[0]);
        String modelo = txtModelo.getText();
        String marca = txtMarca.getText();
        int anio = Integer.parseInt(ntxtAno.getValue().toString());
        try {
            Statement st = conexion.createStatement();
            String query = "INSERT INTO paqueteria.camion (placa, idSucursal, modelo, marca, ano) VALUES ('" + placa + "', " + sucursal + ", '" + modelo + "', '" + marca + "', " + anio + ")";                              
            st.executeUpdate(query);
            query = "select idCamion from paqueteria.camion ORDER BY idCamion DESC LIMIT 1";
            ResultSet rs = st.executeQuery(query);
            int Camion = 0;
            while(rs.next())
                Camion = Integer.parseInt(rs.getString("idCamion"));
            if(PanelArrendado.isVisible())
            {
                int contrato = Integer.parseInt(ddlContrato.getSelectedItem().toString());
                int costo = Integer.parseInt(ntxtCostoArr.getValue().toString());
                String proveedor = txtProveedor.getText();
                query = "INSERT INTO PAQUETERIA.Arrendado (idCamion, tiempocontrato, costototal, proveedor) VALUES (" + Camion + ", " + contrato + ", " + costo + ", '" + proveedor+ "' )";
                st.executeUpdate(query);
            }
            else
            {
                int costo = Integer.parseInt(ntxtCostoComp.getValue().toString());
                Date date = dateCompra.getDate();
                query = "INSERT INTO PAQUETERIA.comprado (idCamion, pago, fechaCompra) VALUES(" + Camion + ", " + costo + ", '" + obtenFecha() + "')";
                st.executeUpdate(query);
            }
            st.close();
            fillTabla();
            CleanControls();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        if(idCamion != 0)
        {
            String query = "";
            if(PanelArrendado.isVisible())
                query = "DELETE FROM PAQUETERIA.arrendado WHERE idCamion = " + idCamion;
            else
                query = "DELETE FROM PAQUETERIA.comprado WHERE idCamion = " + idCamion;
            
            try{
                Statement st = conexion.createStatement();
                st.executeUpdate(query);
                query = "DELETE FROM PAQUETERIA.camion WHERE idCamion = " + idCamion;
                st.executeUpdate(query);
                fillTabla();
                CleanControls();
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

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
            java.util.logging.Logger.getLogger(Camion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Camion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Camion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Camion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Camion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelArrendado;
    private javax.swing.JPanel PanelComprado;
    private javax.swing.JButton btnAdd;
    private javax.swing.JRadioButton btnArrendado;
    private javax.swing.JRadioButton btnComprado;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEditar;
    private javax.swing.ButtonGroup buttonGroup1;
    private com.toedter.calendar.JDateChooser dateCompra;
    private javax.swing.JComboBox<String> ddlContrato;
    private javax.swing.JComboBox<String> ddlSucursal;
    private javax.swing.JTable gridCamion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSpinner ntxtAno;
    private javax.swing.JSpinner ntxtCostoArr;
    private javax.swing.JSpinner ntxtCostoComp;
    private javax.swing.JSpinner ntxtPagoMensual;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtModelo;
    private javax.swing.JTextField txtPlaca;
    private javax.swing.JTextField txtProveedor;
    // End of variables declaration//GEN-END:variables
}
