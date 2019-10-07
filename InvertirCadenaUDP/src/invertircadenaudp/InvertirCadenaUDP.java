/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package invertircadenaudp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

/**
 *
 * @author MPC
 */
public class InvertirCadenaUDP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        mandarCadena();
    }
      
       public static  String pedirCadena(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Introdusca una cadena a invertir\n");
        String cadena = sc.nextLine();
        return cadena;
        
    }
    public static void mandarCadena(){
        final int PUERTO = 5000;
        byte[] buffer = new byte[1024];
        try{
            InetAddress direccion = InetAddress.getByName("localhost");
            DatagramSocket socketUDP = new DatagramSocket();
            String mensaje = pedirCadena();
            buffer = mensaje.getBytes();
            DatagramPacket paqueteEnvio = new DatagramPacket(buffer,buffer.length,direccion,PUERTO);
            socketUDP.send(paqueteEnvio);
            DatagramPacket peticion = new DatagramPacket(buffer,buffer.length);
            socketUDP.receive(peticion);
            mensaje = new String(peticion.getData());
            System.out.print(mensaje);
            socketUDP.close();
        }catch(Exception e){
            System.out.print(e.getMessage());
        }
    }
    
}
