/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package copiarmifactorial;

import java.rmi.Naming;
import java.util.Scanner;

/**
 *
 * @author MPC
 */
public class Cliente {
    public static void main(String[] args){
        InterfazOperaciones factorial;
        int numero;
        int numeros[] = new int[5];
        Scanner sc = new Scanner(System.in);
        
        try{
            factorial = (InterfazOperaciones) Naming.lookup("rmi://localhost/Factorial");
            System.out.print("Introdusca el numero");
            numero = sc.nextInt();
            numeros = factorial.Factorial(numero);
            for(int n: numeros){
                System.out.print(n);
            }
        }catch(Exception e){
            e.getMessage();
        }
    }
}
