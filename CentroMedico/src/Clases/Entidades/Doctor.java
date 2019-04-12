package Clases.Entidades;

import Clase.Clinica.Especialidad;

public class Doctor extends Persona{
    private Especialidad especialidad;

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }
    
}
