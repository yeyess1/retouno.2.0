package com.example.reto10.repository;

import com.example.reto10.crudRepository.UserCrudRepository;
import com.example.reto10.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {
    @Autowired
    private UserCrudRepository userCrudRepository;

    public List<User> getAll() {
        return (List<User>) userCrudRepository.findAll();
    }

    public Optional<User>getUser(int id){
        return userCrudRepository.findById(id);
    }
    public User save(User user){
        return userCrudRepository.save(user);
    }
    public boolean emailExist (String email){
        Optional<User> usuario = userCrudRepository.findByEmail(email);
        return !usuario.isEmpty();//ojo aqui en el original es con !
    }

    public Optional<User> autenticarUsuario (String email, String password) {
        return userCrudRepository.findByEmailAndPassword(email, password);
    }
}
