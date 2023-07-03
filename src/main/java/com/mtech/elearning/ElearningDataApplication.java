package com.mtech.elearning;

import com.mtech.elearning.dao.ElearningDao;
import com.mtech.elearning.entity.*;
import com.mtech.elearning.service.ElearningService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class ElearningDataApplication {

    public static void main(String[] args) {
        SpringApplication.run(ElearningDataApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ElearningService elearningDao) {
        return runner -> {
            createInstructor(elearningDao);
        };
    }

    private void createInstructor(ElearningService elearningDao) {
        Instructor instructor = new Instructor("Mahmoud", "AlZu'bi", "m7moudzo3bi@gmail.com");

        InstructorDetail instructorDetail = new InstructorDetail("mahmoud-alzubi", "coding");

        instructor.setInstructorDetail(instructorDetail);

        Student student = new Student("MAhmoud", "Yousef", "m7moudzo3bi@gmail.com");

        Course tempCourse1 = new Course("Air Guitar - The Ultimate Guide");
        tempCourse1.setInstructor(instructor);
        Review review1 = new Review("Good");
        tempCourse1.addReview(review1);

        Course tempCourse2 = new Course("The Pinball Masterclass");
        tempCourse2.setInstructor(instructor);

        Review review2 = new Review("Very Good");
        tempCourse2.addReview(review2);


        student.addCourse(tempCourse1);
        student.addCourse(tempCourse2);
//
//        elearningDao.save(student);

//        Instructor instructorById = elearningDao.findInstructorByIdJoinFetch(1);
//        System.out.println(instructorById);

//        elearningDao.remove(2);


//        elearningDao.save(instructor);

//        Instructor instructor = elearningDao.findInstructorById(1);

//        instructor.setLastName("Y. AlZu'bi");
//        elearningDao.update(1, instructor);

//        elearningDao.deleteInstructorById(1);

//        Instructor instructor1 = elearningDao.findInstructorById(1);
//        System.out.println(instructor1);
//        Instructor instructor1 = elearningDao.findInstructorByIdJoinFetch(1);
//        System.out.println(instructor1);

//        List<Course> coursesByInstructorId = elearningDao.findCoursesByInstructorId(1);
//        System.out.println(coursesByInstructorId);

//        Course course = elearningDao.findCourseById(10);
//        System.out.println(course);

        Student student2 = elearningDao.findStudentAndCoursesByStudentId(1);
        System.out.println(student);

    }
}
