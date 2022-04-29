package repository.room;

import model.RentalType;
import model.Room;
import repository.BaseRepository;
import repository.room.RoomRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoomRepositoryImpl implements RoomRepository {
    private final BaseRepository baseRepository = new BaseRepository();
    private final RentalTypeRepository rentalTypeRepository = new RentalTypeRepositoryImpl();
    private static final String SELECT_ALL_ROOM = "select * from room";

    private static final String INSERT_ROOM_SQL = "insert into room (" +
            "user_name," +
            "phone," +
            "check_in," +
            "rental_type_id," +
            "other_info) values (?,?,?,?,?);";

    private static final String DELETE_ROOM_SQL = "delete from room where room_id=?;";
    //    private static final String SELECT_CUSTOMER_BY_NAME = "select * from customer where customer_name like?;";

    private static final String SELECT_ROOM_BY_NAME = "select room_id," +
            "user_name," +
            "phone," +
            "check_in," +
            "rental_type_id," +
            "other_info from room  where user_name like?;";

    @Override
    public void insertRoom(Room room) throws SQLException {
        try (Connection connection = this.baseRepository.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ROOM_SQL)) {
            preparedStatement.setString(1, room.getUserName());
            preparedStatement.setString(2, room.getPhone());
            preparedStatement.setString(3, room.getCheckIn());
            preparedStatement.setInt(4, room.getRentalType().getRentalTypeId());
            preparedStatement.setString(5, room.getOtherInfo());
            preparedStatement.executeUpdate();
        } finally {
            baseRepository.close();
        }
    }

    @Override
    public Room selectRoom(Integer id) {
        List<Room> roomList = selectAllRoom();
        Room room = null;
        for (Room room1 : roomList) {
            if (room1.getId() == id) {
                room = room1;
            }
        }
        return room;
    }

    @Override
    public List<Room> selectAllRoom() {
        List<Room> rooms = new ArrayList<>();
        try (Connection connection = this.baseRepository.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ROOM)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Integer id = resultSet.getInt("room_id");
                String user_name = resultSet.getString("user_name");
                String phone = resultSet.getString("phone");
                String check_in = resultSet.getString("check_in");
                RentalType rentalType = rentalTypeRepository.selectRentalType(resultSet.getInt("rental_type_id"));
                String other_info = resultSet.getString("other_info");
                rooms.add(new Room(id, user_name, phone, check_in, rentalType, other_info));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            baseRepository.close();
        }
        return rooms;
    }

    @Override
    public void delete(Integer id) throws SQLException {
        try (Connection connection = this.baseRepository.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(DELETE_ROOM_SQL)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } finally {
            baseRepository.close();
        }
    }

    @Override
    public void update(Room room) throws SQLException {

    }

    @Override
    public List<Room> finByName(String name) {
        List<Room> roomList = new ArrayList<>();
        Connection connection = this.baseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ROOM_BY_NAME);
            preparedStatement.setString(1, "%" + name + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Integer id = resultSet.getInt("room_id");
                String user_name = resultSet.getString("user_name");
                String phone = resultSet.getString("phone");
                String check_in = resultSet.getString("check_in");
                RentalType rentalType = rentalTypeRepository.selectRentalType(resultSet.getInt("rental_type_id"));
                String other_info = resultSet.getString("other_info");
                roomList.add(new Room( id,user_name,phone,check_in,rentalType,other_info));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            baseRepository.close();
        }
        return roomList;
    }

    @Override
    public List<Room> sortByName() {
        return null;
    }
}
