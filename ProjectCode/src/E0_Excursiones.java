package modelo;

import java.time.LocalDate;

public class E0_Excursiones {
    private String codigo;
    private String descripcion;
    private LocalDate fecha;
    private int numDias;
    private double precio;

    

    public Excursiones(String codigo, String descripcion, LocalDate fecha, int numDias, double precio) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.numDias = numDias;
        this.precio = precio;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public int getNumDias() {
        return numDias;
    }

    public void setNumDias(int numDias) {
        this.numDias = numDias;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return  "Codigo: " + codigo + '\n' +
                "Descripcion: " + descripcion + '\n' +
                "Fecha: " + fecha + '\n' +
                "Numero dias: " + numDias + '\n' +
                "Precio: " + precio + '\n' ;
    }
} 
}
