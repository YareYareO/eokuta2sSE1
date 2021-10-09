package org.hbrs.se1.ws21.uebung1.control;

import org.hbrs.se1.ws21.uebung1.control.GermanTranslator;

public class TFactory {
    public static GermanTranslator createGTranslator(){
        return new GermanTranslator();
    }
}
