package com.mycompany.group234.repository;


import com.mycompany.group234.model.UITemplate;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.List;


@Component
public class UITemplateRepository extends SimpleJpaRepository<UITemplate, String> {
    private final EntityManager em;
    public UITemplateRepository(EntityManager em) {
        super(UITemplate.class, em);
        this.em = em;
    }
    @Override
    public List<UITemplate> findAll() {
        return em.createNativeQuery("Select * from \"generated_app\".\"UITemplate\"", UITemplate.class).getResultList();
    }
}