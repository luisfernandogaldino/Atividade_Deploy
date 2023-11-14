package com.pedidos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pedidos.entities.Pedidos;
import com.pedidos.repository.PedidosRepository;

@Service
public class PedidosService {

	private final PedidosRepository pedidosRepository;

	@Autowired

	public PedidosService(PedidosRepository pedidosRepository) {
		this.pedidosRepository = pedidosRepository;
	}
	public  List<Pedidos> buscaTodosPedidos(){
		return pedidosRepository.findAll();
	}
	public Pedidos buscaPedidosId(Long id) {
		Optional <Pedidos> Pedidos = pedidosRepository.findById(id);
		return Pedidos.orElse(null);
	}
	public Pedidos salvaPedidos(Pedidos Pedidos){
		return pedidosRepository.save(Pedidos);
	}
	public Pedidos alterarPedidos(Long id, Pedidos alterarPedidos) {
		Optional <Pedidos> existePedidos = pedidosRepository.findById(id);
		if (existePedidos.isPresent()) {
			alterarPedidos.setId(id);
			return pedidosRepository.save(alterarPedidos);
		}
		return null;
	}
	public boolean apagarPedidos (Long id) {
		Optional <Pedidos> existePedidos = pedidosRepository.findById(id);
		if (existePedidos.isPresent()) {
			pedidosRepository.deleteById(id);
			return true;
		}
		return false;


	}
}
