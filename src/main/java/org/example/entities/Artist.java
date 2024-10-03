package org.example.entities;

import jakarta.persistence.*;

@Entity
public class Artist {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private int id_artist;
    @Column
    private String name;

    public Artist() {
    }

    public Artist(String name) {
        this.name = name;
    }

    public int getId_artist() {
        return id_artist;
    }

    public void setId_artist(int id_artist) {
        this.id_artist = id_artist;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
