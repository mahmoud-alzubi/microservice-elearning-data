package com.mtech.elearning.repository;

import com.mtech.elearning.entity.InstructorDetail;

import java.util.List;

public interface InstructorDetailRepository {

    List<InstructorDetail> findAllInstructorDetails();

    InstructorDetail findInstructorDetailById(int theId);

    void save(InstructorDetail instructorDetail);

    void update(InstructorDetail instructorDetail);

    void deleteInstructorDetail(InstructorDetail instructorDetail);

}
