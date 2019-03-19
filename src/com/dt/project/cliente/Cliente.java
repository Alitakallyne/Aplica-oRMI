
package com.dt.project.cliente;

import com.dt.project.rmi.InterfaceRMI;
import java.rmi.Naming;
import java.rmi.RemoteException;


public class Cliente {
    public Cliente(){
        System.out.println("Iniciando Cliente....");
        try {
            msi = (InterfaceRMI) Naming.lookup("rmi://10.180.50.236:1010/ServidorMat_1");
        } catch (Exception e) {
            System.out.println("Falhou a iniciação do cliente.\n"+e);
            System.exit(0);
        }
    }
    
    public double totalDaSoma(double a, double b) throws RemoteException{
        return msi.soma(a, b);
    }
    
    public static void main(String[] args) {
        Cliente c  = new Cliente();
        try {
            System.out.println("A soma é: "+c.totalDaSoma(2, 5));
        } catch (Exception e) {
            System.out.println("Excepção  durante chamadas remotas: "+e);
        }
    }
    private InterfaceRMI msi; 
   
}