package es.aytos.hibernate.hibernate_dual.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="A_TLF")
public class Telefono {
	
	@Id
	@GeneratedValue
	@Column(name="TLF_ID")
	private int idTelefono;
	
	@Column(name="TLF_NTL")
	private String numTelefono;
	
	@ManyToOne
	@JoinColumn(name="IdProfesor")
	private Persona persona;
	
	public Telefono() {
		
	}

	public int getIdTelefono() {
		return idTelefono;
	}

	public void setIdTelefono(int idTelefono) {
		this.idTelefono = idTelefono;
	}

	public String getNumTelefono() {
		return numTelefono;
	}

	public void setNumTelefono(String numTelefono) {
		this.numTelefono = numTelefono;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	
	

}
