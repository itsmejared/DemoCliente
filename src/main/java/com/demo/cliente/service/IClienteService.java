package com.demo.cliente.service;

import java.util.List;

import com.demo.cliente.model.ClienteModel;

public interface IClienteService {
	
	public void crearCliente(ClienteModel cliente);
	public Double promedioEdad();
	public Double desviacionEdad();
	public List<ClienteModel> listarClientes();

}
