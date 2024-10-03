package org.example.entities;

import jakarta.persistence.*;

@Entity
public class MediaType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_mediaType;
    @Column
    private String name;

    public MediaType() {
    }

    public MediaType(String name) {
        this.name = name;
    }

    public int getId_mediaType() {
        return id_mediaType;
    }

    public void setId_mediaType(int id_mediaType) {
        this.id_mediaType = id_mediaType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
