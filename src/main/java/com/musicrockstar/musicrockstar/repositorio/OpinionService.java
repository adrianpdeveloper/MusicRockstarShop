package com.musicrockstar.musicrockstar.repositorio;

import com.musicrockstar.musicrockstar.jpa.Opinion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

@Service
@ApplicationScope
public class OpinionService {
    @Autowired
    private OpinionRepositorio opiniones;

    public OpinionService(ProductoRepositorio productos) {
        this.opiniones = this.opiniones;
    }

    public void guardarOpinion(Opinion opinion) {
        opiniones.save(opinion);
    }

}
