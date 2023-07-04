package com.mycompany.group234.repository;


import com.mycompany.group234.model.Theme;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.List;


@Component
public class ThemeRepository extends SimpleJpaRepository<Theme, String> {
    private final EntityManager em;
    public ThemeRepository(EntityManager em) {
        super(Theme.class, em);
        this.em = em;
    }
    @Override
    public List<Theme> findAll() {
        return em.createNativeQuery("Select * from \"generated_app\".\"Theme\"", Theme.class).getResultList();
    }
}