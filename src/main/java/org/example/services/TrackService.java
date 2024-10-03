package org.example.services;

import org.example.entities.*;
import org.example.repository.TrackRepository;

import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import static java.lang.Integer.parseInt;

public class TrackService {

    private static Map<String, Track> listaTracks = new HashMap<>();

    public static void crearTrack(String lineas){
        String[] valores = lineas.split("\\|");
        System.out.println(lineas);
        System.out.println(valores.toString());
        int trackId = Integer.parseInt(valores[0]);
        String nombre = valores[1];
        Album album = AlbumService.getOcrear(valores[2]);
        Artist artista = ArtistService.getOcreated(valores[3]);
        Composer composer = ComposerService.getOcreated(valores[4]);
        System.out.println(valores[4]);
        System.out.println(valores[5]);
        System.out.println(valores[6]);
        int milisegundos = Integer.parseInt(valores[5]);
        Genre genero = GenreService.getOcreated(valores[6]);
        MediaType mediaType = MediaTypeService.getOcrear(valores[7]);

        Track track = new Track(trackId, nombre, album, artista, composer, milisegundos, genero, mediaType);
        listaTracks.put(lineas, track);

    }

    public static Map<String, Track> getListaTracks() {
        return listaTracks;
    }

    public static long obtenerCantLista(){
        return listaTracks.entrySet().stream().count();
    }

    public static String obtenerDuracion(){
       int totalMilisegundos = listaTracks.values().stream().mapToInt(Track::getMiliseconds).sum();
       int horas = totalMilisegundos / (1000*60*60);
       int minutos = (totalMilisegundos % (1000*60*60)) / (1000*60);
       int segundos = ((totalMilisegundos % (1000*60*60)) % (1000*60)) / 1000;
       int milisegundos = ((totalMilisegundos % (1000*60*60)) % (1000*60)) % 1000;
       return String.format("%02d:%02d:%02d.%03d", horas, minutos, segundos, milisegundos);
    }

    public static Map<String,AtomicInteger> genreFile () {
        Map<String, AtomicInteger> contadorGeneros = new HashMap<>();
        listaTracks.values().forEach(elementoTrack -> {
            String nombreGenre = elementoTrack.getGenre().getName();
            if (contadorGeneros.containsKey(nombreGenre)){
                contadorGeneros.get(nombreGenre).getAndIncrement();
            }else {
                contadorGeneros.put(nombreGenre,new AtomicInteger());
            }
        });
        return contadorGeneros;
    }
}
