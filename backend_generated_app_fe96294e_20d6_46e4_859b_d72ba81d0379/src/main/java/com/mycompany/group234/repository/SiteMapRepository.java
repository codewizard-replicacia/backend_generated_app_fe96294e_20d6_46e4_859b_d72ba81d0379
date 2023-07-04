package com.mycompany.group234.repository;


import com.mycompany.group234.model.SiteMap;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.List;


@Component
public class SiteMapRepository extends SimpleJpaRepository<SiteMap, String> {
    private final EntityManager em;
    public SiteMapRepository(EntityManager em) {
        super(SiteMap.class, em);
        this.em = em;
    }
    @Override
    public List<SiteMap> findAll() {
        return em.createNativeQuery("Select * from \"generated_app\".\"SiteMap\"", SiteMap.class).getResultList();
    }
}