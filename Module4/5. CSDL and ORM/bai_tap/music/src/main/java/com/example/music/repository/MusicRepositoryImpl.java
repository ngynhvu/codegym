package com.example.music.repository;

import com.example.music.model.Music;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional
public class MusicRepositoryImpl implements MusicRepository{

    @PersistenceContext
    private EntityManager em;
    @Override
    public List<Music> findAll() {
        TypedQuery<Music> query = em.createQuery("select c from Music c", Music.class);
        return query.getResultList();
    }

    @Override
    public void save(Music music) {
        em.persist(music);
    }

    @Override
    public Music findById(int id) {
        TypedQuery<Music> query = em.createQuery("select c from Music c where  c.id=:id", Music.class);
        query.setParameter("id", id);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public void update(Music music) {
        if(findById(music.getId())!=null){
            em.merge(music);
        }
    }

    @Override
    public void delete(Music music) {
        if(findById(music.getId())!=null){
            em.remove(music);
        }
    }
}
