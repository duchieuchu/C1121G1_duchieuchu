package com.example.service;

import com.example.model.Song;
import com.example.repository.ISongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SongService implements ISongService {
@Autowired
private ISongRepository ISongRepository;
    @Override
    public List<Song> findAll() {
        return this.ISongRepository.findAll();
    }

    @Override
    public void save(Song song) {
        this.ISongRepository.save(song);
    }

    @Override
    public Song findById(Integer id) {
        return this.ISongRepository.findById(id);
    }

    @Override
    public void update(Integer id, Song song) {
        this.ISongRepository.update(id,song);
    }

    @Override
    public List<Song> findByName(String name) {
        return this.ISongRepository.findByName(name);
    }

    @Override
    public void remove(Song song) {
        this.ISongRepository.remove(song);
    }
}
