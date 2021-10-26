package org.hbrs.se1.ws21.uebung3.persistence;

import java.util.List;

public class Client {
    private Container c = Container.createContainer();
    PersistenceStrategy<Member> strat = null;

    public Container getC(){ return c;}

    public void addMembers(Integer wieviele) throws ContainerException {
        if(wieviele > 0){
            for (int i=0;i<wieviele;i++){
                c.addMember(new Item(i+1));
            }
        }
    }
    public void view(){
        MemberView.dump(c.getCurrentList());
    }
    public void storeThat(){
        try {
            c.store();
        } catch (PersistenceException e) {
            e.printStackTrace();
        }
    }
    public void loadThat(){
        try {
            c.load();
        } catch (PersistenceException e) {
            e.printStackTrace();
        }
    }
}
