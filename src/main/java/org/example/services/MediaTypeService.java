package org.example.services;

import org.example.entities.MediaType;

import java.util.HashMap;
import java.util.Map;

public class MediaTypeService {
    private static Map<String, MediaType> listaMediaType = new HashMap<>();

    public static MediaType getOcrear(String nombreMT){
        Boolean existe = listaMediaType.containsKey(nombreMT);
        if(existe){
            MediaType mediaEncontrado= listaMediaType.get(nombreMT);
            return mediaEncontrado;
        }else{
            MediaType mediaNuevo = new MediaType(nombreMT);
            listaMediaType.put(nombreMT, mediaNuevo);
            return mediaNuevo;
        }
    }
}
