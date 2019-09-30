package springboot.hibernate.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import springboot.hibernate.dao.UserDAO;
import springboot.hibernate.entity.User;

@Repository("userDAO")
public class UserDAOImpl implements UserDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void create(User user) {
        // TODO Auto-generated method stub
        sessionFactory.getCurrentSession().persist(user);
    }

    @Override
    public void remove(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        String queryString = "UPDATE User u SET u.isEnabled = 0 WHERE u.userId = :id";
        Query query = session.createQuery(queryString);
        query.setParameter("id", id);
        query.executeUpdate();
    }

    @Override
    public void edit(User user) {
        // TODO Auto-generated method stub
        sessionFactory.getCurrentSession().saveOrUpdate(user);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<User> findAll() {
        String query = "from User u where u.isEnabled = 1";
        Session session = this.sessionFactory.getCurrentSession();
        List<User> userList = session.createQuery(query, User.class).getResultList();
        return userList;
    }

    @Override
    public User find(int id) {
        // TODO Auto-generated method stub
        return (User) sessionFactory.getCurrentSession().get(User.class, id);
    }

    @SuppressWarnings("unchecked")
    @Override
    public User findUserByUserName(String name) {
        // TODO Auto-generated method stub
        Session session = this.sessionFactory.getCurrentSession();
        List<User> m = session.createQuery("from User where UserName=:name").setParameter("name", name).list();
        if (m.size() > 0) {
            return m.get(0);
        } else {
            return null;
        }
    }

}
