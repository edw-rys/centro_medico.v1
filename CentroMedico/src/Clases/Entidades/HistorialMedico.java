package Clases.Entidades;

import Clase.Clinica.MuestraPaciente;
import java.sql.Date;

public class HistorialMedico {
    private String sintomas;
    private Doctor doctor;
    private Receta receta;
    private MuestraPaciente muestra;
    private Date fehca;
    public HistorialMedico() {
    }

    public HistorialMedico(String sintomas, Doctor doctor, Receta receta, MuestraPaciente muestra) {
        this.sintomas = sintomas;
        this.doctor = doctor;
        this.receta = receta;
        this.muestra = muestra;
    }

    public String getSintomas() {
        return sintomas;
    }

    public void setSintomas(String sintomas) {
        this.sintomas = sintomas;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Receta getReceta() {
        return receta;
    }

    public void setReceta(Receta receta) {
        this.receta = receta;
    }

    public MuestraPaciente getMuestra() {
        return muestra;
    }

    public void setMuestra(MuestraPaciente muestra) {
        this.muestra = muestra;
    }

    public Date getFehca() {
        return fehca;
    }

    public void setFehca(Date fehca) {
        this.fehca = fehca;
    }

    @Override
    public String toString() {
        return "HistorialMedico{" + "sintomas=" + sintomas + ", doctor=" + doctor + ", receta=" + receta + ", muestra=" + muestra + ", fehca=" + fehca + '}';
    }
    
    
}


