package Modelo.ConsultaBD;

import Clase.Clinica.Especialidad;
import Clase.Clinica.Medicamento;
import Clase.Clinica.MuestraPaciente;
import Clase.Clinica.Procedimiento;
import Clases.Entidades.Cliente;
import Clases.Entidades.Doctor;
import Clases.Entidades.Receta;
import Clases.more.DetalleFactura;
import Clases.more.Factura;
import Modelo.Conexion.ConexionBaseDatos;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

public class GuardarBD {
    private ConexionBaseDatos micon;//Realizar una conexion a la base de datos
    private Connection con;//Hacer conexion
    private PreparedStatement sentenciaPreparada;//Preparar sentencias (buscar, editar, eliminar)

    
    public int guardarUsuario(String user, String clave, String tipo){
        int res=0;
        micon=new ConexionBaseDatos();
       //OBTENER CONEXION
        con=micon.getConection();
        
        if(con==null) return 0;
        String sql = "insert into usuarios (usuario, clave, tipo) "
                                 + "VALUES (     ?,   ?,   ?)";
        try {
            sentenciaPreparada =con.prepareStatement(sql);
            sentenciaPreparada.setString(1, user);
            sentenciaPreparada.setString(2, clave);           
            sentenciaPreparada.setString(3, tipo);           
            
            res=sentenciaPreparada.executeUpdate();
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }finally{
            try {
                con.close();//cierra conexion 
            } catch (SQLException ex) {
                System.out.println("Error en conexion: cerrar conexion");
            }
        }
        
        return res;
    }
    
    public int actualizaUser(String userA, String claveA, String userN, String claveN){
        int res=0;
        micon=new ConexionBaseDatos();
       //OBTENER CONEXION
        con=micon.getConection();
        
        if(con==null) return 0;
        String sql = "update usuarios set usuario=?, clave=? where usuario=? and clave=?";
        try {
            sentenciaPreparada =con.prepareStatement(sql);
            sentenciaPreparada.setString(1, userN);
            sentenciaPreparada.setString(2, claveN);           
            sentenciaPreparada.setString(3, userA);           
            sentenciaPreparada.setString(4, claveA);  
            res=sentenciaPreparada.executeUpdate();
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }finally{
            try {
                con.close();//cierra conexion 
            } catch (SQLException ex) {
                System.out.println("Error en conexion: cerrar conexion");
            }
        }
        
        return res;
    }
    
