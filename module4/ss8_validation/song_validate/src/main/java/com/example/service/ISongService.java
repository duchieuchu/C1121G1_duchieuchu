package com.example.service;

import com.example.model.Song;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ISongService {
    void save(Song song);
    void remove(Song song);
    Page<Song> findAll(Pageable pageable);
}
