package Pantallas;

import Clases.Entidades.Clinica;
import Pantallas.jDialog.GuardarDoctor;
import Pantallas.jDialog.Inactivar;
import Pantallas.jDialog.GuardarMedicina;
import Pantallas.jDialog.GenerarTurno;
import Pantallas.jDialog.PanelEspecialidad;
import Pantallas.Paneles.*;
import Pantallas.jDialog.OperacionCliente;
import Pantallas.jDialog.EdicionUser;
import Pantallas.jDialog.PanelUsuarios;
import Pantallas.jDialog.PantallaProcedimiento;
import Pantallas.jDialog.SeleccionEspecialidadAtencion;
import Pantallas.jDialog.TomaMuestras;
import java.awt.BorderLayout;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


public class PantallaTrabajo extends javax.swing.JFrame {
    
    private static PantallaTrabajo principal=new PantallaTrabajo();
    public static PantallaTrabajo getInstance(){
        return principal;
    }
    
    private PantallaTrabajo() {
        initComponents();
        this.setLocationRelativeTo(null);//Centrar Jframe 
        Clinica.cargarDatosDoctores();
        Clinica.cargarDatos();
    }
    
    
    public void verificarUser(int tipo){
        if(tipo==1)
            opOperacional.setEnabled(false);
        else if(tipo==2)
            opMantenimiento.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        panelCentral = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        menu = new javax.swing.JMenuBar();
        opMantenimiento = new javax.swing.JMenu();
        client = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        inactivarCliente = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        nuevoEspecialidad = new javax.swing.JMenuItem();
        editEspecialidad = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        savDoctor = new javax.swing.JMenuItem();
        editeDoctor = new javax.swing.JMenuItem();
        inactivarDoctor = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        nuevoUser = new javax.swing.JMenuItem();
        editUser = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu8 = new javax.swing.JMenu();
        itemNuevo = new javax.swing.JMenuItem();
        itemEditar = new javax.swing.JMenuItem();
        opOperacional = new javax.swing.JMenu();
        opAsignaTurno = new javax.swing.JMenuItem();
        opFacturacion = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        consultaDoctor = new javax.swing.JMenuItem();
        jMenuItem16 = new javax.swing.JMenuItem();
        consultaPaciente = new javax.swing.JMenuItem();
        consultaMedicinas = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/login/logo.png"))); // NOI18N

        javax.swing.GroupLayout panelCentralLayout = new javax.swing.GroupLayout(panelCentral);
        panelCentral.setLayout(panelCentralLayout);
        panelCentralLayout.setHorizontalGroup(
            panelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCentralLayout.createSequentialGroup()
                .addGap(275, 275, 275)
                .addComponent(jLabel1)
                .addContainerGap(355, Short.MAX_VALUE))
        );
        panelCentralLayout.setVerticalGroup(
            panelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCentralLayout.createSequentialGroup()
                .addGap(185, 185, 185)
                .addComponent(jLabel1)
                .addContainerGap(208, Short.MAX_VALUE))
        );

        getContentPane().add(panelCentral, java.awt.BorderLayout.CENTER);

        opMantenimiento.setText("Mantenimiento");

        client.setText("Cliente");

        jMenuItem2.setText("Nuevo/Editar");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        client.add(jMenuItem2);

        inactivarCliente.setText("Inactivar");
        inactivarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inactivarClienteActionPerformed(evt);
            }
        });
        client.add(inactivarCliente);

        opMantenimiento.add(client);

        jMenu5.setText("Especialidad");

        nuevoEspecialidad.setText("Nuevo");
        nuevoEspecialidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoEspecialidadActionPerformed(evt);
            }
        });
        jMenu5.add(nuevoEspecialidad);

        editEspecialidad.setText("Editar");
        editEspecialidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editEspecialidadActionPerformed(evt);
            }
        });
        jMenu5.add(editEspecialidad);

        opMantenimiento.add(jMenu5);

        jMenu6.setText("Doctores ");

        savDoctor.setText("Nuevo");
        savDoctor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savDoctorActionPerformed(evt);
            }
        });
        jMenu6.add(savDoctor);

        editeDoctor.setText("Editar");
        editeDoctor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editeDoctorActionPerformed(evt);
            }
        });
        jMenu6.add(editeDoctor);

        inactivarDoctor.setText("Inactivar");
        inactivarDoctor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inactivarDoctorActionPerformed(evt);
            }
        });
        jMenu6.add(inactivarDoctor);

        opMantenimiento.add(jMenu6);

        jMenu7.setText("Usuarios");

        nuevoUser.setText("Nuevo");
        nuevoUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoUserActionPerformed(evt);
            }
        });
        jMenu7.add(nuevoUser);

        editUser.setText("Editar");
        editUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editUserActionPerformed(evt);
            }
        });
        jMenu7.add(editUser);

        jMenuItem7.setText("Inactivar");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem7);

        opMantenimiento.add(jMenu7);

        jMenuItem6.setText("Procedimientos");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        opMantenimiento.add(jMenuItem6);

        jMenu8.setText("Medicina");

        itemNuevo.setText("Nuevo");
        itemNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemNuevoActionPerformed(evt);
            }
        });
        jMenu8.add(itemNuevo);

        itemEditar.setText("Editar");
        itemEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemEditarActionPerformed(evt);
            }
        });
        jMenu8.add(itemEditar);

        opMantenimiento.add(jMenu8);

        menu.add(opMantenimiento);

        opOperacional.setText("Operacional");

        opAsignaTurno.setText("Asignar Turno");
        opAsignaTurno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opAsignaTurnoActionPerformed(evt);
            }
        });
        opOperacional.add(opAsignaTurno);

        opFacturacion.setText(" Facturacion");
        opFacturacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opFacturacionActionPerformed(evt);
            }
        });
        opOperacional.add(opFacturacion);

        jMenuItem10.setText("Toma de muetsras");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        opOperacional.add(jMenuItem10);

        jMenuItem11.setText("Atencion al paciente");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        opOperacional.add(jMenuItem11);

        menu.add(opOperacional);

        jMenu1.setText(" Consultas");

        consultaDoctor.setText("Lista Doctores");
        consultaDoctor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultaDoctorActionPerformed(evt);
            }
        });
        jMenu1.add(consultaDoctor);

        jMenuItem16.setText("Clientes");
        jMenuItem16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem16ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem16);

        consultaPaciente.setText("Pacientes");
        consultaPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultaPacienteActionPerformed(evt);
            }
        });
        jMenu1.add(consultaPaciente);

        consultaMedicinas.setText("Inventario Medicinas");
        consultaMedicinas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultaMedicinasActionPerformed(evt);
            }
        });
        jMenu1.add(consultaMedicinas);

        jMenuItem3.setText("Pacientes Atendidos");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        menu.add(jMenu1);

        jMenu3.setText("Salir");
        jMenu3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenu3MousePressed(evt);
            }
        });
        menu.add(jMenu3);

        setJMenuBar(menu);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void consultaPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultaPacienteActionPerformed
        Consultas consultarP=new Consultas();
        consultarP.consultarDatos("", 3);
        consultarP.setSize(  panelCentral.getWidth(),panelCentral.getHeight()  );
        consultarP.setLocation(0, 0);
        panelCentral.removeAll();
        panelCentral.setLayout(new BorderLayout());
        panelCentral.add(consultarP, BorderLayout.CENTER);
        panelCentral.revalidate();
        panelCentral.repaint();
    }//GEN-LAST:event_consultaPacienteActionPerformed

    private void consultaMedicinasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultaMedicinasActionPerformed
        Consultas consultarP=new Consultas();
        consultarP.consultarDatos("", 4);
        panelCentral.removeAll();
        panelCentral.setLayout(new BorderLayout());
        panelCentral.add(consultarP, BorderLayout.CENTER);
        panelCentral.revalidate();
        panelCentral.repaint();
        
    }//GEN-LAST:event_consultaMedicinasActionPerformed

    private void consultaDoctorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultaDoctorActionPerformed
        Consultas consultarP=new Consultas();
        consultarP.consultarDatos("", 1);
        
        panelCentral.removeAll();
        panelCentral.setLayout(new BorderLayout());
        panelCentral.add(consultarP, BorderLayout.CENTER);
        panelCentral.revalidate();
        panelCentral.repaint();
    }//GEN-LAST:event_consultaDoctorActionPerformed

    private void opAsignaTurnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opAsignaTurnoActionPerformed
        GenerarTurno turno=new GenerarTurno(this,true);
        turno.cargarDatos();
        turno.setVisible(true);
    }//GEN-LAST:event_opAsignaTurnoActionPerformed

    private void jMenuItem16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem16ActionPerformed
        Consultas consultarP=new Consultas();
        consultarP.consultarDatos("", 2);
        consultarP.setSize(  panelCentral.getWidth(),panelCentral.getHeight()  );
        consultarP.setLocation(0, 0);
        panelCentral.removeAll();
        panelCentral.setLayout(new BorderLayout());
        panelCentral.add(consultarP, BorderLayout.CENTER);
        panelCentral.revalidate();
        panelCentral.repaint();
    }//GEN-LAST:event_jMenuItem16ActionPerformed

    private void editEspecialidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editEspecialidadActionPerformed
        PanelEspecialidad panel=new PanelEspecialidad(this, true);
        panel.cargarD();
        panel.setVisible(true);
    }//GEN-LAST:event_editEspecialidadActionPerformed

    private void nuevoEspecialidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoEspecialidadActionPerformed
        PanelEspecialidad panel=new PanelEspecialidad(this, true);
        panel.setVisible(true);
    }//GEN-LAST:event_nuevoEspecialidadActionPerformed

    private void editeDoctorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editeDoctorActionPerformed
        GuardarDoctor panel=new GuardarDoctor(this, true);
        panel.cargarCiDoctores();
        panel.setVisible(true);
    }//GEN-LAST:event_editeDoctorActionPerformed

    private void savDoctorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savDoctorActionPerformed
        GuardarDoctor panel=new GuardarDoctor(this, true);
        panel.setVisible(true);
    }//GEN-LAST:event_savDoctorActionPerformed

    private void itemNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemNuevoActionPerformed
        GuardarMedicina g=new GuardarMedicina(this,true);
        g.setVisible(true);
    }//GEN-LAST:event_itemNuevoActionPerformed

    private void itemEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemEditarActionPerformed
        GuardarMedicina g=new GuardarMedicina(this,true);
        g.cargarEdicion();
        g.setVisible(true);
    }//GEN-LAST:event_itemEditarActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        Clinica.cargarDatos();
        Clinica.cargarDatosDoctores();
        TomaMuestras toma=new TomaMuestras(this, true);
        toma.setVisible(true);
        
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        Clinica.cargarDatosDoctores();
        SeleccionEspecialidadAtencion atender=new SeleccionEspecialidadAtencion(this, false);
        atender.setVisible(true);
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void inactivarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inactivarClienteActionPerformed
       Inactivar inh=new Inactivar(this,true);
       inh.cargar(1);
       inh.setVisible(true);
    }//GEN-LAST:event_inactivarClienteActionPerformed

    private void inactivarDoctorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inactivarDoctorActionPerformed
        Inactivar inh=new Inactivar(this,true);
       inh.cargar(2);
       inh.setVisible(true);
    }//GEN-LAST:event_inactivarDoctorActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        Inactivar inh=new Inactivar(this,true);
       inh.cargar(3);
       inh.setVisible(true);
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        OperacionCliente es=new OperacionCliente(this, true);
        es.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void nuevoUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoUserActionPerformed
        PanelUsuarios panel= new PanelUsuarios(this, true);
        panel.setVisible(true);
    }//GEN-LAST:event_nuevoUserActionPerformed

    private void editUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editUserActionPerformed
        EdicionUser panel= new EdicionUser(this, true);
        panel.setVisible(true);
    }//GEN-LAST:event_editUserActionPerformed

    private void opFacturacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opFacturacionActionPerformed
        if(GenerarTurno.getTurnos().isEmpty()){
            JOptionPane.showMessageDialog(null, "No hay turnos por atender");
            return;
        }
        
        GuardarCliente cliente=new GuardarCliente();       
        cliente.setSize(  panelCentral.getWidth(),panelCentral.getHeight()  );
        cliente.setLocation(0, 0);
        panelCentral.removeAll();
        panelCentral.setLayout(new BorderLayout());
        panelCentral.add(cliente, BorderLayout.CENTER);
        panelCentral.revalidate();
        panelCentral.repaint();
    }//GEN-LAST:event_opFacturacionActionPerformed

    private void jMenu3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu3MousePressed
        this.dispose();
        LogIn log=LogIn.getInstacia();
        log.setVisible(true);
    }//GEN-LAST:event_jMenu3MousePressed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        PantallaProcedimiento p=new PantallaProcedimiento(this, true);
        p.setVisible(true);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        Consultas consultarP=new Consultas();
        consultarP.consultarDatos("", 5);
        panelCentral.removeAll();
        panelCentral.setLayout(new BorderLayout());
        panelCentral.add(consultarP, BorderLayout.CENTER);
        panelCentral.revalidate();
        panelCentral.repaint();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

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
            java.util.logging.Logger.getLogger(PantallaTrabajo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PantallaTrabajo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PantallaTrabajo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PantallaTrabajo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        try {
            //</editor-fold>
            //</editor-fold>
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PantallaTrabajo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(PantallaTrabajo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(PantallaTrabajo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(PantallaTrabajo.class.getName()).log(Level.SEVERE, null, ex);
        }
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PantallaTrabajo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu client;
    private javax.swing.JMenuItem consultaDoctor;
    private javax.swing.JMenuItem consultaMedicinas;
    private javax.swing.JMenuItem consultaPaciente;
    private javax.swing.JMenuItem editEspecialidad;
    private javax.swing.JMenuItem editUser;
    private javax.swing.JMenuItem editeDoctor;
    private javax.swing.JMenuItem inactivarCliente;
    private javax.swing.JMenuItem inactivarDoctor;
    private javax.swing.JMenuItem itemEditar;
    private javax.swing.JMenuItem itemNuevo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem16;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuBar menu;
    private javax.swing.JMenuItem nuevoEspecialidad;
    private javax.swing.JMenuItem nuevoUser;
    private javax.swing.JMenuItem opAsignaTurno;
    private javax.swing.JMenuItem opFacturacion;
    private javax.swing.JMenu opMantenimiento;
    private javax.swing.JMenu opOperacional;
    public javax.swing.JPanel panelCentral;
    private javax.swing.JMenuItem savDoctor;
    // End of variables declaration//GEN-END:variables
}
