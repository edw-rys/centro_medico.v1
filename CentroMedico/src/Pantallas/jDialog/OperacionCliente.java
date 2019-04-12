package Pantallas.jDialog;

import Clases.Entidades.Cliente;
import Clases.Entidades.Clinica;
import Modelo.ConsultaBD.ConsultaBD;
import Modelo.ConsultaBD.GuardarBD;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.sql.Date;
import java.util.Calendar;
import javax.swing.JOptionPane;


public class OperacionCliente extends javax.swing.JDialog {
    private Cliente cliente;
    public OperacionCliente(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);//Centrar Jframe 
    }

    
    public void cargar(){
        ConsultaBD con=new ConsultaBD();
        cliente=con.consultarCliente(txtCi.getText());
        if(cliente==null){
            txtApellido.setText("");
            txtEdad.setText("");
            txtNombre.setText("");
            return;}
        txtApellido.setText(cliente.getApellido());
        txtEdad.setText(cliente.getEdad()+"");
        txtNombre.setText(cliente.getNombre());
        cmbGS.setSelectedItem(cliente.getGrupoSanguineo());
        fcNac.setDate(cliente.getFechaNacimineto()); 
    }
    
    private boolean verificarCampos(){
        if(txtApellido.getText().equals("") || txtCi.getText().equals("") || txtEdad.getText().equals("") 
                || txtNombre.getText().equals("") )
            return false;
        return true;
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

        panelDatosCliente = new javax.swing.JPanel();
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
        btnCancelar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        panelDatosCliente.setBackground(new java.awt.Color(204, 255, 255));
        panelDatosCliente.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelDatosCliente.setLayout(new java.awt.BorderLayout());

        jLabel50.setText("              ");
        panelDatosCliente.add(jLabel50, java.awt.BorderLayout.LINE_END);

        panelRecoleccionDatos.setOpaque(false);
        panelRecoleccionDatos.setLayout(new java.awt.GridLayout(14, 2));

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

        fcNac.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                fcNacPropertyChange(evt);
            }
        });
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

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        panelDetalle.add(btnCancelar);

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        panelDetalle.add(btnGuardar);

        panelDatosCliente.add(panelDetalle, java.awt.BorderLayout.SOUTH);

        getContentPane().add(panelDatosCliente);

        pack();
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
        int yearSelect=fcNac.getDate().getYear();
        Calendar cal=Calendar.getInstance();
        txtEdad.setText(( cal.getTime().getYear()-yearSelect)+"");
    }//GEN-LAST:event_fcNacPropertyChange

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        
        if(verificarCampos()){

            if(cliente!=null){
                cliente.setApellido(txtApellido.getText());
                cliente.setEdad(Integer.parseInt(txtEdad.getText()));
                cliente.setNombre(txtNombre.getText());
                cliente.setGrupoSanguineo(cmbGS.getSelectedItem().toString());
                Calendar calendr=fcNac.getCalendar();

                cliente.setFechaNacimineto(new Date( (calendr.getTime().getYear()),
                        calendr.getTime().getMonth(),
                        calendr.getTime().getDate()));
                if(new GuardarBD().editarCliente(cliente)>0)
                    JOptionPane.showMessageDialog(null, "Editado");
                else
                    JOptionPane.showMessageDialog(null, "Capos vacios o erroneos");
                this.dispose();
            }else{
                cliente=new Cliente();
                cliente.setApellido(txtApellido.getText());
                cliente.setCi(txtCi.getText());
                cliente.setEdad(Integer.parseInt(txtEdad.getText()));
                cliente.setNombre(txtNombre.getText());
                cliente.setGrupoSanguineo(cmbGS.getSelectedItem().toString());
                Calendar calendr=fcNac.getCalendar();
                
                cliente.setFechaNacimineto(new Date( (calendr.getTime().getYear()),
                    calendr.getTime().getMonth(),
                    calendr.getTime().getDate()));
                GuardarBD guardar=new GuardarBD();
                int res = guardar.guardarCliente(cliente);
                if(res>0)
                    JOptionPane.showMessageDialog(null, "Datos guardados");
                else
                    JOptionPane.showMessageDialog(null, "Error");
                this.dispose();
            }
        }
        else
            JOptionPane.showMessageDialog(null, "Campos vacios");
        
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
            java.util.logging.Logger.getLogger(OperacionCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OperacionCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OperacionCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OperacionCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                OperacionCliente dialog = new OperacionCliente(new javax.swing.JFrame(), true);
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
    private javax.swing.JComboBox<String> cmbGS;
    private com.toedter.calendar.JDateChooser fcNac;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
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
    private javax.swing.JPanel panelCabezaDatosCliente;
    private javax.swing.JPanel panelDatosCliente;
    private javax.swing.JPanel panelDetalle;
    private javax.swing.JPanel panelRecoleccionDatos;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtCi;
    private javax.swing.JTextField txtEdad;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
