package com.mycompany.group234.repository;


import com.mycompany.group234.model.ReviewRequest;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.List;


@Component
public class ReviewRequestRepository extends SimpleJpaRepository<ReviewRequest, String> {
    private final EntityManager em;
    public ReviewRequestRepository(EntityManager em) {
        super(ReviewRequest.class, em);
        this.em = em;
    }
    @Override
    public List<ReviewRequest> findAll() {
        return em.createNativeQuery("Select * from \"generated_app\".\"ReviewRequest\"", ReviewRequest.class).getResultList();
    }
}