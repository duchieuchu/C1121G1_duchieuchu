package com.example.repository.impl;

import com.example.model.Song;
import com.example.repository.BaseRepository;
import com.example.repository.SongRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;
@Repository
public class SongRepositoryImpl implements SongRepository {

    @Override
    public List<Song> findAll() {
        TypedQuery<Song> typedQuery= BaseRepository.entityManager.createQuery("select s from Song s",Song.class);
        return typedQuery.getResultList();
    }

    @Override
    public void save(Song song) {
        EntityTransaction entityTransaction=BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.persist(song);
        entityTransaction.commit();
    }

    @Override
    public Song findById(Integer id) {
      TypedQuery<Song> typedQuery = BaseRepository.entityManager.createQuery("select m from Song m where m.id= :idSong",Song.class);
      typedQuery.setParameter("idSong",id);
      return typedQuery.getSingleResult();
    }

    @Override
    public void update(Integer id, Song song) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.merge(song);
        entityTransaction.commit();
    }

    @Override
    public List<Song> findByName(String name) {
        return null;
    }

    @Override
    public void remove(Song song) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.remove(song);
        entityTransaction.commit();
    }

}
