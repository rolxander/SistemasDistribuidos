/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reserva;

import BancoCentral.BancoCentral;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import src.Cliente;
import src.Reserva;
        

/**
 *
 * @author MPC
 */
public class Server extends UnicastRemoteObject implements ReservaInterface{
    ArrayList<Reserva> precios = new ArrayList<Reserva>();
    public Server() throws java.rmi.RemoteException{
        super();
            precios.add(new Reserva("26-06-2019",30));
            precios.add(new Reserva("27-06-2019",25));
            precios.add(new Reserva("28-06-2019",25));
            precios.add(new Reserva("29-06-2019",35));
            precios.add(new Reserva("30-06-2019",40));

    }
    @Override
    public boolean reservar(String inicio, String fin, int id_cliente, String fecha_compra) throws RemoteException {
        try{
            Socket socket = new Socket("192.168.1.8",5000);
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream()); 
            Cliente cliente = new Cliente();
            cliente.setId(4);
            out.writeObject(cliente);
            cliente=(Cliente)in.readObject();
            double saldo = cliente.getSaldo();
            socket.close();
            double precio = 0;
            BancoCentral cotizacion;
            cotizacion = (BancoCentral) Naming.lookup("rmi://localhost/cotizacion");
            precio = cotizacion.cotizarDolar(fecha_compra);
            boolean bandera = false;
            double total=0;
            for(Reserva p : precios){
                if(inicio.equalsIgnoreCase(p.getFecha())||fin.equalsIgnoreCase(p.getFecha())){
                    bandera =!bandera;
                }
                if(bandera||(bandera==false && fin.equalsIgnoreCase(p.getFecha()))){
                    total=total + cotizar(precio,(p.getPrecio()));
                    
                }
            }
            System.out.printf("el costo de la reservacion es :+"+total+"\n");
            if(total<saldo){
                return true;
            }else{
                return false;
            }
            
            
            
        }catch(Exception e){
        
        }
        return false;
    }
    public double cotizar(double cotizacion, double cantidad){
           return cotizacion*cantidad;
    }
    public static void main(String[] args){
        try{
            Server  servidor;
            LocateRegistry.createRegistry(2000);
            servidor = new Server();
            Naming.bind("cotizar", servidor);
            }catch(Exception e){
                System.out.print(e.getMessage());
            }
    }
    
    
}
