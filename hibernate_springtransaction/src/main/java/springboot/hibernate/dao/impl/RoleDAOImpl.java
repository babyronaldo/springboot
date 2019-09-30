package springboot.hibernate.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import springboot.hibernate.dao.RoleDAO;
import springboot.hibernate.entity.Role;

import java.util.List;

@Repository("roleDAO")
public class RoleDAOImpl implements RoleDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void create(Role role) {
        // TODO Auto-generated method stub
        sessionFactory.getCurrentSession().persist(role);
    }

    @Override
    public void edit(Role role) {
        // TODO Auto-generated method stub
        sessionFactory.getCurrentSession().saveOrUpdate(role);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Role> findAll() {
        String query = "from Role r";
        Session session = this.sessionFactory.getCurrentSession();
        List<Role> roleList = session.createQuery(query, Role.class).getResultList();
        return roleList;
    }

    @Override
    public Role find(int id) {
        // TODO Auto-generated method stub
        return (Role) sessionFactory.getCurrentSession().get(Role.class, id);
    }

}