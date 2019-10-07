/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BancoCentral;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import src.Dolar;

/**
 *
 * @author MPC
 */
public class Server extends UnicastRemoteObject implements BancoCentral{
    ArrayList<Dolar> cotizaciones =  new ArrayList<Dolar>();
    public Server()throws java.rmi.RemoteException{
        super();
        cotizaciones.add(new Dolar("26-06-2019",  6.90));
        cotizaciones.add(new Dolar("27-06-2019", 6.91));
        cotizaciones.add(new Dolar("28-06-2019", 6.93));
        cotizaciones.add(new Dolar("29-06-2019", 6.92));
        cotizaciones.add(new Dolar("30-06-2019", 6.96));
        cotizaciones.add(new Dolar("26-06-2019", 6.90));
    }

    @Override
    public double cotizarDolar(String fecha) throws RemoteException {
        System.out.print(fecha+"\n");
        double respuesta = 0;
        for(Dolar dolar: cotizaciones){
            if(dolar.getFecha().equalsIgnoreCase(fecha)){
                respuesta = dolar.getPrecio();
            }
        }
        System.out.print("La cotizacion es:" + respuesta+"\n");
        return respuesta;
    }
    public static void main(String[] args){
        final int PUERTO = 1099;
        try{
            Server server;
            LocateRegistry.createRegistry(PUERTO);
            server = new Server();
            Naming.bind("cotizacion", server);
        }catch(Exception e){
            System.out.print(e.getMessage());
        }
    }
  
  }  