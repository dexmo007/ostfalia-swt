package de.ostfalia.swt.aufgabe2;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

/**
 * Immobilien-Implementierung, die die Daten in Instanzvariablen hält.
 */
public class ImmobilieGespeichert implements Immobilie {

    private List<Vermietungseinheit> einheiten = new LinkedList<>();
    private double gesamtwohnflaeche = 0.0;
    private double gesamtgewerbeflaeche = 0.0;
    private BigDecimal gesamtmieteinnahmen = BigDecimal.ZERO;

    @Override
    public int getAnzahlEinheiten() {
        return einheiten.size();
    }

    @Override
    public List<Vermietungseinheit> getEinheiten() {
        return einheiten;
    }

    @Override
    public double getGesamtwohnflaeche() {
        return gesamtwohnflaeche;
    }

    @Override
    public double getGesamtgewerbeflaeche() {
        return gesamtgewerbeflaeche;
    }

    @Override
    public BigDecimal getGesamtmieteinnahmen() {
        return gesamtmieteinnahmen;
    }

    @Override
    public void hinzufuegen(Vermietungseinheit unit) {
        if (unit.getWog() == WohnungOderGewerbe.WOHNUNG) {
            gesamtwohnflaeche += unit.getFlaeche();
        } else {
            gesamtgewerbeflaeche += unit.getFlaeche();
        }
        gesamtmieteinnahmen = gesamtmieteinnahmen.add(unit.getMiete());
        einheiten.add(unit);
    }
}
