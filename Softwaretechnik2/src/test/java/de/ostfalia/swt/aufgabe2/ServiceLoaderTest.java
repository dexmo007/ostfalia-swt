package de.ostfalia.swt.aufgabe2;

import org.junit.Test;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * Created by Henrik on 10/14/2016.
 */
public class ServiceLoaderTest {

    public static void main(String... args) {
        ServiceLoader<Immobilie> serviceLoader = ServiceLoader.load(Immobilie.class);
        Iterator<Immobilie> iterator = serviceLoader.iterator();
        while(iterator.hasNext()){
            Immobilie im = iterator.next();
            System.out.println(im.getClass());
        }
    }
}
