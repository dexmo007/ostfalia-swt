package de.ostfalia.swt.aufgabe2;

import java.math.BigDecimal;

/**
 * Vermietungseinheit.
 */
public class Vermietungseinheit {

    private WohnungOderGewerbe wog;
    private double flaeche;
    BigDecimal miete;

    public Vermietungseinheit(WohnungOderGewerbe wog, double flaeche, BigDecimal miete) {
        this.wog = wog;
        this.flaeche = flaeche;
        this.miete = miete;
    }

    public WohnungOderGewerbe getWog() {
        return wog;
    }

    public void setWog(WohnungOderGewerbe wog) {
        this.wog = wog;
    }

    public double getFlaeche() {
        return flaeche;
    }

    public void setFlaeche(double flaeche) {
        this.flaeche = flaeche;
    }

    public BigDecimal getMiete() {
        return miete;
    }

    public void setMiete(BigDecimal miete) {
        this.miete = miete;
    }
}
