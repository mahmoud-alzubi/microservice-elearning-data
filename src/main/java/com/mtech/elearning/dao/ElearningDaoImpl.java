package com.mtech.elearning.dao;

import com.mtech.elearning.entity.Course;
import com.mtech.elearning.entity.Instructor;
import com.mtech.elearning.entity.InstructorDetail;
import com.mtech.elearning.entity.Student;
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

    /////////////////////INSTRUCTOR//////////////////////////////

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

    /**
     * @param id
     */
    @Override
    @Transactional
    public void remove(int id) {
        Instructor instructor = findInstructorById(id);
        entityManager.remove(instructor);
    }


    ///////////////////COURSE//////////////////////////
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

    //////////////////////INSTRUCTOR DETAILS//////////////
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

    ////////////////OTHERS////////////////////////

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


}
