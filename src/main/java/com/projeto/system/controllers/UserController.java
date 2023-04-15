package com.projeto.system.controllers;

import com.projeto.system.dto.UserDTO;
import com.projeto.system.entities.User;
import com.projeto.system.services.user.UserServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "user")
public class UserController {

    private final UserServiceImpl usuarioService;

    @Autowired
    public UserController(UserServiceImpl usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return usuarioService.getAllUsers();
    }

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<User> saveUser(@Valid @RequestBody UserDTO userDTO){
        User newUser  = usuarioService.saveUser(userDTO);
        return new ResponseEntity<User>(newUser, HttpStatus.CREATED);
    }
}
