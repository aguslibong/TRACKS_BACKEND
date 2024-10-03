package org.example.entities;

import jakarta.persistence.*;

@Entity
public class Composer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_composer;
    @Column
    private String name;

    public Composer() {
    }

    public Composer(String name) {
        this.name = name;
    }

    public int getId_composer() {
        return id_composer;
    }

    public void setId_composer(int id_composer) {
        this.id_composer = id_composer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
