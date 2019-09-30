package springboot.hibernate.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springboot.hibernate.dao.UserDAO;
import springboot.hibernate.entity.User;
import springboot.hibernate.service.UserService;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDAO;

    @Override
    public void create(User user) {
        // TODO Auto-generated method stub
        userDAO.create(user);
    }

    @Override
    public void remove(int id) {
        // TODO Auto-generated method stub
        userDAO.remove(id);
    }

    @Override
    public void edit(User user) {
        // TODO Auto-generated method stub
        userDAO.edit(user);
    }

    @Override
    public List<User> findAll() {
        // TODO Auto-generated method stub
        return userDAO.findAll();
    }

    @Override
    public User find(int id) {
        // TODO Auto-generated method stub
        return userDAO.find(id);
    }

    @Override
    public User findUserByUserName(String name) {
        // TODO Auto-generated method stub
        return this.userDAO.findUserByUserName(name);
    }

}
