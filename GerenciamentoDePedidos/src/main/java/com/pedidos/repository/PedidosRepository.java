package com.pedidos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pedidos.entities.Pedidos;

public interface PedidosRepository extends JpaRepository<Pedidos,Long> {

}
