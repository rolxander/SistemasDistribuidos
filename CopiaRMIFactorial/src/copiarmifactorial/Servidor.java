/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package copiarmifactorial;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;

/**
 *
 * @author MPC
 */
public class Servidor extends UnicastRemoteObject implements InterfazOperaciones{

    Servidor() throws java.rmi.RemoteException{
        super();
    }
    @Override
    public int[] Factorial(int numero) throws RemoteException {
          int[] factoriales = new int[numero];
        for(int i= numero;  i>1 ;i--){
            factoriales[i-1]=i;
        }
        return factoriales;
    }
    public static void main(String[] args){
        try{
            Servidor servidor;
            LocateRegistry.createRegistry(1099);
            servidor = new Servidor();
            Naming.bind("Factorial", servidor);
            
        }catch(Exception e){
            System.out.print(e.getMessage());
        }
    }
    
    
}
