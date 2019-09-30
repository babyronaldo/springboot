package springboot.hibernate.dao;

import springboot.hibernate.entity.Role;

import java.util.List;

public interface RoleDAO {
    public void create(Role role);

//    public void remove(int id);

    public void edit(Role role);

    public List<Role> findAll();

    public Role find(int id);

    public List<String> getRoleNames(int userId);

}
