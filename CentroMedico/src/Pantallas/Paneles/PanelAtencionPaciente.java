package Pantallas.Paneles;

import Clase.Clinica.Especialidad;
import Clase.Clinica.Medicamento;
import Clase.Clinica.MuestraPaciente;
import Clases.Entidades.Cliente;
import Clases.Entidades.Clinica;
import Clases.Entidades.Doctor;
import Clases.Entidades.Receta;
import Modelo.ConsultaBD.ConsultaBD;
import Modelo.ConsultaBD.GuardarBD;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class PanelAtencionPaciente extends javax.swing.JPanel {
    private ArrayList<Medicamento> medicinas;
    private Receta recetaPaciente=new Receta();
    private Cliente paciente;
    private Doctor doctor;
    private Especialidad especialidad;
    public PanelAtencionPaciente() {
        initComponents();
    }
    public void cargarDatos(Cliente paciente, Doctor doctor, Especialidad especialidad){
        this.especialidad=especialidad;
        this.paciente=paciente;
        this.doctor=doctor;
        cargarMedicinas();
        cargarTabla();
        cargarPaaciente();
        cargarDoctor();
        Clinica.addPacientesAtendidos(especialidad.getCode(), paciente);
        Calendar c=Calendar.getInstance();
        fchIni.setDate(c.getTime());
        fchFin.setMinSelectableDate(c.getTime());
    }
    private void cargarTabla(){
        DefaultTableModel modelo =new DefaultTableModel(){
            public boolean isCellEditable(int filas, int col){
                if(col==-1){return true;}else return false; 
            }
        };
        String[] columnas = {"CODIGO", "NOMBRE","CANTIDAD","FECHA INICIO","FECHA FIN"};
        modelo.setColumnIdentifiers(columnas);
        Object [] actual=new Object[5];
        if(recetaPaciente.getMedicina()!= null){
            for (int i = 0 ; i<recetaPaciente.getMedicina().size() ; i++){
                actual[0]=recetaPaciente.getMedicina().get(i).getIdMedicamneto();
                actual[1]=recetaPaciente.getMedicina().get(i).getNombe();
                actual[2]=recetaPaciente.getCantidad().get(i);
                actual[3]=recetaPaciente.getFechaIni().get(i);
                actual[4]=recetaPaciente.getFechaFin().get(i);
                modelo.addRow(actual);
            }
        }
        tableMedicina.setModel(modelo);
    }
    
    private void cargarMedicinas(){
        medicinas=new ConsultaBD().consultaMedicamento();
        cmbMedicina.removeAllItems();
        if(medicinas==null)
            return;
        for(Medicamento m:medicinas){
            cmbMedicina.addItem(m.getNombe());
        }
    }
    private void cargarPaaciente(){
        txtNombre.setText(paciente.getNombre());
        txtApellido.setText(paciente.getApellido());
        txtCi.setText(paciente.getCi());
        txtEdad.setText(paciente.getEdad()+"");
        fcNac.setDate(paciente.getFechaNacimineto());
        cmbGS.setSelectedItem(paciente.getGrupoSanguineo());
        //muestras
        MuestraPaciente muestra=  paciente.getMuestras().get(  paciente.getMuestras().size()-1  );
        txtPresion.setText(muestra.getPresion()+"");
        txtSize.setText(muestra.getEstatura()+"");
        txtPeso.setText(muestra.getPeso()+"");
    }
    private void cargarDoctor(){
        txtCiDoctor.setText(doctor.getCi());
        txtNombreDoctor.setText(doctor.getNombre());
        txtApellidoDoctor.setText(doctor.getApellido());
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        lblDoc = new javax.swing.JLabel();
        lblEspecialidad = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        txtCiDoctor = new javax.swing.JTextField();
        jLabel44 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        txtNombreDoctor = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        txtApellidoDoctor = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtCi = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtApellido = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtEdad = new javax.swing.JTextField();
        jLabel47 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cmbGS = new javax.swing.JComboBox<>();
        jLabel49 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        fcNac = new com.toedter.calendar.JDateChooser();
        jLabel32 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        txtPeso = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtSize = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtPresion = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        taSintomas = new javax.swing.JTextArea();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel8 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtCantidadM = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtVecesM = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        cmbMedicina = new javax.swing.JComboBox<>();
        jLabel30 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        fchIni = new com.toedter.calendar.JDateChooser();
        jLabel21 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        fchFin = new com.toedter.calendar.JDateChooser();
        jLabel28 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jLabel31 = new javax.swing.JLabel();
        btnAddMedicina = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableMedicina = new javax.swing.JTable();
        jPanel15 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        btnGuardar = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.Y_AXIS));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new java.awt.GridLayout(4, 0));

        lblDoc.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblDoc.setText("Doctor");
        jPanel5.add(lblDoc);

        lblEspecialidad.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblEspecialidad.setText("Especialidad");
        jPanel5.add(lblEspecialidad);

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel13.setLayout(new javax.swing.BoxLayout(jPanel13, javax.swing.BoxLayout.LINE_AXIS));

        jPanel14.setOpaque(false);
        jPanel14.setLayout(new javax.swing.BoxLayout(jPanel14, javax.swing.BoxLayout.LINE_AXIS));

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel25.setText("Cédula: ");
        jPanel14.add(jLabel25);

        txtCiDoctor.setEditable(false);
        txtCiDoctor.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel14.add(txtCiDoctor);

        jLabel44.setText("        ");
        jPanel14.add(jLabel44);

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel26.setText("Nombres: ");
        jPanel14.add(jLabel26);

        txtNombreDoctor.setEditable(false);
        txtNombreDoctor.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel14.add(txtNombreDoctor);

        jLabel45.setText("       ");
        jPanel14.add(jLabel45);

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel27.setText("Apellidos: ");
        jPanel14.add(jLabel27);

        txtApellidoDoctor.setEditable(false);
        txtApellidoDoctor.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel14.add(txtApellidoDoctor);

        jPanel13.add(jPanel14);

        jPanel5.add(jPanel13);

        add(jPanel5);

        jPanel3.setOpaque(false);
        jPanel3.setLayout(new java.awt.GridLayout(4, 0));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Datos Paciente");
        jPanel3.add(jLabel3);

        jPanel1.setOpaque(false);
        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.LINE_AXIS));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Cédula: ");
        jPanel1.add(jLabel2);

        txtCi.setEditable(false);
        txtCi.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.add(txtCi);

        jLabel39.setText("        ");
        jPanel1.add(jLabel39);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Nombres: ");
        jPanel1.add(jLabel7);

        txtNombre.setEditable(false);
        txtNombre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.add(txtNombre);

        jLabel40.setText("       ");
        jPanel1.add(jLabel40);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Apellidos: ");
        jPanel1.add(jLabel8);

        txtApellido.setEditable(false);
        txtApellido.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.add(txtApellido);

        jPanel3.add(jPanel1);

        jPanel2.setOpaque(false);
        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.LINE_AXIS));

        jLabel33.setText("                          ");
        jPanel2.add(jLabel33);

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Edad: ");
        jPanel2.add(jLabel9);

        txtEdad.setEditable(false);
        txtEdad.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel2.add(txtEdad);

        jLabel47.setText("      ");
        jPanel2.add(jLabel47);

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("G. Sanguineo: ");
        jPanel2.add(jLabel10);

        cmbGS.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "O-", "O+", "A-", "A+", "B-", "B+", "AB-", "AB+" }));
        cmbGS.setEnabled(false);
        jPanel2.add(cmbGS);

        jLabel49.setText("      ");
        jPanel2.add(jLabel49);

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Fecha Nac:");
        jPanel2.add(jLabel11);

        fcNac.setEnabled(false);
        jPanel2.add(fcNac);

        jLabel32.setText("                           ");
        jPanel2.add(jLabel32);

        jPanel3.add(jPanel2);

        add(jPanel3);

        jPanel4.setLayout(new java.awt.GridLayout(2, 0));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel6.setText("Muestra");
        jPanel4.add(jLabel6);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setLayout(new javax.swing.BoxLayout(jPanel7, javax.swing.BoxLayout.LINE_AXIS));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("Peso:  ");
        jPanel7.add(jLabel12);

        txtPeso.setEditable(false);
        txtPeso.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel7.add(txtPeso);

        jLabel41.setText("        ");
        jPanel7.add(jLabel41);

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("Tamaño:  ");
        jPanel7.add(jLabel13);

        txtSize.setEditable(false);
        txtSize.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel7.add(txtSize);

        jLabel42.setText("       ");
        jPanel7.add(jLabel42);

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setText("Presión:  ");
        jPanel7.add(jLabel14);

        txtPresion.setEditable(false);
        txtPresion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel7.add(txtPresion);

        jPanel4.add(jPanel7);

        add(jPanel4);

        jLabel5.setText("   ");
        add(jLabel5);

        jPanel6.setLayout(new javax.swing.BoxLayout(jPanel6, javax.swing.BoxLayout.Y_AXIS));

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel15.setText("Sintomas");
        jPanel6.add(jLabel15);

        taSintomas.setColumns(20);
        taSintomas.setRows(5);
        jScrollPane1.setViewportView(taSintomas);

        jPanel6.add(jScrollPane1);

        add(jPanel6);
        add(jSeparator1);

        jPanel8.setOpaque(false);
        jPanel8.setLayout(new javax.swing.BoxLayout(jPanel8, javax.swing.BoxLayout.Y_AXIS));

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel24.setText("RECETA");
        jPanel8.add(jLabel24);

        jPanel11.setLayout(new java.awt.GridLayout(4, 0));

        jPanel9.setLayout(new javax.swing.BoxLayout(jPanel9, javax.swing.BoxLayout.LINE_AXIS));

        jLabel29.setText("                          ");
        jPanel9.add(jLabel29);

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setText("Cantidad:  ");
        jPanel9.add(jLabel16);

        txtCantidadM.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel9.add(txtCantidadM);

        jLabel4.setText("     ");
        jPanel9.add(jLabel4);

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel17.setText("Veces al día:  ");
        jPanel9.add(jLabel17);

        txtVecesM.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel9.add(txtVecesM);

        jLabel43.setText("        ");
        jPanel9.add(jLabel43);

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel20.setText("Medicina:  ");
        jPanel9.add(jLabel20);

        cmbMedicina.setEditable(true);
        cmbMedicina.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "null", "null" }));
        jPanel9.add(cmbMedicina);

        jLabel30.setText("                       ");
        jPanel9.add(jLabel30);

        jPanel11.add(jPanel9);

        jLabel22.setText("    ");
        jPanel11.add(jLabel22);

        jPanel10.setLayout(new javax.swing.BoxLayout(jPanel10, javax.swing.BoxLayout.LINE_AXIS));

        jLabel1.setText("                               ");
        jPanel10.add(jLabel1);

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel18.setText("Inicio:  ");
        jPanel10.add(jLabel18);

        fchIni.setEnabled(false);
        jPanel10.add(fchIni);

        jLabel21.setText("            ");
        jPanel10.add(jLabel21);

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel19.setText("Fin:  ");
        jPanel10.add(jLabel19);
        jPanel10.add(fchFin);

        jLabel28.setText("                                              ");
        jPanel10.add(jLabel28);

        jPanel11.add(jPanel10);

        jButton2.setText("Limpiar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel16.add(jButton2);

        jLabel31.setText("                           ");
        jPanel16.add(jLabel31);

        btnAddMedicina.setText("Añadir medicina");
        btnAddMedicina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddMedicinaActionPerformed(evt);
            }
        });
        jPanel16.add(btnAddMedicina);

        jPanel11.add(jPanel16);

        jPanel8.add(jPanel11);

        jLabel23.setText("        ");
        jPanel8.add(jLabel23);

        tableMedicina.setModel(new javax.swing.table.DefaultTableModel(
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
        tableMedicina.setGridColor(new java.awt.Color(204, 204, 204));
        jScrollPane2.setViewportView(tableMedicina);

        jPanel8.add(jScrollPane2);

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 900, Short.MAX_VALUE)
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel8.add(jPanel15);

        add(jPanel8);

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel12.add(btnGuardar);

        add(jPanel12);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddMedicinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddMedicinaActionPerformed
        
        if(txtCantidadM.getText().equals("") || txtVecesM.getText().equals(""))
            return;
        
        recetaPaciente.getMedicina().add(medicinas.get(cmbMedicina.getSelectedIndex()));//medicina
        recetaPaciente.getCantidad().add(Integer.parseInt(txtCantidadM.getText()));//cantidad
        int diaSlect=fchIni.getCalendar().getTime().getDate();
        int mesSelecy=fchIni.getCalendar().getTime().getMonth()+1;
        int yearSelect=fchIni.getCalendar().getTime().getYear();
        recetaPaciente.getFechaIni().add(new Date(yearSelect, mesSelecy, diaSlect));//fecha ini
        recetaPaciente.getVecesPorDia().add(Integer.parseInt(txtVecesM.getText()));
        diaSlect=fchIni.getCalendar().getTime().getDate();
        mesSelecy=fchIni.getCalendar().getTime().getMonth()+1;
        yearSelect=fchIni.getCalendar().getTime().getYear();
        recetaPaciente.getFechaFin().add(new Date(yearSelect, mesSelecy, diaSlect));//fecha fin
        cargarTabla();
    }//GEN-LAST:event_btnAddMedicinaActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        txtCantidadM.setText("");
        txtVecesM.setText("");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if(taSintomas.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Escriba los sintomas");
            return;
        }
        
        if(recetaPaciente.getMedicina().size()<=0){
            JOptionPane.showMessageDialog(null, "Recete por lo menos 1 medicamento");
            return;
        }
        GuardarBD guardar=new GuardarBD();
        int i=guardar.guardarHistoriaPaciente(paciente.getCi(),recetaPaciente,doctor.getCi(),taSintomas.getText());
        if(i>0)JOptionPane.showMessageDialog(null, "Guardado");
        else
            JOptionPane.showMessageDialog(null, "Hubo un error!");
        this.setVisible(false);
    }//GEN-LAST:event_btnGuardarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddMedicina;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<String> cmbGS;
    private javax.swing.JComboBox<String> cmbMedicina;
    private com.toedter.calendar.JDateChooser fcNac;
    private com.toedter.calendar.JDateChooser fchFin;
    private com.toedter.calendar.JDateChooser fchIni;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
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
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
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
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblDoc;
    private javax.swing.JLabel lblEspecialidad;
    private javax.swing.JTextArea taSintomas;
    private javax.swing.JTable tableMedicina;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtApellidoDoctor;
    private javax.swing.JTextField txtCantidadM;
    private javax.swing.JTextField txtCi;
    private javax.swing.JTextField txtCiDoctor;
    private javax.swing.JTextField txtEdad;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNombreDoctor;
    private javax.swing.JTextField txtPeso;
    private javax.swing.JTextField txtPresion;
    private javax.swing.JTextField txtSize;
    private javax.swing.JTextField txtVecesM;
    // End of variables declaration//GEN-END:variables
}
