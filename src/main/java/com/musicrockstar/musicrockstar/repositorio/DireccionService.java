package com.musicrockstar.musicrockstar.repositorio;

import com.musicrockstar.musicrockstar.jpa.Direccion;
import com.musicrockstar.musicrockstar.jpa.Opinion;
import com.musicrockstar.musicrockstar.jpa.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@ApplicationScope
public class DireccionService {

    @Autowired
    DireccionRepositorio direcciones;

    public DireccionService(DireccionRepositorio direcciones) {
        this.direcciones = direcciones;
    }

    public void guardarDireccion(Direccion direccion) {
        direcciones.save(direccion);
    }
    public List<Direccion> listaDireccionesEmail(String email) {
        List<Direccion> direccionesAll=direcciones.findAll();
        List<Direccion> direccionesEmail = new ArrayList<>();
        for (int i = 0; i<direccionesAll.size();i++){
            if (direccionesAll.get(i).getEmail().equalsIgnoreCase(email)){
                direccionesEmail.add(direccionesAll.get(i));
            }
        }
        return direccionesEmail;
    }

    public void borrarDireccion(int id) {

        direcciones.deleteById(id);
    }
}
