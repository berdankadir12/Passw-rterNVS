package at.htl;

import at.htl.HashingPassword;
import at.htl.User;

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
    public User findUserById(String username, String password){


        User retUser = entityManager.createQuery("SELECT u FROM User u WHERE u.username = :username", User.class)
                .setParameter("username", username)
                .getSingleResult();;



        HashingPassword hashingPassword = new HashingPassword();
        String newHash = password + retUser.getSalt();
        String tmp = hashingPassword.hash(newHash);


        if(retUser.getPassword() == tmp){
            return retUser;
        }
        return null;
    }

}
