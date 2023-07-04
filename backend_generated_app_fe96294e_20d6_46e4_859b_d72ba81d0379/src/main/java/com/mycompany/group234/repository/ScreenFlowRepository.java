package com.mycompany.group234.repository;


import com.mycompany.group234.model.ScreenFlow;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.List;


@Component
public class ScreenFlowRepository extends SimpleJpaRepository<ScreenFlow, String> {
    private final EntityManager em;
    public ScreenFlowRepository(EntityManager em) {
        super(ScreenFlow.class, em);
        this.em = em;
    }
    @Override
    public List<ScreenFlow> findAll() {
        return em.createNativeQuery("Select * from \"generated_app\".\"ScreenFlow\"", ScreenFlow.class).getResultList();
    }
}