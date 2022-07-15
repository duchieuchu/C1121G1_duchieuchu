package com.example.service;

import com.example.model.Room;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IRoomService {
    Page<Room> findAll(Pageable pageable);
    void save(Room room);
    Room findById(Integer id);
    void delete(Room room);
    List<Room>findAll();
}
