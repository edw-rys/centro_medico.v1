package Pantallas.jDialog;

import Clase.Clinica.Medicamento;
import Clase.Clinica.Procedimiento;
import Clases.Entidades.Cliente;
import Clases.Entidades.Clinica;
import Clases.more.*;
import Modelo.ConsultaBD.ConsultaBD;
import Modelo.ConsultaBD.GuardarBD;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class PantallaProcedimiento extends javax.swing.JDialog {
    private ArrayList< StockMedicina> medicinas=new ArrayList();
    private ArrayList< Procedimiento> procedimientos=new ArrayList();
    private Factura facturaCliente=null;
    //seleccion
    private ArrayList< Procedimiento> procediminetosSeleccionados=new ArrayList();
    private ArrayList< DetalleFactura> detalleFacturaAdd=new ArrayList();
    public PantallaProcedimiento(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        enableCmaps(false);
        cargarDatosADD();
        
    }
    
    private void enableCmaps(boolean bol){
        cmbMedicina.setEnabled(bol);
        cmbProcedimiento.setEnabled(bol);
        btnUpdate.setEnabled(bol);
        btnAddMedicina.setEnabled(bol);
        btnAddProcedimiento.setEnabled(bol);
    }
    private void cargarMaxMedicina(){
        cmbCantMedicina.removeAllItems();
        int pos=cmbMedicina.getSelectedIndex();
        try{
            StockMedicina med=medicinas.get(pos);
            
            for(int i=1;i<=med.getCantidad();i++)
                cmbCantMedicina.addItem(i+"");
        }catch(java.lang.IndexOutOfBoundsException e){}
    }
    private void cargarDatosADD(){
        ConsultaBD c=new ConsultaBD();
        medicinas=c.consultarMedicina("");
        if(medicinas!=null)
        {cmbMedicina.removeAllItems();
        for(StockMedicina m :medicinas){
            cmbMedicina.addItem(m.getMedicina().getNombe());
        }
        
        }
        procedimientos=c.consultarProcedimientos();
        if(procedimientos!=null)
        {cmbProcedimiento.removeAllItems();
        for(Procedimiento m :procedimientos){
            cmbProcedimiento.addItem(m.getNombre());
        }}
        
        cargarMaxMedicina();
    }
    private Cliente cliente;
    
    private void buscarPaciente(String ci){
        cliente=new ConsultaBD().consultarCliente(ci);
        if(cliente==null){
            JOptionPane.showMessageDialog(null, "No se encontró cliente");
            return;
        }  
        System.out.println(cliente.getFacturas().size());
        if(cliente.getFacturas()==null)return;
        if(cliente.getFacturas().isEmpty())return;
        enableCmaps(true);
        cargarFactura(cliente);
    }
    
    private void cargarFactura(Cliente ci){
        facturaCliente=cliente.getFacturas().get(cliente.getFacturas().size()-1);
        lblCi.setText(cliente.getCi());
        lblFecha.setText(facturaCliente.getFecha().toString());
        lblNumber.setText(facturaCliente.getNumero()+"");
        txtSub.setText(facturaCliente.getSubtotal()+"");
        txtIva.setText(facturaCliente.getIva()+"");
        txtTotal.setText(facturaCliente.getTotal()+"");
        cargarTabla(facturaCliente);
    }
    private void cargarTabla(Factura factura){
        DefaultTableModel modelo =new DefaultTableModel(){
            public boolean isCellEditable(int filas, int col){
                if(col==-1){return true;}else return false; 
            }
        };
        System.out.println("cc");
        String[] columnas = {"Numero", "Descripcion","Cantidad","PRECIO UNITARIO","TOTAL"};
        modelo.setColumnIdentifiers(columnas);
        Object []o=new Object[5];
        double sub=0;
        int i=1;
        if(factura!=null){
            sub=factura.getPrecioConsulta();
            o[0]=i++;
            o[1]=factura.getDescripcionConsulta();
            o[2]=1;
            o[3]=factura.getPrecioConsulta();
            o[4]=factura.getPrecioConsulta();
            modelo.addRow(o);
            if(factura.getDetalle()!=null )
                for(DetalleFactura m : factura.getDetalle()){
                    o[0]=i++;
                    o[1]=m.getMedicina().getNombe();
                    o[2]=m.getCantidadProducto();
                    o[3]=m.getMedicina().getPrecio();
                    o[4]=m.getMedicina().getPrecio()*m.getCantidadProducto();
                    sub+=m.getMedicina().getPrecio()*m.getCantidadProducto();
                    modelo.addRow(o);
                }
            if(factura.getProcedimiento()!=null)
                    for(Procedimiento m : factura.getProcedimiento()){
                    o[0]=i++;
                    o[1]=m.getNombre();
                    o[2]=1;
                    o[3]=m.getPrecio();
                    o[4]=m.getPrecio();
                    sub+=m.getPrecio();
                    modelo.addRow(o);
                }
        }
        double iva=sub*Clinica.iva/100;
        txtSub.setText(sub+"");
        txtIva.setText(iva+"");
        txtTotal.setText((iva+sub)+"");
        table.setModel(modelo);
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        panelPaciente = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        txtCi = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnSearch = new javax.swing.JButton();
        panelProcedimiento = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        cmbProcedimiento = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblPrecioProcedimiento = new javax.swing.JLabel();
        btnAddProcedimiento = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel7 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        cmbMedicina = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        cmbCantMedicina = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lblPrecioMedicina = new javax.swing.JLabel();
        btnAddMedicina = new javax.swing.JButton();
        panelFacturaCliente = new javax.swing.JPanel();
        panelRecoleccionDatos2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        lblNumber = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        lblCi = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        txtSub = new javax.swing.JTextField();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        txtIva = new javax.swing.JTextField();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        panelCabezaDatosCliente1 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        btnClose = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        btnUpdate = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.PAGE_AXIS));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new java.awt.GridLayout());

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new javax.swing.BoxLayout(jPanel5, javax.swing.BoxLayout.Y_AXIS));

        panelPaciente.setBackground(new java.awt.Color(255, 255, 255));
        panelPaciente.setLayout(new java.awt.GridLayout(2, 0));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("PACIENTE");
        jPanel9.add(jLabel1);

        panelPaciente.add(jPanel9);

        jPanel10.setLayout(new javax.swing.BoxLayout(jPanel10, javax.swing.BoxLayout.LINE_AXIS));
        jPanel10.add(txtCi);

        jLabel2.setText("                                ");
        jPanel10.add(jLabel2);

        btnSearch.setText("Buscar cédula");
        btnSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSearchMouseClicked(evt);
            }
        });
        jPanel10.add(btnSearch);

        panelPaciente.add(jPanel10);

        jPanel5.add(panelPaciente);

        panelProcedimiento.setLayout(new javax.swing.BoxLayout(panelProcedimiento, javax.swing.BoxLayout.PAGE_AXIS));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("PROCEDIMIENTO");
        jPanel11.add(jLabel3);

        panelProcedimiento.add(jPanel11);

        jPanel12.setLayout(new javax.swing.BoxLayout(jPanel12, javax.swing.BoxLayout.Y_AXIS));

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel13.setLayout(new java.awt.GridLayout(4, 0));

        jLabel4.setText("Seleccione:   ");
        jPanel13.add(jLabel4);

        cmbProcedimiento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "null", "null", "null" }));
        cmbProcedimiento.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbProcedimientoItemStateChanged(evt);
            }
        });
        jPanel13.add(cmbProcedimiento);

        jLabel6.setText("  ");
        jPanel13.add(jLabel6);

        jLabel5.setText("  ");
        jPanel13.add(jLabel5);

        jLabel7.setText("Precio:  $");
        jPanel13.add(jLabel7);

        lblPrecioProcedimiento.setText("0");
        jPanel13.add(lblPrecioProcedimiento);

        jPanel12.add(jPanel13);

        btnAddProcedimiento.setText("Añadir");
        btnAddProcedimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddProcedimientoActionPerformed(evt);
            }
        });
        jPanel12.add(btnAddProcedimiento);
        jPanel12.add(jSeparator2);

        panelProcedimiento.add(jPanel12);

        jPanel5.add(panelProcedimiento);

        jPanel7.setLayout(new javax.swing.BoxLayout(jPanel7, javax.swing.BoxLayout.Y_AXIS));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setText("Medicina");
        jPanel14.add(jLabel9);

        jPanel7.add(jPanel14);

        jPanel15.setLayout(new javax.swing.BoxLayout(jPanel15, javax.swing.BoxLayout.Y_AXIS));

        jPanel16.setBackground(new java.awt.Color(255, 255, 255));
        jPanel16.setLayout(new java.awt.GridLayout(4, 0));

        jLabel10.setText("Seleccione:   ");
        jPanel16.add(jLabel10);

        cmbMedicina.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "null", "null", "null" }));
        cmbMedicina.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbMedicinaItemStateChanged(evt);
            }
        });
        jPanel16.add(cmbMedicina);

        jLabel16.setText("Cantidad: ");
        jPanel16.add(jLabel16);

        cmbCantMedicina.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0" }));
        cmbCantMedicina.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbCantMedicinaItemStateChanged(evt);
            }
        });
        jPanel16.add(cmbCantMedicina);

        jLabel11.setText("  ");
        jPanel16.add(jLabel11);

        jLabel12.setText("  ");
        jPanel16.add(jLabel12);

        jLabel13.setText("Precio:  $");
        jPanel16.add(jLabel13);

        lblPrecioMedicina.setText("0");
        jPanel16.add(lblPrecioMedicina);

        jPanel15.add(jPanel16);

        btnAddMedicina.setText("Añadir");
        btnAddMedicina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddMedicinaActionPerformed(evt);
            }
        });
        jPanel15.add(btnAddMedicina);

        jPanel7.add(jPanel15);

        jPanel5.add(jPanel7);

        jPanel2.add(jPanel5);

        panelFacturaCliente.setBackground(new java.awt.Color(0, 255, 0));
        panelFacturaCliente.setOpaque(false);
        panelFacturaCliente.setLayout(new java.awt.BorderLayout());

        panelRecoleccionDatos2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelRecoleccionDatos2.setOpaque(false);
        panelRecoleccionDatos2.setLayout(new javax.swing.BoxLayout(panelRecoleccionDatos2, javax.swing.BoxLayout.Y_AXIS));

        jPanel1.setOpaque(false);
        jPanel1.setLayout(new java.awt.GridLayout(8, 2));

        jLabel36.setText(" ");
        jPanel1.add(jLabel36);

        jLabel37.setText(" ");
        jPanel1.add(jLabel37);

        jLabel29.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel29.setText("N°: ");
        jPanel1.add(jLabel29);

        lblNumber.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNumber.setText("....................");
        jPanel1.add(lblNumber);

        jLabel33.setText(" ");
        jPanel1.add(jLabel33);

        jLabel34.setText(" ");
        jPanel1.add(jLabel34);

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel19.setText("Fecha: ");
        jPanel1.add(jLabel19);

        lblFecha.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblFecha.setText("....................");
        jPanel1.add(lblFecha);

        jLabel35.setText(" ");
        jPanel1.add(jLabel35);

        jLabel38.setText(" ");
        jPanel1.add(jLabel38);

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel18.setText("Cédula: ");
        jPanel1.add(jLabel18);

        lblCi.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblCi.setText("....................");
        jPanel1.add(lblCi);

        panelRecoleccionDatos2.add(jPanel1);
        panelRecoleccionDatos2.add(jSeparator1);

        jPanel3.setOpaque(false);
        jPanel3.setLayout(new javax.swing.BoxLayout(jPanel3, javax.swing.BoxLayout.Y_AXIS));

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Numero", "Detalle", "Precio", "Cantidad", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(table);

        jPanel3.add(jScrollPane1);

        jPanel4.setOpaque(false);
        jPanel4.setLayout(new java.awt.GridLayout(7, 0));

        jLabel52.setText("   ");
        jPanel4.add(jLabel52);

        jLabel53.setText(" ");
        jPanel4.add(jLabel53);

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel23.setText("Sub: ");
        jPanel4.add(jLabel23);

        txtSub.setText("  ");
        txtSub.setEnabled(false);
        jPanel4.add(txtSub);

        jLabel54.setText("  ");
        jPanel4.add(jLabel54);

        jLabel55.setText("  ");
        jPanel4.add(jLabel55);

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel21.setText("Iva: ");
        jPanel4.add(jLabel21);

        txtIva.setText("  ");
        txtIva.setEnabled(false);
        jPanel4.add(txtIva);

        jLabel56.setText("   ");
        jPanel4.add(jLabel56);

        jLabel57.setText("  ");
        jPanel4.add(jLabel57);

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel22.setText("Total: ");
        jPanel4.add(jLabel22);

        txtTotal.setText(" ");
        txtTotal.setEnabled(false);
        jPanel4.add(txtTotal);

        jPanel3.add(jPanel4);

        panelRecoleccionDatos2.add(jPanel3);

        panelFacturaCliente.add(panelRecoleccionDatos2, java.awt.BorderLayout.CENTER);

        panelCabezaDatosCliente1.setBackground(new java.awt.Color(0, 204, 204));
        panelCabezaDatosCliente1.setLayout(new java.awt.BorderLayout());

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel24.setText("Factura");
        panelCabezaDatosCliente1.add(jLabel24, java.awt.BorderLayout.CENTER);

        jLabel25.setText(" ");
        panelCabezaDatosCliente1.add(jLabel25, java.awt.BorderLayout.PAGE_START);

        jLabel26.setText(" ");
        panelCabezaDatosCliente1.add(jLabel26, java.awt.BorderLayout.PAGE_END);

        jLabel27.setText("                              ");
        panelCabezaDatosCliente1.add(jLabel27, java.awt.BorderLayout.LINE_START);

        jLabel28.setText("    ");
        panelCabezaDatosCliente1.add(jLabel28, java.awt.BorderLayout.LINE_END);

        panelFacturaCliente.add(panelCabezaDatosCliente1, java.awt.BorderLayout.PAGE_START);

        jPanel2.add(panelFacturaCliente);

        getContentPane().add(jPanel2);

        btnClose.setText("Cancelar");
        jPanel6.add(btnClose);

        jLabel15.setText("               ");
        jPanel6.add(jLabel15);

        btnUpdate.setText("Actualizar");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        jPanel6.add(btnUpdate);

        getContentPane().add(jPanel6);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchMouseClicked
        buscarPaciente(txtCi.getText());
    }//GEN-LAST:event_btnSearchMouseClicked

    private void btnAddProcedimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddProcedimientoActionPerformed
        int pos=cmbProcedimiento.getSelectedIndex();
        
        procediminetosSeleccionados.add(procedimientos.get(pos));
        System.out.println(procedimientos.get(pos).getId()+" "+procedimientos.get(pos).getNombre());
        Factura factura=cliente.getFacturas().get(cliente.getFacturas().size()-1);
        factura.getProcedimiento().add(procedimientos.get(pos));
        cargarFactura(cliente);
    }//GEN-LAST:event_btnAddProcedimientoActionPerformed

    private void btnAddMedicinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddMedicinaActionPerformed
        int pos=cmbMedicina.getSelectedIndex();
        
        
        
        Factura factura=cliente.getFacturas().get(cliente.getFacturas().size()-1);
        Medicamento m =medicinas.get(pos).getMedicina();
        int cant=Integer.parseInt(cmbCantMedicina.getSelectedItem().toString());
        factura.getDetalle().add(new DetalleFactura(cant , m.getPrecio(), m,cant*m.getPrecio()));
        
        DetalleFactura detail=new DetalleFactura();
        detail.setId(Integer.parseInt(lblNumber.getText()));
        detail.setMedicina(medicinas.get(pos).getMedicina());
        detail.setPrecio(medicinas.get(pos).getMedicina().getPrecio());
        detail.setCantidadProducto(cant);
        detail.calcularTotal();
        
        detalleFacturaAdd.add(detail);
        cargarFactura(cliente);
    }//GEN-LAST:event_btnAddMedicinaActionPerformed

    private void cmbProcedimientoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbProcedimientoItemStateChanged
        try{
            int pos=cmbProcedimiento.getSelectedIndex();
            lblPrecioProcedimiento.setText(procedimientos.get(pos).getPrecio()+"");
        }catch(NullPointerException es){
            
        }catch(java.lang.IndexOutOfBoundsException e){}
    }//GEN-LAST:event_cmbProcedimientoItemStateChanged

    private void cmbMedicinaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbMedicinaItemStateChanged
        try{
            int pos=cmbMedicina.getSelectedIndex();
            lblPrecioMedicina.setText((medicinas.get(pos).getMedicina().getPrecio()*
                    Integer.parseInt(cmbCantMedicina.getSelectedItem().toString()))+"");
            cargarMaxMedicina();
        }catch(NullPointerException es){
        }catch(java.lang.IndexOutOfBoundsException e){}
    }//GEN-LAST:event_cmbMedicinaItemStateChanged

    private void cmbCantMedicinaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbCantMedicinaItemStateChanged
        try{
            int pos=cmbMedicina.getSelectedIndex();
            lblPrecioMedicina.setText((medicinas.get(pos).getMedicina().getPrecio()*
                    Integer.parseInt(cmbCantMedicina.getSelectedItem().toString()))+"");
        }catch(NullPointerException es){
        }catch(java.lang.IndexOutOfBoundsException e){}
    }//GEN-LAST:event_cmbCantMedicinaItemStateChanged

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        GuardarBD actualizar=new GuardarBD();
        facturaCliente.setSubtotal(Double.parseDouble(txtSub.getText()));
        facturaCliente.setIva(Double.parseDouble(txtIva.getText()));
        facturaCliente.setTotal(Double.parseDouble(txtTotal.getText()));
        int res=actualizar.actualizarDatosFactura(facturaCliente, procediminetosSeleccionados, detalleFacturaAdd);
        if(res>0)
            JOptionPane.showMessageDialog(null, "Datos Actualizados");
        else
            JOptionPane.showMessageDialog(null, "No actualizado");
        this.dispose();
    }//GEN-LAST:event_btnUpdateActionPerformed

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
            java.util.logging.Logger.getLogger(PantallaProcedimiento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PantallaProcedimiento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PantallaProcedimiento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PantallaProcedimiento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                PantallaProcedimiento dialog = new PantallaProcedimiento(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddMedicina;
    private javax.swing.JButton btnAddProcedimiento;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cmbCantMedicina;
    private javax.swing.JComboBox<String> cmbMedicina;
    private javax.swing.JComboBox<String> cmbProcedimiento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblCi;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblNumber;
    private javax.swing.JLabel lblPrecioMedicina;
    private javax.swing.JLabel lblPrecioProcedimiento;
    private javax.swing.JPanel panelCabezaDatosCliente1;
    private javax.swing.JPanel panelFacturaCliente;
    private javax.swing.JPanel panelPaciente;
    private javax.swing.JPanel panelProcedimiento;
    private javax.swing.JPanel panelRecoleccionDatos2;
    private javax.swing.JTable table;
    private javax.swing.JTextField txtCi;
    private javax.swing.JTextField txtIva;
    private javax.swing.JTextField txtSub;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
