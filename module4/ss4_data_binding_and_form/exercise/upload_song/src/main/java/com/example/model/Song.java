package com.example.model;

public class Song {
    private String name;
    private String singer;
    private String kindOfMusic;
    private String filePath;

    public Song(String name, String singer, String kindOfMusic, String filePath) {
        this.name = name;
        this.singer = singer;
        this.kindOfMusic = kindOfMusic;
        this.filePath = filePath;
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

    public String getKindOfMusic() {
        return kindOfMusic;
    }

    public void setKindOfMusic(String kindOfMusic) {
        this.kindOfMusic = kindOfMusic;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public Song() {
    }
}
