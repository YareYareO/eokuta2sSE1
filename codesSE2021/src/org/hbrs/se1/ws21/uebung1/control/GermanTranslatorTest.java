package org.hbrs.se1.ws21.uebung1.control;

import static org.junit.jupiter.api.Assertions.*;

class GermanTranslatorTest {

    @org.junit.jupiter.api.Test
    void translateNumber() {
        // möchte den client nicht einbinden mit der factory methode sondern nur den GTranslator benuten
        GermanTranslator germ = new GermanTranslator();
        assertEquals("drei",germ.translateNumber(3)); //ÄK 1 zwischen 1 und 10
        //exception -> rückgabe null kann man auch mit assertNotEqual("zwölf",12) zb.
        assertNull(germ.translateNumber(0)); // ÄK 2 =0
        assertNull(germ.translateNumber(-3)); // ÄK 3 kleiner als 0
        assertNull(germ.translateNumber(11)); // ÄK 4 größer als 10
    }
}