package nl.voeding.voedingsmeter.rest;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import nl.voeding.voedingsmeter.enums.Eenheid;
import nl.voeding.voedingsmeter.enums.Productgroep;
import nl.voeding.voedingsmeter.model.Gebruiker;
import nl.voeding.voedingsmeter.model.LocalDateDeserializer;
import nl.voeding.voedingsmeter.model.LocalDateSerializer;
import nl.voeding.voedingsmeter.model.Logboekdag;
import nl.voeding.voedingsmeter.model.Product;
import nl.voeding.voedingsmeter.service.GebruikerService;
import nl.voeding.voedingsmeter.service.ProductService;

@RestController
public class GebruikerEndpoint {

	@Autowired
	GebruikerService gebruikerService;
	
	@GetMapping("/createGebruiker")
	public Gebruiker createGebruiker() {
		Gebruiker gebruiker = new Gebruiker("Karen",LocalDate.of(1989, 12, 25),1.7f);
		gebruikerService.save(gebruiker);
		return gebruiker;
	}

	@PostMapping("/addLogboekdagToGebruiker/{id}")
	public void addLogboekdagToGebruiker(@RequestBody 	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonSerialize(using = LocalDateSerializer.class) LocalDate date,@PathVariable int id) {
		gebruikerService.addLogboekdag(new Logboekdag(date), id);
	}
	
	@GetMapping("/getGebruikers")
	public List<Gebruiker> getGebruikers() {
		System.out.println("getGebruikers");
		return gebruikerService.getAll();
	}
	
	@PostMapping("/GebruikerPost")
	public String postEntiteit(@RequestBody Gebruiker gebruiker) {
		System.out.println("Jojo");
		System.out.println(gebruiker.getNaam());
		gebruikerService.save(gebruiker);
		return "happy";
	}
	
    @GetMapping("/getGebruikerById/{id}")
	public Gebruiker getGebruikerById(@PathVariable int id) {
		System.out.println("getGebruikerById"+id);
	    return gebruikerService.getGebruikerById(id);
	}
	
    @DeleteMapping("/delGebruikerById/{id}")
    public void delGebruikerById(@PathVariable int id) {
		System.out.println("delGebruikerById"+id);
	    gebruikerService.delGebruikerById(id);
	}

}
