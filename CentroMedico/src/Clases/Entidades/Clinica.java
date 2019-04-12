package Clases.Entidades;

import Clase.Clinica.Especialidad;
import Modelo.ConsultaBD.ConsultaBD;
import java.util.ArrayList;

public class Clinica {
    public static final int iva=12;
    private static ArrayList<EspecialidadPacientes> listaAtenciones=new ArrayList<>();
    private static ArrayList<AtencionDoctorPaciente> listaPacientes=new ArrayList<>();
    
    private static ArrayList<AtencionDoctorPaciente> pacientesAtendidos =new ArrayList();
    private static ArrayList<EspecialidadPacientes> pacientesNoAtendidos=new ArrayList<>();
    
    public static ArrayList<Cliente> getListaPacientesNoAtendidos(int i){
        return pacientesNoAtendidos.get(i).getClientesEnAtencion();
    }
    
    public static ArrayList<Especialidad> getEspecialidadSinAtender() {
        ArrayList<Especialidad> especialidades=new ArrayList<>();
        for(EspecialidadPacientes v: pacientesNoAtendidos)
            especialidades.add(v.getEspecialidad());
        return especialidades;
    }
    
    public static void addPacientesNoAtendidos(int i,Cliente c) {
                pacientesNoAtendidos.get(i).getClientesEnAtencion().add(c);

    }
    
    
    public static ArrayList<Cliente> getPacientesAtendidos(int i){
        return pacientesAtendidos.get(i).getClientesEnAtencion();
    }
    
    public static ArrayList<Especialidad> getEspecialidadAtendidos() {
        ArrayList<Especialidad> especialidades=new ArrayList<>();
        for(AtencionDoctorPaciente v: pacientesAtendidos)
            especialidades.add(v.getEspecialidad());
        return especialidades;
    }
    
    public static void addPacientesAtendidos(int id,Cliente paciente) {
        for(int i=0;i<pacientesAtendidos.size()  ;i++){
            if(pacientesAtendidos.get(i).getEspecialidad().getCode()==id){
                pacientesAtendidos.get(i).getClientesEnAtencion().add(paciente);
                pacientesNoAtendidos.get(i).getClientesEnAtencion().remove(paciente);
                break;
            }
        }
    }
    
    
    public static void cargarDatosDoctores(){
        ArrayList<Especialidad> es=new ConsultaBD().consultarEspecialidad();
        boolean noRepeat=false;
        if(es!=null)
        for(Especialidad e: es){
            noRepeat=false;
            for(int i=0;i<listaPacientes.size();i++){
                if(listaPacientes.get(i).getEspecialidad().getCode()==e.getCode()){
                    noRepeat=true;
                    break;
                }
            }
            if(!noRepeat){
                listaPacientes.add(new AtencionDoctorPaciente(e));
                pacientesAtendidos.add(new AtencionDoctorPaciente(e));
            }
        }
        ArrayList<Doctor> doctores=new ConsultaBD().ConsultarDoctores("");
        if(doctores!=null)
        for(int i=0;i<listaPacientes.size();i++){
            for(Doctor d : doctores){
                if(d.getEspecialidad().getCode()==listaPacientes.get(i).getEspecialidad().getCode()){
                    listaPacientes.get(i).setDoctor(d);
                    break;
                }
            }
        }
        
    }
    public static void addPacientes(int i,Cliente paciente) {
        listaPacientes.get(i).getClientesEnAtencion().add(paciente);
    }
    public static int getPacientesSize(){
        return listaPacientes.size();
    }
    public static Cliente getPaciente(int i){
        if(listaPacientes.get(i).getClientesEnAtencion().isEmpty())
            return null;
        return listaPacientes.get(i).getClientesEnAtencion().get(0);
    }
    public static Cliente getPaciente(int i, int pos){
        if(listaPacientes.get(i).getClientesEnAtencion().isEmpty())
            return null;
        return listaPacientes.get(i).getClientesEnAtencion().get(pos);
    }
    public static Doctor getDoctor (int i ){
        return listaPacientes.get(i).getDoctor();
    }

    public static ArrayList<Especialidad> getEspecialidadAtender() {
        ArrayList<Especialidad> especialidades=new ArrayList<>();
        for(AtencionDoctorPaciente v: listaPacientes)
            especialidades.add(v.getEspecialidad());
        return especialidades;
    }
    
    public static Especialidad getEspecialidadDoctor(int i){
        return listaPacientes.get(i).getEspecialidad();
    }
    
    
    public static ArrayList<EspecialidadPacientes> getListaAtenciones() {
        return listaAtenciones;
    }
    
    public static void cargarDatos(){
        ArrayList<Especialidad> es=new ConsultaBD().consultarEspecialidad();
        boolean noRepeat=false;
        if(es!=null)
        for(Especialidad e: es){
            noRepeat=false;
            for(int i=0;i<listaAtenciones.size();i++){
                if(listaAtenciones.get(i).getEspecialidad().getCode()==e.getCode()){
                    noRepeat=true;
                    break;
                }
            }
            if(!noRepeat){
                listaAtenciones.add(new EspecialidadPacientes(e));
                pacientesNoAtendidos.add(new EspecialidadPacientes(e));
            }
        }
    }
    
    public static Especialidad getEspecialidad(int i){
        return listaAtenciones.get(i).getEspecialidad();
    }

    public static void addCliente(int i, Cliente c){
        listaAtenciones.get(i).getClientesEnAtencion().add(c);
    }
    public static Cliente getCliente(int i){
        if(listaAtenciones.get(i).getClientesEnAtencion().isEmpty())
            return null;
        return listaAtenciones.get(i).getClientesEnAtencion().get(0);
    }
    
    public static Cliente getCliente(int i, int pos){
        if(listaAtenciones.get(i).getClientesEnAtencion().isEmpty())
            return null;
        return listaAtenciones.get(i).getClientesEnAtencion().get(pos);
    }
    
    public static void removeClienteEspecialidad(int i){
        addPacientes(i, listaAtenciones.get(i).getClientesEnAtencion().get(0));
        listaAtenciones.get(i).getClientesEnAtencion().remove(0);
    }
}
class EspecialidadPacientes{
    private Especialidad especialidad;
    private ArrayList<Cliente> clientesEnAtencion=new ArrayList<>();

    public EspecialidadPacientes(Especialidad especialidad) {
        this.especialidad = especialidad;
    }
    
    public ArrayList<Cliente> getClientesEnAtencion() {
        return clientesEnAtencion;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }
    
}

class AtencionDoctorPaciente{
    private Doctor doctor;
    private Especialidad especialidad;
    private ArrayList<Cliente> clientesEnAtencion=new ArrayList<>();

    public AtencionDoctorPaciente(Especialidad especialidad) {
        this.especialidad = especialidad;
    }
    
    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public ArrayList<Cliente> getClientesEnAtencion() {
        return clientesEnAtencion;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

    
    
    
}