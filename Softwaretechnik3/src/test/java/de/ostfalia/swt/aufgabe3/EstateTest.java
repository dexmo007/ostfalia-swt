package de.ostfalia.swt.aufgabe3;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

/**
 * Created by henri on 11/5/2016.
 */
public class EstateTest {

    @Test
    public void testSingleUnit() {
        EstateUnit unit = new EstateUnit(ApartmentOrTrade.APARTMENT, 20.0, BigDecimal.TEN);
        Estate estate = new Estate();
        estate.addUnit(unit);
        assertEquals(20.0, estate.getApartmentsAreaTotal(), 0.00001);
        assertEquals(0.0, estate.getTradeAreaTotal(), 0.00001);
        assertEquals(BigDecimal.TEN, estate.getRentalTotal());
        // aot changed
        unit.setAot(ApartmentOrTrade.TRADE);
        assertEquals(0.0, estate.getApartmentsAreaTotal(), 0.00001);
        assertEquals(20.0, estate.getTradeAreaTotal(), 0.00001);
        assertEquals(BigDecimal.TEN, estate.getRentalTotal());
        // rental changed
        unit.setRental(new BigDecimal("7.0"));
        assertEquals(0.0, estate.getApartmentsAreaTotal(), 0.00001);
        assertEquals(20.0, estate.getTradeAreaTotal(), 0.00001);
        assertEquals(new BigDecimal("7.0"), estate.getRentalTotal());
        // area changed
        unit.setArea(30.0);
        assertEquals(0.0, estate.getApartmentsAreaTotal(), 0.00001);
        assertEquals(30.0, estate.getTradeAreaTotal(), 0.00001);
        assertEquals(new BigDecimal("7.0"), estate.getRentalTotal());
    }
}
