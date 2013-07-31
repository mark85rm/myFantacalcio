package it.myfantacalcio.dataobject;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="RUOLIGIOCATORI")
public class RuoloGiocatore implements Serializable {
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof RuoloGiocatore) {
			RuoloGiocatore temp = (RuoloGiocatore) obj;
			if (this.id.equals(temp.getId()))
				return true;
		}
		return false;
	}

	@Override
	public int hashCode() {
	    return id.hashCode();
	}

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
