package com.mycompany.group234.repository;


import com.mycompany.group234.model.ScreenFeature;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.List;


@Component
public class ScreenFeatureRepository extends SimpleJpaRepository<ScreenFeature, String> {
    private final EntityManager em;
    public ScreenFeatureRepository(EntityManager em) {
        super(ScreenFeature.class, em);
        this.em = em;
    }
    @Override
    public List<ScreenFeature> findAll() {
        return em.createNativeQuery("Select * from \"generated_app\".\"ScreenFeature\"", ScreenFeature.class).getResultList();
    }
}