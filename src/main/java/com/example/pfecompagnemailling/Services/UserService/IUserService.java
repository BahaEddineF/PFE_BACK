package com.example.pfecompagnemailling.Services.UserService;

import com.example.pfecompagnemailling.DTO.UserInfo;
import com.example.pfecompagnemailling.Entities.User;

import java.util.List;

import org.springframework.security.core.Authentication;

public interface IUserService {
    public User addUser(User user);

    public User updateUser(UserInfo userInfo);

    public List<UserInfo> getAllUsers();

    public User getUserById(int id);

    public UserInfo getUserInfoById(int id);

    public void deleteUser(int id);

    void blockUser(int id);

    void unblockUser(int id);

    long countUsers();
    
    UserInfo getUserProfile(Authentication authentication);

}
