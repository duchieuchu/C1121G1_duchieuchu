package repository;

import model.TheMuonSach;

import java.util.List;

public interface ITheMuonSachRepository {
    List<TheMuonSach> selectAllTheMuonSach();

    TheMuonSach selectTheMuonSach(int idTheMuonSach);
}
