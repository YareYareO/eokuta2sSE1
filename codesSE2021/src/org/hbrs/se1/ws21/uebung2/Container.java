package org.hbrs.se1.ws21.uebung2;
import java.util.ArrayList;

public class Container {
    ArrayList<Member> cont = new ArrayList<Member>();

    public void addMember(Member m) throws ContainerException{
        try {
            for (Member x : cont) {
                if (x.getID() == m.getID()) {
                    throw new ContainerException();
                }
            }
            cont.add(m);
        }catch(ContainerException e){
            return;
        }
    }
    public String deleteMember(Integer id){
            cont.removeIf(x -> x.getID() == id);
            return "Object: "+ id +  "erfolgreich gelöscht";
    }

    public void dump(){
        for (Member x:cont) {
            System.out.println(x);
        }
    }
    public int size(){
        return cont.size();
    }

    /*
    public static void main(String[] args) {
        ArrayList<String> cars = new ArrayList<String>();
        cars.add("Volvo");
        cars.add("BMW");
        cars.add("Ford");
        cars.add("Mazda");
        System.out.println(cars);
    } */

}
