package de.ostfalia.swt.aufgabe1;

/**
 * Fabrik für Immobilien. Konfiguration über System-Property {@code huh.ImmobilieImpl}. Mögliche Werte:
 * <ul>
 *    <li>de.ostfalia.swt.aufgabe1.ImmobilieGespeichert</li>
 *    <li>de.ostfalia.swt.aufgabe1.ImmobilieBerechnet</li>
 * </ul>
 */
public abstract class ImmobilieFactory {
    /**
     * Erzeugt eine {@link Immobilie}-Instanz.
     *
     * @return Neu erzeugte Estate-Instanz
     * @throws InstantiationException Falls Fehler beim Erzeugen der Instanz, z.B. Klasse nicht gefunden oder Property nicht gesetzt.
     */
    public static Immobilie newInstance() throws InstantiationException {
        String impl = System.getProperty("huh.ImmobilieImpl");
        if (impl == null)
            throw new InstantiationException("Property \"huh.ImmobilieImpl\" not set");

        try {
            return (Immobilie) Class.forName(impl).newInstance();
        } catch (Exception e) {
            throw new InstantiationException("Class not found");
        }
    }
}
