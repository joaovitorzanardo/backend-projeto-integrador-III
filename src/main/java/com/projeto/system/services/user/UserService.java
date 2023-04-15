package com.projeto.system.services.user;

import com.projeto.system.dto.UserDTO;
import com.projeto.system.entities.User;

import java.util.List;

public interface UserService {

    public List<User> getAllUsers();
    public User saveUser(UserDTO userDTO);

}
