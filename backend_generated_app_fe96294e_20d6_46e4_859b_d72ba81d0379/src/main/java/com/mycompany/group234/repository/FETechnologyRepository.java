package com.mycompany.group234.repository;


import com.mycompany.group234.model.FETechnology;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.List;


@Component
public class FETechnologyRepository extends SimpleJpaRepository<FETechnology, String> {
    private final EntityManager em;
    public FETechnologyRepository(EntityManager em) {
        super(FETechnology.class, em);
        this.em = em;
    }
    @Override
    public List<FETechnology> findAll() {
        return em.createNativeQuery("Select * from \"generated_app\".\"FETechnology\"", FETechnology.class).getResultList();
    }
}