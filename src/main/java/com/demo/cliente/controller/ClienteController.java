package com.demo.cliente.controller;

import java.util.HashMap;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.cliente.model.ClienteModel;
import com.demo.cliente.model.ListaClienteModel;
import com.demo.cliente.service.IClienteService;
import com.google.gson.Gson;

@RestController
public class ClienteController {

	private final IClienteService clienteService;

	public ClienteController(IClienteService clienteService) {
		this.clienteService = clienteService;
	}

	@GetMapping(value = "/listclientes", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getClients() {
		ListaClienteModel clientes = new ListaClienteModel(clienteService.listarClientes());
		return ResponseEntity.ok(new Gson().toJson(clientes));
	}

	@GetMapping(value = "/kpideclientes", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> kpiClients() {
		Double promedioEdad = clienteService.promedioEdad();
		Double desviacionEdad = clienteService.desviacionEdad();
		int cantidadEdad = clienteService.listarClientes().size();
		HashMap<String, String> respuesta = new HashMap<String, String>();
		respuesta.put("Mensaje", String.format("Se procesaron %s clientes", cantidadEdad));
		respuesta.put("x1", String.format("El promedio de edad entre todos los clientes es %.2f", promedioEdad));
		respuesta.put("x2",
				String.format("La desviacion estandar de edad entre todos los clientes es %.2f", desviacionEdad));
		return ResponseEntity.ok(new Gson().toJson(respuesta));
	}

	@PostMapping(value = "/creacliente", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> createClient(@RequestBody ClienteModel cliente) {
		clienteService.crearCliente(cliente);
		HashMap<String, String> respuesta = new HashMap<String, String>();
		respuesta.put("Mensaje", String.format("Cliente %s %s fue creado", cliente.getNombre(), cliente.getApellido()));
		return ResponseEntity.ok(new Gson().toJson(respuesta));
	}

}