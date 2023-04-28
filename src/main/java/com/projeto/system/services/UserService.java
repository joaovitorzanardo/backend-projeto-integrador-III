package com.projeto.system.services;

import com.projeto.system.dto.UserDTO;
import com.projeto.system.entities.User;
import com.projeto.system.constants.UserRole;
import com.projeto.system.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return  userRepository.findAll();
    }

    public void saveUser(UserDTO userDTO) {
        User user = new User();
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setOrganization(userDTO.getOrganization());
        user.setUserRole(UserRole.ADMIN);
        userRepository.save(user);
    }

    public void updateUser(UserDTO userDTO, Long userId) {
        User user = userRepository.findUserByUserId(userId);
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setOrganization(userDTO.getOrganization());
        userRepository.save(user);
    }

    public void deleteUser(Long userId) {
        User user = userRepository.findUserByUserId(userId);
        userRepository.delete(user);
    }

}
