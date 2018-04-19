package es.aytos.hibernate.hibernate_dual.modelo;
import es.aytos.hibernate.hibernate_dual.modelo.Persona;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
@Entity
@Table(name="A_DIR")
public class Direccion implements Serializable{

	 @Id
	 @GeneratedValue
	 @Column(name="DIR_ID")
	private Integer idDireccion;
	 
	 @Column(name="DIR_PRO")
	private String provincia;
	 
	 @Column(name="DIR_CP")
	private String codigoPostal;
	 
	 @Column(name="DIR_CAL")
	private String calle;
	
	 @Column(name="DIR_NUM")
	private Integer numero;
	
	 @Column(name="DIR_BLQ")
	private Integer bloque;
	
	 @Column(name="DIR_PLT")
	private Integer planta;
	
	 @Column(name="DIR_PRT")
	private String puerta;
	
	@ManyToMany(mappedBy="direcciones")
	private List<Persona> persona=new ArrayList();
	


	public Direccion(){
		
	}

	public Integer getIdDireccion() {
		return idDireccion;
	}

	public void setIdDireccion(Integer idDireccion) {
		this.idDireccion = idDireccion;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Integer getBloque() {
		return bloque;
	}

	public void setBloque(Integer bloque) {
		this.bloque = bloque;
	}

	public Integer getPlanta() {
		return planta;
	}

	public void setPlanta(Integer planta) {
		this.planta = planta;
	}

	public String getPuerta() {
		return puerta;
	}

	public void setPuerta(String puerta) {
		this.puerta = puerta;
	}
	public List<Persona> getPersona() {
		return persona;
	}

	public void setPersona(List<Persona> persona) {
		this.persona = persona;
	}
	
}
