package es.aytos.hibernate.hibernate_dual.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity // Esto dice que la clase es lo mismo que a entidad osea una tabla
@Table(name = "A_PER") // Dice el nombre de la tabla que concuerda con la clase
public class Persona implements Serializable { // Es necesario

	@Id // Le decimos que es la id de la tabla PK
	@GeneratedValue // Auto generada
	@Column(name = "PER_ID") // Le damos un nombre en la tabla de la base de datos (,..) para mas propiedades
	private int idPersona;// Esto es una columna en la tabla

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

	// Si tenemos una clave compuesta necesitamos crear una clase aparte con el
	// @EmbebeID o algo asi.

	public Persona() {
		// SE NECESITA UN CONSTRUCTOR VACIO PARA QUE HIBERNATE PUEDA INSTANCIARLO ES
		// NECESARIO
	}

	// HAY QUE CREAR LOS GETTER Y SETTER NECESARIO

	public int getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}

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

}
