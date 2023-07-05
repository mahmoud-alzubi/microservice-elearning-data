package com.mtech.elearning.service;

import com.mtech.elearning.entity.InstructorDetail;
import com.mtech.elearning.exceptions.InstructorDetailNotFoundException;
import com.mtech.elearning.repository.InstructorDetailRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstructorDetailServiceImpl implements InstructorDetailService {

    private Logger logger = LoggerFactory.getLogger(getClass());
    private final InstructorDetailRepository repository;


    //////////////////////////////////////////////////

    /**
     * Class Constructor
     *
     * @param repository
     */
    @Autowired
    public InstructorDetailServiceImpl(InstructorDetailRepository repository) {
        this.repository = repository;
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
            List<InstructorDetail> instructorDetailList = repository.findAllInstructorDetails();
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
            InstructorDetail instructorDetail = repository.findInstructorDetailById(theId);
            if (instructorDetail == null) {
                throw new InstructorDetailNotFoundException("Instructor details not found with id: " + theId);
            }
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
            repository.save(instructorDetail);
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
            repository.update(instructorDetail);
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
            InstructorDetail instructorDetail = repository.findInstructorDetailById(id);
            if (instructorDetail == null) {
                throw new InstructorDetailNotFoundException("Instructor details not found with id: " + id);
            }
            repository.deleteInstructorDetail(instructorDetail);
        } finally {
            logger.info("/deleteInstructorDetail({})", id);
        }
    }

}
