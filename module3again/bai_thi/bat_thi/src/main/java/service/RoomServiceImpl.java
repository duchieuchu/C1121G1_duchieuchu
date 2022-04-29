package service;

import model.Room;
import repository.room.RoomRepository;
import repository.room.RoomRepositoryImpl;

import java.sql.SQLException;
import java.util.List;

public class RoomServiceImpl implements RoomService {
    private final RoomRepository roomRepository = new RoomRepositoryImpl();

    @Override
    public void insertRoom(Room room) throws SQLException {
        this.roomRepository.insertRoom(room);
    }

    @Override
    public Room selectRoom(Integer id) {
        return this.roomRepository.selectRoom(id);
    }

    @Override
    public List<Room> selectAllRoom() {
        return this.roomRepository.selectAllRoom();
    }

    @Override
    public void delete(Integer id) throws SQLException {
        this.roomRepository.delete(id);
    }

    @Override
    public void update(Room room) throws SQLException {
        this.roomRepository.update(room);
    }

    @Override
    public List<Room> finByName(String name) {
        return this.roomRepository.finByName(name);
    }

    @Override
    public List<Room> sortByName() {
        return this.roomRepository.sortByName();
    }
}
