package de.ostfalia.swt.aufgabe1;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

/**
 * Created by Henrik on 10/9/2016.
 */
public class ImmobilieTest {

    private Immobilie immobilieBerechnet;
    private Immobilie immobilieGespeichert;

    @Before
    public void init() throws InstantiationException {
        System.setProperty(ImmobilieFactoryTest.PROPERTY_KEY, ImmobilieFactoryTest.IMMOBILIE_BERECHNET);
        immobilieBerechnet = ImmobilieFactory.newInstance();
        System.setProperty(ImmobilieFactoryTest.PROPERTY_KEY, ImmobilieFactoryTest.IMMOBILIE_GESPEICHERT);
        immobilieGespeichert = ImmobilieFactory.newInstance();
    }

    @Test
    public void testImmobilie() {
        testImmobilie(immobilieBerechnet);
        testImmobilie(immobilieGespeichert);
    }

    private void testImmobilie(Immobilie immobilie) {
        Vermietungseinheit unit1 = new Vermietungseinheit(WohnungOderGewerbe.WOHNUNG, 20.0, BigDecimal.valueOf(100.0));
        Vermietungseinheit unit2 = new Vermietungseinheit(WohnungOderGewerbe.GEWERBE, 30.0, BigDecimal.valueOf(200.0));
        Vermietungseinheit unit3 = new Vermietungseinheit(WohnungOderGewerbe.WOHNUNG, 50.0, BigDecimal.valueOf(800.0));
        Vermietungseinheit unit4 = new Vermietungseinheit(WohnungOderGewerbe.GEWERBE, 60.0, BigDecimal.valueOf(350.0));
        // 1 unit
        immobilie.hinzufuegen(unit1);
        assertEquals(20.0, immobilie.getGesamtwohnflaeche(), 0.00001);
        assertEquals(0.0, immobilie.getGesamtgewerbeflaeche(), 0.00001);
        assertEquals(BigDecimal.valueOf(100.0), immobilie.getGesamtmieteinnahmen());
        // 2 units
        immobilie.hinzufuegen(unit2);
        assertEquals(20.0, immobilie.getGesamtwohnflaeche(), 0.00001);
        assertEquals(30.0, immobilie.getGesamtgewerbeflaeche(), 0.00001);
        assertEquals(BigDecimal.valueOf(300.0), immobilie.getGesamtmieteinnahmen());
        // 3 units
        immobilie.hinzufuegen(unit3);
        assertEquals(70.0, immobilie.getGesamtwohnflaeche(), 0.00001);
        assertEquals(30.0, immobilie.getGesamtgewerbeflaeche(), 0.00001);
        assertEquals(BigDecimal.valueOf(1100.0), immobilie.getGesamtmieteinnahmen());
        // 4 units
        immobilie.hinzufuegen(unit4);
        assertEquals(70.0, immobilie.getGesamtwohnflaeche(), 0.00001);
        assertEquals(90.0, immobilie.getGesamtgewerbeflaeche(), 0.00001);
        assertEquals(BigDecimal.valueOf(1450.0), immobilie.getGesamtmieteinnahmen());
    }
}
