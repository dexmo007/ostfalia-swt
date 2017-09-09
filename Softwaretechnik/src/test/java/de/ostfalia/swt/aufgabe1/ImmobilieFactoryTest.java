package de.ostfalia.swt.aufgabe1;

import de.ostfalia.swt.aufgabe1.ImmobilieBerechnet;
import de.ostfalia.swt.aufgabe1.ImmobilieFactory;
import de.ostfalia.swt.aufgabe1.ImmobilieGespeichert;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by Henrik on 10/9/2016.
 */
public class ImmobilieFactoryTest {

    public static final String PROPERTY_KEY = "huh.ImmobilieImpl";
    public static final String IMMOBILIE_BERECHNET = "de.ostfalia.swt.aufgabe1.ImmobilieBerechnet";
    public static final String IMMOBILIE_GESPEICHERT = "de.ostfalia.swt.aufgabe1.ImmobilieGespeichert";

    @Test
    public void testNewInstance() throws InstantiationException {
        System.setProperty(PROPERTY_KEY, IMMOBILIE_BERECHNET);
        assertTrue(ImmobilieFactory.newInstance() instanceof ImmobilieBerechnet);

        System.setProperty(PROPERTY_KEY, IMMOBILIE_GESPEICHERT);
        assertTrue(ImmobilieFactory.newInstance() instanceof ImmobilieGespeichert);
    }

    @Test(expected = InstantiationException.class)
    public void testNewInstancePropertyNull() throws InstantiationException {
        System.clearProperty(PROPERTY_KEY);
        ImmobilieFactory.newInstance();
    }

    @Test(expected = InstantiationException.class)
    public void testNewInstanceClassNotFound() throws InstantiationException {
        System.setProperty(PROPERTY_KEY, "BULLSHIT");
        ImmobilieFactory.newInstance();
    }

}
