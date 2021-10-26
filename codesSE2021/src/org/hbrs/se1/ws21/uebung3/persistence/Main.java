package org.hbrs.se1.ws21.uebung3.persistence;

public class Main {
    public static void setAContainersStrategy(Container c, PersistenceStrategy<Member> p){
        c.setPS(p);
    }


}
