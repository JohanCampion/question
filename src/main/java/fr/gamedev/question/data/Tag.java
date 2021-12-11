package fr.gamedev.question.data;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;

@Entity
public class Tag {

	@GeneratedValue(generator = "seq_gen_tag")
	@GenericGenerator(name = "seq_gen_tag", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
			parameters = { @Parameter(name = "sequence_name", value = "seq_tag"),
					@Parameter(name = "initial_value", value = "0"), @Parameter(name = "increment_size", value = "1") })


	@Id
	private Long id;
	private String valeur;
	@ManyToOne
	private Category category;



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
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	
	
}
