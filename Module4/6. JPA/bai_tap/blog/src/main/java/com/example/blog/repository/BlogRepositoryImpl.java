package com.example.blog.repository;

import com.example.blog.model.Blog;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional
public class BlogRepositoryImpl implements BlogRepository {
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Blog> findAll() {
        TypedQuery<Blog> query = em.createQuery("select c from Blog c", Blog.class);
        return query.getResultList();
    }

    @Override
    @Transactional
    public void save(Blog blog) {
        if (blog.getId() != 0) {
            em.merge(blog);
        } else {
            em.persist(blog);
        }
    }

    @Override
    public Blog findById(int id) {
        TypedQuery<Blog> query = em.createQuery("select c from Blog c where  c.id=:id", Blog.class);
        query.setParameter("id", id);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public void update(Blog blog) {
        if(findById(blog.getId())!=null){
            em.merge(blog);
        }
    }

    @Override
    public void delete(Blog blog) {
        em.remove(em.find(Blog.class,blog.getId()));
    }
}
