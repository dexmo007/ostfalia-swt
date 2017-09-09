package de.ostfalia.swt.aufgabe3;

import java.math.BigDecimal;
import java.util.EventObject;

/**
 * Created by henri on 11/5/2016.
 */
public class EstateUnitChangedEvent extends EventObject {
    private ApartmentOrTrade oldApartmentOrTrade;
    private BigDecimal oldRental;
    private Double oldArea;

    public EstateUnitChangedEvent(Object source, ApartmentOrTrade oldApartmentOrTrade) {
        super(source);
        this.oldApartmentOrTrade = oldApartmentOrTrade;
    }

    public EstateUnitChangedEvent(Object source, BigDecimal oldRental) {
        super(source);
        this.oldRental = oldRental;
    }

    public EstateUnitChangedEvent(Object source, Double oldArea) {
        super(source);
        this.oldArea = oldArea;
    }

    public ApartmentOrTrade getOldApartmentOrTrade() {
        return oldApartmentOrTrade;
    }

    public BigDecimal getOldRental() {
        return oldRental;
    }

    public Double getOldArea() {
        return oldArea;
    }

    @Override
    public String toString() {
        //todo
        return super.toString();
    }
}
