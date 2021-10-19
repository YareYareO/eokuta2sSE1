package org.hbrs.se1.ws21.uebung2;

public class Item implements Member{

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
