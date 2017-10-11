package nl.voeding.voedingsmeter.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import nl.voeding.voedingsmeter.enums.Eenheid;
import nl.voeding.voedingsmeter.model.Product;
import nl.voeding.voedingsmeter.service.VoedingsmeterService;

@RestController
public class VoedingsmeterEndpoint {

	@Autowired
	VoedingsmeterService voedingsmeterService;
	
	@GetMapping("/hallo")
	public String getHallo() {
		return "Hallo allemaal";
	}
	
	@GetMapping("/createProduct")
	public Product createProduct() {
		Product appel = new Product("appel",100f,Eenheid.GRAM,60f,0f,0.2f,0f,0.2f,13f,10.4f,null,2.0f,0.003f,"http://www.voedingscentrum.nl/encyclopedie/appel.aspx");
		voedingsmeterService.save(appel);
		return appel;
	}

	@GetMapping("/getProducts")
	public List<Product> getProducts() {
		return voedingsmeterService.getAll();
	}

}
