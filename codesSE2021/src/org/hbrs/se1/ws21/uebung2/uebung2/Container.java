package org.hbrs.se1.ws21.uebung2;
import java.util.ArrayList;
import java.util.Objects;

public class Container {
    ArrayList<Member> cont = new ArrayList<Member>();

    public void addMember(Member m) throws ContainerException{
            for (Member x : cont) {
                if (Objects.equals(x.getID(), m.getID())) {
                    throw new ContainerException();
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
    public void dump(){
        for (Member x:cont) {
            System.out.println(x);
        }
    }
    public int size(){
        return cont.size();
    }
}
