package it.myfantacalcio.dataobject;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "GIOCATORI")
public class Giocatore implements Serializable {

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Giocatore) {
			Giocatore temp = (Giocatore) obj;
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
	private static final long serialVersionUID = -7488239478930713985L;

	@Id
	@Column(name = "IDGIOCATORE")
	private Long id;

	@Column(name = "NOME")
	private String nome;

	@Column(name = "SQUADRA")
	private String squadraCalcio;

	@ManyToMany(mappedBy = "giocatori")
	private Set<Squadra> squadre = new HashSet<Squadra>();

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "IDRUOLO")
	private RuoloGiocatore ruoloGiocatore;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSquadraCalcio() {
		return squadraCalcio;
	}

	public void setSquadraCalcio(String squadraCalcio) {
		this.squadraCalcio = squadraCalcio;
	}

	public RuoloGiocatore getRuoloGiocatore() {
		return ruoloGiocatore;
	}

	public void setRuoloGiocatore(RuoloGiocatore ruoloGiocatore) {
		this.ruoloGiocatore = ruoloGiocatore;
	}

	public Set<Squadra> getSquadre() {
		return squadre;
	}

	public void setSquadre(Set<Squadra> squadre) {
		this.squadre = squadre;
	}

	@Override
	public String toString() {
		return "Giocatore [id=" + id + ", nome=" + nome + ", squadraCalcio="
				+ squadraCalcio + "]";
	}

}
