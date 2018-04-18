package es.aytos.hibernate.hibernate_dual.pruebas;

import es.aytos.hibernate.hibernate_dual.modelo.EstadoCivil;
import es.aytos.hibernate.hibernate_dual.modelo.Persona;
import es.aytos.hibernate.hibernate_dual.repositorio.RepositorioPersona;

public class Pruebas {

	public static void main(String[] args) {
		System.out.println(crearPersona());

	}

	private static Integer crearPersona() {
		final Persona persona = new Persona();
		persona.setNombre("Rafa");
		persona.setApellidos("Alvarez-Ossorio");
		persona.setEdad(25);
		persona.setEstadoCivil(EstadoCivil.VIUDO);
		persona.setDni("15404157E");
		return RepositorioPersona.crearPersona(persona);
	}

}
