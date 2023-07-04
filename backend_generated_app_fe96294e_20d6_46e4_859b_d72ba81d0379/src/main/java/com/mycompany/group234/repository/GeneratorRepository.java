package com.mycompany.group234.repository;


import com.mycompany.group234.model.Generator;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.List;


@Component
public class GeneratorRepository extends SimpleJpaRepository<Generator, String> {
    private final EntityManager em;
    public GeneratorRepository(EntityManager em) {
        super(Generator.class, em);
        this.em = em;
    }
    @Override
    public List<Generator> findAll() {
        return em.createNativeQuery("Select * from \"generated_app\".\"Generator\"", Generator.class).getResultList();
    }
}