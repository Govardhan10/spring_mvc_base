package com.pluralsight.repository;

import com.pluralsight.model.Exercise;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository(value = "createRepository")
public class ExerciseRepoImpl implements ExerciseRepository{

    @PersistenceContext
    private EntityManager em;

    @Override
    public Exercise save(Exercise exercise) {
        em.persist(exercise);
        em.flush();
        return exercise;
    }
}
