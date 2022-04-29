package repository.room;

import model.RentalType;
import repository.BaseRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RentalTypeRepositoryImpl implements RentalTypeRepository{
    private final BaseRepository baseRepository = new BaseRepository();
    private static final String SELECT_RENTAL_TYPE = "select * from rental_type";
    private static final String SELECT_RENTAL_TYPE_BY_ID = "select rental_type_name from rental_type where rental_type_id=?;";

    @Override
    public List<RentalType> selectAllRentalType() {
        List<RentalType> rentalTypes = new ArrayList<>();
        try (Connection connection = this.baseRepository.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_RENTAL_TYPE)) {
            ResultSet resultSet =preparedStatement.executeQuery();
            while (resultSet.next()){
                Integer rentalTypeId=resultSet.getInt("rental_type_id");
                String rentalTypeName=resultSet.getString("rental_type_name");
                rentalTypes.add(new RentalType(rentalTypeId,rentalTypeName));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            baseRepository.close();
        }

        return rentalTypes;
    }

    @Override
    public RentalType selectRentalType(Integer rentalTypeId) {
        RentalType rentalType = null;
        try(Connection connection= this.baseRepository.getConnection();PreparedStatement preparedStatement =connection.prepareStatement(SELECT_RENTAL_TYPE_BY_ID)){
            preparedStatement.setInt(1,rentalTypeId);
            ResultSet resultSet= preparedStatement.executeQuery();
            while (resultSet.next()){
                String rentalTypeName=resultSet.getString("rental_type_name");
                rentalType=new RentalType(rentalTypeId,rentalTypeName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            baseRepository.close();
        }
        return rentalType;
    }
}
