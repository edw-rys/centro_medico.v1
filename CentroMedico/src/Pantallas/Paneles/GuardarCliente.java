package Pantallas.Paneles;

import Pantallas.jDialog.GenerarTurno;
import Clase.Clinica.Especialidad;
import Clases.Entidades.Cliente;
import Clases.Entidades.Clinica;
import Clases.more.Factura;
import Modelo.ConsultaBD.ConsultaBD;
import Modelo.ConsultaBD.GuardarBD;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class GuardarCliente extends javax.swing.JPanel {
    private Factura factura;
    private Cliente paciente;
    private Especialidad especialidad;
    public static final double IVA=12;
    public GuardarCliente() {
        initComponents();
        fcNac.setMaxSelectableDate(Calendar.getInstance().getTime());
        buscarEspecialidad();
        lblEspecialidad.setText( especialidad.getNombre());
        GenerarTurno.getTurnos().remove(0);
    }
    
    private void buscarEspecialidad(){
        ArrayList<Especialidad> espe=new ConsultaBD().consultarEspecialidad();
        String subCode=GenerarTurno.getTurnos().get(0).substring(0, 3);
        for(Especialidad e:espe)
            if(e.getNombre().substring(0,3).equals(subCode)){
                especialidad=e;
                return;
            }
    }
    private void cargarTabla(String especialidad,int c, double p1, double p2){
        DefaultTableModel modelo =new DefaultTableModel(){
            public boolean isCellEditable(int filas, int col){
                if(col==-1){return true;}else return false; 
            }
        };
        String[] columnas = {"Numero", "Descripcion","Cantidad","PRECIO UNITARIO","TOTAL"};
        modelo.setColumnIdentifiers(columnas);
        Object []o={ 1,especialidad,c, p1, p2};
        modelo.addRow(o);
        table.setModel(modelo);
    }

    public void cargar(){
        ConsultaBD con=new ConsultaBD();
        paciente=con.consultarCliente(txtCi.getText());
        if(paciente==null){
            txtApellido.setText("");
            txtEdad.setText("");
            txtNombre.setText("");
            return;
        }
        txtApellido.setText(paciente.getApellido());
        txtEdad.setText(paciente.getEdad()+"");
        txtNombre.setText(paciente.getNombre());
        cmbGS.setSelectedItem(paciente.getGrupoSanguineo());
        fcNac.setDate(paciente.getFechaNacimineto()); 
    }
    
    private boolean verificarCampos(){
        if(txtApellido.getText().equals("") || txtCi.getText().equals("") || txtEdad.getText().equals("") 
                || txtNombre.getText().equals("") )
            return false;
        if(txtCi.getText().length()!=10){
            txtCi.setBackground(Color.red);
            return false;
        }
        if(txtPrecio.getText().equals("")){
            txtPrecio.setBackground(Color.red);
            return false;
        }
        return true;
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        panelDatosCliente = new javax.swing.JPanel();
        jLabel50 = new javax.swing.JLabel();
        panelRecoleccionDatos = new javax.swing.JPanel();
        lblEspecialidad = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtCi = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtApellido = new javax.swing.JTextField();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtEdad = new javax.swing.JTextField();
        jLabel47 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cmbGS = new javax.swing.JComboBox<>();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        fcNac = new com.toedter.calendar.JDateChooser();
        panelCabezaDatosCliente = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        panelDetalle = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        lblEspecialidad1 = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        jLabel58 = new javax.swing.JLabel();
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
        jPanel5 = new javax.swing.JPanel();
        btnGenerar = new javax.swing.JButton();
        jLabel59 = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        jLabel60 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.Y_AXIS));

        jPanel2.setOpaque(false);
        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.LINE_AXIS));

        panelDatosCliente.setBackground(new java.awt.Color(0, 255, 0));
        panelDatosCliente.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelDatosCliente.setOpaque(false);
        panelDatosCliente.setLayout(new java.awt.BorderLayout());

        jLabel50.setText("              ");
        panelDatosCliente.add(jLabel50, java.awt.BorderLayout.LINE_END);

        panelRecoleccionDatos.setOpaque(false);
        panelRecoleccionDatos.setLayout(new java.awt.GridLayout(14, 2));

        lblEspecialidad.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblEspecialidad.setText("Especialidad");
        panelRecoleccionDatos.add(lblEspecialidad);

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel20.setText("   Buscar por cédula");
        panelRecoleccionDatos.add(jLabel20);

        jLabel12.setText(" ");
        panelRecoleccionDatos.add(jLabel12);

        jLabel13.setText(" ");
        panelRecoleccionDatos.add(jLabel13);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Cédula: ");
        panelRecoleccionDatos.add(jLabel2);

        txtCi.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtCi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCiKeyTyped(evt);
            }
        });
        panelRecoleccionDatos.add(txtCi);

        jLabel39.setText(" ");
        panelRecoleccionDatos.add(jLabel39);

        jLabel43.setText("  ");
        panelRecoleccionDatos.add(jLabel43);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Nombres: ");
        panelRecoleccionDatos.add(jLabel7);

        txtNombre.setEditable(false);
        txtNombre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        panelRecoleccionDatos.add(txtNombre);

        jLabel40.setText(" ");
        panelRecoleccionDatos.add(jLabel40);

        jLabel41.setText(" ");
        panelRecoleccionDatos.add(jLabel41);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Apellidos: ");
        panelRecoleccionDatos.add(jLabel8);

        txtApellido.setEditable(false);
        txtApellido.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        panelRecoleccionDatos.add(txtApellido);

        jLabel44.setText(" ");
        panelRecoleccionDatos.add(jLabel44);

        jLabel45.setText(" ");
        panelRecoleccionDatos.add(jLabel45);

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Edad: ");
        panelRecoleccionDatos.add(jLabel9);

        txtEdad.setEditable(false);
        txtEdad.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        panelRecoleccionDatos.add(txtEdad);

        jLabel47.setText(" ");
        panelRecoleccionDatos.add(jLabel47);

        jLabel46.setText(" ");
        panelRecoleccionDatos.add(jLabel46);

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("G. Sanguineo: ");
        panelRecoleccionDatos.add(jLabel10);

        cmbGS.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "O-", "O+", "A-", "A+", "B-", "B+", "AB-", "AB+" }));
        panelRecoleccionDatos.add(cmbGS);

        jLabel48.setText(" ");
        panelRecoleccionDatos.add(jLabel48);

        jLabel49.setText(" ");
        panelRecoleccionDatos.add(jLabel49);

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Fecha Nac:");
        panelRecoleccionDatos.add(jLabel11);

        fcNac.setEnabled(false);
        panelRecoleccionDatos.add(fcNac);

        panelDatosCliente.add(panelRecoleccionDatos, java.awt.BorderLayout.CENTER);

        panelCabezaDatosCliente.setBackground(new java.awt.Color(102, 255, 204));
        panelCabezaDatosCliente.setLayout(new java.awt.BorderLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Datos del cliente");
        panelCabezaDatosCliente.add(jLabel1, java.awt.BorderLayout.CENTER);

        jLabel3.setText(" ");
        panelCabezaDatosCliente.add(jLabel3, java.awt.BorderLayout.PAGE_START);

        jLabel4.setText(" ");
        panelCabezaDatosCliente.add(jLabel4, java.awt.BorderLayout.PAGE_END);

        jLabel5.setText("                              ");
        panelCabezaDatosCliente.add(jLabel5, java.awt.BorderLayout.LINE_START);

        jLabel6.setText("               ");
        panelCabezaDatosCliente.add(jLabel6, java.awt.BorderLayout.LINE_END);

        panelDatosCliente.add(panelCabezaDatosCliente, java.awt.BorderLayout.PAGE_START);

        panelDetalle.setLayout(new java.awt.GridLayout(3, 0));

        jLabel15.setText(" ");
        panelDetalle.add(jLabel15);

        jLabel14.setText(" ");
        panelDetalle.add(jLabel14);

        lblEspecialidad1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblEspecialidad1.setText("Precio: ");
        panelDetalle.add(lblEspecialidad1);

        txtPrecio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtPrecio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecioKeyTyped(evt);
            }
        });
        panelDetalle.add(txtPrecio);

        panelDatosCliente.add(panelDetalle, java.awt.BorderLayout.SOUTH);

        jPanel2.add(panelDatosCliente);

        jLabel58.setText("     ");
        jPanel2.add(jLabel58);

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
                "Nunero", "Detalle", "Precio", "Cantidad", "Total"
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

        add(jPanel2);

        jPanel5.setLayout(new javax.swing.BoxLayout(jPanel5, javax.swing.BoxLayout.LINE_AXIS));

        btnGenerar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnGenerar.setText("Generar Factura");
        btnGenerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarActionPerformed(evt);
            }
        });
        jPanel5.add(btnGenerar);

        jLabel59.setText("              ");
        jPanel5.add(jLabel59);

        btnCancelar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnCancelar.setText("Cancelar");
        jPanel5.add(btnCancelar);

        jLabel60.setText("              ");
        jPanel5.add(jLabel60);

        btnGuardar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel5.add(btnGuardar);

        add(jPanel5);
    }// </editor-fold>//GEN-END:initComponents

    private void txtCiKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCiKeyTyped
        txtCi.setBackground(Color.white);
        char x=evt.getKeyChar();
        if(x<'0' || x>'9' ){
           evt.consume(); // consumir el evento para que no se realice
        }
        if(txtCi.getText().length()==10)
        {
            evt.consume();
        }
        cargar();
    }//GEN-LAST:event_txtCiKeyTyped

    private void btnGenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarActionPerformed
        if(verificarCampos()){
            lblCi.setText(txtCi.getText());
            Calendar cal=Calendar.getInstance();
            int diaSlect=cal.getTime().getDate();
            int mesSelecy=cal.getTime().getMonth();
            int yearSelect=cal.getTime().getYear()+1900;
            
            int nFactura=new ConsultaBD().getNextNumberFacture();
            
            lblNumber.setText("      "+nFactura+"");
            lblFecha.setText(diaSlect+" / "+(mesSelecy+1)+" / "+yearSelect );
            double sub=Double.parseDouble(txtPrecio.getText());
            double iva=sub*(IVA/100), total=iva+sub;
            txtSub.setText(sub+"");
            txtIva.setText(iva+"");
            txtTotal.setText(total+"");
            
          /*  cliente=new Cliente();
            cliente.setApellido(txtApellido.getText());
            cliente.setCi(txtCi.getText());
            cliente.setEdad(Integer.parseInt(txtEdad.getText()));
            cliente.setNombre(txtNombre.getText());
            cliente.setGrupoSanguineo(cmbGS.getSelectedItem().toString());
            Calendar calendr=fcNac.getCalendar();
            
            cliente.setFechaNacimineto(new Date( (calendr.getTime().getYear()),
                    calendr.getTime().getMonth(),
                    calendr.getTime().getDate()));*/
            
            
            factura=new Factura(nFactura, new Date(yearSelect-1900, mesSelecy, diaSlect),
                    sub, iva, total, txtCi.getText());
            cargarTabla(  lblEspecialidad.getText(), 1, sub, sub*1);
        }
        else
            JOptionPane.showMessageDialog(null, "Capos vacios o erroneos");
        
    }//GEN-LAST:event_btnGenerarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if(paciente==null || factura==null){
            JOptionPane.showMessageDialog(null, "No hay datos generados");
            return;
        }
        GuardarBD guardar=new GuardarBD();

        for(int i=0;i<Clinica.getListaAtenciones().size();i++){
            if(Clinica.getEspecialidad(i).getCode()==especialidad.getCode()){
                Clinica.addCliente(i, paciente);
                Clinica.addPacientesNoAtendidos(i, paciente);
                break;
            }
        }
        int rs=guardar.guardarFactura(factura,lblEspecialidad.getText());
        if(rs>0)
            JOptionPane.showMessageDialog(null, "Datos guardados correctamente!");
        else
            JOptionPane.showMessageDialog(null, "No se guardó la factura");
        
        
        this.setVisible(false);
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void txtPrecioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioKeyTyped
        txtPrecio.setBackground(Color.white);
        char caracter= evt.getKeyChar();  
        if (((caracter < '0') || (caracter > '9')) 
            && (caracter != java.awt.event.KeyEvent.VK_BACK_SPACE)
            && (caracter != '.' || txtPrecio.getText().contains(".")) ) {
                evt.consume();
        }
    }//GEN-LAST:event_txtPrecioKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGenerar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<String> cmbGS;
    private com.toedter.calendar.JDateChooser fcNac;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
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
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblCi;
    private javax.swing.JLabel lblEspecialidad;
    private javax.swing.JLabel lblEspecialidad1;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblNumber;
    private javax.swing.JPanel panelCabezaDatosCliente;
    private javax.swing.JPanel panelCabezaDatosCliente1;
    private javax.swing.JPanel panelDatosCliente;
    private javax.swing.JPanel panelDetalle;
    private javax.swing.JPanel panelFacturaCliente;
    private javax.swing.JPanel panelRecoleccionDatos;
    private javax.swing.JPanel panelRecoleccionDatos2;
    private javax.swing.JTable table;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtCi;
    private javax.swing.JTextField txtEdad;
    private javax.swing.JTextField txtIva;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtSub;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
