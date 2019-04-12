package Clases.Entidades;

import Clase.Clinica.MuestraPaciente;
import Clases.more.Factura;
import java.util.ArrayList;

public class Cliente extends Persona{
    private String grupoSanguineo;
    private ArrayList < HistorialMedico> historialMedico;
    private ArrayList <Receta> recetas;
    private ArrayList<Factura> facturas;
    private ArrayList<MuestraPaciente> muestras;
    public Cliente() {
        recetas=new ArrayList<>();
        facturas=new ArrayList<>();
        muestras=new ArrayList<>();
        historialMedico=new ArrayList<>();
    }
    public String getGrupoSanguineo() {
        return grupoSanguineo;
    }
    
    
    public void actualizarReceta(){
        for(HistorialMedico his:historialMedico){
            recetas.add(his.getReceta());
        }
    }

    public ArrayList<HistorialMedico> getHistorialMedico() {
        return historialMedico;
    }

    public void setHistorialMedico(ArrayList<HistorialMedico> historialMedico) {
        this.historialMedico = historialMedico;
    }
    
    
    public void setGrupoSanguineo(String grupoSanguineo) {
        this.grupoSanguineo = grupoSanguineo;
    }

    

    public ArrayList<Receta> getRecetas() {
        return recetas;
    }

    public void setRecetas(ArrayList<Receta> recetas) {
        this.recetas = recetas;
    }

    public ArrayList<Factura> getFacturas() {
        return facturas;
    }

    public void setFacturas(ArrayList<Factura> facturas) {
        this.facturas = facturas;
    }

    public ArrayList<MuestraPaciente> getMuestras() {
        return muestras;
    }

    public void setMuestras(ArrayList<MuestraPaciente> muestras) {
        this.muestras = muestras;
    }

    @Override
    public String toString() {
        return "Cliente{" + "grupoSanguineo=" + grupoSanguineo + ", historialMedico=" + historialMedico + ", recetas=" + recetas + ", facturas=" + facturas + ", muestras=" + muestras + '}';
    }
       
    
}
