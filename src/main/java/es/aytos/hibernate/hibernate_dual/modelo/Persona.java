package es.aytos.hibernate.hibernate_dual.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity // Esto dice que la clase es lo mismo que a entidad osea una tabla
@Table(name = "A_PER") // Dice el nombre de la tabla que concuerda con la clase
public class Persona extends Usuario implements Serializable  { // Es necesario

	//COMO ES HIJA LA ID LA TIENE EN EL PADRE
	//@Id // Le decimos que es la id de la tabla PK
	//@GeneratedValue // Auto generada
	//@Column(name = "PER_ID") // Le damos un nombre en la tabla de la base de datos (,..) para mas propiedades
	//private int idPersona;// Esto es una columna en la tabla

	@Column(name = "PER_NOM", nullable = false, length = 50) // NO PUEDE SER NULA y su longitud es 50 esto crea la
																// columna en la base de datos
	private String nombre;

	@Column(name = "PER_APE", nullable = false, length = 250) // Igual nombre de la columa , no puede ser nula y 250
																// caracteres de longitud
	private String apellidos;

	@Column(name = "PER_DNI", nullable = false, length = 9, unique = true) // Esto último dice que es unica no puede
																			// haber valores iguales.
	private String dni;

	@Column(name = "PER_EDA", nullable = false)
	private Integer edad;

	@Column(name = "PER_ECV", nullable = false)
	@Enumerated // Indica a la base de datos que es un enumerado -- Es ordinal es decir 1 , 2 ,
				// 3 Va en orden como se crea en el ENUM creara una tipo numerico e inserta
				// 1,2,3 y al leerlo lo convierte en string
	// @Enumerated(value = EnumType.STRING) Lo guarda en la base de datos en forma
	// de String no de forma ordinal
	private EstadoCivil estadoCivil;
	
	@ManyToMany(cascade = {CascadeType.ALL})
	@JoinTable(name="PersonDireccion")
	private List<Direccion> direcciones=new ArrayList();

	//onetomany   --> manyToone
	
	@OneToMany(mappedBy="persona",cascade= CascadeType.ALL)
	private Set<Telefono> telefono;
	
	@OneToOne(cascade=CascadeType.ALL)
	private DetallePersona detallePersona;
	
	// Si tenemos una clave compuesta necesitamos crear una clase aparte con el
	// @EmbebeID o algo asi.

	public Persona() {
		// SE NECESITA UN CONSTRUCTOR VACIO PARA QUE HIBERNATE PUEDA INSTANCIARLO ES
		// NECESARIO
	}

	// HAY QUE CREAR LOS GETTER Y SETTER NECESARIO

	//public int getIdPersona() {
	//	return idPersona;
	//}

	//public void setIdPersona(int idPersona) {
	//	this.idPersona = idPersona;
	//}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public EstadoCivil getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(EstadoCivil estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public List<Direccion> getDireccion() {
		return direcciones;
	}

	public void setDireccion(List<Direccion> direccion) {
		this.direcciones = direccion;
	}

	public Set<Telefono> getTelefono() {
		return telefono;
	}

	public void setTelefono(Set<Telefono> telefono) {
		this.telefono = telefono;
	}

	public DetallePersona getDetallePersona() {
		return detallePersona;
	}

	public void setDetallePersona(DetallePersona detallePersona) {
		this.detallePersona = detallePersona;
	}

}
