package Clases.more;

public class Laboratorio {
    private int idLaboratorio;
    private String nombre;

    public Laboratorio() {
    }

    
    public Laboratorio(int idLaboratorio, String nombre) {
        this.idLaboratorio = idLaboratorio;
        this.nombre = nombre;
    }

    public int getIdLaboratorio() {
        return idLaboratorio;
    }

    public void setIdLaboratorio(int idLaboratorio) {
        this.idLaboratorio = idLaboratorio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
