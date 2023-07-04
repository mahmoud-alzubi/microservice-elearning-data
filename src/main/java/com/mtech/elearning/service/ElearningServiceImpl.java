package com.mtech.elearning.service;

import com.mtech.elearning.dao.ElearningDaoImpl;
import com.mtech.elearning.entity.*;
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
     * To Retrieve All Instructor Details
     *
     * @return
     */
    @Override
    public List<InstructorDetail> findAllInstructorDetails() {
        try {
            logger.info("findAllInstructorDetails()");
            List<InstructorDetail> instructorDetailList = dao.findAllInstructorDetails();
            return instructorDetailList;
        } finally {
            logger.info("/findAllInstructorDetails()");
        }
    }

    //////////////////////////////////////////////////

    /**
     * To Find Instructor Details By ID
     *
     * @param theId
     * @return
     */
    @Override
    public InstructorDetail findInstructorDetailById(int theId) {
        try {
            logger.info("findInstructorDetailById({})", theId);
            InstructorDetail instructorDetail = dao.findInstructorDetailById(theId);
            return instructorDetail;
        } finally {
            logger.info("/findInstructorDetailById({})", theId);
        }
    }

    //////////////////////////////////////////////////

    /**
     * To Add new Instructor Details Record
     *
     * @param instructorDetail
     */
    @Override
    @Transactional
    public void save(InstructorDetail instructorDetail) {
        try {
            logger.info("save({})", instructorDetail);
            dao.save(instructorDetail);
        } finally {
            logger.info("/save({})", instructorDetail);
        }
    }

    //////////////////////////////////////////////////

    /**
     * To Update Instructor Details
     *
     * @param id
     * @param instructorDetail
     */
    @Override
    @Transactional
    public void update(int id, InstructorDetail instructorDetail) {
        try {
            logger.info("update({}, {})", id, instructorDetail);
            instructorDetail.setId(id);
            dao.update(instructorDetail);
        } finally {
            logger.info("/update({}, {})", id, instructorDetail);
        }
    }

    //////////////////////////////////////////////////

    /**
     * To Delete Instructor Details
     *
     * @param id
     */
    @Override
    @Transactional
    public void deleteInstructorDetail(int id) {
        try {
            logger.info("deleteInstructorDetail({})", id);
            InstructorDetail instructorDetail = dao.findInstructorDetailById(id);
            if (instructorDetail == null) {
                // handle instructor detail record not found exception ..
            }
            dao.deleteInstructorDetail(instructorDetail);
        } finally {
            logger.info("/deleteInstructorDetail({})", id);
        }
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
            List<Instructor> instructorList = dao.findAllInstructors();
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

    //////////////////////////////////////////////////

    /**
     * To Find All Courses
     *
     * @return
     */
    @Override
    public List<Course> findAllCourses() {
        try {
            logger.info("findAllCourses()");
            List<Course> courseList = dao.findAllCourses();
            return courseList;
        } finally {
            logger.info("/findAllCourses()");
        }
    }

    //////////////////////////////////////////////////

    /**
     * To Find Specific Course By Given ID
     *
     * @param theId
     * @return
     */
    @Override
    public Course findCourseById(int theId) {
        try {
            logger.info("findCourseById({})", theId);
            Course course = dao.findCourseById(theId);
            return course;
        } finally {
            logger.info("/findCourseById({})", theId);
        }
    }

    //////////////////////////////////////////////////

    /**
     * To Add New Course Record
     *
     * @param theCourse
     */
    @Transactional
    @Override
    public void save(Course theCourse) {
        try {
            logger.info("save({})", theCourse);
            dao.save(theCourse);
        } finally {
            logger.info("/save({})", theCourse);
        }
    }

    //////////////////////////////////////////////////

    /**
     * To Update Existing Course
     *
     * @param id
     * @param tempCourse
     */
    @Override
    @Transactional
    public void update(int id, Course tempCourse) {
        try {
            logger.info("update({}, {})", tempCourse);
            tempCourse.setId(id);
            dao.update(tempCourse);
        } finally {
            logger.info("/update({}, {})", tempCourse);
        }
    }

    //////////////////////////////////////////////////

    /**
     * To Remove Selected Course By ID
     *
     * @param theId
     */
    @Override
    @Transactional
    public void deleteCourseById(int theId) {
        try {
            logger.info("deleteCourseById({})", theId);
            Course course = dao.findCourseById(theId);
            // handle course not found exception

            dao.deleteCourse(course);
        } finally {
            logger.info("/deleteCourseById({})", theId);
        }
    }

    //////////////////////////////////////////////////

    /**
     * To Find Courses And Reviews By Given Course ID
     *
     * @param theId
     * @return
     */
    @Override
    public Course findCourseAndReviewsByCourseId(int theId) {
        try {
            logger.info("findCourseAndReviewsByCourseId({})", theId);
            Course course = dao.findCourseAndReviewsByCourseId(theId);
            return course;
        } finally {
            logger.info("/findCourseAndReviewsByCourseId({})", theId);
        }
    }


    //////////////////////////////////////////////////

    /**
     * To Find Student Record Based On ID
     *
     * @param id
     * @return
     */
    @Override
    public Student findStudentById(int id) {
        try {
            logger.info("findStudentById({})", id);
            Student student = dao.findStudentById(id);
            return student;
        } finally {
            logger.info("/findStudentById({})", id);
        }
    }

    //////////////////////////////////////////////////

    /**
     * To Add New Student Record
     *
     * @param student
     */
    @Override
    @Transactional
    public void save(Student student) {
        try {
            logger.info("save({})", student);
            dao.save(student);
        } finally {
            logger.info("/save({})", student);
        }
    }

    //////////////////////////////////////////////////

    /**
     * To Update student data
     *
     * @param id
     * @param student
     */
    @Override
    public void update(int id, Student student) {
        try {
            logger.info("update({},{})", id, student);
            student.setId(id);
            dao.update(student);
        } finally {
            logger.info("/update({}, {})", id, student);
        }
    }

    //////////////////////////////////////////////////

    /**
     * To Delete Student By Given ID
     *
     * @param id
     */
    @Override
    @Transactional
    public void deleteStudentById(int id) {
        try {
            logger.info("deleteStudentById({})", id);
            Student student = dao.findStudentById(id);
            if (student == null) {
                //handle student not found exception here ..
            }
            dao.deleteStudent(student);
        } finally {
            logger.info("/deleteStudentById({})", id);
        }
    }

    //////////////////////////////////////////////////

    /**
     * To Find Review By ID
     *
     * @param id
     * @return
     */
    @Override
    public Review findReviewById(int id) {
        try {
            logger.info("findReviewById({})", id);
            Review review = dao.findReviewById(id);
            return review;
        } finally {
            logger.info("/findReviewById({})", id);
        }
    }

    //////////////////////////////////////////////////

    /**
     * To Add New Review Record
     *
     * @param review
     */
    @Override
    @Transactional
    public void save(Review review) {
        try {
            logger.info("save({})", review);
            dao.save(review);
        } finally {
            logger.info("/save({})", review);
        }
    }

    //////////////////////////////////////////////////

    /**
     * To Update Review Revord
     *
     * @param id
     * @param review
     */
    @Override
    @Transactional
    public void update(int id, Review review) {
        try {
            logger.info("update({}, {})", id, review);
            review.setId(id);
            dao.update(review);
        } finally {
            logger.info("/update({}, {})", id, review);
        }
    }

    //////////////////////////////////////////////////

    /**
     * To Delete Review Record
     *
     * @param id
     */
    @Override
    public void deleteReview(int id) {
        try {
            logger.info("deleteReview({})", id);
            Review review = dao.findReviewById(id);
            if (review == null) {
                // throw review not found exception..
            }
            dao.deleteReview(review);
        } finally {
            logger.info("/deleteReview({})", id);
        }
    }

    //////////////////////////////////////////////////

    /**
     * To Find Student And Courses By Student ID
     *
     * @param theId
     * @return
     */
    @Override
    public Student findStudentAndCoursesByStudentId(int theId) {
        try {
            logger.info("findStudentAndCoursesByStudentId({})", theId);
            Student student = dao.findStudentAndCoursesByStudentId(theId);
            return student;
        } finally {
            logger.info("/findStudentAndCoursesByStudentId({})", theId);
        }
    }


}
