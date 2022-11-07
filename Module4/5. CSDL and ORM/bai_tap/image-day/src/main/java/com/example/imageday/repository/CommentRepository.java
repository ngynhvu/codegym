package com.example.imageday.repository;

import com.example.imageday.model.Comment;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CommentRepository implements ICommentRepository{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Comment> findAll() {
        TypedQuery<Comment> query=entityManager.createQuery("SELECT c from Comment as c", Comment.class);
        return query.getResultList();
    }

    @Override
    public void save(Comment comment) {
        entityManager.persist(comment);
    }
}
