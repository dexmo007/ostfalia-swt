package de.ostfalia.swt.aufgabe3;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

/**
 * EstateUnit.
 */
public class EstateUnit {

    private ApartmentOrTrade aot;
    private double area;
    private BigDecimal rental;
    private Vector<EstateUnitChangedListener> listeners = new Vector<>();

    public EstateUnit(ApartmentOrTrade aot, double area, BigDecimal rental) {
        this.aot = aot;
        this.area = area;
        this.rental = rental;
    }

    public ApartmentOrTrade getAot() {
        return aot;
    }

    public void setAot(ApartmentOrTrade aot) {
        EstateUnitChangedEvent event = new EstateUnitChangedEvent(this, this.aot);
        this.aot = aot;
        listeners.forEach(l -> l.estateUnitChanged(event));
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        EstateUnitChangedEvent event = new EstateUnitChangedEvent(this, this.area);
        this.area = area;
        listeners.forEach(l -> l.estateUnitChanged(event));
    }

    public BigDecimal getRental() {
        return rental;
    }

    public void setRental(BigDecimal rental) {
        EstateUnitChangedEvent event = new EstateUnitChangedEvent(this, this.rental);
        this.rental = rental;
        listeners.forEach(l -> l.estateUnitChanged(event));
    }

    public void addEstateUnitChangedListener(EstateUnitChangedListener listener) {
        listeners.add(listener);
    }

    // todo not specified in JavaDoc but needed for estate.removeUnit(unit), right?
    public void removeEstateUnitChangedListener(EstateUnitChangedListener listener) {
        listeners.remove(listener);
    }
}
