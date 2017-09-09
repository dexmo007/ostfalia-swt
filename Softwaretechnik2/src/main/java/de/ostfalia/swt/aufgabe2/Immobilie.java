package de.ostfalia.swt.aufgabe2;

import java.math.BigDecimal;
import java.util.List;

/**
 * Schnittstelle für Immobilien. Eine Immobilie kann Wohn- oder Gewerbeeinheiten enthalten, siehe {@link Vermietungseinheit}. Diese werden durch {@link WohnungOderGewerbe} unterschieden.
 */
public interface Immobilie {
    /**
     * @return Anzahl der Wohn- oder Gewerbeeinheiten in dieser Immobilie
     */
    int getAnzahlEinheiten();

    /**
     * @return Liste der Wohn- und Gewerbeeinheiten dieser Immobilie
     */
    List<Vermietungseinheit> getEinheiten();

    /**
     * Gesamtwohnfläche dieser Immobilie
     *
     * @return Gesamtwohnfläche
     */
    double getGesamtwohnflaeche();

    /**
     * Gesamtgewerbefläche dieser Immobilie
     *
     * @return Gesamtgewerbefläche
     */
    double getGesamtgewerbeflaeche();

    /**
     * Monatliche Gesamtmieteinnahmen dieser Immobilie
     *
     * @return Gesamtmieteinnahmen
     */
    BigDecimal getGesamtmieteinnahmen();


    /**
     * Hinzufügen einer Mieteinheit.
     *
     * @param unit Die hinzuzufügende Mieteinheit
     */
    void hinzufuegen(Vermietungseinheit unit);

}
