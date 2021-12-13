package com.example.reto10.services;

import com.example.reto10.model.User;
import com.example.reto10.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServices {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAll() {
        return userRepository.getAll();
    }

    public Optional<User> getUser(int id) {
        return userRepository.getUser(id);
    }

    public User registrar(User user) {
        if (user.getId() == null) {
            if (!userRepository.emailExist(user.getEmail())) {//pilas esta linea de codigo difiere del original
                return userRepository.save(user);
            } else {
                return user;
            }
        } else {
            return user;
        }
    }


    public boolean existeEmail(String email) {
        return userRepository.emailExist(email);
    }

    public User autenticarUsuario(String email, String password) {
        Optional<User> usuario = userRepository.autenticarUsuario(email, password);
        if (usuario.isEmpty()) {
            return new User(email, password, "NO DEFINIDO ");
        } else {
            return usuario.get();
        }
    }
}




