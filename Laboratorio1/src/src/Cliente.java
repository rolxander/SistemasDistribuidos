package src;

import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MPC
 */
public class Cliente implements Serializable{

    public int getId() {
        return id;
    }
    public float getSaldo() {
        return saldo;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }
    int id;
    float saldo;

    public Cliente(int id, float saldo) {
        this.id = id;
        this.saldo = saldo;
    }
    public Cliente(){
        id=0;
        saldo=0;
    }
}
