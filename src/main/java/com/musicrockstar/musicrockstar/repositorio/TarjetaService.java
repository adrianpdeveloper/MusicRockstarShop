package com.musicrockstar.musicrockstar.repositorio;

import com.musicrockstar.musicrockstar.jpa.Direccion;
import com.musicrockstar.musicrockstar.jpa.Tarjeta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

import java.util.ArrayList;
import java.util.List;

@Service
@ApplicationScope
public class TarjetaService {

    @Autowired
    TarjetaRepositorio tarjetas;

    public void guardarTarjeta(Tarjeta tarjeta) {
        tarjetas.save(tarjeta);
    }
    public TarjetaService(TarjetaRepositorio tarjetas) {
        this.tarjetas = tarjetas;
    }

    public List<Tarjeta> listaTarjetasEmail(String email) {
        List<Tarjeta> tarjetasAll=tarjetas.findAll();
        List<Tarjeta> tarjetasEmail = new ArrayList<>();
        for (int i = 0; i<tarjetasAll.size();i++){
            if (tarjetasAll.get(i).getEmail().equalsIgnoreCase(email)){
                tarjetasEmail.add(tarjetasAll.get(i));
            }
        }
        return tarjetasEmail;
    }

    public void borrarTarjeta(int id) {

        tarjetas.deleteById(id);
    }
}
