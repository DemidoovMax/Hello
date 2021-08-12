package web.service;

import web.model.Role;

import java.util.List;

public interface RoleService {
    List<Role> getRolesList();

    void deleteRole(String name);

    Role getRole(String name);

    void saveRole(Role role);

    Role getRoleById(Long id);
}
