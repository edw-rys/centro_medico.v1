package Pantallas.jDialog;

import Clase.Clinica.MuestraPaciente;
import Clases.Entidades.Cliente;
import Clases.Entidades.Doctor;
import Clases.Entidades.HistorialMedico;

public class HistorialPaciente extends javax.swing.JDialog {
    private Cliente cliente;
    private HistorialMedico historial;
    int pos=0;
    public HistorialPaciente(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);//Centrar Jframe 
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
        cargarDatos();
    }
    
    private void cargarDatos(){
        historial=cliente.getHistorialMedico().get(pos);
        lblEspecialidad.setText(historial.getDoctor().getEspecialidad().getNombre());
        //doctor;
        Doctor doctor=historial.getDoctor();
        txtCiDoctor.setText(doctor.getNombre());
        txtNombreDoctor.setText(doctor.getNombre());
        txtApellidoDoctor.setText(doctor.getApellido());
        
        //muestra
        MuestraPaciente muestra=historial.getMuestra();
        txtPeso.setText(muestra.getPeso()+"");
        txtPresion.setText(muestra.getPresion()+"");
        txtSize.setText(muestra.getEstatura()+"");
        //Sintomas
        taSintomas.setText(historial.getSintomas());
        
        try{txtFecha.setText(historial.getFehca().toString());}catch(NullPointerException es){}
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        lblDoc = new javax.swing.JLabel();
        lblEspecialidad = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        txtCiDoctor = new javax.swing.JTextField();
        jLabel44 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        txtNombreDoctor = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        txtApellidoDoctor = new javax.swing.JTextField();
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
        jPanel6 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        taSintomas = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        next = new javax.swing.JButton();
        previews = new javax.swing.JButton();
        jLabel28 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new java.awt.GridLayout(3, 0));

        lblDoc.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblDoc.setText("Doctor");
        jPanel5.add(lblDoc);

        lblEspecialidad.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblEspecialidad.setText("Especialidad");
        jPanel5.add(lblEspecialidad);

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel13.setLayout(new javax.swing.BoxLayout(jPanel13, javax.swing.BoxLayout.LINE_AXIS));

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel25.setText("Cédula: ");
        jPanel13.add(jLabel25);

        txtCiDoctor.setEditable(false);
        txtCiDoctor.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel13.add(txtCiDoctor);

        jLabel44.setText("        ");
        jPanel13.add(jLabel44);

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel26.setText("Nombres: ");
        jPanel13.add(jLabel26);

        txtNombreDoctor.setEditable(false);
        txtNombreDoctor.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel13.add(txtNombreDoctor);

        jLabel45.setText("       ");
        jPanel13.add(jLabel45);

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel27.setText("Apellidos: ");
        jPanel13.add(jLabel27);

        txtApellidoDoctor.setEditable(false);
        txtApellidoDoctor.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel13.add(txtApellidoDoctor);

        jPanel5.add(jPanel13);

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

        jPanel6.setLayout(new javax.swing.BoxLayout(jPanel6, javax.swing.BoxLayout.Y_AXIS));

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel15.setText("Sintomas");
        jPanel6.add(jLabel15);

        taSintomas.setColumns(20);
        taSintomas.setRows(5);
        jScrollPane1.setViewportView(taSintomas);

        jPanel6.add(jScrollPane1);

        jButton2.setText("CERRAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        next.setText(">");
        next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextActionPerformed(evt);
            }
        });

        previews.setText("<");
        previews.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previewsActionPerformed(evt);
            }
        });

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel28.setText("Fecha: ");

        txtFecha.setEditable(false);
        txtFecha.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(jLabel28)
                .addGap(31, 31, 31)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(previews)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(next))
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 139, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(next)
                    .addComponent(previews)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 737, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(104, 104, 104)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void previewsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previewsActionPerformed
        if(pos<=0)
            return;
        pos--;
        cargarDatos();
    }//GEN-LAST:event_previewsActionPerformed

    private void nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextActionPerformed
        if(pos>=cliente.getHistorialMedico().size()-1)
            return;
        pos++;
        cargarDatos();
    }//GEN-LAST:event_nextActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    
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
            java.util.logging.Logger.getLogger(HistorialPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HistorialPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HistorialPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HistorialPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                HistorialPaciente dialog = new HistorialPaciente(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDoc;
    private javax.swing.JLabel lblEspecialidad;
    private javax.swing.JButton next;
    private javax.swing.JButton previews;
    private javax.swing.JTextArea taSintomas;
    private javax.swing.JTextField txtApellidoDoctor;
    private javax.swing.JTextField txtCiDoctor;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtNombreDoctor;
    private javax.swing.JTextField txtPeso;
    private javax.swing.JTextField txtPresion;
    private javax.swing.JTextField txtSize;
    // End of variables declaration//GEN-END:variables
}
