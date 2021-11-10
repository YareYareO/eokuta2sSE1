package org.hbrs.se1.ws21.uebung4.prototype;

import java.io.*;
import java.util.List;

public class PersistenceStrategyStream<Employee> implements PersistenceStrategy<Employee> {


    // URL of file, in which the objects are stored
    private String location = "employees.ser";

    // Backdoor method used only for testing purposes, if the location should be changed in a Unit-Test
    // Example: Location is a directory (Streams do not like directories, so try this out ;-)!
    public void setLocation(String location) {
        this.location = location;
    }
    private ObjectOutputStream objOut = null;
    private ObjectInputStream objIn = null;
    List<Employee> newListe = null;
    @Override
    /**
     * Method for opening the connection to a stream (here: Input- and Output-Stream)
     * In case of having problems while opening the streams, leave the code in methods load
     * and save
     */
    public void openConnection() throws PersistenceException {
        try {
            FileOutputStream fileOut = new FileOutputStream(location);
            objOut = new ObjectOutputStream(fileOut);
            FileInputStream fileIn = new FileInputStream(location);
            objIn = new ObjectInputStream(fileIn);

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
    }

    @Override
    /**
     * Method for closing the connections to a stream
     */
    public void closeConnection() throws PersistenceException {
        try {
            objOut.close();
            objIn.close();
            objOut = null;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    /**
     * Method for saving a list of Member-objects to a disk (HDD)
     */
    public void save(List<Employee> member) throws PersistenceException {
        try {
            //FileOutputStream fileOut = new FileOutputStream(location);
            //objOut = new ObjectOutputStream(fileOut);
            openConnection();
            objOut.writeObject(member);
        } catch (IOException e) {
            System.out.println("save methode fehler");
            e.printStackTrace();
            closeConnection();
        }

    }

    @Override
    /**
     * Method for loading a list of Member-objects from a disk (HDD)
     * Some coding examples come for free :-)
     * Take also a look at the import statements above ;-!
     */
    public List<Employee> load() throws PersistenceException {

        try {
            if(objOut == null){
                openConnection();
            }

            //irgendwie checken ob der stream offen ist
            Object obj;
            try {
                obj = objIn.readObject();

                if (obj instanceof List<?>) {
                    newListe = (List) obj;
                }
                closeConnection();
                return newListe;
            }catch (EOFException a){ System.out.println("Konnte nicht erfolgreich geladen werden, versuche erst etwas zu speichern mit store");}

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            closeConnection();
        }
        return null;
    }
}
