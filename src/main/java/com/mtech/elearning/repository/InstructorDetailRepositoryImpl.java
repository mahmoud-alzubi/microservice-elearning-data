package com.mtech.elearning.repository;

import com.mtech.elearning.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class InstructorDetailRepositoryImpl implements InstructorDetailRepository {
    private final EntityManager entityManager;

    @Autowired
    public InstructorDetailRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<InstructorDetail> findAllInstructorDetails() {
        TypedQuery<InstructorDetail> instructorDetailTypedQuery = entityManager.createQuery("FROM InstructorDetail", InstructorDetail.class);
        return instructorDetailTypedQuery.getResultList();
    }

    @Override
    public InstructorDetail findInstructorDetailById(int theId) {
        InstructorDetail instructorDetail = entityManager.find(InstructorDetail.class, theId);
        return instructorDetail;
    }


    @Override
    @Transactional
    public void deleteInstructorDetail(InstructorDetail instructorDetail) {
        entityManager.remove(instructorDetail);
    }

    @Override
    public void save(InstructorDetail instructorDetail) {
        entityManager.persist(instructorDetail);
    }


    @Override
    public void update(InstructorDetail instructorDetail) {
        entityManager.merge(instructorDetail);
    }


}
