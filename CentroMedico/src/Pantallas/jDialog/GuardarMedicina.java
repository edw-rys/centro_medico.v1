package Pantallas.jDialog;

import Clase.Clinica.Medicamento;
import Clase.Clinica.TipoMedicamento;
import Clases.more.Laboratorio;
import Clases.more.StockMedicina;
import Modelo.ConsultaBD.ConsultaBD;
import Modelo.ConsultaBD.GuardarBD;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JOptionPane;

public class GuardarMedicina extends javax.swing.JDialog {

    private ArrayList<Laboratorio> labs=new ArrayList();
    private ArrayList< TipoMedicamento> tipoMed=new ArrayList();
    private ArrayList< StockMedicina> medicinas=new ArrayList();
    
    private StockMedicina medicina;
    public GuardarMedicina(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);//Centrar Jframe 
        cargarTiposAndLabs();
        lblMedicina.setVisible(false);
        cmbMedicinas.setVisible(false);
        cmbEstado.setVisible(false);
        lblEstado.setVisible(false);
    }
    
    private void cargarMedicinaEdicion() {
        txtCodigo.setText(medicina.getMedicina().getIdMedicamneto()+"");
        txtNombre.setText(medicina.getMedicina().getNombe());
        txtCant.setText(medicina.getCantidad()+"");
        txtCosto.setText(medicina.getMedicina().getPrecio()+"");
        cmbTM.setSelectedItem(medicina.getMedicina().getTipo().getDescripcion());
        cmbLab.setSelectedItem(medicina.getMedicina().getLaboratorio().getNombre());
        cmbEstado.setSelectedIndex(medicina.getEstado());
    }
    
    public void cargarEdicion(){
        cmbEstado.setVisible(true);
        lblEstado.setVisible(true);
        txtCodigo.setEditable(false);
        lblMedicina.setVisible(true);
        cmbMedicinas.setVisible(true);
        ConsultaBD c=new ConsultaBD();
        medicinas=c.consultarMedicina("");
        if(medicinas==null)
            return;
        cmbMedicinas.removeAllItems();
        for(StockMedicina m :medicinas){
            cmbMedicinas.addItem(m.getMedicina().getNombe());
        }
        medicina=medicinas.get(0);
    }
    private void cargarTiposAndLabs(){
        cmbLab.removeAllItems();
        cmbTM.removeAllItems();
        ConsultaBD con=new ConsultaBD();
        tipoMed=con.consultaTiposMedicamento();
        labs=con.consultaLaboratorios();
        for(TipoMedicamento t:tipoMed)
            cmbTM.addItem(t.getDescripcion());
        for(Laboratorio l:labs)
            cmbLab.addItem(l.getNombre());
    }
    public boolean verificarDatos(){
        if(txtCodigo.getText().equals("")  || txtCant.getText().equals("") 
                || txtCosto.getText().equals("") || txtNombre.getText().equals(""))
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

        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        lblMedicina = new javax.swing.JLabel();
        cmbMedicinas = new javax.swing.JComboBox<>();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtCosto = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cmbTM = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cmbLab = new javax.swing.JComboBox<>();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtCant = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        lblEstado = new javax.swing.JLabel();
        cmbEstado = new javax.swing.JComboBox<>();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel26 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel5.setBackground(new java.awt.Color(255, 255, 0));
        jPanel5.setLayout(new java.awt.BorderLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Medicina");
        jPanel5.add(jLabel1, java.awt.BorderLayout.CENTER);

        jLabel8.setText("     ");
        jPanel5.add(jLabel8, java.awt.BorderLayout.PAGE_START);

        jLabel9.setText("   ");
        jPanel5.add(jLabel9, java.awt.BorderLayout.PAGE_END);

        jLabel23.setText("                                                    ");
        jPanel5.add(jLabel23, java.awt.BorderLayout.LINE_START);

        jLabel27.setText("                    ");
        jPanel5.add(jLabel27, java.awt.BorderLayout.LINE_END);

        jPanel2.add(jPanel5, java.awt.BorderLayout.PAGE_START);

        jLabel10.setText("                         ");
        jPanel2.add(jLabel10, java.awt.BorderLayout.LINE_END);

        jPanel6.setOpaque(false);
        jPanel6.setLayout(new java.awt.GridLayout(17, 2));

        lblMedicina.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblMedicina.setText("Medicina");
        jPanel6.add(lblMedicina);

        cmbMedicinas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbMedicinas.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbMedicinasItemStateChanged(evt);
            }
        });
        jPanel6.add(cmbMedicinas);

        jLabel29.setText("  ");
        jPanel6.add(jLabel29);

        jLabel30.setText("  ");
        jPanel6.add(jLabel30);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("codigo");
        jPanel6.add(jLabel2);

        txtCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodigoKeyTyped(evt);
            }
        });
        jPanel6.add(txtCodigo);

        jLabel11.setText(" ");
        jPanel6.add(jLabel11);

        jLabel12.setText(" ");
        jPanel6.add(jLabel12);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Nombre");
        jPanel6.add(jLabel3);
        jPanel6.add(txtNombre);

        jLabel15.setText(" ");
        jPanel6.add(jLabel15);

        jLabel13.setText(" ");
        jPanel6.add(jLabel13);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Costo $");
        jPanel6.add(jLabel4);

        txtCosto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCostoKeyTyped(evt);
            }
        });
        jPanel6.add(txtCosto);

        jLabel14.setText(" ");
        jPanel6.add(jLabel14);

        jLabel18.setText(" ");
        jPanel6.add(jLabel18);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Tipo medicina");
        jPanel6.add(jLabel5);

        cmbTM.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel6.add(cmbTM);

        jLabel16.setText(" ");
        jPanel6.add(jLabel16);

        jLabel17.setText(" ");
        jPanel6.add(jLabel17);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Laboratorio");
        jPanel6.add(jLabel6);

        cmbLab.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel6.add(cmbLab);

        jLabel19.setText(" ");
        jPanel6.add(jLabel19);

        jLabel20.setText(" ");
        jPanel6.add(jLabel20);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Cantidad");
        jPanel6.add(jLabel7);

        txtCant.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantKeyTyped(evt);
            }
        });
        jPanel6.add(txtCant);

        jLabel21.setText(" ");
        jPanel6.add(jLabel21);

        jLabel22.setText(" ");
        jPanel6.add(jLabel22);

        lblEstado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblEstado.setText("Estado");
        jPanel6.add(lblEstado);

        cmbEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Inhabilitado", "Habilitado" }));
        cmbEstado.setSelectedIndex(1);
        jPanel6.add(cmbEstado);

        jLabel24.setText("   ");
        jPanel6.add(jLabel24);

        jLabel25.setText("  ");
        jPanel6.add(jLabel25);

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel6.add(btnGuardar);

        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton2);

        jPanel2.add(jPanel6, java.awt.BorderLayout.CENTER);

        jLabel26.setText("                 ");
        jPanel2.add(jLabel26, java.awt.BorderLayout.LINE_START);

        getContentPane().add(jPanel2);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        int res=0;
        String fase="";
        if(!verificarDatos()){
            JOptionPane.showMessageDialog(null, "Faltan datos");
            return;
        }
        
        if(this.medicina!=null){
            fase="Editado";
            medicina.getMedicina().setPrecio(Double.parseDouble(txtCosto.getText()));
            medicina.getMedicina().setTipo(tipoMed.get(cmbTM.getSelectedIndex()));
            medicina.getMedicina().setLaboratorio(labs.get(cmbLab.getSelectedIndex()));
            medicina.setCantidad(Integer.parseInt(txtCant.getText()));
            medicina.setEstado(cmbEstado.getSelectedIndex());
            GuardarBD g=new  GuardarBD();
            int dia=Calendar.getInstance().getTime().getDate();
            int mes=Calendar.getInstance().getTime().getMonth();
            int year=Calendar.getInstance().getTime().getYear();
            medicina.setFecha(new Date(year, mes, dia));
            res=g.editarMedicina(medicina.getMedicina(), medicina.getCantidad(), medicina.getFecha(), 
                    medicina.getEstado()+"");
        }else{fase="Guardado";
            Medicamento m=new Medicamento(Integer.parseInt(txtCodigo.getText()), txtNombre.getText());
            m.setPrecio(Double.parseDouble(txtCosto.getText()));
            m.setTipo(tipoMed.get(cmbTM.getSelectedIndex()));
            m.setLaboratorio(labs.get(cmbLab.getSelectedIndex()));
            GuardarBD g=new  GuardarBD();
            int dia=Calendar.getInstance().getTime().getDate();
            int mes=Calendar.getInstance().getTime().getMonth();
            int year=Calendar.getInstance().getTime().getYear();
            res=g.guardarMedicina(m, Integer.parseInt(txtCant.getText()), new Date(year, mes, dia));
        }
        if(res>0)
            JOptionPane.showMessageDialog(null, fase+" Correctamente");
        else
            JOptionPane.showMessageDialog(null, "Error!");
        this.dispose();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void txtCostoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCostoKeyTyped
        txtCosto.setBackground(Color.white);
        char caracter= evt.getKeyChar();  
        if (((caracter < '0') || (caracter > '9')) 
            && (caracter != java.awt.event.KeyEvent.VK_BACK_SPACE)
            && (caracter != '.' || txtCosto.getText().contains(".")) ) {
                evt.consume();
        }
    }//GEN-LAST:event_txtCostoKeyTyped

    private void txtCodigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoKeyTyped
        char x=evt.getKeyChar();
        if(x<'0' || x>'9' ){
           evt.consume(); // consumir el evento para que no se realice
        }
    }//GEN-LAST:event_txtCodigoKeyTyped

    private void txtCantKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantKeyTyped
        char x=evt.getKeyChar();
        if(x<'0' || x>'9' ){
           evt.consume(); // consumir el evento para que no se realice
        }
    }//GEN-LAST:event_txtCantKeyTyped

    private void cmbMedicinasItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbMedicinasItemStateChanged
        try{
            medicina=medicinas.get(cmbMedicinas.getSelectedIndex());
            cargarMedicinaEdicion();
        }catch(NullPointerException es){}
        catch(java.lang.IndexOutOfBoundsException e){}
    }//GEN-LAST:event_cmbMedicinasItemStateChanged

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
            java.util.logging.Logger.getLogger(GuardarMedicina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GuardarMedicina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GuardarMedicina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GuardarMedicina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                GuardarMedicina dialog = new GuardarMedicina(new javax.swing.JFrame(), true);
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
    private javax.swing.JComboBox<String> cmbEstado;
    private javax.swing.JComboBox<String> cmbLab;
    private javax.swing.JComboBox<String> cmbMedicinas;
    private javax.swing.JComboBox<String> cmbTM;
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
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblMedicina;
    private javax.swing.JTextField txtCant;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtCosto;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables

    
}
