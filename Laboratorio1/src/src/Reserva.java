/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import java.io.Serializable;

/**
 *
 * @author MPC
 */
public class Reserva implements Serializable{
    private String fecha;
    private double precio;
    public Reserva() {
        this.fecha ="";
        this.precio = 0;
    }
    public Reserva(String fecha, double precio) {
        this.fecha = fecha;
        this.precio = precio;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getFecha() {
        return fecha;
    }

    public double getPrecio() {
        return precio;
    }
    
    
}
