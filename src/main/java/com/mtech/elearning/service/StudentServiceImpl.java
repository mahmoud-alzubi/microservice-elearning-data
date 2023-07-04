package com.mtech.elearning.service;

import com.mtech.elearning.entity.Student;
import com.mtech.elearning.repository.StudentRepositoryImpl;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
    private Logger logger = LoggerFactory.getLogger(getClass());
    private final StudentRepositoryImpl repository;

    //////////////////////////////////////////////////

    /**
     * Class Constructor
     *
     * @param repository
     */
    @Autowired
    public StudentServiceImpl(StudentRepositoryImpl repository) {
        this.repository = repository;
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
            Student student = repository.findStudentById(id);
            return student;
        } finally {
            logger.info("/findStudentById({})", id);
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
            Student student = repository.findStudentAndCoursesByStudentId(theId);
            return student;
        } finally {
            logger.info("/findStudentAndCoursesByStudentId({})", theId);
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
            repository.save(student);
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
            repository.update(student);
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
            Student student = repository.findStudentById(id);
            if (student == null) {
                //handle student not found exception here ..
            }
            repository.deleteStudent(student);
        } finally {
            logger.info("/deleteStudentById({})", id);
        }
    }


}
