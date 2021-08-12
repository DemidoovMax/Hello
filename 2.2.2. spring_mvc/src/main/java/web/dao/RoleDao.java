package web.dao;

import web.model.Role;

import java.util.List;

public interface RoleDao {
    List<Role> getRolesList();

    void deleteRole(String name);

    Role getRole(String name);

    void saveRole(Role role);

    Role getRoleById(Long id);
}
