package web.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import web.model.User;

import java.util.List;

public interface UserService extends UserDetailsService {
    List<User> getUserList();

    void add(User user);

    void delete(int id);

    void update(User user);

    User getUserById(int id);
}
