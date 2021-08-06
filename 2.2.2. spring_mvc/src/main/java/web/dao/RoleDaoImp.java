package web.dao;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import web.model.Role;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
@ComponentScan("web")
@Transactional
public class RoleDaoImp implements RoleDao {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Role> getRolesList() {
        return entityManager.createQuery("select r from Role r", Role.class).getResultList();
    }

    @Override
    public void deleteRole(String name) {
        entityManager.createQuery("delete from User u where u.name = :name")
                .setParameter("name", name).executeUpdate();
    }

    @Override
    public Role getRole(String name) {
        return entityManager.createQuery("select r from Role r where r.role = :role", Role.class)
                .setParameter("role", name).getSingleResult();

    }

    @Override
    public void saveRole(Role role) {
        entityManager.persist(role);
    }
}
