package Pantallas.Paneles;

import Pantallas.jDialog.RecetasPanel;
import Clases.Entidades.Cliente;
import Clases.Entidades.Clinica;
import Clases.Entidades.Doctor;
import Clases.more.StockMedicina;
import Modelo.ConsultaBD.ConsultaBD;
import Pantallas.PantallaTrabajo;
import Pantallas.jDialog.HistorialPaciente;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Consultas extends javax.swing.JPanel {
    private int tipo ;
    ArrayList<Cliente> paciente;
    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
    
    public Consultas() {
        initComponents();
    }
    public void consultarDatos(String critero, int tipoConsulta){
        setTipo(tipoConsulta);
        ConsultaBD consultar =new ConsultaBD();
        DefaultTableModel modelo =new DefaultTableModel(){
            public boolean isCellEditable(int filas, int col){
                if(col==-1){return true;}else return false; 
            }
        };
        if(tipoConsulta!=3) {
            vistaReceta.setVisible(false);
            btnHistorial.setVisible(false);
        }
        switch(tipoConsulta){
            case 1:
                consultarDoctor(consultar, modelo, critero);
                break;
            case 2:
                consultarCliente(consultar, modelo, critero);
                break;
            case 3:consultarPaciente(consultar,modelo,critero);
                break;
            case 4:consultarMedicia(consultar, modelo, critero);
            break;
            case 5:pantallaPacientesAtendidos(modelo);
                break;
        }
    }
    
    private void consultarPaciente(ConsultaBD consultar  , DefaultTableModel modelo ,String critero){
        paciente = consultar.ConsultarPacientes(critero);
        
        String[] columnas = {"CEDULA", "NOMBRE","APELLIDOS","EDAD","GRUPO SANGUINEO","FECHA NAC"};
        modelo.setColumnIdentifiers(columnas);
        Object [] actual=new Object[6];
        if(paciente!= null){
            for (Cliente m:paciente){
                actual[0]= m.getCi();
                actual[1]= m.getNombre();
                actual[2]= m.getApellido();
                actual[3]= m.getEdad();
                actual[4]= m.getGrupoSanguineo();
                actual[5]= m.getFechaNacimineto();
                modelo.addRow(actual);
            }
               
        }
        tableQuery.setModel(modelo);
    }

    private void consultarMedicia(ConsultaBD consultar  , DefaultTableModel modelo ,String critero){
        ArrayList<StockMedicina> medicina = consultar.consultarMedicina(critero);
        
        String[] columnas = {"CODIGO", "NOMBRE","PRECIO","TIPO","LABORATORIO","STOCK","FECHA"};
        modelo.setColumnIdentifiers(columnas);
        Object [] actual=new Object[7];
        if(medicina!= null){
            for (StockMedicina m:medicina){
                actual[0]= m.getMedicina().getIdMedicamneto();
                actual[1]= m.getMedicina().getNombe();
                actual[2]= m.getMedicina().getPrecio();
                actual[3]= m.getMedicina().getTipo().getDescripcion();
                actual[4]= m.getMedicina().getLaboratorio().getNombre();
                actual[5]= m.getCantidad();
                actual[6]= m.getFecha().getDate()+"/"+(m.getFecha().getMonth()+1)+"/"+(m.getFecha().getYear()+1900);
                modelo.addRow(actual);
            }
        }
        tableQuery.setModel(modelo);
    }
    private void pantallaPacientesAtendidos(DefaultTableModel modelo ){
        String[] columnas = {"CEDULA", "NOMBRE","APELLIDOS","EDAD","GRUPO SANGUINEO","FECHA NAC","Especialidad","Atendido"};
        modelo.setColumnIdentifiers(columnas);
        Object [] actual=new Object[8];
        if(Clinica.getEspecialidadSinAtender()!=null){
        for(int i=0;i<Clinica.getEspecialidadSinAtender().size();i++){
            ArrayList<Cliente> atendidos=Clinica.getListaPacientesNoAtendidos(i);
            if(atendidos!=null){
                for(int j=0;j<atendidos.size();j++){
                    Cliente m=atendidos.get(j);
                    actual[0]= m.getCi();
                    actual[1]= m.getNombre();
                    actual[2]= m.getApellido();
                    actual[3]= m.getEdad();
                    actual[4]= m.getGrupoSanguineo();
                    actual[5]= m.getFechaNacimineto();
                    actual[6]=Clinica.getEspecialidadSinAtender().get(i).getNombre();
                    actual[7]="NO";
                    modelo.addRow(actual);
                }
            }
        }}
        if(Clinica.getEspecialidadAtendidos()!=null)
        for(int i=0;i<Clinica.getEspecialidadAtender().size();i++){
            ArrayList<Cliente> atendidos=Clinica.getPacientesAtendidos(i);
            if(atendidos!=null)
                for(int j=0;j<atendidos.size();j++){
                    Cliente m=atendidos.get(j);
                    actual[0]= m.getCi();
                    actual[1]= m.getNombre();
                    actual[2]= m.getApellido();
                    actual[3]= m.getEdad();
                    actual[4]= m.getGrupoSanguineo();
                    actual[5]= m.getFechaNacimineto();
                    actual[6]=Clinica.getEspecialidadSinAtender().get(i).getNombre();
                    actual[7]="SI";
                    modelo.addRow(actual);
                }
               
        }
        tableQuery.setModel(modelo);
    }
    
    private void consultarCliente(ConsultaBD consultar  , DefaultTableModel modelo ,String critero){
        paciente = consultar.ConsultarClientes(critero);
        
        String[] columnas = {"CEDULA", "NOMBRE","APELLIDOS","EDAD","GRUPO SANGUINEO","FECHA NAC"};
        modelo.setColumnIdentifiers(columnas);
        Object [] actual=new Object[6];
        if(paciente!= null){
            for (Cliente m:paciente){
                actual[0]= m.getCi();
                actual[1]= m.getNombre();
                actual[2]= m.getApellido();
                actual[3]= m.getEdad();
                actual[4]= m.getGrupoSanguineo();
                actual[5]= m.getFechaNacimineto();
                modelo.addRow(actual);
            }
               
        }
        tableQuery.setModel(modelo);
    }
    private void consultarDoctor(ConsultaBD consultar  , DefaultTableModel modelo ,String critero){
        ArrayList<Doctor> doctor = consultar.ConsultarDoctores(critero);
        String[] columnas = {"CEDULA", "NOMBRE","APELLIDOS","EDAD","FECHA NAC","ESPECIALIDAD"};
        modelo.setColumnIdentifiers(columnas);
        Object [] actual=new Object[6];
        if(doctor!= null){
            for (Doctor m:doctor){
                actual[0]= m.getCi();
                actual[1]= m.getNombre();
                actual[2]= m.getApellido();
                actual[3]= m.getEdad();
                actual[4]= m.getFechaNacimineto();
                actual[5]= m.getEspecialidad().getNombre();
                modelo.addRow(actual);
            }
               
        }
        tableQuery.setModel(modelo);
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        busqueda = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        vistaReceta = new javax.swing.JButton();
        btnHistorial = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableQuery = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new java.awt.BorderLayout());

        jPanel2.setOpaque(false);

        jPanel3.setOpaque(false);
        jPanel3.setLayout(new java.awt.BorderLayout());

        busqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                busquedaKeyTyped(evt);
            }
        });
        jPanel3.add(busqueda, java.awt.BorderLayout.CENTER);

        jLabel1.setText("Filtar por Nombre");
        jPanel3.add(jLabel1, java.awt.BorderLayout.PAGE_START);

        jPanel4.setOpaque(false);

        vistaReceta.setText("Ver Receta");
        vistaReceta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vistaRecetaActionPerformed(evt);
            }
        });

        btnHistorial.setText("Historial Médico");
        btnHistorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHistorialActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(btnHistorial, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(vistaReceta, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(98, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnHistorial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(vistaReceta, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        add(jPanel2, java.awt.BorderLayout.NORTH);

        jScrollPane1.setOpaque(false);

        tableQuery.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tableQuery);

        add(jScrollPane1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void busquedaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_busquedaKeyTyped
        consultarDatos(busqueda.getText(), this.tipo);
    }//GEN-LAST:event_busquedaKeyTyped

    private void vistaRecetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vistaRecetaActionPerformed
        int indice = tableQuery.getSelectedRow();//Fila seleccionada
        if (indice<0){
            JOptionPane.showMessageDialog(null, "Selecione una fila");
            return;
        }
        
        DefaultTableModel modelo = (DefaultTableModel) tableQuery.getModel();//obtener modelo de datos
        String cedula = (String)modelo.getValueAt(indice, 0);
        for (Cliente p:paciente){
            if(p.getCi().equals(cedula)){
                if(p.getRecetas().isEmpty() || p.getRecetas()==null){
                    JOptionPane.showMessageDialog(null, "No existen recetas");
                    return;
                }
                RecetasPanel panel=new RecetasPanel(PantallaTrabajo.getInstance(),true);
                panel.setRecetas(p.getRecetas());
                panel.setVisible(true);
            }
        }
    }//GEN-LAST:event_vistaRecetaActionPerformed

    private void btnHistorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHistorialActionPerformed
        int indice = tableQuery.getSelectedRow();//Fila seleccionada
        if (indice<0){
            JOptionPane.showMessageDialog(null, "Selecione una fila");
            return;
        }
        
        DefaultTableModel modelo = (DefaultTableModel) tableQuery.getModel();//obtener modelo de datos
        String cedula = (String)modelo.getValueAt(indice, 0);
        for (Cliente p:paciente){
            if(p.getCi().equals(cedula)){
                try{
                if(p.getHistorialMedico().isEmpty() || p.getHistorialMedico()==null
                        || p.getHistorialMedico().get(0).getSintomas()==null){
                    JOptionPane.showMessageDialog(null, "No hay historial");
                    return;
                }}catch(NullPointerException es){}
                HistorialPaciente panel=new HistorialPaciente(PantallaTrabajo.getInstance(),true);
                panel.setCliente(p);
                panel.setVisible(true);
            }
        }
    }//GEN-LAST:event_btnHistorialActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHistorial;
    private javax.swing.JTextField busqueda;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableQuery;
    private javax.swing.JButton vistaReceta;
    // End of variables declaration//GEN-END:variables
}
