package service;

import model.Room;

import java.sql.SQLException;
import java.util.List;

public interface RoomService {

    void insertRoom(Room room) throws SQLException;

    Room selectRoom(Integer id);

    List<Room> selectAllRoom();

    void delete(Integer id) throws SQLException;

    void update(Room room) throws SQLException;

    List<Room> finByName(String name);

    List<Room> sortByName();
}
