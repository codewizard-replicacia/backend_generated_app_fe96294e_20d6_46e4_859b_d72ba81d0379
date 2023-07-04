package com.mycompany.group234.repository;


import com.mycompany.group234.model.FECapability;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.List;


@Component
public class FECapabilityRepository extends SimpleJpaRepository<FECapability, String> {
    private final EntityManager em;
    public FECapabilityRepository(EntityManager em) {
        super(FECapability.class, em);
        this.em = em;
    }
    @Override
    public List<FECapability> findAll() {
        return em.createNativeQuery("Select * from \"generated_app\".\"FECapability\"", FECapability.class).getResultList();
    }
}