package com.mtech.elearning.service;

import com.mtech.elearning.entity.Course;
import com.mtech.elearning.entity.Instructor;
import com.mtech.elearning.exceptions.InstructorDetailNotFoundException;
import com.mtech.elearning.repository.CourseRepositoryImpl;
import com.mtech.elearning.repository.InstructorRepositoryImpl;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstructorServiceImpl implements InstructorService {
    private Logger logger = LoggerFactory.getLogger(getClass());
    private final InstructorRepositoryImpl repository;

    //////////////////////////////////////////////////

    /**
     * Class Constructor
     *
     * @param repository
     */
    @Autowired
    public InstructorServiceImpl(InstructorRepositoryImpl repository) {
        this.repository = repository;
    }


    //////////////////////////////////////////////////

    /**
     * To Retrieve All Instructors
     *
     * @return
     */
    @Override
    public List<Instructor> findAllInstructors() {
        try {
            logger.info("findAllInstructors()");
            List<Instructor> instructorList = repository.findAllInstructors();
            return instructorList;
        } finally {
            logger.info("/findAllInstructors()");
        }
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
            Instructor instructor = repository.findInstructorByIdJoinFetch(id);
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
            repository.save(instructor);
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
            repository.update(tempInstructor);
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
            Instructor instructor = repository.findInstructorById(theId);
            List<Course> courses = instructor.getCourses();
            for (Course course : courses) {
                course.setInstructor(null);
            }
            repository.deleteInstructor(instructor);
        } finally {
            logger.info("/deleteInstructorById({})", theId);
        }
    }


}