    public int guardarCliente(Cliente c){
        int res=0;
        micon=new ConexionBaseDatos();
       //OBTENER CONEXION
        con=micon.getConection();
        
        if(con==null) return 0;
        String sql = "insert into paciente (`cedula`, `nombre`, `apellido`, `edad`, `grupo_san`, `fecha_nac`) "
                                 + "VALUES (     ?,        ?,       ?,         ?,      ?   ,        ?)";
        try {
            sentenciaPreparada =con.prepareStatement(sql);
            sentenciaPreparada.setString(1, c.getCi());
            sentenciaPreparada.setString(2, c.getNombre());           
            sentenciaPreparada.setString(3, c.getApellido());           
            sentenciaPreparada.setInt(4, c.getEdad());           
            sentenciaPreparada.setString(5, c.getGrupoSanguineo());                      
            sentenciaPreparada.setDate(6, c.getFechaNacimineto());
            
            res=sentenciaPreparada.executeUpdate();
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }finally{
            try {
                con.close();//cierra conexion 
            } catch (SQLException ex) {
                System.out.println("Error en conexion: cerrar conexion");
            }
        }
        
        return res;
    }
    public int editarCliente(Cliente c){
        int res=0;
        micon=new ConexionBaseDatos();
       //OBTENER CONEXION
        con=micon.getConection();
        
        if(con==null) return 0;
        String sql = "update paciente set nombre=?,apellido=?, edad=?, grupo_san=?,fecha_nac=? where cedula=?";
        try {
            sentenciaPreparada =con.prepareStatement(sql);
            sentenciaPreparada.setString(1, c.getNombre());           
            sentenciaPreparada.setString(2, c.getApellido());           
            sentenciaPreparada.setInt(3, c.getEdad());           
            sentenciaPreparada.setString(4, c.getGrupoSanguineo());                      
            sentenciaPreparada.setDate(5, c.getFechaNacimineto());
            sentenciaPreparada.setString(6, c.getCi());
            
            res=sentenciaPreparada.executeUpdate();
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }finally{
            try {
                con.close();//cierra conexion 
            } catch (SQLException ex) {
                System.out.println("Error en conexion: cerrar conexion");
            }
        }
        
        return res;
    }
    private int guardarConsulta(double costo, String especialidad, String ci){
        int res=0;
        micon=new ConexionBaseDatos();
       //OBTENER CONEXION
        con=micon.getConection();
        if(con==null) return 0;
        
        String sql = "insert into consulta  (descripcion, costo, cipaciente) "
                                 + "VALUES (?,?,?);";
        try {
            sentenciaPreparada =con.prepareStatement(sql);
            sentenciaPreparada.setString(1, especialidad);
            sentenciaPreparada.setDouble(2, costo);
            sentenciaPreparada.setString(3, ci);
            res=sentenciaPreparada.executeUpdate();
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }finally{
            try {
                con.close();//cierra conexion 
            } catch (SQLException ex) {
                System.out.println("Error en conexion: cerrar conexion");
            }
        }
        
        return res;
    }
    public int guardarFactura(Factura factura, String especialidad) {
        guardarConsulta(factura.getSubtotal(),especialidad, factura.getCiCliente());
        int idconsulta=new ConsultaBD().ultimaConsulta(factura.getCiCliente());
        int res=0;
        micon=new ConexionBaseDatos();
       //OBTENER CONEXION
        con=micon.getConection();
        if(con==null) return 0;
        System.out.println(idconsulta);
        String sql = "insert into factura  (`idfactura`, `fecha`, `subtotal`, `iva`, `total`, `cedulaPaciente`, consulta_id) "
                                 + "VALUES ( ?,              ?,       ?,        ?,      ? ,         ?,             ?);";
        try {
            sentenciaPreparada =con.prepareStatement(sql);
            sentenciaPreparada.setInt(1, factura.getNumero());
            sentenciaPreparada.setDate(2, factura.getFecha());           
            sentenciaPreparada.setDouble(3, factura.getSubtotal());           
            sentenciaPreparada.setDouble(4, factura.getIva());           
            sentenciaPreparada.setDouble(5, factura.getTotal());                      
            sentenciaPreparada.setString(6, factura.getCiCliente());
            sentenciaPreparada.setInt(7, idconsulta);
            res=sentenciaPreparada.executeUpdate();
            
        } catch (SQLException ex) {
            System.out.println("Factura: "+ex.getMessage());
        }
        
        return res;
    }
    public int guardarEspecialidad(Especialidad es){
        int res=0;
        micon=new ConexionBaseDatos();
       //OBTENER CONEXION
        con=micon.getConection();
        if(con==null) return 0;
        
        String sql = "insert into especialidad  ( idespecialidad, descripcion ) "
                                 + "VALUES ( ?,              ?    ); ";
        try {
            sentenciaPreparada =con.prepareStatement(sql);
            sentenciaPreparada.setInt(1 , es.getCode());
            sentenciaPreparada.setString(2 , es.getNombre());           
            
            res=sentenciaPreparada.executeUpdate();
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }finally{
            try {
                con.close();//cierra conexion 
            } catch (SQLException ex) {
                System.out.println("Error en conexion: cerrar conexion");
            }
        }
        res=guardarTipoEmp(es);
        return res;
    }
    public int guardarTipoEmp(Especialidad es){
        int res=0;
        micon=new ConexionBaseDatos();
       //OBTENER CONEXION
        con=micon.getConection();
        if(con==null) return 0;
        
        String sql = "insert into tipo_emp (idtipo_emp, descripcion, especialidad_id) values ("+es.getCode()+
                ", '"+es.getNombre()+"', "+es.getCode()+");";
        try {
            sentenciaPreparada =con.prepareStatement(sql);           
            
            res=sentenciaPreparada.executeUpdate();
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }finally{
            try {
                con.close();//cierra conexion 
            } catch (SQLException ex) {
                System.out.println("Error en conexion: cerrar conexion");
            }
        }
        
        return res;
    }
    
