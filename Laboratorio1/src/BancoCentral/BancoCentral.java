/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BancoCentral;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import src.Dolar;

/**
 *
 * @author MPC
 */
public interface BancoCentral extends Remote{
    double cotizarDolar(String fecha) throws RemoteException;
}
