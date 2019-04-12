package Pantallas.jDialog;

import Clases.Entidades.Receta;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;


public class RecetasPanel extends javax.swing.JDialog {

    private ArrayList<Receta> recetas=new ArrayList();
    private int pos=0;
    public RecetasPanel(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);//Centrar Jframe        
    }

    public void setRecetas(ArrayList<Receta> recetas) {
        this.recetas = recetas;
        mostrarReceta(0);
    }
    public void mostrarReceta(int i){
        tituloReceta.setText("Receta n°:  "+(i+1));
        agregarDatos(recetas.get(i));
    }
    
    private void agregarDatos(Receta receta){
        DefaultTableModel modelo =new DefaultTableModel(){
            public boolean isCellEditable(int filas, int col){
                if(col==-1){return true;}else return false; 
            }
        };
        
        String[] columnas = {"CODIGO", "NOMBRE","Cantidad","Veces por dia","Fecha Ini","Fecha Fin"};
        modelo.setColumnIdentifiers(columnas);
        Object [] actual=new Object[7];
        if(receta.getMedicina()!= null){
            for (int i=0; i< receta.getMedicina().size();i++){
                actual[0]= receta.getMedicina().get(i).getIdMedicamneto();
                actual[1]= receta.getMedicina().get(i).getNombe();
                actual[2]= receta.getCantidad().get(i);
                actual[3]= receta.getVecesPorDia().get(i);
                actual[4]= receta.getFechaIni().get(i);
                actual[5]= receta.getFechaFin().get(i);
                modelo.addRow(actual);
            }
               
        }
        medicinas.setModel(modelo);
        
    }
    
    private void activarDesactivarBotones(){
        btnIzq.setEnabled(true);
        btnDer.setEnabled(true);
        if(pos<=0){
            pos=0;
            btnIzq.setEnabled(false);
        }
        if(pos >= recetas.size()-1){
            pos=recetas.size()-1;
            btnDer.setEnabled(false);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        medicinas = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        tituloReceta = new javax.swing.JLabel();
        btnDer = new javax.swing.JButton();
        btnIzq = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setText("Cerrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, java.awt.BorderLayout.PAGE_END);

        jPanel2.setBackground(new java.awt.Color(204, 255, 204));
        jPanel2.setOpaque(false);
        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.LINE_AXIS));

        jScrollPane1.setOpaque(false);

        medicinas.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(medicinas);

        jPanel2.add(jScrollPane1);

        jPanel1.add(jPanel2, java.awt.BorderLayout.CENTER);

        jPanel3.setBackground(new java.awt.Color(204, 255, 204));

        tituloReceta.setFont(new java.awt.Font("Tahoma", 2, 24)); // NOI18N
        tituloReceta.setText("Receta n°:  ");

        btnDer.setText(">");
        btnDer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDerMouseClicked(evt);
            }
        });

        btnIzq.setText("<");
        btnIzq.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnIzqMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(btnIzq)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addComponent(tituloReceta, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62)
                .addComponent(btnDer))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tituloReceta, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
            .addComponent(btnDer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnIzq, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel3, java.awt.BorderLayout.PAGE_START);

        getContentPane().add(jPanel1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDerMouseClicked
        activarDesactivarBotones();
        if(pos <recetas.size()-1){
            pos++;
            mostrarReceta(pos);
        }
    }//GEN-LAST:event_btnDerMouseClicked

    private void btnIzqMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnIzqMouseClicked
        activarDesactivarBotones();
        if(pos >0){
            pos--;
            mostrarReceta(pos);
        }

    }//GEN-LAST:event_btnIzqMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(RecetasPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RecetasPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RecetasPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RecetasPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        try {
            //</editor-fold>
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RecetasPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(RecetasPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(RecetasPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(RecetasPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                RecetasPanel dialog = new RecetasPanel(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnDer;
    private javax.swing.JButton btnIzq;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable medicinas;
    private javax.swing.JLabel tituloReceta;
    // End of variables declaration//GEN-END:variables
}
