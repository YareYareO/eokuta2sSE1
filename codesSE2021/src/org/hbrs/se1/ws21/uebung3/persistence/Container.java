package org.hbrs.se1.ws21.uebung3.persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Container {
    private PersistenceStrategy<Member> pers = null;

    public void setPS(PersistenceStrategy<Member> ps){  //so können verschiedene PS genutzt werden
        pers = ps;
    }

    private static boolean doesAContainerAlreadyExist = false; //zeigt ob in der runtime schonmal ein container erstellt wurde. in der testklasse muss man so jeden test einzeln machen

    public static Container createContainer() {
        if(!doesAContainerAlreadyExist){  //falls noch kein objekt erstellt wurde
            doesAContainerAlreadyExist=true;
            return new Container();  //returne ein Objekt
        }
        else{
            System.out.println("Ein Container wurde schon erstellt.");
            throw new UnsupportedOperationException();
        }
    }
    private Container(){} //private gemacht also muss jeder Container durch createContainer() erstellt werden

    List<Member> cont = new ArrayList<Member>();


    public void addMember(Member m) throws ContainerException {
            for (Member x : cont) {
                if (Objects.equals(x.getID(), m.getID())) {
                    throw new ContainerException(m.getID());
                }
            }
            cont.add(m);
    }
    public String deleteMember(Integer id){
        String retID = id + " wurde nicht";
        for (Member m: cont) {
            if(Objects.equals(m.getID(), id)){
                cont.remove(m);
                retID = String.valueOf(id);
            }
        }
        return "Object: "+ retID +  " erfolgreich gelöscht";
    }

    public List<Member> getCurrentList(){
        return cont;
    }
    public int size(){
        return cont.size();
    }

    public void store() throws PersistenceException{
        pers.save(cont);       //PSS schreibt die aktuelle List in den Stream
    }
    public void load() throws PersistenceException{
        try{
        cont = pers.load();}
        catch(UnsupportedOperationException u){
            System.out.println("strategymongodb ist noch nicht definiert");
        }
    }

    public PersistenceStrategy<Member> getPSS(){ return pers;}
}
