
package com.dt.project.cliente;

import com.dt.project.rmi.InterfaceRMI;
import java.rmi.Naming;
import java.rmi.RemoteException;


public class Cliente {
    public Cliente(){
        System.out.println("Iniciando Cliente....");
        try {
            msi = (InterfaceRMI) Naming.lookup("rmi://10.180.50.236:1010/Lista");
        } catch (Exception e) {
            System.out.println("Falhou a iniciação do cliente.\n"+e);
            System.exit(0);
        }
    }
    
    public String totalDoVetor(int vet[]) throws RemoteException{
        return msi.vetores(vet);
    }
    
    public static void main(String[] args) {
        Cliente c  = new Cliente();
        int[] vet = new int[10];
        try {
            
            for(int i = 0; i <10 ; i++){
                vet[i] = (int) (Math.random()*10);
            }
            System.out.println("A soma é: "+c.totalDoVetor(vet));
        } catch (Exception e) {
            System.out.println("Excepção  durante chamadas remotas: "+e);
        }
    }
    private InterfaceRMI msi; 
   
}