package com.mtech.elearning.repository;

import com.mtech.elearning.entity.Instructor;
import com.mtech.elearning.exceptions.InstructorDetailNotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class InstructorRepositoryImpl implements InstructorRepository {
    private final EntityManager entityManager;

    @Autowired
    public InstructorRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public List<Instructor> findAllInstructors() {
        TypedQuery<Instructor> query = entityManager.createQuery("FROM Instructor", Instructor.class);
        return query.getResultList();
    }

    @Override
    public Instructor findInstructorById(int id) {
        Instructor instructor = entityManager.find(Instructor.class, id);
        return instructor;
    }

    @Override
    public Instructor findInstructorByIdJoinFetch(int theId) {
        //JPQL query
        try {
            TypedQuery<Instructor> query = entityManager.createQuery(""" 
                    SELECT i from Instructor i 
                    JOIN FETCH i.courses
                    JOIN FETCH i.instructorDetail 
                    WHERE i.id = :data
                    """, Instructor.class);

            TypedQuery<Instructor> data = query.setParameter("data", theId);
            return data.getSingleResult();
        } catch (NoResultException e) {
            throw new InstructorDetailNotFoundException("Instructor  not found with id: " + theId);
        }
    }

    @Override
    public void deleteInstructor(Instructor instructor) {
        entityManager.remove(instructor);
    }

    @Override
    public void save(Instructor instructor) {
        entityManager.persist(instructor);
    }

    @Override
    public void update(Instructor tempInstructor) {
        entityManager.merge(tempInstructor);
    }

}
