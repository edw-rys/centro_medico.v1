package Clase.Clinica;

import Clase.Clinica.TipoMedicamento;
import Clases.more.Laboratorio;
import java.sql.Date;

public class Medicamento {
    private int idMedicamneto;
    private String nombre;
    private double precio;
    private TipoMedicamento tipo;
    private Laboratorio laboratorio;
    

    public Medicamento() {
    }

    public Medicamento(int idMedicamneto, String nombe) {
        this.idMedicamneto = idMedicamneto;
        this.nombre = nombe;
    }
    
    public Medicamento(int idMedicamneto, String nombre, double precio, TipoMedicamento tipo, Laboratorio laboratorio) {
        this.idMedicamneto = idMedicamneto;
        this.nombre = nombre;
        this.precio = precio;
        this.tipo = tipo;
        this.laboratorio = laboratorio;

    }
    
    public int getIdMedicamneto() {
        return idMedicamneto;
    }

    public void setIdMedicamneto(int idMedicamneto) {
        this.idMedicamneto = idMedicamneto;
    }

    public String getNombe() {
        return nombre;
    }

    public void setNombe(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public TipoMedicamento getTipo() {
        return tipo;
    }

    public void setTipo(TipoMedicamento tipo) {
        this.tipo = tipo;
    }

    public Laboratorio getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(Laboratorio laboratorio) {
        this.laboratorio = laboratorio;
    }


    
    
    
    
}
