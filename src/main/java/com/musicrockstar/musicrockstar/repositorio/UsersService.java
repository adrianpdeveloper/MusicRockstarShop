package com.musicrockstar.musicrockstar.repositorio;

import com.musicrockstar.musicrockstar.jpa.Opinion;
import com.musicrockstar.musicrockstar.jpa.Producto;
import com.musicrockstar.musicrockstar.jpa.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

import java.util.Optional;

@Service
@ApplicationScope
public class UsersService {

    @Autowired
    UsersRepositorio users;

    public void registrarUser(Users user) {
        users.save(user);
    }

    public Optional<Users> bbuscarUser(String correo) {
        return users.findById(correo);
    }

}
