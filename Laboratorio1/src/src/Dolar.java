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
public class Dolar implements Serializable {
    double precio;
    String fecha;
    
    public Dolar(){
        precio=0;
        fecha="";
    };
    public Dolar(String fecha,double precio) {
        this.precio = precio;
        this.fecha = fecha;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getPrecio() {
        return precio;
    }

    public String getFecha() {
        return fecha;
    }
    
}
