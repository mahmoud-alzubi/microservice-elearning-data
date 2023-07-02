package com.mtech.elearning.service;

import com.mtech.elearning.dao.ElearningDaoImpl;
import com.mtech.elearning.entity.Course;
import com.mtech.elearning.entity.Instructor;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ElearningServiceImpl implements ElearningService {
    private Logger logger = LoggerFactory.getLogger(getClass());
    private ElearningDaoImpl dao;

    ////////////////////////////////////////////////////

    /**
     * Constructor
     *
     * @param dao
     */
    @Autowired
    public ElearningServiceImpl(ElearningDaoImpl dao) {
        this.dao = dao;
    }

    //////////////////////////////////////////////////

    /**
     * To Find Instructor Data By ID
     *
     * @param id
     * @return
     */
    @Override
    public Instructor findInstructorById(int id) {
        try {
            logger.info("findInstructorById({})", id);
            Instructor instructor = dao.findInstructorByIdJoinFetch(id);
            return instructor;
        } finally {
            logger.info("/findInstructorById({})", id);
        }
    }

    //////////////////////////////////////////////////

    /**
     * To Save New Instructor Data
     *
     * @param instructor
     */
    @Override
    @Transactional
    public void save(Instructor instructor) {
        try {
            logger.info("save({})", instructor);
            dao.save(instructor);
        } finally {
            logger.info("/save({})", instructor);
        }
    }

    //////////////////////////////////////////////////

    /**
     * To Update The Instructor Data
     *
     * @param tempInstructor
     */
    @Override
    @Transactional
    public void update(int id, Instructor tempInstructor) {
        try {
            logger.info("update({},{})", id, tempInstructor);
            tempInstructor.setId(id);
            dao.update(tempInstructor);
        } finally {
            logger.info("/update({}, {})", id, tempInstructor);
        }
    }

    //////////////////////////////////////////////////

    /**
     * To Delete Instructor By ID
     *
     * @param theId
     */
    @Override
    @Transactional
    public void deleteInstructorById(int theId) {
        try {
            logger.info("deleteInstructorById({})", theId);
            Instructor instructor = dao.findInstructorById(theId);
            List<Course> courses = instructor.getCourses();
            for (Course course : courses) {
                course.setInstructor(null);
            }
            dao.deleteInstructor(instructor);
        } finally {
            logger.info("/deleteInstructorById({})", theId);
        }
    }

    //////////////////////////////////////////////////

    /**
     * To Find All Courses For Specific Constructor
     *
     * @param theId
     * @return
     */
    @Override
    public List<Course> findCoursesByInstructorId(int theId) {
        try {
            logger.info("findCoursesByInstructorId({})", theId);
            List<Course> courseList = dao.findCoursesByInstructorId(theId);
            return courseList;
        } finally {
            logger.info("/findCoursesByInstructorId({})", theId);
        }
    }


}
