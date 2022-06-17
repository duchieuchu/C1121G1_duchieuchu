package com.example.model;

public class Song {
    private String name;
    private String singer;
    private String typeMusic;
    private String pathSong;

    public Song(String name, String singer, String typeMusic, String pathSong) {
        this.name = name;
        this.singer = singer;
        this.typeMusic = typeMusic;
        this.pathSong = pathSong;
    }

    public Song() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getTypeMusic() {
        return typeMusic;
    }

    public void setTypeMusic(String typeMusic) {
        this.typeMusic = typeMusic;
    }

    public String getPathSong() {
        return pathSong;
    }

    public void setPathSong(String pathSong) {
        this.pathSong = pathSong;
    }
}
