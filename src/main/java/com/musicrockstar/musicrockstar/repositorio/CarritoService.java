package com.musicrockstar.musicrockstar.repositorio;

import com.musicrockstar.musicrockstar.jpa.Carrito;
import com.musicrockstar.musicrockstar.jpa.Direccion;
import com.musicrockstar.musicrockstar.jpa.Opinion;
import com.musicrockstar.musicrockstar.jpa.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.annotation.ApplicationScope;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@ApplicationScope
public class CarritoService {

    @Autowired
    CarritoRepositorio carritos;

    public CarritoService(CarritoRepositorio carritos) {
        this.carritos = carritos;
    }

    public Carrito carritoEmail(String email){
        List<Carrito> carritosAll = carritos.findAll();
        Carrito carrito = new Carrito();
        for (int i = 0; i<carritosAll.size();i++){
            if (carritosAll.get(i).getEmail().equalsIgnoreCase(email)){
                carrito = carritosAll.get(i);
            }
        }
        return carrito;
    }

    public void agregarCarritoEmail(String email, Producto producto, int id_Carrito){
        List<Carrito> carritosAll = carritos.findAll();
        Carrito carrito = new Carrito();
        for (int i = 0; i<carritosAll.size();i++){
            if (carritosAll.get(i).getEmail().equalsIgnoreCase(email)){
                carrito = carritosAll.get(i);
            }
        }
        List<Producto> productos = new ArrayList<Producto>();
        if (carrito.getProductos()!=null){
            System.out.println(carrito.getProductos().get(0).getDescripcion());
            productos = carrito.getProductos();
            for (int i = 0; i < carrito.getProductos().size(); i++){
                if (carrito.getProductos().get(i).getId()==producto.getId());

            }
            System.out.println("Numero de Productos "+ productos.size());
            productos.add(producto);
        }else{
            System.out.println("else");
            System.out.println("Numero de Productos "+ productos.size());
            productos.add(producto);
            System.out.println(productos.size());
        }
        carrito.setProductos(productos);
        carritos.save(carrito);
        //changeProductList(productos, id_Carrito);
    }
    public void guardarDireccion(Carrito carrito) {
        carritos.save(carrito);
    }

    @Transactional
    @Modifying
    @Query("update Carrito c set c.productos = ?1 where c.id= ?2")
    void changeProductList(List<Producto> productos, int id){};

}
