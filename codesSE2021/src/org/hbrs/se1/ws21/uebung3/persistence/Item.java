package org.hbrs.se1.ws21.uebung3.persistence;

import java.io.Serializable;

public class Item implements Member, Serializable {

    private Integer ID;

    public Item(Integer i){ID = i;}
    @Override
    public Integer getID() {
        return ID;
    }
    @Override
    public String toString(){
        return "Member (ID = " + getID() + ")";
    }
}
