
package com.dt.project.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface InterfaceRMI extends Remote {
   public String vetores(int vet[], String v) throws RemoteException;
}
