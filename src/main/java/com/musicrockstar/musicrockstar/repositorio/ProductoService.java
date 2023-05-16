package com.musicrockstar.musicrockstar.repositorio;

import com.musicrockstar.musicrockstar.jpa.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@ApplicationScope
public class ProductoService{

    @Autowired
    private ProductoRepositorio productos;

    public ProductoService(ProductoRepositorio productos) {
        this.productos = this.productos;
    }

    public List<Producto> listaProductos() {
        List<Producto> todosProductos=productos.findAll();
        List<Producto> productosEnStock = new ArrayList<>();
        for (int i = 0; i<todosProductos.size();i++){
            if (todosProductos.get(i).getInventario()>0){
                productosEnStock.add(todosProductos.get(i));
            }
        }
        return productosEnStock;
    }

    public List<Producto> listaProductosTipo(String tipo) {
        List<Producto> todosProductos=productos.findAll();
        List<Producto> cuerdaProductos = new ArrayList<>();
        for (int i = 0; i<todosProductos.size();i++){
            if (todosProductos.get(i).getTipo().equalsIgnoreCase(tipo) && todosProductos.get(i).getInventario()>0){
                cuerdaProductos.add(todosProductos.get(i));
            }
        }
        return cuerdaProductos;
    }
    public List<Producto> listaProductosOferta() {
        List<Producto> todosProductos=productos.findAll();
        List<Producto> ofertaProductos = new ArrayList<>();
        for (int i = 0; i<todosProductos.size();i++){
            if (todosProductos.get(i).getSinRebaja() != 0){
                ofertaProductos.add(todosProductos.get(i));
            }
        }
        return ofertaProductos;
    }
    public Optional<Producto> bbuscarProducto(int id) {
        return productos.findById(id);
    }


}