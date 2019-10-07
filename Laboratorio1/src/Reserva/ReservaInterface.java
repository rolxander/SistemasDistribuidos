/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reserva;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author MPC
 */
public interface ReservaInterface extends Remote {
    boolean reservar(String inicio,String fin,int id_cliente,String fecha_compra)throws RemoteException;
}
