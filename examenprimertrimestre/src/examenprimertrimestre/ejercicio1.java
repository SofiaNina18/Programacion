package examenprimertrimestre;

import java.util.Scanner;

public class ejercicio1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int [] numeros= new int [1000];
        int contador = 0;
        
        System.out.println("Introduce números enteros. Introduce 0 para finalizar.");
        
        while (true) {
            System.out.print("> ");
            int n = sc.nextInt(); 
            if (n == 0) break;
            numeros[contador] = n;
            contador++;}
            
            int [] secuencia = {4,5,6,7};
            int repeticiones=0;
            
            for (int i=0; i<=contador-4; i++) {
            	if (numeros[i] == 4 && 
            		numeros[i+1] == 5 && 
            		numeros[i+2] == 6 && 
            		numeros[i+3] == 7) 
            	{repeticiones++;}
            }
            System.out.println("La secuencia '4, 5, 6, 7' se repitió: " + repeticiones + " veces.");
        }
    }
       

