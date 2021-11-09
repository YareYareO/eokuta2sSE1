package org.hbrs.se1.ws21.uebung4.prototype;

public class Utility {
    public static void addEmployee ( Container con, Employee employee ) throws ContainerException {
        if ( contains(con, employee) ) {
            ContainerException ex = new ContainerException("ID bereits vorhanden!");
            throw ex;
        }
        con.getCurrentList().add(employee);
    }
    private static boolean contains(Container con, Employee employee) {
        int ID = employee.getPid();
        for ( Employee emp : con.getCurrentList()) {
            if ( emp.getPid() == ID ) {
                return true;
            }
        }
        return false;
    }
    public static boolean hasNumbers(String s){
        for(int i = 0; i < s.length(); i++){
            if (Character.isDigit(s.charAt(i))) {
                return true;
            }
        }
        return false;
    }
    public static void setAContainersStrategy(Container c, PersistenceStrategy<Employee> p){
        c.setPS(p);
    }
}
