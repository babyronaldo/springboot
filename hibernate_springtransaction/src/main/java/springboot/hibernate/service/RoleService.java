package springboot.hibernate.service;

import springboot.hibernate.entity.Role;

import java.util.List;

public interface RoleService {
    public void create(Role role);

    public void edit(Role role);

    public List<Role> findAll();

    public Role find(int id);

}
