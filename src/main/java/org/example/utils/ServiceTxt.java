package org.example.utils;

import org.example.entities.Album;
import org.example.services.AlbumService;
import org.example.services.TrackService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class ServiceTxt {
    public static void importadorTXT(){
        try(BufferedReader bufer = new BufferedReader(new FileReader("C:\\Users\\Usuario\\UTN\\2024\\Backend\\SIMU_Agus\\src\\main\\resources\\Tracks_Data.txt")) ){
            String lineas = bufer.readLine();
            while ((lineas = bufer.readLine()) != null){
                TrackService.crearTrack(lineas);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        } ;
    }

    public static void exportadorTXT(Map<String, AtomicInteger> listaAExportar){
        try (FileWriter generador = new FileWriter("C:\\Users\\Usuario\\UTN\\2024\\Backend\\SIMU_Agus\\src\\main\\resources\\GenreData.txt")){
            generador.append("GENERO, CANTIDAD_TRACKS \n");

            listaAExportar.entrySet().forEach(genero-> {
                try {
                    generador.append(genero.getKey()).append(",").append(genero.getValue().toString()).append("\n");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
            generador.flush();
            System.out.println("archivo Creado");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
