package com.mycompany.group234.repository;


import com.mycompany.group234.model.BECapability;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.List;


@Component
public class BECapabilityRepository extends SimpleJpaRepository<BECapability, String> {
    private final EntityManager em;
    public BECapabilityRepository(EntityManager em) {
        super(BECapability.class, em);
        this.em = em;
    }
    @Override
    public List<BECapability> findAll() {
        return em.createNativeQuery("Select * from \"generated_app\".\"BECapability\"", BECapability.class).getResultList();
    }
}