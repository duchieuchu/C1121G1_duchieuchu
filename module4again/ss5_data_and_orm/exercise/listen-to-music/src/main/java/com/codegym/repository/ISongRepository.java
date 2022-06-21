package com.codegym.repository;

import com.codegym.model.Song;

import java.util.List;

public interface ISongRepository {
    List<Song>findAll();
    void save(Song song);
    void update(Integer id,Song song);
    void delete(Integer id);
    Song findById(Integer id);
}
