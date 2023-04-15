package com.projeto.system.services.user;

import com.projeto.system.entities.User;
import com.projeto.system.repositories.UserRepository;
import com.projeto.system.security.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findUserByEmail(email);
        if (user != null) {
            return new UserDetails(user);
        }
        throw new UsernameNotFoundException("Nenhum usuário com o email fornecido foi encontrado!");
    }
}
