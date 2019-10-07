
import BancoCentral.BancoCentral;
import Reserva.ReservaInterface;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.rmi.Naming;
import java.text.SimpleDateFormat;
import java.util.Date;
import src.Cliente;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change thisS template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MPC
 */
public class prueba {
    public static void main(String[] args){
        
        try{/*object sockets
            Socket socket = new Socket("192.168.1.8",5000);
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream()); 
            Cliente cliente = new Cliente();
            cliente.setId(4);
            out.writeObject(cliente);
            cliente=(Cliente)in.readObject();
            System.out.print("El cliente con el id: " +cliente.getId()+" tiene un saldo de: " + cliente.getSaldo());*/
            /*rmi
            double precio = 0;
            BancoCentral cotizacion;
            cotizacion = (BancoCentral) Naming.lookup("rmi://localhost/cotizacion");
            precio = cotizacion.cotizarDolar("27-09-2019");
            
            System.out.print(precio);
            *//*
            SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");
            //Date date = sdf.parse("2014-05-02");
            Date date = sdf.parse("12-12-2018");
            //long milies = date.getTime();
            //System.out.print(milies);                  
            System.out.print(sdf.format(date));*/
            
            boolean puede = false;
            ReservaInterface puedeReservar;
            puedeReservar = (ReservaInterface) Naming.lookup("rmi://localhost/cotizar");
            puede = puedeReservar.reservar("26-06-2019","28-06-2019",4,"26-06-2019");
            System.out.print(puede);
        }catch(Exception e){
            System.out.print(e.getMessage());
        }
        
    }
}
