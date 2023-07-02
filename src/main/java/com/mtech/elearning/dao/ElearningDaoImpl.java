package com.mtech.elearning.dao;

import com.mtech.elearning.entity.Course;
import com.mtech.elearning.entity.Instructor;
import com.mtech.elearning.entity.InstructorDetail;
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

    /**
     * @param theId
     */
//    @Override
//    @Transactional
//    public void deleteInstructorById(int theId) {
//        Instructor instructor = entityManager.find(Instructor.class, theId);
//        List<Course> courses = instructor.getCourses();
//        for (Course course : courses) {
//            course.setInstructor(null);
//        }
//        entityManager.remove(instructor);
//    }


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
    @Transactional
    public void save(Course theCourse) {
        entityManager.persist(theCourse);
    }

    @Override
    @Transactional
    public void update(Course tempCourse) {
        entityManager.merge(tempCourse);
    }

    @Override
    @Transactional
    public void deleteCourseById(int theId) {
        Course courseById = findCourseById(theId);
        entityManager.remove(courseById);
    }

    //////////////////////INSTRUCTOR DETAILS//////////////
    @Override
    public InstructorDetail findInstructorDetailById(int theId) {
        InstructorDetail instructorDetail = entityManager.find(InstructorDetail.class, theId);
        return instructorDetail;
    }


    @Override
    @Transactional
    public void deleteInstructorDetailById(int theId) {
        Instructor instructorById = findInstructorById(theId);
        entityManager.remove(instructorById);
    }

    ////////////////OTHERS////////////////////////

    @Override
    public Course findCourseAndReviewsByCourseId(int theId) {
        TypedQuery<Course> query = entityManager.createQuery("""
                SELECT c from Course c 
                JOIN FETCH c.reviews
                WHERE c.id = :data
                """, Course.class);
        Course course = query.getSingleResult();
        return course;
    }


}
