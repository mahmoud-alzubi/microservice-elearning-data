package com.mtech.elearning.dao;

import com.mtech.elearning.entity.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ElearningDaoImpl implements ElearningDao {

    private EntityManager entityManager;

    @Autowired
    public ElearningDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public List<Instructor> findAllInstructors() {
        TypedQuery<Instructor> query = entityManager.createQuery("FROM Instructor", Instructor.class);
        return query.getResultList();
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Instructor findInstructorById(int id) {
        Instructor instructor = entityManager.find(Instructor.class, id);
        return instructor;
    }

    /**
     * @param theId
     * @return
     */
    @Override
    public Instructor findInstructorByIdJoinFetch(int theId) {
        //JPQL query
        TypedQuery<Instructor> query = entityManager.createQuery(""" 
                SELECT i from Instructor i 
                JOIN FETCH i.courses
                JOIN FETCH i.instructorDetail 
                WHERE i.id = :data
                """, Instructor.class);

        TypedQuery<Instructor> data = query.setParameter("data", theId);
        return data.getSingleResult();
    }

    @Override
    public void deleteInstructor(Instructor instructor) {
        entityManager.remove(instructor);
    }

    /**
     * @param instructor
     */
    @Override
    public void save(Instructor instructor) {
        entityManager.persist(instructor);
    }

    /**
     * @param tempInstructor
     */
    @Override
    public void update(Instructor tempInstructor) {
        entityManager.merge(tempInstructor);
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
    public void save(Course theCourse) {
        entityManager.persist(theCourse);
    }

    @Override
    public void save(Student student) {
        entityManager.persist(student);
    }

    @Override
    public void save(InstructorDetail instructorDetail) {
        entityManager.persist(instructorDetail);
    }

    @Override
    public void update(Course tempCourse) {
        entityManager.merge(tempCourse);
    }

    @Override
    public void update(Student student) {
        entityManager.merge(student);
    }

    @Override
    public void update(InstructorDetail instructorDetail) {
        entityManager.merge(instructorDetail);
    }

    @Override
    public void deleteCourse(Course course) {
        entityManager.remove(course);
    }

    @Override
    public List<InstructorDetail> findAllInstructorDetails() {
        TypedQuery<InstructorDetail> instructorDetailTypedQuery = entityManager.createQuery("FROM InstructorDetail", InstructorDetail.class);
        return instructorDetailTypedQuery.getResultList();
    }

    @Override
    public InstructorDetail findInstructorDetailById(int theId) {
        InstructorDetail instructorDetail = entityManager.find(InstructorDetail.class, theId);
        return instructorDetail;
    }


    @Override
    @Transactional
    public void deleteInstructorDetail(InstructorDetail instructorDetail) {
        entityManager.remove(instructorDetail);
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
    public Student findStudentById(int id) {
        Student student = entityManager.find(Student.class, id);
        return student;
    }

    @Override
    public void deleteStudent(Student student) {
        entityManager.remove(student);
    }


    ////////////////////// REVIEWS /////////////
    @Override
    public Review findReviewById(int id) {
        Review review = entityManager.find(Review.class, id);
        return review;
    }

    @Override
    public void save(Review review) {
        entityManager.persist(review);
    }

    @Override
    public void update(Review review) {
        entityManager.merge(review);
    }

    @Override
    public void deleteReview(Review review) {
        entityManager.remove(review);
    }


}
