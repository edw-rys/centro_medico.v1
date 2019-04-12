package Clases.more;

import Clase.Clinica.Medicamento;

public class DetalleFactura {
    private int id;
    private int cantidadProducto;
    private double precio;
    private Medicamento medicina;
    private double total;
    public DetalleFactura(int id, int cantidadProducto, double precio, Medicamento medicina) {
        this.id = id;
        this.cantidadProducto = cantidadProducto;
        this.precio = precio;
        this.medicina = medicina;
        
    }

    public DetalleFactura(int cantidadProducto, double precio, Medicamento medicina, double total) {
        this.cantidadProducto = cantidadProducto;
        this.precio = precio;
        this.medicina = medicina;
        this.total = total;
    }
    
    public DetalleFactura() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(int cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Medicamento getMedicina() {
        return medicina;
    }

    public void setMedicina(Medicamento medicina) {
        this.medicina = medicina;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    

    public void calcularTotal(){
        this.total=this.cantidadProducto*this.precio;
    }
    
}
