package fr.gamedev.question.data;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;

@Entity
public class Category {

	@GeneratedValue(generator = "seq_gen_category")
	@GenericGenerator(name = "seq_gen_category", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
			parameters = { @Parameter(name = "sequence_name", value = "seq_category"),
					@Parameter(name = "initial_value", value = "0"), @Parameter(name = "increment_size", value = "1") })


	@Id
	private Long id;
	private String valeur;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getValeur() {
		return valeur;
	}
	public void setValeur(String valeur) {
		this.valeur = valeur;
	}
}
