
package Clases.more;

import Clase.Clinica.Medicamento;
import java.sql.Date;

public class StockMedicina{
    private Medicamento medicina;
    private int cantidad;
    private Date fecha;
    private int estado;
    public StockMedicina() {
    }
    
    public StockMedicina(Medicamento medicina, int cantidad, Date fecha, int estado) {
        this.medicina = medicina;
        this.cantidad = cantidad;
        this.fecha = fecha;
        this.estado=estado;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
    
    
    
    public Medicamento getMedicina() {
        return medicina;
    }

    public void setMedicina(Medicamento medicina) {
        this.medicina = medicina;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    
    
}

