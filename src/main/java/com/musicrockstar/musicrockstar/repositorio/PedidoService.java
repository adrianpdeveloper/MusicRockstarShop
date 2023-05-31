package com.musicrockstar.musicrockstar.repositorio;

import com.musicrockstar.musicrockstar.jpa.Carrito;
import com.musicrockstar.musicrockstar.jpa.Pedido;
import com.musicrockstar.musicrockstar.jpa.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.annotation.ApplicationScope;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@ApplicationScope
public class PedidoService {

    @Autowired
    PedidoRepositorio pedidos;

    @Autowired
    ProductoRepositorio productos;
    public PedidoService(PedidoRepositorio pedidos) {
        this.pedidos = pedidos;
    }

    public List<Pedido> pedidoEmail(String email){
        List<Pedido> pedidosAll = pedidos.findAll();
        List<Pedido> pedidos = new ArrayList<Pedido>();
        Pedido pedido = new Pedido();
        for (int i = 0; i<pedidosAll.size();i++){
            if (pedidosAll.get(i).getEmail().equalsIgnoreCase(email)){
                pedido = pedidosAll.get(i);
                pedidos.add(pedido);
            }
        }
        return pedidos;
    }
    public Optional<Pedido> bbuscarPedido(int id){
        return pedidos.findById(id);
    }

    public void borrarPedido(int id) {

        pedidos.deleteById(id);
    }

    public void ejecutarPedido(Pedido pedido){
        pedidos.save(pedido);
    }



}
