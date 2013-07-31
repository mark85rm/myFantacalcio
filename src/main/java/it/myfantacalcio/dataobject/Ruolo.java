package it.myfantacalcio.dataobject;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="RUOLI")
public class Ruolo implements Serializable {
	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 858657288260990083L;
	
	@Id
	@Column(name="ID")
	@GeneratedValue
	private Integer id;
	
	@Column(name="NOME")
	private String nome;
	
	@ManyToMany(mappedBy="ruoli")
	private Set<Utente> utenti = new HashSet<Utente>();

	public Set<Utente> getUtenti() {
		return utenti;
	}

	public void setUtenti(Set<Utente> utenti) {
		this.utenti = utenti;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Ruolo [id=" + id + ", nome=" + nome + "]";
	}
	
	

}
