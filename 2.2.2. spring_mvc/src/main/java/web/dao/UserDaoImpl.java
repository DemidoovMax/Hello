package web.dao;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
@ComponentScan("web")
@Transactional
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    EntityManager entityManager;


    @Override
    public List<User> getUserList() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    public void add(User user) {
        entityManager.persist(user);
    }

    @Override
    public void delete(int id) {
        entityManager.createQuery("delete from User u where u.id = :id").setParameter("id", id).executeUpdate();
    }

    @Override
    public void update(User user) {
        entityManager.merge(user);
    }

    @Override
    public User getUserById(int id) {
        return entityManager.createQuery("select u from User u where u.id = :id", User.class)
                .setParameter("id", id).getSingleResult();
    }
}
