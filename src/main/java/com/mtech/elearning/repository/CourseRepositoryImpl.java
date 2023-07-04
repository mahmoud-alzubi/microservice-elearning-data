package com.mtech.elearning.repository;

import com.mtech.elearning.entity.Course;
import com.mtech.elearning.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CourseRepositoryImpl implements CourseRepository {

    private final EntityManager entityManager;

    @Autowired
    public CourseRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public List<Course> findAllCourses() {
        TypedQuery<Course> query = entityManager.createQuery("FROM Course", Course.class);
        return query.getResultList();
    }

    @Override
    public List<Course> findCoursesByInstructorId(int theId) {
        Query query = entityManager.createQuery("FROM Course WHERE instructor.id = :data");
        query.setParameter("data", theId);
        return query.getResultList();
    }

    @Override
    public Course findCourseById(int theId) {
        Course course = entityManager.find(Course.class, theId);
        return course;
    }


    @Override
    public Course findCourseAndReviewsByCourseId(int theId) {
        TypedQuery<Course> query = entityManager.createQuery("""
                SELECT c from Course c 
                JOIN FETCH c.reviews
                WHERE c.id = :data
                """, Course.class);
        query.setParameter("data", theId);
        Course course = query.getSingleResult();
        return course;
    }


    @Override
    public void save(Course theCourse) {
        entityManager.persist(theCourse);
    }


    @Override
    public void update(Course tempCourse) {
        entityManager.merge(tempCourse);
    }

    @Override
    public void deleteCourse(Course course) {
        entityManager.remove(course);
    }


}
