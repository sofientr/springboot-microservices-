/*
 * Copyright (C) TALYS ™ - All Rights Reserved Unauthorized copying of this file, via any medium is
 * strictly prohibited Proprietary and confidential
 */
package com.esprit.microservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.microservice.entity.Client;
import com.esprit.microservice.repository.ClientRepository;

/**
 * {@link } class.
 *
 * @since 0.1.0
 */
@Service
public class ClientService {
	@Autowired
	private ClientRepository clientRepository;

	public Client addClient(Client a) {

		return clientRepository.save(a);

	}

	public List<Client> getAllClient() {

		return clientRepository.findAll();
	}

	public String deleteClient(int id) {

		if (clientRepository.findById(id).isPresent()) {
			clientRepository.deleteById(id);
			return "aero supprimé";
		}
		else
			return " aero non supprimé";
	}

	public Client updateClient(int id, Client a) {

		if (clientRepository.findById(id).isPresent()) {
			Client existingClient = clientRepository.findById(id).get();
			existingClient.setNom(a.getNom());
			existingClient.setPrenom(a.getPrenom());
			existingClient.setTel(a.getTel());
			return clientRepository.save(existingClient);

		}
		else
			return null;

	}

}
