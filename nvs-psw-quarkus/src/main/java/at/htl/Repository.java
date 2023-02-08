package at.htl;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@ApplicationScoped
public class Repository {

    @Inject
    EntityManager entityManager;

    @Transactional
    public User addNewUser(User user){

        entityManager.persist(user);

        return user;
    }
}
