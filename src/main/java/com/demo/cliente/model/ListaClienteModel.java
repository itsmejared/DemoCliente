package com.demo.cliente.model;

import java.util.List;

public class ListaClienteModel {
	private List<ClienteModel> clientes;

	public ListaClienteModel(List<ClienteModel> clientes) {
		this.clientes = clientes;
	}

	public List<ClienteModel> getClientes() {
		return clientes;
	}

	public void setClientes(List<ClienteModel> clientes) {
		this.clientes = clientes;
	}

}
