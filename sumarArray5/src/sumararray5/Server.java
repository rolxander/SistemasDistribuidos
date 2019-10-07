/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sumararray5;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author MPC
 */
public class Server implements Runnable {
    public Server(){
        Thread hilo = new Thread(this);
        hilo.start();
    }
    public int[] Aumentar5(int[] numeros){
        for(int n=0;n<numeros.length; n++){
            numeros[n]+=5;
        }
        return numeros;
    }
    public static void main(String[] args){
        Server server = new Server();
    }
    @Override
    public void run() {
        final int PUERTO = 5000;
        ServerSocket server = null;
        Socket sc = null;
        ObjectOutputStream out;
        ObjectInputStream in;
        try{
            server = new ServerSocket(PUERTO);
            System.out.print("servidor corriendo");
            while(true){
                sc = server.accept();
                out = new ObjectOutputStream(sc.getOutputStream());
                in = new ObjectInputStream(sc.getInputStream());
                int[] numeros;
                numeros = (int[])in.readObject();
                numeros = Aumentar5(numeros);
                out.writeObject(numeros);
                sc.close();
            }
        }
        catch(Exception e){
            System.out.print(e.getMessage());}
    }
    
    
}
