package com.mtech.elearning.repository;

import com.mtech.elearning.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentRepositoryImpl implements StudentRepository {
    private final EntityManager entityManager;

    @Autowired
    public StudentRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void save(Student student) {
        entityManager.persist(student);
    }

    @Override
    public void update(Student student) {
        entityManager.merge(student);
    }


    @Override
    public Student findStudentAndCoursesByStudentId(int theId) {
        TypedQuery<Student> query = entityManager.createQuery("""
                SELECT s from Student s
                JOIN FETCH s.courses
                WHERE s.id = :data
                """, Student.class);
        query.setParameter("data", theId);
        return query.getSingleResult();
    }

    @Override
    public List<Student> findAll() {
        Query query = entityManager.createQuery("SELECT s FROM Student s");
        return query.getResultList();
    }

    @Override
    public Student findStudentById(int id) {
        Student student = entityManager.find(Student.class, id);
        return student;
    }

    @Override
    public void deleteStudent(Student student) {
        entityManager.remove(student);
    }

}
