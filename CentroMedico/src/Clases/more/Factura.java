package Clases.more;

import Clase.Clinica.Procedimiento;
import java.sql.Date;
import java.util.ArrayList;

public class Factura {
    private int numero;
    private Date fecha;
    private double subtotal;
    private double iva;
    private double total;
    private String ciCliente;
    private ArrayList<DetalleFactura> detalle;
    private ArrayList<Procedimiento> procedimiento;
    private double precioConsulta;
    private String descripcionConsulta;
    
    public Factura() {
    }

    public Factura(int numero, Date fecha, double sub,double iva, double total, String ciCliente) {
        this.numero = numero;
        this.fecha = fecha;
        this.subtotal=sub;
        this.iva = iva;
        this.total = total;
        this.ciCliente = ciCliente;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
    

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getCiCliente() {
        return ciCliente;
    }

    public void setCiCliente(String ciCliente) {
        this.ciCliente = ciCliente;
    }

    public ArrayList<DetalleFactura> getDetalle() {
        return detalle;
    }

    public void setDetalle(ArrayList<DetalleFactura> detalle) {
        this.detalle = detalle;
    }

    public ArrayList<Procedimiento> getProcedimiento() {
        return procedimiento;
    }

    public void setProcedimiento(ArrayList<Procedimiento> procedimiento) {
        this.procedimiento = procedimiento;
    }

    

    public double getPrecioConsulta() {
        return precioConsulta;
    }

    public void setPrecioConsulta(double precioConsulta) {
        this.precioConsulta = precioConsulta;
    }

    public String getDescripcionConsulta() {
        return descripcionConsulta;
    }

    public void setDescripcionConsulta(String descripcionConsulta) {
        this.descripcionConsulta = descripcionConsulta;
    }
    
    
    
}
