package org.hbrs.se1.ws21.uebung4.prototype;

public class Main {

    /** Keine Testmethode aber machen sie mit der main methode was sie wollen!!! Diese startet dei eingabe und alle funktion sollten drinne sein mit Exceptions etc
     *  Ich habe keine Kraft mehr für eine Testklasse, ich bin */
    public static void main (String[] args) throws Exception {
        PersistenceStrategyStream<Employee> pss = new PersistenceStrategyStream<>();
        Container con = Container.getInstance();
        Utility.setAContainersStrategy(con, pss);
        Eingabe eingabe = new Eingabe(con);

        eingabe.startEingabe();

    }
}
