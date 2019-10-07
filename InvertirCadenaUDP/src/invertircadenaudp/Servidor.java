package invertircadenaudp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MPC
 */
public class Servidor implements Runnable{

    public Servidor(){
        Thread hilo = new Thread(this);
        hilo.start();
    }
    @Override
    public void run() {
        final int PUERTO = 5000;
        byte[] buffer = new byte[1024];
        int[] prueba = new int[10];
        
        try{
            DatagramSocket socketUDP = new DatagramSocket(PUERTO);
            DatagramPacket peticion = new DatagramPacket(buffer,buffer.length);
            socketUDP.receive(peticion);
            String mensaje = new String(peticion.getData());
            int puertoCliente = peticion.getPort();
            InetAddress direccion = peticion.getAddress();
            mensaje = invertirCadena(mensaje);
            buffer = mensaje.getBytes();
            System.out.print(buffer);
            DatagramPacket respuesta = new DatagramPacket(buffer,buffer.length,direccion,puertoCliente);
            socketUDP.send(respuesta);
            socketUDP.close();
        }
        catch(Exception e){
            System.out.print(e.getMessage());
        }
        

    }
    
    public String invertirCadena(String cadena){
        String cadenaInvertida=new String();
        for(int i = (cadena.length()-1); i>=0; i--){
            cadenaInvertida = cadenaInvertida+ cadena.charAt(i);
        }
        return cadenaInvertida;
    }
    public static void main(String[] args){
        Servidor servidor = new Servidor();
    }
    
    
}
