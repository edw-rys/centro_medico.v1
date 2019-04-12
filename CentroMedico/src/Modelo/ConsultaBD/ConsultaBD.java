package Modelo.ConsultaBD;

import Clases.Entidades.Cliente;
import Clases.Entidades.Doctor;
import Clase.Clinica.MuestraPaciente;
import Clase.Clinica.Especialidad;
import Clases.Entidades.HistorialMedico;
import Clases.Entidades.Receta;
import Clase.Clinica.TipoMedicamento;
import Clase.Clinica.Medicamento;
import Clase.Clinica.Procedimiento;
import Clases.more.DetalleFactura;
import Clases.more.Factura;
import Clases.more.StockMedicina;
import Clases.more.Laboratorio;
import Modelo.Conexion.ConexionBaseDatos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ConsultaBD {
    private ConexionBaseDatos micon;//Realizar una conexion a la base de datos
    private Connection con;//Hacer conexion
    private PreparedStatement sentenciaPreparada;//Preparar sentencias (buscar, editar, eliminar)
    private ResultSet resultset;
    
    
    
    
    //Consultas
    
    
    public int getNextNumberFacture(){
        micon=new ConexionBaseDatos();
        con=micon.getConection(); 
        if(con==null) return 0;
        int resultado=0;
        String query = "SELECT MAX(idfactura) FROM factura";
        try {
            sentenciaPreparada = con.prepareStatement(query);
            resultset=sentenciaPreparada.executeQuery();
            if(resultset.next())
                resultado=resultset.getInt(1);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }finally{
          try {
              con.close();
          } catch (SQLException ex) {              
          }
        }
      return resultado +1;
    }
    
    public ArrayList<Especialidad> consultarEspecialidad(){
        micon=new ConexionBaseDatos();//
       //OBTENER CONEXION
        con=micon.getConection();       //Se intenta conectar a la base de datos
        if(con==null) return null;
        ArrayList<Especialidad> lista=new ArrayList<>();
        String query ="select * from especialidad where estado=1";
        try {
            sentenciaPreparada = con.prepareStatement(query);
            resultset=sentenciaPreparada.executeQuery();
            while(resultset.next()){
                Especialidad esp=new Especialidad(resultset.getInt("idespecialidad"), resultset.getString("descripcion"));
                lista.add(esp);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }finally{
            try {
                con.close();//cierra conexion 
            } catch (SQLException ex) {
                System.out.println("Error en conexion: cerrar conexion");
            }
        }
        return lista;
    }
    
    
    public int consultarUsuarios(String user , String clave){
        int rspta=0;
        micon=new ConexionBaseDatos();//
       //OBTENER CONEXION
        con=micon.getConection();       //Se intenta conectar a la base de datos
        if(con==null) return 0;
        
        String query ="select * from usuarios where usuario =? and clave= ? and estado='1'";
        try {
            sentenciaPreparada = con.prepareStatement(query);
            sentenciaPreparada.setString(1, user );
            sentenciaPreparada.setString(2, clave );
            resultset=sentenciaPreparada.executeQuery();
            if(resultset.next()){
                if(resultset.getString("tipo").equals("ADMINISTRADOR"))
                    rspta=1;
                else if(resultset.getString("tipo").equals("OPERADOR"))
                    rspta=2;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            rspta=0;
        }finally{
            try {
                con.close();//cierra conexion 
            } catch (SQLException ex) {
                System.out.println("Error en conexion: cerrar conexion");
            }
        }
        
        return rspta;
    }
    
    //consultar usuarios
    public ArrayList<String> cargarUsuarios(){
        micon=new ConexionBaseDatos();//
       //OBTENER CONEXION
        con=micon.getConection();       //Se intenta conectar a la base de datos
        if(con==null) return null;
        ArrayList<String> users=new ArrayList<>();
        String query ="select usuario from usuarios ";
        try {
            sentenciaPreparada = con.prepareStatement(query);

            resultset=sentenciaPreparada.executeQuery();
            while(resultset.next())
                users.add(resultset.getString("usuario"));
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }finally{
            try {
                con.close();//cierra conexion 
            } catch (SQLException ex) {
                System.out.println("Error en conexion: cerrar conexion");
            }
        }
        
        return users;
    }
    
    
    
    public Cliente consultarCliente(String ci){
        micon=new ConexionBaseDatos();//
       //OBTENER CONEXION
       con=micon.getConection();       //Se intenta conectar a la base de datos

       if(con==null) return null;    
       Cliente paciente=null;
        try {
            String query = "select * from paciente where cedula='"+ci+"'";//escribe sentencia
            sentenciaPreparada = con.prepareStatement(query);
            //Prepara la sentencia para ser ejecutada a la base de datos
            resultset=sentenciaPreparada.executeQuery();//ejecuta Sentecia para buscar a la base de datos
            if(resultset.next()){
                paciente=new Cliente();
                paciente.setNombre(resultset.getString("nombre"));
                paciente.setApellido(resultset.getString("apellido"));
                paciente.setCi(resultset.getString("cedula"));
                paciente.setEdad(resultset.getInt("edad")   );
                paciente.setFechaNacimineto(resultset.getDate("fecha_nac"));
                paciente.setGrupoSanguineo(resultset.getString("grupo_san"));

            }
               
        } catch (SQLException ex) {
            System.out.println("Error - "+ex.getMessage());
        }finally{
            try {
                con.close();//cierra conexion 
            } catch (SQLException ex) {
                System.out.println("Error en conexion: cerrar conexion");
            }
        }
        if(paciente!=null)
            paciente.setFacturas(addFacturaCliente(ci));
       return paciente;
    }
    
    public ArrayList<Doctor>  ConsultarDoctores(String criterio ){
       micon=new ConexionBaseDatos();//
       //OBTENER CONEXION
       con=micon.getConection();       //Se intenta conectar a la base de datos
       if(con==null) return null;    //Si no se pudo conextar  retorna 0
       ArrayList<Doctor> doctores=new ArrayList<>();
        try {
            String query = "SELECT * FROM `empleado` as emp, tipo_emp as tip, especialidad as esp WHERE "
                    + "emp.tipo_emp_id=tip.idtipo_emp and esp.idespecialidad=tip.especialidad_id and emp.estado=1";//escribe sentencia
            if(!criterio.equals("")){
                query+=" and (emp.nombre like concat('%',?,'%') or emp.cedula like concat(?,'%'))";
                sentenciaPreparada = con.prepareStatement(query);
                sentenciaPreparada.setString(1, criterio );
                sentenciaPreparada.setString(2, criterio );
            }else
                sentenciaPreparada = con.prepareStatement(query);
        
            //Prepara la sentencia para ser ejecutada a la base de datos
            resultset=sentenciaPreparada.executeQuery();//ejecuta Sentecia para buscar a la base de datos
            while(resultset.next())
            {
                Especialidad especialidad=new Especialidad(resultset.getInt("esp.idespecialidad"), resultset.getString("esp.descripcion"));
                
                Doctor doctor=new Doctor();
                doctor.setNombre(resultset.getString("emp.nombre"));
                doctor.setApellido(resultset.getString("emp.apellido"));
                doctor.setCi(resultset.getString("emp.cedula"));
                doctor.setEdad(resultset.getInt("emp.edad")   );
                doctor.setFechaNacimineto(resultset.getDate("emp.fecha_nac"));
                doctor.setEspecialidad(especialidad);
                doctores.add(doctor);
            }
               
        } catch (SQLException ex) {
            System.out.println("Error - "+ex.getMessage());
        }finally{
            try {
                con.close();//cierra conexion 
            } catch (SQLException ex) {
                System.out.println("Error en conexion: cerrar conexion");
            }
        }
       
       return doctores;
    }
    
    
    public ArrayList<Cliente>  ConsultarPacientes(String criterio ){
        ArrayList<Cliente> pacientes=ConsultarClientes(criterio);
        if(pacientes!=null)
        for(int i=0;i<pacientes.size();i++){
           pacientes.get(i).setHistorialMedico(historialPaciente(pacientes.get(i).getCi()));
           pacientes.get(i).actualizarReceta();
        }
        return pacientes;
    }
    
    
    public ArrayList<Cliente>  ConsultarClientes(String criterio ){
       micon=new ConexionBaseDatos();//
       //OBTENER CONEXION
       con=micon.getConection();       //Se intenta conectar a la base de datos

       if(con==null) return null;    

        ArrayList<Cliente> pacientes=new ArrayList<>();
        try {
            String query = "select * from paciente";//escribe sentencia
            if(!criterio.equals("")){
                query+=" where nombre like concat('%',?,'%')";
                sentenciaPreparada = con.prepareStatement(query);
                sentenciaPreparada.setString(1, criterio );
            }else
                sentenciaPreparada = con.prepareStatement(query);
        
            //Prepara la sentencia para ser ejecutada a la base de datos
            resultset=sentenciaPreparada.executeQuery();//ejecuta Sentecia para buscar a la base de datos
            while(resultset.next())
            {
                Cliente paciente=new Cliente();
                paciente.setNombre(resultset.getString("nombre"));
                paciente.setApellido(resultset.getString("apellido"));
                paciente.setCi(resultset.getString("cedula"));
                paciente.setEdad(resultset.getInt("edad")   );
                paciente.setFechaNacimineto(resultset.getDate("fecha_nac"));
                paciente.setGrupoSanguineo(resultset.getString("grupo_san"));
                pacientes.add(paciente);
            }
               
        } catch (SQLException ex) {
            System.out.println("Error - "+ex.getMessage());
        }finally{
            try {
                con.close();//cierra conexion 
            } catch (SQLException ex) {
                System.out.println("Error en conexion: cerrar conexion");
            }
        }
       
       return pacientes;
    }
    
    public ArrayList<StockMedicina> consultarMedicina(String criterio ){
       micon=new ConexionBaseDatos();//
       //OBTENER CONEXION
       con=micon.getConection();       //Se intenta conectar a la base de datos
       
       if(con==null) return null;    
       ArrayList<StockMedicina> medicina=new ArrayList<>();
        try {
            String query = "SELECT `m`.*, `l`.*, `s`.*, `t`.* "
                    + "FROM `medicamento` AS `m` LEFT JOIN `laboratorio` "
                    + "AS `l` ON `m`.`laboratorio_id` = `l`.`idlaboratorio` LEFT JOIN `stock_med` "
                    + "AS `s` ON `s`.`medicamento_id` = `m`.`idmedicamento` 	"
                    + "LEFT JOIN `tipo_med` AS `t` ON `m`.`tipo_med_id` = `t`.`idtipo_med`";
                    //+ " where m.estado='1'";  
            
            
            if(!criterio.equals("")){
                query+=" where m.nombre like concat('%',?,'%')";
                sentenciaPreparada = con.prepareStatement(query);
                sentenciaPreparada.setString(1, criterio );
            }else
                sentenciaPreparada = con.prepareStatement(query);
        
            //Prepara la sentencia para ser ejecutada a la base de datos
            resultset=sentenciaPreparada.executeQuery();//ejecuta Sentecia para buscar a la base de datos
            while(resultset.next())
            {
                StockMedicina stock=new StockMedicina();
                Medicamento m=new Medicamento();
                m.setNombe(resultset.getString("m.nombre"));
                m.setPrecio(resultset.getDouble("m.costo"));
                m.setIdMedicamneto(resultset.getInt("m.idmedicamento"));
                
                TipoMedicamento tipo=new TipoMedicamento();
                tipo.setCodigo(resultset.getInt("t.idtipo_med"));
                tipo.setDescripcion(resultset.getString("t.descripcion"));
                
                Laboratorio l=new Laboratorio();
                l.setIdLaboratorio(resultset.getInt("l.idlaboratorio"));
                l.setNombre(resultset.getString("l.laboratorio"));
                
                m.setLaboratorio(l);
                m.setTipo(tipo);
                stock.setEstado(Integer.parseInt(resultset.getString("estado")));
                stock.setMedicina(m);
                stock.setCantidad(resultset.getInt("s.cantidad"));
                stock.setFecha(resultset.getDate("s.fecha"));
                medicina.add(stock);
            }
               
        } catch (SQLException ex) {
            System.out.println("Error - "+ex.getMessage());
        }finally{
            try {
                con.close();//cierra conexion 
            } catch (SQLException ex) {
                System.out.println("Error en conexion: cerrar conexion");
            }
        }
       
       return medicina;
    }

    public ArrayList<Medicamento> consultaMedicamento(){
        micon=new ConexionBaseDatos();//
        //OBTENER CONEXION
        con=micon.getConection();       //Se intenta conectar a la base de datos
        if(con==null) return null;    
        ArrayList<Medicamento> medicinas=new ArrayList<>();
        try {
            
            String query = "SELECT *from medicamento where estado='1'";
                         
            sentenciaPreparada = con.prepareStatement(query);
            
            //Prepara la sentencia para ser ejecutada a la base de datos
            resultset=sentenciaPreparada.executeQuery();//ejecuta Sentecia para buscar a la base de datos
            while(resultset.next()){
                Medicamento med=new Medicamento();
                med.setIdMedicamneto(resultset.getInt("idmedicamento"));
                med.setNombe(resultset.getString("nombre"));
                med.setPrecio(resultset.getDouble("costo"));
                medicinas.add(med);
            }
               
        } catch (SQLException ex) {
            System.out.println("Error - "+ex.getMessage());
        }finally{
            try {
                con.close();//cierra conexion 
            } catch (SQLException ex) {
                System.out.println("Error en conexion: cerrar conexion");
            }
        }
       
       return medicinas;
    }
    public Receta consultarReceta(int idReceta, Receta rct){
        micon=new ConexionBaseDatos();//
        //OBTENER CONEXION
        con=micon.getConection();       //Se intenta conectar a la base de datos
        if(con==null) return null;    
        try {
            
            String query = "SELECT `D`.*, `M`.* FROM `detalle_tratamiento` AS `D` "
                    + "LEFT JOIN `medicamento` AS `M` ON `D`.`medicamento_id` = `M`.`idmedicamento` "
                    + "WHERE D.tratamiento_id=?";
                             
            sentenciaPreparada = con.prepareStatement(query);
            sentenciaPreparada.setInt(1, idReceta);
            //Prepara la sentencia para ser ejecutada a la base de datos
            resultset=sentenciaPreparada.executeQuery();//ejecuta Sentecia para buscar a la base de datos
            while(resultset.next()){
                rct.getCantidad().add(resultset.getInt("D.cantidad"));
                rct.getVecesPorDia().add(resultset.getInt("D.veces_x_dia"));
                rct.getFechaIni().add(resultset.getDate("D.fecha_inicio"));
                rct.getFechaFin().add(resultset.getDate("D.fecha_fin"));   
                rct.getMedicina().add(new Medicamento(resultset.getInt("M.idmedicamento"), resultset.getString("M.nombre")));
            }
               
        } catch (SQLException ex) {
            System.out.println("Error - "+ex.getMessage());
        }finally{
            try {
                con.close();//cierra conexion 
            } catch (SQLException ex) {
                System.out.println("Error en conexion: cerrar conexion");
            }
        }
       
       return rct;
    }
    
    
 
    
    public ArrayList<HistorialMedico> historialPaciente(String ciPaciente){
        micon=new ConexionBaseDatos();//
       //OBTENER CONEXION
        con=micon.getConection();
        if(con==null) return null;
        ArrayList<HistorialMedico> historial=new ArrayList<>();
        try{
            String query="SELECT `pac`.*, `mst`.*, `h_med`.*, `snt`.*, `emp`.*, `trt`.*, `t_e`.*, `esp`.* "
                    + "FROM `paciente` AS `pac` "
                    + "LEFT JOIN `muestra` AS `mst` ON `mst`.`cedulaPaciente` = `pac`.`cedula` "
                    + "LEFT JOIN `historia_medica` AS `h_med` ON `h_med`.`muestra_id` = `mst`.`idmuestra` "
                    + "LEFT JOIN `sintomas` AS `snt` ON `h_med`.`sintomas_id` = `snt`.`idsintomas` "
                    + "LEFT JOIN `empleado` AS `emp` ON `h_med`.`cedulaEmpleado` = `emp`.`cedula` "
                    + "LEFT JOIN `tratamiento` AS `trt` ON `h_med`.`tratamiento_id` = `trt`.`idtratamiento` "
                    + "LEFT JOIN `tipo_emp` AS `t_e` ON `emp`.`tipo_emp_id` = `t_e`.`idtipo_emp` "
                    + "LEFT JOIN `especialidad` AS `esp` ON `t_e`.`especialidad_id` = `esp`.`idespecialidad`"
                    + " where `pac`.cedula=?";
            sentenciaPreparada = con.prepareStatement(query);
            sentenciaPreparada.setString(1, ciPaciente);
            resultset=sentenciaPreparada.executeQuery();//ejecuta Sentecia para buscar a la base de datos
            while(resultset.next()){
                MuestraPaciente muestra=new MuestraPaciente();
                muestra.setPeso(resultset.getDouble("mst.peso"));
                muestra.setEstatura(resultset.getDouble("mst.estatura"));
                muestra.setPresion(resultset.getInt("mst.presion"));
                
                
                
                Receta rct=new Receta();
                rct.setCode(resultset.getInt("idtratamiento"));
                rct.setFecha(resultset.getDate("fecha")); 
                
                Especialidad especialidad=new Especialidad(resultset.getInt("esp.idespecialidad"), resultset.getString("esp.descripcion"));
                
                Doctor doctor=new Doctor();
                doctor.setNombre(resultset.getString("emp.nombre"));
                doctor.setApellido(resultset.getString("emp.apellido"));
                doctor.setEdad(resultset.getInt("emp.edad"));
                doctor. setFechaNacimineto(resultset.getDate("emp.fecha_nac"));
                doctor.setEspecialidad(especialidad);
                
                
                HistorialMedico h=new HistorialMedico();
                
                h.setSintomas(resultset.getString("snt.descripcion"));
                h.setDoctor(doctor);
                h.setMuestra(muestra);
                h.setReceta(rct);
                h.setFehca(resultset.getDate("fecha_ing"));
                historial.add(h);
            }
        }catch (SQLException ex) {
            System.out.println("Error - "+ex.getMessage());
        }finally{
            try {
                con.close();//cierra conexion 
            } catch (SQLException ex) {
                System.out.println("Error en conexion: cerrar conexion");
            }
        }
        for(int i=0; i < historial.size();i++){
            Receta receta=historial.get(i).getReceta();
            historial.get(i).setReceta(consultarReceta(receta.getCode() , receta  ));
        }
        return historial;
    }
    
    
    public int tipo_emp(int idEspecialidad){
        int id=0;
        micon=new ConexionBaseDatos();//
       //OBTENER CONEXION
        con=micon.getConection();
        if(con==null) return 0;
        
        try{
            String query="select *from tipo_emp where especialidad_id='"+idEspecialidad+"'";
            sentenciaPreparada = con.prepareStatement(query);
            resultset=sentenciaPreparada.executeQuery();//ejecuta Sentecia para buscar a la base de datos
            if(resultset.next())
                id=resultset.getInt("idtipo_emp");
        }catch(SQLException ex){System.out.println(ex.getMessage());}
        finally{
            try {
                con.close();//cierra conexion 
            } catch (SQLException ex) {
                System.out.println("Error en conexion: cerrar conexion");
            }
        }
        return id;
    } 
    
    
    public int ultimaConsulta(String ci){
        int id=0;
        micon=new ConexionBaseDatos();//
       //OBTENER CONEXION
        con=micon.getConection();
        if(con==null) return 0;
        
        try{
            String query="SELECT MAX(idconsulta) FROM consulta  where cipaciente='"+ci+"'";
            sentenciaPreparada = con.prepareStatement(query);
            resultset=sentenciaPreparada.executeQuery();//ejecuta Sentecia para buscar a la base de datos
            if(resultset.next())
                id=resultset.getInt("MAX(idconsulta)");
        }catch(SQLException ex){System.out.println(ex.getMessage());}
        finally{
            try {
                con.close();//cierra conexion 
            } catch (SQLException ex) {
                System.out.println("Error en conexion: cerrar conexion");
            }
        }
        return id;
    } 
    
    public ArrayList<Laboratorio> consultaLaboratorios(){
        micon=new ConexionBaseDatos();//
       //OBTENER CONEXION
        con=micon.getConection();
        if(con==null) return null;
        ArrayList<Laboratorio> labs=new ArrayList<>();
        try{
            String query="select *from laboratorio";
            sentenciaPreparada = con.prepareStatement(query);
            resultset=sentenciaPreparada.executeQuery();//ejecuta Sentecia para buscar a la base de datos
            while(resultset.next())
                labs.add(new Laboratorio(resultset.getInt("idlaboratorio"), resultset.getString("laboratorio")));
        }catch(SQLException ex){System.out.println(ex.getMessage());}
        finally{
            try {
                con.close();//cierra conexion 
            } catch (SQLException ex) {
                System.out.println("Error en conexion: cerrar conexion");
            }
        }
        return labs;
    }
    
    public ArrayList<TipoMedicamento> consultaTiposMedicamento(){
        micon=new ConexionBaseDatos();//
       //OBTENER CONEXION
        con=micon.getConection();
        if(con==null) return null;
        ArrayList<TipoMedicamento> tipo=new ArrayList<>();
        try{
            String query="select *from tipo_med";
            sentenciaPreparada = con.prepareStatement(query);
            resultset=sentenciaPreparada.executeQuery();//ejecuta Sentecia para buscar a la base de datos
            while(resultset.next())
                tipo.add(new TipoMedicamento(resultset.getInt("idtipo_med"), resultset.getString("descripcion")));
        }catch(SQLException ex){System.out.println(ex.getMessage());}
        finally{
            try {
                con.close();//cierra conexion 
            } catch (SQLException ex) {
                System.out.println("Error en conexion: cerrar conexion");
            }
        }
        return tipo;
    }
    public int getIdmuestraPaciente(String ci){
        micon=new ConexionBaseDatos();
        con=micon.getConection(); 
        if(con==null) return 0;
        int resultado=0;
        String query = "SELECT MAX(idmuestra) FROM muestra where cedulaPaciente=?";
        try {
            sentenciaPreparada = con.prepareStatement(query);
            sentenciaPreparada.setString(1, ci);
            resultset=sentenciaPreparada.executeQuery();
            if(resultset.next())
                resultado=resultset.getInt(1);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }finally{
          try {
              con.close();
          } catch (SQLException ex) {              
          }
        }
      return resultado ;
    }
    
    public int getIdSintomasLast(){
        micon=new ConexionBaseDatos();
        con=micon.getConection(); 
        if(con==null) return 0;
        int resultado=0;
        String query = "SELECT MAX(idsintomas) FROM sintomas";
        try {
            sentenciaPreparada = con.prepareStatement(query);
            resultset=sentenciaPreparada.executeQuery();
            if(resultset.next())
                resultado=resultset.getInt(1);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }finally{
          try {
              con.close();
          } catch (SQLException ex) {              
          }
        }
      return resultado ;
    }
    public int getIdTratamiento(){
        micon=new ConexionBaseDatos();
        con=micon.getConection(); 
        if(con==null) return 0;
        int resultado=0;
        String query = "SELECT MAX(idtratamiento) FROM tratamiento";
        try {
            sentenciaPreparada = con.prepareStatement(query);
            resultset=sentenciaPreparada.executeQuery();
            if(resultset.next())
                resultado=resultset.getInt(1);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }finally{
          try {
              con.close();
          } catch (SQLException ex) {              
          }
        }
      return resultado ;
    }
    public ArrayList<Factura> addFacturaCliente(String ci){
        micon=new ConexionBaseDatos();
        con=micon.getConection(); 
        if(con==null) return null;
        int resultado=0;
        String query = "SELECT `fct`.*, `con`.* "
                + "FROM `factura` AS `fct` "
                + "LEFT JOIN `consulta` AS `con` ON `fct`.`consulta_id` = `con`.`idconsulta`  "
                + "where fct.cedulaPaciente=?";
        ArrayList<Factura> facturas=new ArrayList<>();

        try {
            sentenciaPreparada = con.prepareStatement(query);
            sentenciaPreparada.setString(1, ci);
            resultset=sentenciaPreparada.executeQuery();
            
            while(resultset.next()){
                Factura factura=new Factura();
                factura.setCiCliente(resultset.getString("fct.cedulaPaciente"));
                factura.setNumero(resultset.getInt("fct.idfactura"));
                factura.setFecha(resultset.getDate("fct.fecha"));
                factura.setIva(resultset.getDouble("fct.iva"));
                factura.setSubtotal(resultset.getDouble("fct.subtotal"));
                factura.setTotal(resultset.getDouble("fct.total"));
                factura.setPrecioConsulta(resultset.getDouble("con.costo"));
                factura.setDescripcionConsulta(resultset.getString("con.descripcion"));
                facturas.add(factura);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }finally{
          try {
              con.close();
          } catch (SQLException ex) {              
          }
        }
        if(facturas!=null){
            for(Factura f:facturas){
                f.setDetalle(addDetalleFactura(f.getNumero()));
                f.setProcedimiento(addProcedimientoFactura(f.getNumero()));
            }
        }
            
        
      return facturas ;
    }
    
    private ArrayList<DetalleFactura> addDetalleFactura(int factura){
        micon=new ConexionBaseDatos();
        con=micon.getConection(); 
        if(con==null) return null;
        String query = "SELECT `df`.*, `med`.*"
                + "FROM `detalle_factura` AS `df`  "
                + "LEFT JOIN `medicamento` AS `med` ON `df`.`medicamento_id` = `med`.`idmedicamento` "
                + "where df.factura_id=?";
        ArrayList<DetalleFactura> detalles=new ArrayList<>();

        try {
            sentenciaPreparada = con.prepareStatement(query);
            sentenciaPreparada.setInt(1, factura);
            resultset=sentenciaPreparada.executeQuery();
            while(resultset.next()){
                DetalleFactura detalle=new DetalleFactura();
                detalle.setCantidadProducto(resultset.getInt("df.cantidad"));
                detalle.setId(resultset.getInt("df.factura_id"));
                detalle.setPrecio(resultset.getDouble("df.precio"));
                detalle.setTotal(resultset.getDouble("df.total"));
                detalle.setMedicina(new Medicamento(resultset.getInt("med.idmedicamento"), resultset.getString("med.nombre")));
                detalles.add(detalle);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }finally{
          try {
              con.close();
          } catch (SQLException ex) {              
          }
        }
      return detalles ;
    }
    
    private ArrayList<Procedimiento> addProcedimientoFactura(int factura){
        micon=new ConexionBaseDatos();
        con=micon.getConection(); 
        if(con==null) return null;
        String query = "SELECT `ph`.*, `pro`.*"
                + "FROM `procedimientos_hechos` AS `ph` "
                + "LEFT JOIN `procedimientos` AS `pro` ON `ph`.`id_procedimiento` = `pro`.`idprocedimientos` "
                + "where ph.id_factura=?";
        ArrayList<Procedimiento> procedimientos=new ArrayList<>();

        try {
            sentenciaPreparada = con.prepareStatement(query);
            sentenciaPreparada.setInt(1, factura);
            resultset=sentenciaPreparada.executeQuery();
            while(resultset.next()){
                Procedimiento proc=new Procedimiento();
                proc.setId(resultset.getInt("pro.idprocedimientos"));
                proc.setNombre(resultset.getString("pro.nombre"));
                proc.setPrecio(resultset.getDouble("pro.precio"));
                
                procedimientos.add(proc);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }finally{
          try {
              con.close();
          } catch (SQLException ex) {              
          }
        }
      return procedimientos ;
    }

    public ArrayList<Procedimiento> consultarProcedimientos() {
        micon=new ConexionBaseDatos();
        con=micon.getConection(); 
        if(con==null) return null;
        String query = "SELECT * from procedimientos";
        ArrayList<Procedimiento> procedimientos=new ArrayList<>();

        try {
            sentenciaPreparada = con.prepareStatement(query);
            resultset=sentenciaPreparada.executeQuery();
            while(resultset.next()){
                Procedimiento proc=new Procedimiento();
                proc.setId(resultset.getInt("idprocedimientos"));
                proc.setNombre(resultset.getString("nombre"));
                proc.setPrecio(resultset.getDouble("precio"));
                
                procedimientos.add(proc);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }finally{
          try {
              con.close();
          } catch (SQLException ex) {              
          }
        }
      return procedimientos ;
    }
    
    
}
