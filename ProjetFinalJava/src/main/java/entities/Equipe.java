package entities;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonView;

import views.Views;

@Entity
@Table(name="equipe")
@SequenceGenerator(name = "seqEquipe", sequenceName = "seq_equipe", initialValue = 100, allocationSize = 1)
public class Equipe {

	@Id
	@GeneratedValue(generator = "seqEquipe", strategy = GenerationType.SEQUENCE)
	private Integer id;
	@EmbeddedId
	private EquipeKey key;
	@JsonView(Views.Common.class)
	@Column(name = "teamname", nullable = false, unique = true, length = 200)
	@NotEmpty
	private String name;

	
	public Equipe() {
		
	}

	public Equipe(Integer id, EquipeKey key, @NotEmpty String name) {
		this.id = id;
		this.key = key;
		this.name = name;
	}

	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public EquipeKey getKey() {
		return key;
	}

	public void setKey(EquipeKey key) {
		this.key = key;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((key == null) ? 0 : key.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Equipe other = (Equipe) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	
	
	

	
	
	
}
