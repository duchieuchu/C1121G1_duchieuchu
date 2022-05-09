package com.example.service;

import com.example.model.Song;
import com.example.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SongServiceImpl implements SongService{
@Autowired
private SongRepository songRepository;
    @Override
    public List<Song> findAll() {
        return this.songRepository.findAll();
    }

    @Override
    public void save(Song song) {
        this.songRepository.save(song);
    }

    @Override
    public Song findById(Integer id) {
        return this.songRepository.findById(id);
    }

    @Override
    public void update(Integer id, Song song) {
        this.songRepository.update(id,song);
    }

    @Override
    public List<Song> findByName(String name) {
        return this.songRepository.findByName(name);
    }

    @Override
    public void remove(Song song) {
        this.songRepository.remove(song);
    }
}
