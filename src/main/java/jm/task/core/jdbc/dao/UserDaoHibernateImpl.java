package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


import java.util.List;

public class UserDaoHibernateImpl implements UserDao {
    private Session session;
    private final SessionFactory factory;

    public UserDaoHibernateImpl() {
        factory = Util.getFactory();
    }


    @Override
    public void createUsersTable() {
            session = factory.getCurrentSession();
            session.beginTransaction();
            session.createSQLQuery("CREATE TABLE IF NOT EXISTS users (id int not null AUTO_INCREMENT, name VARCHAR(40)," +
                    "lastName VARCHAR(40), age INT, primary key (id))").executeUpdate();
            session.getTransaction().commit();
    }

    @Override
    public void dropUsersTable() {
            session = factory.getCurrentSession();
            session.beginTransaction();
            session.createSQLQuery("drop table if EXISTS users").executeUpdate();
            session.getTransaction().commit();
            session.close();
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
            User user = new User(name, lastName, age);
            session = factory.getCurrentSession();
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
            session.close();
    }

    @Override
    public void removeUserById(long id) {
            session = factory.getCurrentSession();
            session.beginTransaction();
            User user = session.get(User.class, id);
            session.delete(user);
            session.getTransaction().commit();
            session.close();

    }

    @Override
    public List<User> getAllUsers() {
            session = factory.getCurrentSession();
            session.beginTransaction();
            List<User> userList = session.createQuery("from User", User.class).getResultList();
            session.getTransaction().commit();
            session.close();
            return userList;


    }

    @Override
    public void cleanUsersTable() {
            session = factory.getCurrentSession();
            session.beginTransaction();
            session.createQuery("delete User").executeUpdate();
            session.getTransaction().commit();
            session.close();
    }
}
