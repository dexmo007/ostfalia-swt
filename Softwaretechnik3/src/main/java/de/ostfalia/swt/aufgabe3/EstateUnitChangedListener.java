package de.ostfalia.swt.aufgabe3;

import java.util.EventListener;

/**
 * Created by henri on 11/5/2016.
 */
public interface EstateUnitChangedListener extends EventListener {

    void estateUnitChanged(EstateUnitChangedEvent e);
}
