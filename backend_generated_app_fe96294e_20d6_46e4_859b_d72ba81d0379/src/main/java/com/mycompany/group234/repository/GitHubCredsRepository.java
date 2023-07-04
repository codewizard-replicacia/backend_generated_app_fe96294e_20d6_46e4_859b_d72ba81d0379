package com.mycompany.group234.repository;


import com.mycompany.group234.model.GitHubCreds;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.List;


@Component
public class GitHubCredsRepository extends SimpleJpaRepository<GitHubCreds, String> {
    private final EntityManager em;
    public GitHubCredsRepository(EntityManager em) {
        super(GitHubCreds.class, em);
        this.em = em;
    }
    @Override
    public List<GitHubCreds> findAll() {
        return em.createNativeQuery("Select * from \"generated_app\".\"GitHubCreds\"", GitHubCreds.class).getResultList();
    }
}