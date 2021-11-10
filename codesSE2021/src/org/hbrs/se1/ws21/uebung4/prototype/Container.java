package org.hbrs.se1.ws21.uebung4.prototype;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;



public class Container {

	private List<Employee> liste = null;

	private static Container instance = new Container();

	/** SINGLETON KRAM*/
	final static String LOCATION = "allemployees1.ser";


	public static Container getInstance() {
		return instance;
	}
	

	private Container(){
		liste = new ArrayList<Employee>();
	}
	


	/**ABSCHNITT STREAM ZUM SPEICHERN DER LISTE-------------------------------------------------------*/

	private PersistenceStrategy<Employee> pers = null;

	public void setPS(PersistenceStrategy<Employee> ps){  //so können verschiedene PS genutzt werden
		pers = ps;
	}
	public PersistenceStrategy<Employee> getPSS(){ return pers;}

	public void store() throws ContainerException, PersistenceException {
		pers.save(liste);

	}

	public void load() throws PersistenceException{
		try{
			liste = pers.load();
		}
		catch(UnsupportedOperationException u){
			System.out.println("strategymongodb ist noch nicht definiert");
		}
	}

	/** ABSCHNITT CONTAINER EIGENSCHAFTEN----------------------------------------------------*/


	public int size() {
		return liste.size();
	}

	public List<Employee> getCurrentList() {
		if(this.liste != null) {
			return this.liste;
		}
		else{return liste = new ArrayList<>();}
	}

	private Employee getEmployee(int id) {
		for ( Employee employee : liste) {
			if (id == employee.getPid() ){
				return employee;
			}
		}
		return null;
	}
}
