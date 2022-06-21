package com.codegym.service;

import com.codegym.model.Song;
import com.codegym.repository.ISongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongService implements ISongService {
    @Autowired
    private ISongRepository iSongRepository;

    @Override
    public List<Song> findAll() {
        return this.iSongRepository.findAll();
    }

    @Override
    public void save(Song song) {
        this.iSongRepository.save(song);
    }

    @Override
    public void update(Integer id, Song song) {
        this.iSongRepository.update(id, song);
    }

    @Override
    public void delete(Song song) {
        this.iSongRepository.delete(song);
    }

    @Override
    public Song findById(Integer id) {
        return this.iSongRepository.findById(id);
    }
}
