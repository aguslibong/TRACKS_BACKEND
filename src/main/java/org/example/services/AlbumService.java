package org.example.services;

import org.example.entities.Album;

import java.util.HashMap;
import java.util.Map;

public class AlbumService {
    private static Map<String, Album> listaAlbumes = new HashMap<>();

    public static Album getOcrear(String nombreAlbum) {
        Boolean existe = listaAlbumes.containsKey(nombreAlbum);
        if(existe) {
            Album albumEncontrado = listaAlbumes.get(nombreAlbum);
            return albumEncontrado;
        }else{
            Album albumNuevo = new Album(nombreAlbum);
            listaAlbumes.put(nombreAlbum, albumNuevo);
            return albumNuevo;
        }
    }
    //public static void agregarTrackAAlbum
}
