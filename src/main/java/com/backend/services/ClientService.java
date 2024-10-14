package com.backend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.entities.Client;
import com.backend.repositories.ClientRepository;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository repository;
	
	public List<Client> findAll() {
		return repository.findAll();
	}
	
	public Client findById(Long id) {
		Optional<Client> obj = repository.findById(id);
		return obj.get();
	}
	
	public Client insert(Client obj) {
		return repository.save(obj);
	}
	
	public Client update(Client obj, Long id) {
		Client client = findById(id);
		client.setAccessionDate(obj.getAccessionDate());
		client.setName(obj.getName());
		client.setPhoneNumber(obj.getPhoneNumber());
		return repository.save(client);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
}
