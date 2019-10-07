/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sumararray5;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author MPC
 */
public class SumarArray5 {

    /**
     * @param args the command line arguments
     * 
     */
    public static void mostrarNumeros(int[] numeros){
        for(int n : numeros){
            System.out.print(n);
            System.out.print("\n");
        }
    }
    public static int[]  pedirNumeros(){
        int[] numeros = new int[5];
        Scanner sc = new Scanner(System.in);
        System.out.print("Introdusca 5 numeros\n");
        for(int i=0;i<5;i++){
            numeros[i] = sc.nextInt();
        }
        
        return numeros;
    }
    public static int[] mandarNumeros(int[] numeros){
        final String HOST= "192.168.1.8";
        final int PORT=5000;
        ObjectOutputStream out;
        ObjectInputStream in;
        try{
            Socket sc = new Socket(HOST,PORT);
            out = new ObjectOutputStream(sc.getOutputStream());
            in = new ObjectInputStream(sc.getInputStream());
            out.writeObject(numeros);
            numeros = (int[])in.readObject();
            return numeros;
        }catch(Exception e){
            System.out.print(e.getMessage());}
        return null;
    }
    public static void main(String[] args) {
        int[] numeros;
        numeros=pedirNumeros();
        numeros = mandarNumeros(numeros);
        mostrarNumeros(numeros);
    }
    
}
