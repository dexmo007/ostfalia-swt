package de.ostfalia.swt.aufgabe1;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

/**
 * Immobilien-Implementierung, die die Daten durch Iteration über die Wohneinheiten berechnet.
 */
public class ImmobilieBerechnet implements Immobilie {

    private List<Vermietungseinheit> einheiten = new LinkedList<>();

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
        return einheiten.parallelStream()
                .filter(unit -> unit.getWog() == WohnungOderGewerbe.WOHNUNG)
                .mapToDouble(Vermietungseinheit::getFlaeche)
                .sum();
    }

    @Override
    public double getGesamtgewerbeflaeche() {
        return einheiten.parallelStream()
                .filter(unit -> unit.getWog() == WohnungOderGewerbe.GEWERBE)
                .mapToDouble(Vermietungseinheit::getFlaeche)
                .sum();
    }

    @Override
    public BigDecimal getGesamtmieteinnahmen() {
        return einheiten.parallelStream()
                .map(unit -> unit.getMiete())
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    @Override
    public void hinzufuegen(Vermietungseinheit unit) {
        einheiten.add(unit);
    }
}
