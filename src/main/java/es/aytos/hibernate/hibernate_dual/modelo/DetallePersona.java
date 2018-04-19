package es.aytos.hibernate.hibernate_dual.modelo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
@Entity
@Table(name="A_DPR")
public class DetallePersona {
	
	@Id
	@Column(name="DPR_ID")
	private int idDetallePersona;
	
	@Column(name = "DPR_HIJ")
	private Boolean hijos;
	
	@Column(name = "DPR_MAS")
	private Boolean mascota;
	
	@Column(name = "DPR_DPT")
	private Boolean deportista;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="ID_PER")
	private Persona persona;
	
	public DetallePersona() {
		
	}

	public int getIdDetallePersona() {
		return idDetallePersona;
	}

	public void setIdDetallePersona(int idDetallePersona) {
		this.idDetallePersona = idDetallePersona;
	}

	public Boolean getHijos() {
		return hijos;
	}

	public void setHijos(Boolean hijos) {
		this.hijos = hijos;
	}

	public Boolean getMascota() {
		return mascota;
	}

	public void setMascota(Boolean mascota) {
		this.mascota = mascota;
	}

	public Boolean getDeportista() {
		return deportista;
	}

	public void setDeportista(Boolean deportista) {
		this.deportista = deportista;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	
}
