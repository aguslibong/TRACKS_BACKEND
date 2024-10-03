package org.example.services;

import org.example.entities.Artist;
import org.example.entities.Genre;

import java.util.HashMap;
import java.util.Map;

public class GenreService {
    private static Map<String, Genre> listaGenre = new HashMap<>();

    public static Genre getOcreated (String key) {
        if (listaGenre.containsKey(key)){
            return listaGenre.get(key);
        } else {
            Genre nuevo = new Genre(key);
            listaGenre.put(key, nuevo);
            return nuevo;
        }
    }
}
