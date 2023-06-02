package com.projeto.system.controllers;

import com.projeto.system.dto.UserDTO;
import com.projeto.system.entities.User;
import com.projeto.system.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "user")
public class UserController {

    @Autowired
    UserService userService;

    @CrossOrigin
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @CrossOrigin
    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseStatus(HttpStatus.CREATED)
    public String saveUser(@Valid @RequestBody UserDTO userDTO){
        userService.saveUser(userDTO);
        return "Usuário Criado com Sucesso!";
    }

    @CrossOrigin
    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public String updateUser(@Valid @RequestBody UserDTO userDTO, @RequestParam Long userId) {
        userService.updateUser(userDTO, userId);
        return "Usuário Atualizado!";
    }

    @CrossOrigin
    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public String deleteUser(@RequestParam Long userId) {
        userService.deleteUser(userId);
        return "Usuário Excluído!";
    }

}
