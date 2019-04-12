package Pantallas.jDialog;

import Clase.Clinica.MuestraPaciente;
import Clases.Entidades.Cliente;
import Clases.Entidades.Clinica;
import Modelo.ConsultaBD.GuardarBD;
import javax.swing.JOptionPane;

public class TomaMuestras extends javax.swing.JDialog {

    public TomaMuestras(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);//Centrar Jframe 
        txtNombre.setEditable(false);
        txtCi.setEditable(false);
        txtEdad.setEditable(false);
        cargarEsepecialidades();
    }
    
    private void cargarEsepecialidades(){
        cmbEspecialidad.removeAllItems();
        for(int i=0;i<Clinica.getListaAtenciones().size();i++)
            cmbEspecialidad.addItem(Clinica.getEspecialidad(i).getNombre());
    }
    private void cargarCampos(int i){
        if(i<0)return;
        Cliente c=Clinica.getCliente(i);
        if(c==null){
            txtCi.setText("");
            txtNombre.setText("");
            txtEdad.setText("");
            return;
        }
        txtCi.setText(c.getCi());
        txtNombre.setText(c.getNombre());
        txtEdad.setText(c.getEdad()+"");
    }
    
    private boolean verificarCampos(){
        if(txtPeso.getText().equals("") || txtPresion.getText().equals("") || txtSize.getText().equals("")
                || txtCi.getText().equals("") || txtNombre.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Campos vacios!");
            return false;
        }
        return true;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtCi = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txtEdad = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtPresion = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtPeso = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtSize = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        panelTipoMuestras = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cmbEspecialidad = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        btnGuardar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel2.setOpaque(false);
        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel3.setOpaque(false);
        jPanel3.setLayout(new java.awt.GridLayout(12, 0));

        jLabel18.setText("   ");
        jPanel3.add(jLabel18);

        jLabel17.setText("   ");
        jPanel3.add(jLabel17);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Nombre: ");
        jPanel3.add(jLabel4);

        txtNombre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel3.add(txtNombre);

        jLabel9.setText("   ");
        jPanel3.add(jLabel9);

        jLabel10.setText("   ");
        jPanel3.add(jLabel10);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Cédula: ");
        jPanel3.add(jLabel5);

        txtCi.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel3.add(txtCi);

        jLabel14.setText("   ");
        jPanel3.add(jLabel14);

        jLabel13.setText("   ");
        jPanel3.add(jLabel13);

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel19.setText("Edad: ");
        jPanel3.add(jLabel19);

        txtEdad.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel3.add(txtEdad);

        jLabel21.setText("   ");
        jPanel3.add(jLabel21);

        jLabel20.setText("   ");
        jPanel3.add(jLabel20);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Presión: ");
        jPanel3.add(jLabel6);

        txtPresion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtPresion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPresionKeyTyped(evt);
            }
        });
        jPanel3.add(txtPresion);

        jLabel11.setText("   ");
        jPanel3.add(jLabel11);

        jLabel12.setText("   ");
        jPanel3.add(jLabel12);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("Peso: ");
        jPanel3.add(jLabel7);

        txtPeso.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtPeso.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPesoKeyTyped(evt);
            }
        });
        jPanel3.add(txtPeso);

        jLabel15.setText("   ");
        jPanel3.add(jLabel15);

        jLabel16.setText("   ");
        jPanel3.add(jLabel16);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("Tamaño: ");
        jPanel3.add(jLabel8);

        txtSize.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtSize.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSizeKeyTyped(evt);
            }
        });
        jPanel3.add(txtSize);

        jPanel2.add(jPanel3, java.awt.BorderLayout.CENTER);

        jLabel2.setText("             ");
        jPanel2.add(jLabel2, java.awt.BorderLayout.EAST);

        jLabel3.setText("                  ");
        jPanel2.add(jLabel3, java.awt.BorderLayout.WEST);

        jPanel1.add(jPanel2, java.awt.BorderLayout.CENTER);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Especialidad");

        cmbEspecialidad.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmbEspecialidad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbEspecialidad.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbEspecialidadItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout panelTipoMuestrasLayout = new javax.swing.GroupLayout(panelTipoMuestras);
        panelTipoMuestras.setLayout(panelTipoMuestrasLayout);
        panelTipoMuestrasLayout.setHorizontalGroup(
            panelTipoMuestrasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTipoMuestrasLayout.createSequentialGroup()
                .addGap(140, 140, 140)
                .addComponent(jLabel1)
                .addGap(87, 87, 87)
                .addComponent(cmbEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(157, Short.MAX_VALUE))
        );
        panelTipoMuestrasLayout.setVerticalGroup(
            panelTipoMuestrasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTipoMuestrasLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(panelTipoMuestrasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cmbEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(46, Short.MAX_VALUE))
        );

        jPanel1.add(panelTipoMuestras, java.awt.BorderLayout.PAGE_START);

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel4.add(btnGuardar);

        jPanel1.add(jPanel4, java.awt.BorderLayout.PAGE_END);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbEspecialidadItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbEspecialidadItemStateChanged
        try{
            cargarCampos(cmbEspecialidad.getSelectedIndex());
        }catch(NullPointerException es){}
    }//GEN-LAST:event_cmbEspecialidadItemStateChanged

    private void txtPresionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPresionKeyTyped
        char x=evt.getKeyChar();
        if(x<'0' || x>'9' ){
           evt.consume(); // consumir el evento para que no se realice
        }
    }//GEN-LAST:event_txtPresionKeyTyped

    private void txtPesoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesoKeyTyped
        char caracter= evt.getKeyChar();  
        if (((caracter < '0') || (caracter > '9')) 
            && (caracter != java.awt.event.KeyEvent.VK_BACK_SPACE)
            && (caracter != '.' || txtPeso.getText().contains(".")) ) {
                evt.consume();
        }
    }//GEN-LAST:event_txtPesoKeyTyped

    private void txtSizeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSizeKeyTyped
        char caracter= evt.getKeyChar();  
        if (((caracter < '0') || (caracter > '9')) 
            && (caracter != java.awt.event.KeyEvent.VK_BACK_SPACE)
            && (caracter != '.' || txtSize.getText().contains(".")) ) {
                evt.consume();
        }
    }//GEN-LAST:event_txtSizeKeyTyped

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if(!verificarCampos())
            return;
        MuestraPaciente muestra= new MuestraPaciente(
                Double.parseDouble(txtPeso.getText()), 
                Double.parseDouble(txtSize.getText()),
                Integer.parseInt(txtPresion.getText()));
        Clinica.getCliente(cmbEspecialidad.getSelectedIndex()).getMuestras().add(muestra);
        int res=new GuardarBD().guardarMuestras(txtCi.getText(), muestra);
        if(res>0){
            Clinica.removeClienteEspecialidad(cmbEspecialidad.getSelectedIndex());
            JOptionPane.showMessageDialog(null, "Datos registrados correctamente");
        }else JOptionPane.showMessageDialog(null, "No se pudo registrar datos");
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
            java.util.logging.Logger.getLogger(TomaMuestras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TomaMuestras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TomaMuestras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TomaMuestras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TomaMuestras dialog = new TomaMuestras(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<String> cmbEspecialidad;
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel panelTipoMuestras;
    private javax.swing.JTextField txtCi;
    private javax.swing.JTextField txtEdad;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPeso;
    private javax.swing.JTextField txtPresion;
    private javax.swing.JTextField txtSize;
    // End of variables declaration//GEN-END:variables
}
