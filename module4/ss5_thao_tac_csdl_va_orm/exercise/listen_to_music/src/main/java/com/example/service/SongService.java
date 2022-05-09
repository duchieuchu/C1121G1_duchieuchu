package com.example.service;

import com.example.model.Song;

import java.util.List;

public interface SongService {
    List<Song> findAll();

    void save(Song song);

    Song findById(Integer id);

    void update(Integer id, Song song);

    List<Song> findByName(String name);

    void remove(Song song);

}
