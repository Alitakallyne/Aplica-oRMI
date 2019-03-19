package com.dt.project.cliente;

import com.dt.project.rmi.InterfaceRMI;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.Scanner;

public class Cliente {

    public Cliente() {
        System.out.println("Iniciando Cliente....");
        try {
            msi = (InterfaceRMI) Naming.lookup("rmi://10.180.50.236:1010/Lista");
        } catch (Exception e) {
            System.out.println("Falhou a iniciação do cliente.\n" + e);
            System.exit(0);
        }
    }

    public String totalDoVetor(int vet[]) throws RemoteException {
        return msi.vetores(vet);
    }

    public static void main(String[] args) {
        Cliente c = new Cliente();
        Scanner s = new Scanner(System.in);
        int sair, n, op;
        try {
            do {
                System.out.println("Informe Quantos numeros deseja armazenar: ");
                n = s.nextInt();
                int[] vet = new int[n];

                System.out.println("1 - Para Armazenar Randomicamente\n2 - Para Setar valores: ");
                op = s.nextInt();
                if (op == 1) {
                    for (int i = 0; i < n; i++) {
                        vet[i] = (int) (Math.random() * 100);
                    }

                    System.out.println("\n-------------------NUMEROS ARMAZENADOS---------------------\n");
                    for (int i = 0; i < n; i++) {
                        System.out.println("[" + vet[i] + "]");
                    }
                    System.out.println("\n-------------------NUMEROS ARMAZENADOS ORDENADOS---------------------\n");
                    System.out.println("[" + c.totalDoVetor(vet) + "]");
                } else if (op == 2) {
                    for (int i = 0; i < n; i++) {
                        System.out.println("Informe o valor a ser armazenado: ");
                        vet[i] = s.nextInt();
                    }

                    System.out.println("\n-------------------NUMEROS ARMAZENADOS---------------------\n");
                    for (int i = 0; i < n; i++) {
                        System.out.println("[" + vet[i] + "]");
                    }
                    System.out.println("\n-------------------NUMEROS ARMAZENADOS ORDENADOS---------------------\n");
                    System.out.println("[" + c.totalDoVetor(vet) + "]");
                }else{
                    System.out.println("Opção escolhida Invalida");
                }

                do {
                    System.out.println("1 - Para armazenar Outro vetor\n2 - Para sair\n");
                    sair = s.nextInt();
                } while (sair < 1 || sair > 2);

            } while (sair != 2);

        } catch (Exception e) {
            System.out.println("Excepção  durante chamadas remotas: " + e);
        }
    }
    private InterfaceRMI msi;

}
