/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package copiarmifactorial;

/**
 *
 * @author MPC
 */
public class prueba {
    public static void main(String[] args){
    int[] prueba = Factorial(5);
    System.out.print(prueba.toString());
    
    }
    
    public static int[] Factorial(int numero){
        int[] factoriales = new int[numero];
        for(int i= numero;  i>0 ;i--){
            factoriales[i-1] =  i;
        }
        return factoriales;
    }
    
}
