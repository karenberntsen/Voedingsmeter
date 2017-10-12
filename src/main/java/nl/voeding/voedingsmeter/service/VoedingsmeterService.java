package nl.voeding.voedingsmeter.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import nl.voeding.voedingsmeter.model.Product;
import nl.voeding.voedingsmeter.repositories.ProductRepository;

@Service
@Transactional
public class VoedingsmeterService {

	@Autowired
	ProductRepository voedingsmeterRepository;
	
	public Product save(Product product) {
		voedingsmeterRepository.save(product);
		return product;
	}
	
	public List<Product> getAll() {
		return (List<Product>)voedingsmeterRepository.findAll();
	}
	
	public Product getProductById(int id) {
		System.out.println("Service:getProductById"+id);
	    return voedingsmeterRepository.findOne((long)id);
	}
	
	public void delProductById(int id) {
		System.out.println("Service:delProductById"+id);		
		voedingsmeterRepository.delete((long)id);
	}
	
}