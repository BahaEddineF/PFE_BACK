package com.example.pfecompagnemailling.Controllers;


import com.example.pfecompagnemailling.Entities.Role;
import com.example.pfecompagnemailling.Services.RoleService.IRoleService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class RoleController {
    IRoleService iRoleService;

    @PostMapping("/addRole")
    public Role addRole(@RequestBody Role Role){
        return iRoleService.addRole(Role)  ;
    }

    @PutMapping("/updateRole")
    public Role updateRole(@RequestBody Role Role){
        return iRoleService.updateRole(Role)  ;
    }

    @GetMapping("/AllRole")
    public List<Role> AllRole(){
        return iRoleService.getAllRoles()  ;
    }

    @GetMapping("/getRoleById/{id}")
    public Role getRoleById(@PathVariable("id") int id){
        return iRoleService.getRoleById(id)  ;
    }

    @DeleteMapping("/deleteRole/{id}")
    public void deleteRole(@PathVariable("id") int id){
        iRoleService.deleteRole(id);  ;
    }
}
