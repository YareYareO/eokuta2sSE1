package org.hbrs.se1.ws21.uebung4.prototype;

import java.util.ArrayList;
import java.util.List;

public class Employee implements java.io.Serializable, Comparable {

    private String vorname;
    private String name;
    private Integer pid;
    private String abteilung;
    private String rolle;
    private List<String> expertise = new ArrayList<>(3);
    private Integer[] expBewertung = new Integer[3];

    public String getAbteilung() {

        if (abteilung != null) {
            return abteilung;
        }
        else{return "keine Abteilung";}
    }

    public String getRolle(){return rolle;}
    public void setRolle(String s){rolle = s;}
    public void setAbteilung(String abteilung) {
        this.abteilung = abteilung;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public void setExpertise(String exp, Integer numb){
        if(expertise.size() < 3 && numb <= 3 & numb > 0){
            expertise.add(exp);
            expBewertung[expertise.size()-1] = numb;
        }
    }
    public List<String> getExpertise(){ return expertise;}

    public Integer[] getExpertiseBewertung(){ return expBewertung;}

    public Employee(String vn,String n,Integer id,String at){
        this.setAbteilung(at);
        this.setVorname(vn);
        this.setName(n);
        this.setPid(id);
    }
    public Employee(){
    }

    public String toString(){
        String ret = "Mitarbeiter Nr:" + getPid() + " ; " +  getName() + ", " + getVorname() + "; Rolle im Unternehmen: "+ getRolle() +  "; Abteilung: " + getAbteilung() +"; ";

        return (ret + getExpBew());
    }
    private String getExpBew(){
        String ret = "Expertisen: ";
        for (String s: getExpertise()){
            ret += s + ", Bewertet mit: " + getExpertiseBewertung()[getExpertise().indexOf(s)] + "; ";
        }
        return ret;
    }

    @Override
    public int compareTo(Object o) {
        return 0; // Werte: 0, 1, -1 --> Pid vergleichen!
    }
}

