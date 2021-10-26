package org.hbrs.se1.ws21.uebung3.persistence;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ContainerTest {

    /*
    * habe alles wieder in einen ordner gepackt, da es ordentlicher für mich ist
    * */

    Item n1 = new Item(1);
    Item n3 = new Item(3);
    Item n4 = new Item(4);
    Item n5 = new Item(5);

    @Test
    void testnr1() throws ContainerException {
        Container c3 = Container.createContainer();
        PersistenceStrategyStream<Member> pSS = new PersistenceStrategyStream<>();
        c3.addMember(n3);
        c3.addMember(n4);
        c3.addMember(n5);
        c3.addMember(n1);
        try {
            c3.setPS(pSS);
            c3.getPSS().openConnection();
            c3.store();
            c3.load();
            c3.getPSS().closeConnection();
        } catch (PersistenceException e) {
            e.printStackTrace();
        }
    }
    @Test
    void testOhneEchtesPS() throws ContainerException {
        Container c3 = Container.createContainer();
        c3.addMember(n3);
        c3.addMember(n4);
        c3.addMember(n5);
        // neue Liste machen

        try {
            c3.getPSS().openConnection();
            c3.store();
            c3.load();
            c3.getPSS().closeConnection();
        } catch (NullPointerException | PersistenceException n) {
            System.out.println("Nullpointer exception wurde geworfen. Test erfolgreich");
        }
    }
    @Test
    void testMitMongoDB() throws ContainerException {
        Container c3 = Container.createContainer();
        c3.addMember(n3);
        c3.addMember(n4);
        c3.addMember(n5);
        // neue Liste machen
        PersistenceStrategyMongoDB<Member> mongo = new PersistenceStrategyMongoDB<>();
        try { // wie der test mit null nur mit der Strategy, UnsupportedOperation wird erwartet weil das die methoden werfen
            c3.setPS(mongo);
            c3.getPSS().openConnection();
            c3.store();
            c3.load();
            c3.getPSS().closeConnection();
        } catch (UnsupportedOperationException | PersistenceException n) {
            System.out.println("UnsupportedOperationException wurde geworfen. Test erfolgreich");
        }
    }
    @Test
    void testMitFalscherLocation() throws ContainerException {
        Container c3 = Container.createContainer();
        c3.addMember(n3);
        c3.addMember(n4);
        c3.addMember(n5);
        // neue Liste machen
        PersistenceStrategyStream<Member> strategy = new PersistenceStrategyStream<>();

        try { // wie der test mit null nur mit der Strategy, UnsupportedOperation wird erwartet weil das die methoden werfen
            c3.setPS(strategy);
            c3.getPSS().openConnection();
            c3.store();                 //objects.ser wird beschrieben
            strategy.setLocation("keineobjects.ser");  //location wird zu keineobjects
            c3.load();                  // load initialisiert InputStream mit keineobjects.ser und sucht dort nach dateien
            c3.getPSS().closeConnection();
        } catch (Exception n) { //ich kann irgendwie keine FileNotFoundExceptions catchen
            System.out.println("****** Falls FileNotFound geworfen wurde: Test erfolgreich *******" + n.getMessage() );
        }
    }
    @Test
    void hurensohn(){
        Client kevin = new Client();
        try {
            kevin.addMembers(8);
            Main.setAContainersStrategy(kevin.getC(), new PersistenceStrategyStream<>());
            kevin.storeThat();
            kevin.loadThat();
        } catch (ContainerException e) {
            e.printStackTrace();
        }
    }
}