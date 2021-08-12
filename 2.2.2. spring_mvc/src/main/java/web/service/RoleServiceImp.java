package web.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.RoleDao;
import web.model.Role;

import java.util.List;

@Service
@Transactional
public class RoleServiceImp implements RoleService {
    RoleDao roleDao;

    public RoleServiceImp(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public List<Role> getRolesList() {
        return roleDao.getRolesList();
    }

    @Override
    public void deleteRole(String name) {
        roleDao.deleteRole(name);
    }

    @Override
    public Role getRole(String name) {
        return roleDao.getRole(name);
    }

    @Override
    public void saveRole(Role role) {
        roleDao.saveRole(role);
    }

    @Override
    public Role getRoleById(Long id) {
        return roleDao.getRoleById(id);
    }
}
