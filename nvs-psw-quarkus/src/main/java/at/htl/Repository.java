package at.htl;

import at.htl.HashingPassword;
import at.htl.User;
import io.quarkus.hibernate.orm.runtime.session.JTASessionOpener;
import org.hibernate.Session;
import org.hibernate.Transaction;

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
                .getSingleResult();
        if(password != "") {
            HashingPassword hashingPassword = new HashingPassword();
            String newHash = password + retUser.getSalt();
            String tmp = hashingPassword.hash(newHash);


            if (retUser.getPassword() == tmp) {
                return retUser;
            }
        }
        else{
            return retUser;
        }
        return retUser;
    }
    public User forgetPassword(User user) {

        User user1 = findUserById(user.getUsername(), "");
        user1.setPassword(user.getPassword());

        HashingPassword hashingPassword = new HashingPassword();
        user1.setPassword(hashingPassword.hash(user1.getPassword()));


        User retUser = entityManager.merge(user1);

        return  retUser;

    }
}
