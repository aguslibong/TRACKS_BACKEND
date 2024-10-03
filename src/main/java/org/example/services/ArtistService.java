package org.example.services;

import org.example.entities.Album;
import org.example.entities.Artist;

import java.util.HashMap;
import java.util.Map;

public class ArtistService {
    private static Map<String, Artist> listaArtist = new HashMap<>();

    public static Artist getOcreated (String key) {
        if (listaArtist.containsKey(key)){
            return listaArtist.get(key);
        } else {
            Artist nuevo = new Artist(key);
            listaArtist.put(key, nuevo);
            return nuevo;
        }
    }
}
