package nl.voeding.voedingsmeter.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
public class Gebruiker {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull
	private String naam;
	
	@NotNull
	private LocalDate geboortedatum;
	
	@NotNull
	private Float lengte;
	
	@NotNull
	@OneToMany(mappedBy = "gebruiker")
	private Set<Logboekdag> logboek = new HashSet<>();

	//private Set<Lichaamssamenstelling> lichaamssamenstellingen = new HashSet<>();
}
