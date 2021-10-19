package org.hbrs.se1.ws21.uebung2;

public class ContainerException extends Exception{
    public ContainerException(){
        super("Das Member-Objekt mit der ID ist bereits vorhanden!");
    }
}
