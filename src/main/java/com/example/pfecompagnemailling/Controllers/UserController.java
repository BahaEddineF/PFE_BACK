package com.example.pfecompagnemailling.Controllers;


import com.example.pfecompagnemailling.DTO.UserInfo;
import com.example.pfecompagnemailling.Entities.User;
import com.example.pfecompagnemailling.Services.UserService.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class UserController {
    IUserService iUserService;

    @PostMapping("/addUser")
    public User addUser(@RequestBody User User){
        return iUserService.addUser(User)  ;
    }

    @PutMapping("/updateUser")
    public User updateUser(@RequestBody UserInfo userInfo ){
        return iUserService.updateUser(userInfo)  ;
    }

    @GetMapping("/getAllUser")
    public List<UserInfo> getAllUser(){
        return iUserService.getAllUsers()  ;
    }

    @GetMapping("/getUserInfoById/{id}")
    public UserInfo getUserInfoById(@PathVariable("id") int id){
        return iUserService.getUserInfoById(id)  ;
    }

    @DeleteMapping("/deleteUser/{id}")
    public void getUsedeleteUserrById(@PathVariable("id") int id){
         iUserService.deleteUser(id);  ;
    }

    @PutMapping(value = "/blockUser/{id}")
    public void blockUser(@PathVariable("id") int id)
    {
        iUserService.blockUser(id);
    }

    @PutMapping(value = "/unblockUser/{id}")
    public void unblockUser(@PathVariable("id") int id)
    {
        iUserService.unblockUser(id);
    }
}