    public int actualizarEspecialidad(Especialidad es, int activo){
        int res=0;
        micon=new ConexionBaseDatos();
       //OBTENER CONEXION
        con=micon.getConection();
        if(con==null) return 0;
        
        String sql = "UPDATE especialidad set descripcion='"+es.getNombre()+"', estado='"+activo
                + "' where idespecialidad='"+es.getCode()+"'";
        try {
            sentenciaPreparada =con.prepareStatement(sql);
            res=sentenciaPreparada.executeUpdate();
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return res;
    }
    
    
    
    
    public int guardarDoctor(Doctor c){
        int res=0;
        micon=new ConexionBaseDatos();
       //OBTENER CONEXION
        con=micon.getConection();
        int idtipo=new ConsultaBD().tipo_emp(c.getEspecialidad().getCode());
        System.out.println(c.getEspecialidad().getCode());
        System.out.println(idtipo);
        if(con==null) return 0;
        String sql = "insert into empleado (`cedula`, `nombre`, `apellido`, `edad`, `fecha_nac`, `tipo_emp_id`) "
                                 + "VALUES (     ?,        ?,       ?,         ?,        ?   ,        ?)";
        try {
            sentenciaPreparada =con.prepareStatement(sql);
            sentenciaPreparada.setString(1, c.getCi());
            sentenciaPreparada.setString(2, c.getNombre());           
            sentenciaPreparada.setString(3, c.getApellido());           
            sentenciaPreparada.setInt(4, c.getEdad());           
            sentenciaPreparada.setDate(5, c.getFechaNacimineto());                      
            sentenciaPreparada.setInt(6, idtipo);
            
            res=sentenciaPreparada.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }finally{
            try {
                con.close();//cierra conexion 
            } catch (SQLException ex) {
                System.out.println("Error en conexion: cerrar conexion");
            }
        }
        return res;
    }
    
    public int editarDoctor(Doctor c){
        int res=0;
        micon=new ConexionBaseDatos();
       //OBTENER CONEXION
        con=micon.getConection();
        int idtipo=new ConsultaBD().tipo_emp(c.getEspecialidad().getCode());
        if(con==null) return 0;
        String sql = ""
                + "UPDATE empleado set nombre=? , apellido=?, edad=?, fecha_nac=? , tipo_emp_id=? "
                                 + "where cedula= ?";
        try {
            sentenciaPreparada =con.prepareStatement(sql);
            
            sentenciaPreparada.setString(1, c.getNombre());           
            sentenciaPreparada.setString(2, c.getApellido());           
            sentenciaPreparada.setInt(3, c.getEdad());           
            sentenciaPreparada.setDate(4, c.getFechaNacimineto());                      
            sentenciaPreparada.setInt(5, idtipo);
            sentenciaPreparada.setString(6, c.getCi());
            
            res=sentenciaPreparada.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }finally{
            try {
                con.close();//cierra conexion 
            } catch (SQLException ex) {
                System.out.println("Error en conexion: cerrar conexion");
            }
        }
        return res;
    }
    public int guardarMedicina(Medicamento m, int stock, Date fecha){
        int res=0;
        micon=new ConexionBaseDatos();
       //OBTENER CONEXION
        con=micon.getConection();
        if(con==null) return 0;
        String sql = "insert into medicamento (`idmedicamento`, `nombre`, `costo`, `tipo_med_id`, `laboratorio_id`, `estado`) "
                                 + "VALUES (            ?,        ?,       ?,         ?,                ?   ,        ?)";
        try {
            sentenciaPreparada =con.prepareStatement(sql);
            sentenciaPreparada.setInt(1, m.getIdMedicamneto());
            sentenciaPreparada.setString(2, m.getNombe());           
            sentenciaPreparada.setDouble(3, m.getPrecio());           
            sentenciaPreparada.setInt(4, m.getTipo().getCodigo());           
            sentenciaPreparada.setInt(5, m.getLaboratorio().getIdLaboratorio());                      
            sentenciaPreparada.setString(6, "1");
            
            res=sentenciaPreparada.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }finally{
            try {
                con.close();//cierra conexion 
            } catch (SQLException ex) {
                System.out.println("Error en conexion: cerrar conexion");
            }
        }
        
        res=guardarStock(m.getIdMedicamneto(), stock, fecha);
        
        return res;
    }
    
    public int editarMedicina(Medicamento m, int stock, Date fecha,String estado){
        int res=0;
        micon=new ConexionBaseDatos();
       //OBTENER CONEXION
        con=micon.getConection();
        if(con==null) return 0;
        String sql = "update medicamento set nombre=?, costo=?, tipo_med_id=?, laboratorio_id=?, estado=? "
                + "where idmedicamento=?";
        try {
            sentenciaPreparada =con.prepareStatement(sql);
            
            sentenciaPreparada.setString(1, m.getNombe());           
            sentenciaPreparada.setDouble(2, m.getPrecio());           
            sentenciaPreparada.setInt(3, m.getTipo().getCodigo());           
            sentenciaPreparada.setInt(4, m.getLaboratorio().getIdLaboratorio());                      
            sentenciaPreparada.setString(5, estado);
            sentenciaPreparada.setInt(6, m.getIdMedicamneto());
            
            res=sentenciaPreparada.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }finally{
            try {
                con.close();//cierra conexion 
            } catch (SQLException ex) {
                System.out.println("Error en conexion: cerrar conexion");
            }
        }
        
        res=editarStock(m.getIdMedicamneto(), stock, fecha);
        
        return res;
    }
    
    
    public int guardarStock(int id,int cant, Date fechax){
        int res=0;
        micon=new ConexionBaseDatos();
       //OBTENER CONEXION
        con=micon.getConection();
        if(con==null) return 0;
        String sql = "insert into stock_med (`medicamento_id`, `cantidad`, `fecha`) "
                                 + "VALUES (            ?,        ?,       ?      )";
        try {
            sentenciaPreparada =con.prepareStatement(sql);
            sentenciaPreparada.setInt(1, id);
            sentenciaPreparada.setInt(2,cant);           
            sentenciaPreparada.setDate(3, fechax);           
            
            res=sentenciaPreparada.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return res;
    }
    public int editarStock(int id,int cant, Date fechax){
        int res=0;
        micon=new ConexionBaseDatos();
       //OBTENER CONEXION
        con=micon.getConection();
        if(con==null) return 0;
        String sql = "update stock_med set cantidad =?, fecha=? where medicamento_id=?";
        try {
            sentenciaPreparada =con.prepareStatement(sql);
            sentenciaPreparada.setInt(1,cant);           
            sentenciaPreparada.setDate(2, fechax);           
            sentenciaPreparada.setInt(3, id); 
            
            res=sentenciaPreparada.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }finally{
            try {
                con.close();//cierra conexion 
            } catch (SQLException ex) {
                System.out.println("Error en conexion: cerrar conexion");
            }
        }
        return res;
    }
    public int darBajaMedicina(int id){
        int res=0;
        micon=new ConexionBaseDatos();
       //OBTENER CONEXION
        con=micon.getConection();
        if(con==null) return 0;
        String sql = "update medicamento set estado=0 where idmedicamento='"+id+"'";
        try {
            sentenciaPreparada =con.prepareStatement(sql);
            
            res=sentenciaPreparada.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return res;
    }
    
    
    public int guardarMuestras(String ci, MuestraPaciente muestra){
        int res=0;
        micon=new ConexionBaseDatos();
       //OBTENER CONEXION
        con=micon.getConection();
        if(con==null) return 0;
        String sql = "insert into muestra (peso,estatura,presion,cedulaPaciente) VALUES(?,?,?,?)";
        try {
            sentenciaPreparada =con.prepareStatement(sql);
            sentenciaPreparada.setDouble(1, muestra.getPeso());
            sentenciaPreparada.setDouble(2, muestra.getEstatura());
            sentenciaPreparada.setDouble(3, muestra.getPresion());
            sentenciaPreparada.setString(4, ci );
            res=sentenciaPreparada.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }finally{
            try {
                con.close();//cierra conexion 
            } catch (SQLException ex) {
                System.out.println("Error en conexion: cerrar conexion");
            }
        }
        
        return res;
    }
    
    
    
    public int guardarHistoriaPaciente(String ci, Receta receta,  String ciEmp, String sintomas){
        ConsultaBD cons=new  ConsultaBD();
        int res=guardarTratamiento(ci);
        res= guardarSintomas(sintomas);
        
        int idT=cons.getIdTratamiento();
        
        guardarTodosDetallesTratamiento(receta, idT);
        
        res=guardarHistorialMedico(ciEmp, cons.getIdmuestraPaciente(ci), cons.getIdSintomasLast(), idT);
        
        return res;
    }
    
    private int guardarSintomas(String sintomas){
        int res=0;
        micon=new ConexionBaseDatos();
       //OBTENER CONEXION
        con=micon.getConection();
        if(con==null) return 0;
        String sql = "insert into sintomas (descripcion) values (?)";
        try {
            sentenciaPreparada =con.prepareStatement(sql);
            sentenciaPreparada.setString(1, sintomas);
            res=sentenciaPreparada.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }finally{
            try {
                con.close();//cierra conexion 
            } catch (SQLException ex) {
                System.out.println("Error en conexion: cerrar conexion");
            }
        }
        
        return res;
    }
    
    private int guardarTratamiento(String ci){
        int res=0;
        micon=new ConexionBaseDatos();
       //OBTENER CONEXION
        con=micon.getConection();
        if(con==null) return 0;
        Calendar c=Calendar.getInstance();
        Date day=new Date(c.getTime().getYear(), c.getTime().getMonth(), c.getTime().getDate());
        String sql = "insert into tratamiento(cedulapaciente,fecha) values (?,?)";
        try {
            sentenciaPreparada =con.prepareStatement(sql);
            sentenciaPreparada.setString(1, ci);
            sentenciaPreparada.setDate(2, day);
            res=sentenciaPreparada.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("guardarTratamiento "+ex.getMessage());
        }finally{
            try {
                con.close();//cierra conexion 
            } catch (SQLException ex) {
                System.out.println("Error en conexion: cerrar conexion");
            }
        }
        
        return res;
    }
    
    private void guardarTodosDetallesTratamiento(Receta receta, int idT){
        for(int i=0;i<receta.getMedicina().size();i++){
            guardarDetalleTratamiento( idT , receta.getMedicina().get(i).getIdMedicamneto()  ,
                    receta.getCantidad().get(i), receta.getVecesPorDia().get(i),
                     receta.getFechaIni().get(i), receta.getFechaFin().get(i));
        }
    }
    
    
    private int guardarDetalleTratamiento(int tratamiento , int idM, int cant, int veces, Date ini, Date fin){
        int res=0;
        micon=new ConexionBaseDatos();
       //OBTENER CONEXION
        con=micon.getConection();
        if(con==null) return 0;
       
        String sql = "insert into detalle_tratamiento(tratamiento_id, medicamento_id, cantidad, veces_x_dia,fecha_inicio, fecha_fin) "
                + "values (?, ?, ?, ?, ?, ?)";
        try {
            sentenciaPreparada =con.prepareStatement(sql);
            sentenciaPreparada.setInt(1, tratamiento);
            sentenciaPreparada.setInt(2, idM);
            sentenciaPreparada.setInt(3, cant);
            sentenciaPreparada.setInt(4, veces);
            sentenciaPreparada.setDate(5, ini);
            sentenciaPreparada.setDate(6, fin);
            
            res=sentenciaPreparada.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("guardarTodosDetallesTratamiento "+ex.getMessage());
        }finally{
            try {
                con.close();//cierra conexion 
            } catch (SQLException ex) {
                System.out.println("Error en conexion: cerrar conexion");
            }
        }
        
        return res;
    }
    
    private int guardarHistorialMedico(String ciMedico,int muestra,int sintomas, int tratamiento ){
        int res=0;
        micon=new ConexionBaseDatos();
       //OBTENER CONEXION
        con=micon.getConection();
        if(con==null) return 0;
        Calendar c=Calendar.getInstance();
        Date day=new Date(c.getTime().getYear(), c.getTime().getMonth(), c.getTime().getDate());
        String sql = "insert into historia_medica(fecha_ing,muestra_id, cedulaEmpleado, sintomas_id, tratamiento_id) "
                + "values (?,?,?,?,?)";
        try {
            sentenciaPreparada =con.prepareStatement(sql);
            sentenciaPreparada.setDate(1, day);
            sentenciaPreparada.setInt(2, muestra);
            sentenciaPreparada.setString(3, ciMedico);
            sentenciaPreparada.setInt(4, sintomas);
            sentenciaPreparada.setInt(5, tratamiento);
            
            res=sentenciaPreparada.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("guardarHistorialMedico "+ex.getMessage());
        }finally{
            try {
                con.close();//cierra conexion 
            } catch (SQLException ex) {
                System.out.println("Error en conexion: cerrar conexion");
            }
        }
        
        return res;
    }
    
    
    public int inactivarStr(String tabla, String campo,String where){
        int res=0;
        micon=new ConexionBaseDatos();
       //OBTENER CONEXION
        con=micon.getConection();
        if(con==null) return 0;

        String sql = "update "+tabla+" set estado=0 where "+campo+"=?";
        try {
            sentenciaPreparada =con.prepareStatement(sql);
            sentenciaPreparada.setString(1, where);
           
            res=sentenciaPreparada.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("inactivarStr "+ex.getMessage());
        }finally{
            try {
                con.close();//cierra conexion 
            } catch (SQLException ex) {
                System.out.println("Error en conexion: cerrar conexion");
            }
        }
        return res;
    }
    
    public int actualizarDatosFactura(Factura factura, ArrayList <Procedimiento> procedimientos,ArrayList<DetalleFactura> detail){
        int res=0;
        micon=new ConexionBaseDatos();
       //OBTENER CONEXION
        con=micon.getConection();
        if(con==null) return 0;

        String sql = "update factura set subtotal=?,iva=?, total=? where idfactura=?";
        try {
            sentenciaPreparada =con.prepareStatement(sql);
            sentenciaPreparada.setDouble(1, factura.getSubtotal());
            sentenciaPreparada.setDouble(2, factura.getIva());
            sentenciaPreparada.setDouble(3, factura.getTotal());
            sentenciaPreparada.setInt(4, factura.getNumero());
            res=sentenciaPreparada.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("actualizarDatosFactura "+ex.getMessage());
        }finally{
            try {
                con.close();//cierra conexion 
            } catch (SQLException ex) {
                System.out.println("Error en conexion: cerrar conexion");
            }
        }
        if(procedimientos!=null )
            if(!procedimientos.isEmpty())
                actualizarProcedimineto(factura,procedimientos);
        if(detail!=null)
            if(!detail.isEmpty()){
                actualizarDetalleFactura(factura.getNumero(),detail);
                for(DetalleFactura de: detail)
                    uptdateStockMedicina(de.getMedicina().getIdMedicamneto(), de.getCantidadProducto());
            }
        return res;
    }
    
    public int actualizarProcedimineto(Factura factura , ArrayList <Procedimiento> procedimientos){
        int res=0;
        micon=new ConexionBaseDatos();
       //OBTENER CONEXION
        con=micon.getConection();
        if(con==null) return 0;
        String values="";
        for(int i=0;i<procedimientos.size();i++){
            Procedimiento de=procedimientos.get(i);
            values+="('"+factura.getCiCliente()+"', "+de.getId()+", "+factura.getNumero()+") ";
            if(i==procedimientos.size()-1)
                continue;
            values+=", ";
        }
        System.out.println(values);
        String sql = "insert into procedimientos_hechos (cedula_paciente, id_procedimiento, id_factura) values"+values;
        try {
            sentenciaPreparada =con.prepareStatement(sql);
            res=sentenciaPreparada.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("actualizarDetalleFactura "+ex.getMessage());
        }finally{
            try {
                con.close();//cierra conexion 
            } catch (SQLException ex) {
                System.out.println("Error en conexion: cerrar conexion");
            }
        }
        return res;
    }
    
    public int actualizarDetalleFactura(int factura,ArrayList<DetalleFactura> detail){
        int res=0;
        micon=new ConexionBaseDatos();
       //OBTENER CONEXION
        con=micon.getConection();
        if(con==null) return 0;
        String values="";
        for(int i=0;i<detail.size();i++){
            DetalleFactura de=detail.get(i);
            values+="("+factura+", "+de.getCantidadProducto()+", "+de.getPrecio()+", "+de.getTotal()+", "+de.getMedicina().getIdMedicamneto()+") ";
            if(i==detail.size()-1)
                continue;
            values+=", ";
        }
        System.out.println(values);
        String sql = "insert into detalle_factura (factura_id, cantidad,precio, total, medicamento_id) values"+values;
        try {
            sentenciaPreparada =con.prepareStatement(sql);
            res=sentenciaPreparada.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("actualizarDatosFactura "+ex.getMessage());
        }finally{
            try {
                con.close();//cierra conexion 
            } catch (SQLException ex) {
                System.out.println("Error en conexion: cerrar conexion");
            }
        }
        return res;
    }
    
    private void uptdateStockMedicina(int idM, int cantG){
        int canT=maxStockMed(idM)-cantG;
        micon=new ConexionBaseDatos();
        con=micon.getConection(); 
        if(con==null) return ;
        
        
        String sql = "update stock_med set cantidad="+canT+" where medicamento_id= "+ idM;
        try {
            sentenciaPreparada =con.prepareStatement(sql);
            sentenciaPreparada.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("actualizar stock "+ex.getMessage());
        }finally{
            try {
                con.close();//cierra conexion 
            } catch (SQLException ex) {
                System.out.println("Error en conexion: cerrar conexion updateStockMed");
            }
        }
    }
    
    
    public int maxStockMed(int idM) {
        micon=new ConexionBaseDatos();
        con=micon.getConection(); 
        if(con==null) return 0;
        String query = "SELECT cantidad from stock_med where medicamento_id="+idM;
        int cant=0;
        try {
            sentenciaPreparada = con.prepareStatement(query);
            ResultSet resultset=sentenciaPreparada.executeQuery();
            if(resultset.next()){
                cant=resultset.getInt("cantidad");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }finally{
          try {
              con.close();
          } catch (SQLException ex) {              
              System.out.println("Error en conexion: cerrar conexion maxStockMed");
          }
        }
      return cant ;
    }
}
