package org.example.repository;

import jakarta.persistence.EntityManager;
import org.example.EntityManagerProvider.EntityManageProvide;
import org.example.entities.Track;
import org.example.services.TrackService;

import java.util.List;
import java.util.Map;

public class TrackRepository {
    private static  EntityManager em = EntityManageProvide.getEntityManagment();

    public static void guardar(Map<String, Track> tracks) {
        em.getTransaction().begin();
        for (Map.Entry<String, Track> entry : tracks.entrySet()) {
            em.persist(entry.getValue()); // Guardar cada Track en la base de datos
        }
        em.getTransaction().commit();
    }

    public static List<Track> trackFindbyArtist (String artist_name) {
        List<Track> listaTracks = em.createNativeQuery("SELECT t.* from Track t JOIN Artist a ON t.artist_id = a.id_artist WHERE a.name = :name", Track.class)
                .setParameter("name", artist_name)
                .getResultList();
        return listaTracks;
    }

}
