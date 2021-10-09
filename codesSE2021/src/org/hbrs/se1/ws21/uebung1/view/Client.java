package org.hbrs.se1.ws21.uebung1.view;

import org.hbrs.se1.ws21.uebung1.control.TFactory;

public class Client {
	/*public static void main(String[] args) {
		Client kevin = new Client();
		kevin.display(2);
		kevin.display(-2);
		kevin.display(0);
		kevin.display(1);
		kevin.display(22);
		kevin.display(10);
	} */

	/*
	 * Methode zur Ausgabe einer Zahl auf der Console
	 */
	public void display( int aNumber ){
		// In dieser Methode soll die Methode translateNumber 
		// mit dem übergegebenen Wert der Variable aNumber 
		// aufgerufen werden.
		//
		// Strenge Implementierung gegen das Interface Translator gewuenscht!


		// derNeueTranslator.translatenumber()
		TFactory.createGTranslator().translateNumber(aNumber);
		//system.outprint ist im germantranslator. dann habe ich mit dem try und catch eine "entweder oder" situation, für mich übersichtlicher

	}
}



