package com.demo.cliente.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.demo.cliente.model.ClienteModel;

@Service
public class ClienteService implements IClienteService {

	private List<ClienteModel> clientes = new ArrayList<ClienteModel>();

	@Override
	public List<ClienteModel> listarClientes() {
		return clientes;
	}

	@Override
	public void crearCliente(ClienteModel cliente) {
		clientes.add(cliente);
	}

	@Override
	public Double promedioEdad() {
		Double promedioEdad = 0.0;
		for (ClienteModel cliente : clientes) {
			promedioEdad += cliente.getEdad();
		}
		promedioEdad /= clientes.size();
		return (Double.isNaN(promedioEdad) ? 0.0 : promedioEdad);
	}

	@Override
	public Double desviacionEdad() {
		Double promedio = promedioEdad(); // media aritmetica
		Double varianza = 0.0;
		Double desviacion = 0.0;

		// Obtenemos la Varianza
		for (ClienteModel cliente : clientes) {
			varianza += Math.pow(cliente.getEdad() - promedio, 2);
		}

		// suma de diferencias sobre "n"
		varianza = varianza / clientes.size();

		// Obtenemos la desviacion
		desviacion = Math.sqrt(varianza);

		return (Double.isNaN(desviacion) ? 0.0 : desviacion);
	}

}
