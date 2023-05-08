package com.musicrockstar.musicrockstar.repositorio;

import com.musicrockstar.musicrockstar.jpa.Producto;
import com.musicrockstar.musicrockstar.jpa.Prueba;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

import java.util.List;

@Service
@ApplicationScope
public class PruebaService {

    @Autowired
    private PruebaRepository prueba;

    public PruebaService(ProductoRepositorio productos) {
        this.prueba = this.prueba;
    }

    public List<Prueba> listaPruebas() {
        return prueba.findAll();
    }
}
