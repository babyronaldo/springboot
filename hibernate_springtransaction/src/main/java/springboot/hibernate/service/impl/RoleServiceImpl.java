package springboot.hibernate.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.hibernate.dao.RoleDAO;
import springboot.hibernate.entity.Role;
import springboot.hibernate.service.RoleService;

import javax.transaction.Transactional;
import java.util.List;

@Service("roleService")
@Transactional
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDAO roleDAO;

    @Override
    public void create(Role role) {
        // TODO Auto-generated method stub
        roleDAO.create(role);
    }

    @Override
    public void edit(Role role) {
        // TODO Auto-generated method stub
        roleDAO.edit(role);
    }

    @Override
    public List<Role> findAll() {
        // TODO Auto-generated method stub
        return roleDAO.findAll();
    }

    @Override
    public Role find(int id) {
        // TODO Auto-generated method stub
        return roleDAO.find(id);
    }

}
