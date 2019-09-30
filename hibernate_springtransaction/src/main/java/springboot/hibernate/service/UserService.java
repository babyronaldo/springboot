package springboot.hibernate.service;

import java.util.List;

import springboot.hibernate.entity.User;

public interface UserService {
    public void create(User user);

    public void remove(int id);

    public void edit(User user);

    public List<User> findAll();

    public User find(int id);

    public User findUserByUserName(String name);
}
