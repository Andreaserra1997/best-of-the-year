package com.experis.course.bestoftheyear.model;

public class Song {

    //ATTRIBUTI
    private String id;
    private String titolo;

    //COSTRUTTORI
    public Song(String id, String titolo) {
        this.id = id;
        this.titolo = titolo;
    }

    //GETTER E SETTER
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }
}
