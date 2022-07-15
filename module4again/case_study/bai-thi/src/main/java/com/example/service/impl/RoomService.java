package com.example.service.impl;

import com.example.model.Room;
import com.example.repository.IRoomRepository;
import com.example.service.IRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService implements IRoomService {
    @Autowired
    private IRoomRepository iRoomRepository;

    @Override
    public Page<Room> findAll(Pageable pageable) {
        return iRoomRepository.findAll(pageable);
    }

    @Override
    public void save(Room room) {
        iRoomRepository.save(room);
    }

    @Override
    public Room findById(Integer id) {
        return iRoomRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Room room) {
        iRoomRepository.delete(room);
    }

    @Override
    public List<Room> findAll() {
        return iRoomRepository.findAll();
    }
}
