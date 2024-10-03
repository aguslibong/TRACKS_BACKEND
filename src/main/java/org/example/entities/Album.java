package org.example.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Album {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private int id;
    @Column
    private String name;
    @OneToMany (mappedBy = "album", cascade = CascadeType.ALL)
    private List<Track> lista_tracks = new ArrayList<>();

    public Album() {
    }

    public Album(String name ) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Track> getLista_tracks() {
        return lista_tracks;
    }

    public void setLista_tracks(List<Track> lista_tracks) {
        this.lista_tracks = lista_tracks;
    }
}
