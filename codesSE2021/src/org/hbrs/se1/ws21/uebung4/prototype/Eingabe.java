package org.hbrs.se1.ws21.uebung4.prototype;


import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Eingabe {
    Container con;
    public Eingabe(Container c){ con = c;}
    public void startEingabe() throws ContainerException, Exception {

        String strInput = null;

        // Initialisierung des Eingabe-View
        Scanner scanner = new Scanner( System.in );

        // Ausgabe eines Texts zur Begruessung
        System.out.println("Bei Hilfe geben Sie: 'help' ein. ");
        System.out.println("für store/enter, bitte in diesem Format eingeben-> Integer: id; String: Nachname; String: Vorname; String: Rolle im Unternehmen; String: Abteilung(optional); String: Expertise + Integer: ExpertisenBewertung (bis zu drei mal)" );
        System.out.println("Alle einzelnen Komponenten mit einem Leerzeichen trennen");

        while ( true ) {

            System.out.print( "> "  );

            strInput = scanner.nextLine();

            // Extrahiert ein Array aus der Eingabe
            String[] strings = strInput.split(" ");

            // 	Falls 'help' eingegeben wurde, werden alle Befehle ausgedruckt
            if ( strings[0].equals("help") ) {
                System.out.println("Folgende Befehle stehen zur Verfuegung: help, dump, enter, store, load, search und exit");
            }
            // Auswahl der bisher implementierten Befehle:
            else if ( strings[0].equals("dump") ) {
                startAusgabe();
            }
            // Auswahl der bisher implementierten Befehle:
            else if ( strings[0].equals("enter") && strings[5] != null) {
                erstelle(strings);
            }

            else if (  strings[0].equals("store")  ) {
                erstelle(strings);
                con.store();
            }
            else if ( strings[0].equals("search")){
                if(strings[1] != null) {
                    for (Employee e : con.getCurrentList()) {
                        if (e.getExpertise().contains(strings[1])) {
                            System.out.println(e);
                        }
                    }
                }
            }
            else if( strings[0].equals("load")){
                con.load();
                System.out.println("Erfolgreich die Datei abgelesen");
            }
            else if ( strings[0].equals("exit")){ return;}
            else{ System.out.println("inkorrekte Eingabe, folgen sie den Anweisungen oder geben sie 'help' ein.");}

        } // Ende der Schleife
    }
    private void erstelle(String[] strings){
            if(strings.length >= 6 && isNumeric(strings[1])) {
                Employee emp = new Employee();

                if (!Utility.hasNumbers(strings[2])) {
                    emp.setName(strings[2]);
                } else {
                    emp.setName("ungültige Eingabe für Namen");
                }

                if (!Utility.hasNumbers(strings[3])) {
                    emp.setVorname(strings[3]);
                } else {
                    emp.setVorname("ungültige Eingabe für Vornamen");
                }

                if (!Utility.hasNumbers(strings[4])) {
                    emp.setRolle(strings[4]);
                } else {
                    emp.setRolle("ungültige Eingabe für Rolle");
                }

                int i = 5;
                if (!isNumeric(strings[i + 1])) {
                    if (!Utility.hasNumbers(strings[i])) {
                        emp.setAbteilung(strings[i]);
                        i++;
                    } else {
                        emp.setAbteilung("Ungültige Abteilung");
                        i++;
                    }
                }
                while (i + 2 <= strings.length) {
                    if (!Utility.hasNumbers(strings[i])) {
                        if ((Integer.parseInt(strings[i + 1]) <= 3) && (Integer.parseInt(strings[i + 1]) > 0)) {
                            emp.setExpertise(strings[i], Integer.valueOf(strings[i + 1]));
                            i += 2;
                        } else {
                            emp.setExpertise(strings[i], 0);
                            i += 2;
                        }
                    } else {

                        if ((Integer.parseInt(strings[i + 1]) <= 3) && (Integer.parseInt(strings[i + 1]) > 0)) {
                            emp.setExpertise("ungültige Expertise", Integer.valueOf(strings[i + 1]));
                            i += 2;
                        } else {
                            emp.setExpertise("ungültige Expertise", 0);
                            i += 2;
                        }
                    }
                }
                try {
                    emp.setPid(Integer.valueOf(strings[1]));
                    Utility.addEmployee(con, emp);
                    System.out.println("Objekt erfolgreich gespeichert");
                } catch (Exception e) {
                    System.out.println("Id ist keine unterstützte Nummer");
                }
            } else{ System.out.println("Die Eingabe war zu kurz, oder der erste Wert ist keine Zahl. bitte auf den Format achten");}

    }

    private boolean isNumeric(String s){
        try{
            Integer i = Integer.valueOf(s);
            return true;
        }catch(Exception e){
            return false;
        }
    }

    /**
     * Diese Methode realisiert die Ausgabe. Sie funktioniert also benutze ich sie :-)
     */
    public void startAusgabe() {
            if(con.getCurrentList().size() != 0) {
                Collections.sort(con.getCurrentList());
                for (Employee employee : con.getCurrentList()) {
                    System.out.println(employee.toString());
                }
            }else{System.out.println("Liste konnte nicht ausgegeben werden. Ist die Liste etwa leer?");}
    }
}
