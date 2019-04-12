package Pantallas.jDialog;

import Clase.Clinica.Especialidad;
import Clases.Entidades.Doctor;
import Modelo.ConsultaBD.ConsultaBD;
import Modelo.ConsultaBD.GuardarBD;
import java.util.Calendar;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.sql.Date;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class GuardarDoctor extends javax.swing.JDialog {

    public GuardarDoctor(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        cargarEspecialidades();
        fcNac.setMaxSelectableDate(Calendar.getInstance().getTime());
        this.setLocationRelativeTo(null);//Centrar Jframe 
        panelSeleccionCi.setVisible(false);
    }

    private ArrayList<Especialidad> especialiddes=new ArrayList<>();
    private ArrayList<Doctor> doctores=new ArrayList<>();
    private int pos=-1;
    private Doctor doctorActualizar=null;
    public void cargarEspecialidades(){
        ConsultaBD c=new ConsultaBD();
        especialiddes= c.consultarEspecialidad();
        cmbEspecialidad.removeAllItems();
        for(Especialidad e:especialiddes)
            cmbEspecialidad.addItem(e.getNombre());
    }
    
    private boolean verificarCampos(){
        if(txtApellido.getText().equals("") || txtCi.getText().equals("") || txtEdad.getText().equals("") 
                || txtNombre.getText().equals("") )
            return false;
        if(txtCi.getText().length()!=10){
            txtCi.setBackground(Color.red);
            return false;
        }
        return true;
    }
    
    public void cargarCiDoctores(){
        panelSeleccionCi.setVisible(true);
        btnGuardar.setText("Actualizar");
        txtCi.setEnabled(false);
        ConsultaBD c=new ConsultaBD();
        doctores= c.ConsultarDoctores("");
        cmbCi.removeAllItems();
        for(Doctor e:doctores)
            cmbCi.addItem(e.getCi());
    }
    
    private void cargarDatos(){
        if(pos<0) return;
        doctorActualizar=doctores.get(pos);
        txtCi.setText(doctores.get(pos).getCi());
        txtNombre.setText(doctores.get(pos).getNombre());
        txtApellido.setText(doctores.get(pos).getApellido());
        txtEdad.setText(doctores.get(pos).getEdad()+"");
        cmbEspecialidad.setSelectedItem(  doctores.get(pos).getEspecialidad().getNombre());
        fcNac.setDate( doctores.get(pos).getFechaNacimineto());
    }
    
    public void soloLetras(KeyEvent evt){
        char c=evt.getKeyChar();
        if((c<'a' || c>'z')  && (c<'A' || c>'Z'))
            if(c!=' ')
                evt.consume();
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        panelDatosDoctor = new javax.swing.JPanel();
        jLabel50 = new javax.swing.JLabel();
        panelRecoleccionDatos = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
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
        cmbEspecialidad = new javax.swing.JComboBox<>();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        fcNac = new com.toedter.calendar.JDateChooser();
        panelCabezaDatosDatos = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        panelSeleccionCi = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        lblEspecialidad1 = new javax.swing.JLabel();
        cmbCi = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        btnGuardar = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new java.awt.BorderLayout());

        panelDatosDoctor.setBackground(new java.awt.Color(0, 255, 0));
        panelDatosDoctor.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelDatosDoctor.setOpaque(false);
        panelDatosDoctor.setLayout(new java.awt.BorderLayout());

        jLabel50.setText("              ");
        panelDatosDoctor.add(jLabel50, java.awt.BorderLayout.LINE_END);

        panelRecoleccionDatos.setOpaque(false);
        panelRecoleccionDatos.setLayout(new java.awt.GridLayout(13, 2));

        jLabel20.setText(" ");
        panelRecoleccionDatos.add(jLabel20);

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

        txtNombre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });
        panelRecoleccionDatos.add(txtNombre);

        jLabel40.setText(" ");
        panelRecoleccionDatos.add(jLabel40);

        jLabel41.setText(" ");
        panelRecoleccionDatos.add(jLabel41);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Apellidos: ");
        panelRecoleccionDatos.add(jLabel8);

        txtApellido.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtApellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApellidoKeyTyped(evt);
            }
        });
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
        jLabel10.setText("Especialidad");
        panelRecoleccionDatos.add(jLabel10);

        cmbEspecialidad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "null", "null" }));
        panelRecoleccionDatos.add(cmbEspecialidad);

        jLabel48.setText(" ");
        panelRecoleccionDatos.add(jLabel48);

        jLabel49.setText(" ");
        panelRecoleccionDatos.add(jLabel49);

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Fecha Nac:");
        panelRecoleccionDatos.add(jLabel11);

        fcNac.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                fcNacPropertyChange(evt);
            }
        });
        panelRecoleccionDatos.add(fcNac);

        panelDatosDoctor.add(panelRecoleccionDatos, java.awt.BorderLayout.CENTER);

        panelCabezaDatosDatos.setBackground(new java.awt.Color(102, 255, 204));
        panelCabezaDatosDatos.setLayout(new java.awt.BorderLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Datos del Doctor");
        panelCabezaDatosDatos.add(jLabel1, java.awt.BorderLayout.CENTER);

        jLabel3.setText(" ");
        panelCabezaDatosDatos.add(jLabel3, java.awt.BorderLayout.PAGE_START);

        jLabel4.setText(" ");
        panelCabezaDatosDatos.add(jLabel4, java.awt.BorderLayout.PAGE_END);

        jLabel5.setText("                              ");
        panelCabezaDatosDatos.add(jLabel5, java.awt.BorderLayout.LINE_START);

        jLabel6.setText("               ");
        panelCabezaDatosDatos.add(jLabel6, java.awt.BorderLayout.LINE_END);

        panelDatosDoctor.add(panelCabezaDatosDatos, java.awt.BorderLayout.PAGE_START);

        panelSeleccionCi.setLayout(new java.awt.GridLayout(3, 0));

        jLabel15.setText(" ");
        panelSeleccionCi.add(jLabel15);

        jLabel14.setText(" ");
        panelSeleccionCi.add(jLabel14);

        lblEspecialidad1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblEspecialidad1.setText("Cedula");
        panelSeleccionCi.add(lblEspecialidad1);

        cmbCi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "null", "null" }));
        cmbCi.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbCiItemStateChanged(evt);
            }
        });
        panelSeleccionCi.add(cmbCi);

        panelDatosDoctor.add(panelSeleccionCi, java.awt.BorderLayout.SOUTH);

        jPanel1.add(panelDatosDoctor, java.awt.BorderLayout.CENTER);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        btnGuardar.setBackground(new java.awt.Color(0, 255, 255));
        btnGuardar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel2.add(btnGuardar);

        jLabel16.setText("                  ");
        jPanel2.add(jLabel16);

        btnCancelar.setBackground(new java.awt.Color(204, 0, 0));
        btnCancelar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(255, 0, 0));
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel2.add(btnCancelar);

        jPanel1.add(jPanel2, java.awt.BorderLayout.SOUTH);

        getContentPane().add(jPanel1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCiKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCiKeyTyped
        txtCi.setBackground(Color.white);
        char x=evt.getKeyChar();
        if(x<'0' || x>'9' )
        {
            evt.consume(); // consumir el evento para que no se realice
        }
        if(txtCi.getText().length()==10)
        {
            evt.consume();
        }
    }//GEN-LAST:event_txtCiKeyTyped

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        soloLetras(evt);
    }//GEN-LAST:event_txtNombreKeyTyped

    private void txtApellidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidoKeyTyped
        soloLetras(evt);
    }//GEN-LAST:event_txtApellidoKeyTyped

    private void fcNacPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_fcNacPropertyChange
        //Evento selección de un dia
        if( fcNac.getDate()==null)
        return;
        int diaSlect=fcNac.getDate().getDate();
        int mesSelecy=fcNac.getDate().getMonth()+1;
        int yearSelect=fcNac.getDate().getYear();
        Calendar cal=Calendar.getInstance();
        txtEdad.setText(( cal.getTime().getYear()-yearSelect)+"");
    }//GEN-LAST:event_fcNacPropertyChange

    private void cmbCiItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbCiItemStateChanged
        try{
            pos = cmbCi.getSelectedIndex();
            cargarDatos();
        }catch(NullPointerException es){}
        catch(java.lang.IndexOutOfBoundsException e){}
    }//GEN-LAST:event_cmbCiItemStateChanged

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if(!verificarCampos()){
            JOptionPane.showMessageDialog(null, "Faltan datos o hay datos erroneos");
            return;}
        GuardarBD guardar=new GuardarBD();
        if(doctorActualizar==null){
            Doctor doctor=new Doctor();
            doctor.setNombre(txtNombre.getText());
            doctor.setApellido(txtApellido.getText());
            doctor.setCi(txtCi.getText());
            doctor.setEspecialidad(especialiddes.get(cmbEspecialidad.getSelectedIndex()));
            doctor.setEdad(Integer.parseInt(txtEdad.getText()));
            doctor.setFechaNacimineto(new Date( fcNac.getCalendar().getTime().getYear(),
                    fcNac.getCalendar().getTime().getMonth(),
                    fcNac.getCalendar().getTime().getDate()));
            if(guardar.guardarDoctor(doctor)>0)
                JOptionPane.showMessageDialog(null, "Datos guardados");
            else
                JOptionPane.showMessageDialog(null, "Error al guardar");
        }else{
            doctorActualizar.setNombre(txtNombre.getText());
            doctorActualizar.setApellido(txtApellido.getText());
            doctorActualizar.setEspecialidad(especialiddes.get(cmbEspecialidad.getSelectedIndex()));
            doctorActualizar.setEdad(Integer.parseInt(txtEdad.getText()));
            doctorActualizar.setFechaNacimineto(new Date( fcNac.getCalendar().getTime().getYear(),
                    fcNac.getCalendar().getTime().getMonth(),
                    fcNac.getCalendar().getTime().getDate()));
            if(guardar.editarDoctor(doctorActualizar)>0)
                JOptionPane.showMessageDialog(null, "Datos guardados");
            else
                JOptionPane.showMessageDialog(null, "Error al guardar");
        }
        this.dispose();
    }//GEN-LAST:event_btnGuardarActionPerformed

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
            java.util.logging.Logger.getLogger(GuardarDoctor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GuardarDoctor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GuardarDoctor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GuardarDoctor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                GuardarDoctor dialog = new GuardarDoctor(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<String> cmbCi;
    private javax.swing.JComboBox<String> cmbEspecialidad;
    private com.toedter.calendar.JDateChooser fcNac;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
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
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblEspecialidad1;
    private javax.swing.JPanel panelCabezaDatosDatos;
    private javax.swing.JPanel panelDatosDoctor;
    private javax.swing.JPanel panelRecoleccionDatos;
    private javax.swing.JPanel panelSeleccionCi;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtCi;
    private javax.swing.JTextField txtEdad;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
