package com.mtech.elearning;

import com.mtech.elearning.dao.ElearningDao;
import com.mtech.elearning.entity.Course;
import com.mtech.elearning.entity.Instructor;
import com.mtech.elearning.entity.InstructorDetail;
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
//
        InstructorDetail instructorDetail = new InstructorDetail("mahmoud-alzubi", "coding");
//
        instructor.setInstructorDetail(instructorDetail);
//
        Course tempCourse1 = new Course("Air Guitar - The Ultimate Guide");
        Course tempCourse2 = new Course("The Pinball Masterclass");

        instructor.addCource(tempCourse1);
        instructor.addCource(tempCourse2);
//
//        elearningDao.save(instructor);

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


    }
}
