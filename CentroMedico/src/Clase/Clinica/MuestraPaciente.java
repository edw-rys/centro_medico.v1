package Clase.Clinica;

public class MuestraPaciente {
    private double peso;
    private double estatura;
    private int presion;
 
    public MuestraPaciente(double peso, double estatura, int presion) {
        this.peso = peso;
        this.estatura = estatura;
        this.presion = presion;
    }

    public MuestraPaciente() {
    }

    
    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getEstatura() {
        return estatura;
    }

    public void setEstatura(double estatura) {
        this.estatura = estatura;
    }

    public int getPresion() {
        return presion;
    }

    public void setPresion(int presion) {
        this.presion = presion;
    }

    @Override
    public String toString() {
        return "MuestraPaciente{" + "peso=" + peso + ", estatura=" + estatura + ", presion=" + presion + '}';
    }
    
    
    
}
