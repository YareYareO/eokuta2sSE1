package org.hbrs.se1.ws21.uebung2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContainerTest {

    Item n1 = new Item(1);
    Item n12 = new Item(1);
    Item n3 = new Item(3);
    Item n4 = new Item(4);
    Item n5 = new Item(5);

    @Test
    void testnr1() throws ContainerException {
        Container c1 = new Container();
        try{
        // zwei elemente mit gleicher id hochladen
            c1.addMember(n1);
            c1.addMember(n12); //n12 wird nicht eingefügt weil id auch 1 ist wie n1
            }
        catch(ContainerException c){
            c1.addMember(n3);
            c1.dump();
        }
    }

    @Test
    void testnr2() throws ContainerException{
        Container c2 = new Container();
            c2.addMember(n4);
            c2.addMember(n5);
            System.out.println(c2.deleteMember(4)); // n4 wird ordnungsgemäß entfernt
            System.out.println(c2.deleteMember(4)); // konnte nicht entfernt werden
            System.out.println(c2.deleteMember(1)); // konnte auch nicht entfernt werden
            c2.dump();  //beweis dass n4 entfernt wurde
    }

    @Test
    void testnr3() throws ContainerException{
        Container c3 = new Container();
        c3.addMember(n3);
        c3.addMember(n4);
        c3.addMember(n5);
        c3.dump();                          //dump sollte drei members zeigen
        assertEquals(3,c3.size()); //gucke ob size richtig funktioniert
        System.out.println(".");
        c3.deleteMember(4);
        c3.deleteMember(3);
        c3.addMember(n1);
        c3.dump();                          //sollte zwei member zeigen
        assertEquals(2,c3.size());
    }
}