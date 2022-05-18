package web.dao;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.models.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;


//    @Override
//    @Transactional
//    public void createUsersTable() {
//        entityManager.createNativeQuery("CREATE TABLE IF NOT EXISTS `users` (\n" +
//                "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
//                "  `firstName` VARCHAR(45) NOT NULL,\n" +
//                "  `lastName` VARCHAR(45) NOT NULL,\n" +
//                "  `email` VARCHAR(45) NOT NULL,\n" +
//                "  PRIMARY KEY (`id`));").executeUpdate();
//    }

    @Override
    public List<User> index() {
        return entityManager.createQuery("select s from User s ", User.class)
                .getResultList();
    }

    @Transactional
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public User show(long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void update(long id, User user) {
        entityManager.persist();
    }

}
