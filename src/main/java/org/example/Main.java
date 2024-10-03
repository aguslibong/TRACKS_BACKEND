package org.example;

import org.example.entities.Track;
import org.example.repository.TrackRepository;
import org.example.services.TrackService;
import org.example.utils.ServiceTxt;
import org.hibernate.boot.registry.selector.spi.StrategyCreator;

import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ServiceTxt.importadorTXT();
        TrackRepository.guardar(TrackService.getListaTracks());
        System.out.println(TrackService.obtenerCantLista());
        System.out.println(TrackService.obtenerDuracion());
        ServiceTxt.exportadorTXT(TrackService.genreFile());
        List<Track> listbyArt = TrackRepository.trackFindbyArtist("The Who");
        System.out.println("lista de track con artits: The Who");
        listbyArt.forEach( track -> {
            System.out.println(track.toString());
        });
    }
}