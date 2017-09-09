package de.ostfalia.swt.aufgabe3;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Immobilien-Implementierung, die die Daten in Instanzvariablen hält.
 */
public class Estate implements EstateUnitChangedListener {

    private List<EstateUnit> units = new LinkedList<>();
    private double apartmentsAreaTotal = 0.0;
    private double tradeAreaTotal = 0.0;
    private BigDecimal rentalTotal = BigDecimal.ZERO;

    public int getNumberOfUnits() {
        return units.size();
    }

    public List<EstateUnit> getUnits() {
        return Collections.unmodifiableList(units);
    }

    public double getApartmentsAreaTotal() {
        return apartmentsAreaTotal;
    }

    public double getTradeAreaTotal() {
        return tradeAreaTotal;
    }

    public BigDecimal getRentalTotal() {
        return rentalTotal;
    }

    public void addUnit(EstateUnit unit) {
        if (unit.getAot() == ApartmentOrTrade.APARTMENT) {
            apartmentsAreaTotal += unit.getArea();
        } else {
            tradeAreaTotal += unit.getArea();
        }
        rentalTotal = rentalTotal.add(unit.getRental());
        units.add(unit);
        unit.addEstateUnitChangedListener(this);
    }

    public void removeUnit(EstateUnit unit) throws IllegalArgumentException {
        if (units.remove(unit)) {
            if (unit.getAot() == ApartmentOrTrade.APARTMENT) {
                apartmentsAreaTotal -= unit.getArea();
            } else {
                tradeAreaTotal -= unit.getArea();
            }
            rentalTotal = rentalTotal.subtract(unit.getRental());
            unit.removeEstateUnitChangedListener(this);
        } else {
            throw new IllegalArgumentException("Unit does not exist");
        }
    }

    @Override
    public void estateUnitChanged(EstateUnitChangedEvent e) {
        EstateUnit source = (EstateUnit) e.getSource();
        if (e.getOldApartmentOrTrade() != null) {
            if (e.getOldApartmentOrTrade() == ApartmentOrTrade.APARTMENT){
                apartmentsAreaTotal -= source.getArea();
                tradeAreaTotal += source.getArea();
            } else {
                tradeAreaTotal -= source.getArea();
                apartmentsAreaTotal += source.getArea();
            }
        } else if (e.getOldArea() != null) {
            if (source.getAot() == ApartmentOrTrade.APARTMENT) {
                apartmentsAreaTotal += source.getArea() - e.getOldArea();
            } else {
                tradeAreaTotal += source.getArea() - e.getOldArea();
            }
        } else {
            rentalTotal = rentalTotal.subtract(e.getOldRental()).add(source.getRental());
        }
    }
}
