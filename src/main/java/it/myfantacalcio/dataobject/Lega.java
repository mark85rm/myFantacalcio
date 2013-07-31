package it.myfantacalcio.dataobject;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="LEGHE")
public class Lega implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4339516071991749353L;

	

	@Id
    @Column(name="IDLEGA")
    @GeneratedValue
    private Long id;
	
	@Column(name="NOMELEGA")
	private String nome;
	
	@OneToMany(mappedBy="lega")
    private Set<Squadra> squadre;
	
	@ManyToOne
    @JoinColumn(name="UTENTEAMMINISTRATORE")
	private Utente utenteAmministratore;
	
	@Column(name="ENABLED")
	private Boolean enabled;
	

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

	public Set<Squadra> getSquadre() {
		return squadre;
	}

	public void setSquadre(Set<Squadra> squadre) {
		this.squadre = squadre;
	}
	

	public Utente getUtenteAmministratore() {
		return utenteAmministratore;
	}

	public void setUtenteAmministratore(Utente utenteAmministratore) {
		this.utenteAmministratore = utenteAmministratore;
	}
	
	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	@Override
	public String toString() {
		return "Lega [id=" + id + ", nome=" + nome + ", " +
				"utenteAmministratore=" + utenteAmministratore.getUsername() + "]";
	}


	
}
