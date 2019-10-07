/*

 */
package BancoCliente;

import src.Cliente;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 *
 * @author MPC
 */
public class Server implements Runnable {
    ArrayList<Cliente> clientes = new ArrayList<Cliente>();
    public Server(){
        clientes.add( new Cliente(1,300));
        clientes.add( new Cliente(2,400));
        clientes.add( new Cliente(3,1000));
        Thread hilo =  new Thread(this);
        hilo.start();
    }
    public Cliente buscarCliente(int id,ArrayList<Cliente> clientes){
        Cliente respuesta = new Cliente(0,0);
        for(Cliente cliente : clientes){
           // System.out.print(cliente.getSaldo()+"\n");
            if(id==cliente.getId()){
                respuesta = cliente;
            }
        }
        System.out.print("el cleinte con el id: "+ respuesta.getId() + " tiene un saldo de : "+ respuesta.getSaldo()+"\n");
        return respuesta;
    }
    public static void main(String[] args){

           new Server();
    }

    @Override
    public void run() {
     
        clientes.add( new Cliente(4,4680));
        ObjectInputStream in;
        ObjectOutputStream out;
        ServerSocket server=null;
        Socket socket = null;
        final int PUERTO = 5000;
        Cliente cliente;
        try{
            server = new ServerSocket(PUERTO);
             while(true){
                 socket = server.accept();
                 out = new ObjectOutputStream(socket.getOutputStream());
                 in = new  ObjectInputStream(socket.getInputStream());
                 cliente=(Cliente)in.readObject();
                 cliente = buscarCliente(cliente.getId(), clientes);
                 out.writeObject(cliente);
                 socket.close();
            }
        }catch(Exception e){
            System.out.print(e.getMessage());
        }
       
    }
    
    
    
}
