package nl.voeding.voedingsmeter.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import nl.voeding.voedingsmeter.model.Product;
import nl.voeding.voedingsmeter.repositories.VoedingsmeterRepository;

@Service
@Transactional
public class VoedingsmeterService {

	@Autowired
	VoedingsmeterRepository voedingsmeterRepository;
	
	public Product save(Product product) {
		voedingsmeterRepository.save(product);
		return product;
	}
	
	public List<Product> getAll() {
		return (List<Product>)voedingsmeterRepository.findAll();
	}
}