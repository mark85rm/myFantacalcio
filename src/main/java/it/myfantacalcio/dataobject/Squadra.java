package it.myfantacalcio.dataobject;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="SQUADRE")
public class Squadra implements Serializable {
	
	/*
	/**
	 * 
	*/
	private static final long serialVersionUID = -2435234234454L;
	
	@Id
    @Column(name="CODICE")
    @GeneratedValue
    private Long codice;
	
	@Column(name="NOME",  nullable = false, unique = true)
	private String nome;
	
	
	@ManyToOne
	@JoinColumn(name="lega")
	private Lega lega;
	
	@ManyToMany(cascade = {CascadeType.ALL}, fetch=FetchType.EAGER)
    @JoinTable(name="GIOCATORI_SQUADRE", 
                joinColumns={@JoinColumn(name="IDSQUADRA")}, 
                inverseJoinColumns={@JoinColumn(name="IDGIOCATORE")})
    private Set<Giocatore> giocatori = new HashSet<Giocatore>();

	
	public Lega getLega() {
		return lega;
	}


	public void setLega(Lega lega) {
		this.lega = lega;
	}


	public Long getCodice() {
		return codice;
	}


	public void setCodice(Long codice) {
		this.codice = codice;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public Set<Giocatore> getGiocatori() {
		return giocatori;
	}


	public void setGiocatori(Set<Giocatore> giocatori) {
		this.giocatori = giocatori;
	}


	@Override
	public String toString() {
		return "Squadra [codice=" + codice + ", nome=" + nome + ", numero giocatori= " + giocatori.size() + "]";
	}
	
	

}
