package org.example.services;

import org.example.entities.Artist;
import org.example.entities.Composer;

import java.util.HashMap;
import java.util.Map;

public class ComposerService {
    private static Map<String, Composer> listaComposers = new HashMap<>();

    public static Composer getOcreated (String key) {
        if (listaComposers.containsKey(key)){
            return listaComposers.get(key);
        } else {
            Composer nuevo = new Composer(key);
            listaComposers.put(key, nuevo);
            return nuevo;
        }
    }
}
