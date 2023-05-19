package com.example.pfecompagnemailling.Services.UserService;


import com.example.pfecompagnemailling.DTO.UserInfo;
import com.example.pfecompagnemailling.Entities.Role;
import com.example.pfecompagnemailling.Entities.User;
import com.example.pfecompagnemailling.Repository.RoleRepository;
import com.example.pfecompagnemailling.Repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserService implements IUserService {
    public final UserRepository userRepository;
    public final RoleRepository roleRepository;
     
    @Override
    public User addUser(User user) {
        Role roleUser = roleRepository.findById(2).get();
        user.setRole(roleUser);
        user.setActive(true);
        return userRepository.save(user);
    }

    @Override
    public User updateUser(UserInfo userInfo) {
            User user = userRepository.findById(userInfo.getId()).get();
        Role roleUser = roleRepository.findById(2).get();
        user.setRole(roleUser);
        user.setActive(userInfo.isActive());
        user.setNom(userInfo.getNom());
        user.setPrenom(userInfo.getPrenom());
        user.setDatenaissance(userInfo.getDateDeNaissance());
        user.setLogin(userInfo.getLogin());
        user.setEmail(userInfo.getEmail());
        return userRepository.save(user);
    }

    @Override
    public List<UserInfo> getAllUsers() {
        return userRepository.findAll().stream().map(UserInfo::fromEntity).collect(Collectors.toList());
    }
    @Override
    public User getUserById(int id) {
        return userRepository.findById(id).orElse(null);
      
    }

    @Override
    public UserInfo getUserInfoById(int id) {
        User user =  userRepository.findById(id).orElse(null);
        return UserInfo.fromEntity(user);
    }

    @Override
    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }

    @Override
    public void blockUser(int id) {
        User user  = this.getUserById(id);
        user.setActive(false);
        userRepository.save(user);
    }

    @Override
    public void unblockUser(int id) {
        User user  = this.getUserById(id);
        user.setActive(true);
        userRepository.save(user);
    }

}
