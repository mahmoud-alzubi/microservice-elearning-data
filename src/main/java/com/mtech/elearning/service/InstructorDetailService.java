package com.mtech.elearning.service;

import com.mtech.elearning.entity.InstructorDetail;

import java.util.List;

public interface InstructorDetailService {
    List<InstructorDetail> findAllInstructorDetails();

    InstructorDetail findInstructorDetailById(int theId);

    void save(InstructorDetail instructorDetail);

    void update(int id, InstructorDetail instructorDetail);

    void deleteInstructorDetail(int id);

}
