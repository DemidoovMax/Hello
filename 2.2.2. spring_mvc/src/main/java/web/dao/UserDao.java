package web.dao;


import web.model.User;

import java.util.List;

public interface UserDao {
    List<User> getUserList();

    void add(User user);

    void delete(long id);

    void update(User user);

    User getUserById(long id);

    User findByUsername(String name);
}
