package com.example.pfecompagnemailling.Services.RoleService;

import com.example.pfecompagnemailling.Entities.Role;

import java.util.List;

public interface IRoleService {
    public Role addRole(Role Role);

    public Role updateRole(Role Role);

    public List<Role> getAllRoles();

    public Role getRoleById(int id);

    public void deleteRole(int id);
}
