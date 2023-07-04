package com.mycompany.group234.repository;


import com.mycompany.group234.model.Setting;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.List;


@Component
public class SettingRepository extends SimpleJpaRepository<Setting, String> {
    private final EntityManager em;
    public SettingRepository(EntityManager em) {
        super(Setting.class, em);
        this.em = em;
    }
    @Override
    public List<Setting> findAll() {
        return em.createNativeQuery("Select * from \"generated_app\".\"Setting\"", Setting.class).getResultList();
    }
}