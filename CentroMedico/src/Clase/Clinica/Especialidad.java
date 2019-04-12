package Clase.Clinica;

public class Especialidad {
    private int code;
    private String nombre;
    public Especialidad(int code, String nombre) {
        this.code = code;
        this.nombre = nombre;
    }
    
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    @Override
    public String toString() {
        return nombre ;
    }
    

    
}
