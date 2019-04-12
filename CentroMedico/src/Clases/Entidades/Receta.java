package Clases.Entidades;

import Clase.Clinica.Medicamento;
import java.sql.Date;
import java.util.ArrayList;

public class Receta {
    private int code;
    private Date fecha;
    private ArrayList<Medicamento> medicina;
    private ArrayList<Integer> cantidad;
    private ArrayList<Integer> vecesPorDia;
    private ArrayList<Date> fechaIni;
    private ArrayList<Date> fechaFin;

    public Receta() {
        this.medicina=new ArrayList<>();
        this.cantidad=new ArrayList<>();
        this.fechaFin=new ArrayList<>();
        this.cantidad=new ArrayList<>();
        this.fechaIni=new ArrayList<>(); 
        this.vecesPorDia=new ArrayList<>();
    }
    
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
    
    
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public ArrayList<Medicamento> getMedicina() {
        return medicina;
    }

    public void setMedicina(ArrayList<Medicamento> medicina) {
        this.medicina = medicina;
    }

    public ArrayList<Integer> getCantidad() {
        return cantidad;
    }

    public void setCantidad(ArrayList<Integer> cantidad) {
        this.cantidad = cantidad;
    }

    public ArrayList<Integer> getVecesPorDia() {
        return vecesPorDia;
    }

    public void setVecesPorDia(ArrayList<Integer> vecesPorDia) {
        this.vecesPorDia = vecesPorDia;
    }

    public ArrayList<Date> getFechaIni() {
        return fechaIni;
    }

    public void setFechaIni(ArrayList<Date> fechaIni) {
        this.fechaIni = fechaIni;
    }

    public ArrayList<Date> getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(ArrayList<Date> fechaFin) {
        this.fechaFin = fechaFin;
    }



    
}
