
package com.esprit.microservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.esprit.microservice.entity.Client;
import com.esprit.microservice.service.ClientService;

@RestController
@RequestMapping(value = "/api/client")
public class ClientController {
	private String title = "Hello,I'm the aero Microservice";
	@Autowired
	ClientService clientService;

	@RequestMapping("/hello")
	public String sayHello() {

		System.out.println(title);
		return title;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Client> createAero(@RequestBody Client a) {

		return new ResponseEntity<>(clientService.addClient(a), HttpStatus.OK);
	}

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<Client>> getClients() {

		return new ResponseEntity<>(clientService.getAllClient(), HttpStatus.OK);
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Client updateClient(@PathVariable(value = "id") int id, @RequestBody Client a) {

		return clientService.updateClient(id, a);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<String> deleteClient(@PathVariable(value = "id") int id) {

		return new ResponseEntity<String>(clientService.deleteClient(id), HttpStatus.OK);
	}

}
