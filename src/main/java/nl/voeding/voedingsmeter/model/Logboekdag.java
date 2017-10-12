package nl.voeding.voedingsmeter.model;

import nl.voeding.voedingsmeter.model.Gebruiker;
import java.time.LocalDate;
import java.util.Collection;
import java.util.HashMap;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.NaturalId;


@Entity
public class Logboekdag {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull
	private LocalDate datum;
	
	@NaturalId
	@NotNull
	@ManyToOne
	private Gebruiker gebruiker;

	@OneToMany
	@NotNull
	private HashMap<Product,Float> producten = new HashMap<>();

	public Logboekdag(Long id, LocalDate datum, Gebruiker gebruiker) {
		super();
		this.id = id;
		this.datum = datum;
		this.gebruiker = gebruiker;
	}

	public Gebruiker getGebruiker() {
		return gebruiker;
	}

	public void setGebruiker(Gebruiker gebruiker) {
		this.gebruiker = gebruiker;
	}
	
	public void addProduct(Product product, Float hoeveelheid) {
		producten.merge(product, hoeveelheid, Float::sum);
	}
	
	public void removeProduct(Product product) {
		producten.remove(product);
	}
	
	public void removeProduct(Product product,Float hoeveelheid) {
		producten.merge(product, -hoeveelheid, Float::sum);
		if (producten.get(product)<=0) {
			producten.remove(product);
		}
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDatum() {
		return datum;
	}

	public void setDatum(LocalDate datum) {
		this.datum = datum;
	}

}
