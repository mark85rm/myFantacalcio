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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="UTENTI")

public class Utente implements Serializable{
	/*
	/**
	 * 
	*/
	private static final long serialVersionUID = -7267307219778227696L;

	@Override
	public String toString() {
		return "Utente [id=" + id + ", username=" + username + ", password="
				+ password + ", nome=" + nome + ", cognome=" + cognome
				+ ", mail=" + mail + ", enabled=" + enabled + ", squadra="
				+ squadra.getNome() + "]";
	}

	@Id
    @Column(name="ID")
    @GeneratedValue
    private Long id;
	
	@Column(name="USERNAME",  nullable = false, unique = true)
	private String username;
	
	@Column(name="PASSWORD",  nullable = false)
	private String password;
	
	@Column(name="PASSWORD", updatable=false, insertable=false)
	private String repeatpassword;
	
	@Column(name="NOME")
	private String nome;
	
	@Column(name="COGNOME")
	private String cognome;
	
	@Column(name="MAIL")
	@NotEmpty @Email
	private String mail;
	
	@Column(name="ENABLED")
	private Boolean enabled;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "squadra")
	private Squadra squadra;
	
	@ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name="ruoli_utenti", 
                joinColumns={@JoinColumn(name="ID_RUOLO")}, 
                inverseJoinColumns={@JoinColumn(name="ID_UTENTE")})
    private Set<Ruolo> ruoli = new HashSet<Ruolo>();
	
	
	@OneToMany(mappedBy="utenteAmministratore")
	private Set<Lega> legheAmministrate;
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Squadra getSquadra() {
		return squadra;
	}

	public void setSquadra(Squadra squadra) {
		this.squadra = squadra;
	}

	public Set<Lega> getLegheAmministrate() {
		return legheAmministrate;
	}

	public void setLegheAmministrate(Set<Lega> legheAmministrate) {
		this.legheAmministrate = legheAmministrate;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public Set<Ruolo> getRuoli() {
		return ruoli;
	}

	public void setRuoli(Set<Ruolo> ruoli) {
		this.ruoli = ruoli;
	}

	public String getRepeatpassword() {
		return repeatpassword;
	}

	public void setRepeatpassword(String repeatpassword) {
		this.repeatpassword = repeatpassword;
	}



}
