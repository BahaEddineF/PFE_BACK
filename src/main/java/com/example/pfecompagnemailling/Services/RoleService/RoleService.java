package com.example.pfecompagnemailling.Services.RoleService;

import com.example.pfecompagnemailling.Entities.Role;
import com.example.pfecompagnemailling.Repository.RoleRepository;
import com.example.pfecompagnemailling.Services.PlanificationService.IPlanificationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RoleService implements IRoleService {

    public RoleRepository roleRepository;

    @Override
    public Role addRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Role updateRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    public Role getRoleById(int id) {
        return roleRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteRole(int id) {
        roleRepository.deleteById(id);
    }
}
