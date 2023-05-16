package com.musicrockstar.musicrockstar.repositorio;

import com.musicrockstar.musicrockstar.jpa.Carrito;
import com.musicrockstar.musicrockstar.jpa.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepositorio extends JpaRepository<Pedido, Integer> {


}
