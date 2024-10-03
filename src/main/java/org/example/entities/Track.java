package org.example.entities;

import jakarta.persistence.*;

@Entity
public class Track {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private int id;

    @Column
    private int track_id;
    @Column
    private String name;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn (name = "album_id")
    private Album album;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn (name = "artist_id")
    private Artist artist_name;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn (name = "composer_id")
    private Composer composer;
    private int miliseconds;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn (name = "genre_id")
    private Genre genre;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn (name = "mediaType_id")
    private MediaType mediaType;

    public Track() {
    }

    public Track(int track_id, String name, Album album, Artist artist_name, Composer composer, int miliseconds, Genre genre, MediaType mediaType) {
        this.track_id = track_id;
        this.name = name;
        this.album = album;
        this.artist_name = artist_name;
        this.composer = composer;
        this.miliseconds = miliseconds;
        this.genre = genre;
        this.mediaType = mediaType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTrack_id() {
        return track_id;
    }

    public void setTrack_id(int track_id) {
        this.track_id = track_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public Artist getArtist_name() {
        return artist_name;
    }

    public void setArtist_name(Artist artist_name) {
        this.artist_name = artist_name;
    }

    public Composer getComposer() {
        return composer;
    }

    public void setComposer(Composer composer) {
        this.composer = composer;
    }

    public int getMiliseconds() {
        return miliseconds;
    }

    public void setMiliseconds(int miliseconds) {
        this.miliseconds = miliseconds;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public MediaType getMediaType() {
        return mediaType;
    }

    public void setMediaType(MediaType mediaType) {
        this.mediaType = mediaType;
    }

    @Override
    public String toString() {
        return "Track{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", artist_name=" + artist_name.getName() +
                '}';
    }
}
