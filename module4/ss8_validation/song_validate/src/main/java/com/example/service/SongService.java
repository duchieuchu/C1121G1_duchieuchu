package com.example.service;

import com.example.model.Song;
import com.example.repository.ISongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SongService implements ISongService {
    @Autowired
    private ISongRepository iSongRepository;

    @Override
    public void save(Song song) {
        this.iSongRepository.save(song);
    }

    @Override
    public void remove(Song song) {
        this.iSongRepository.delete(song);
    }

    @Override
    public Page<Song> findAll(Pageable pageable) {
        return this.iSongRepository.findAll(pageable);
    }
}
