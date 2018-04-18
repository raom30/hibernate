package es.aytos.hibernate.hibernate_dual.pruebas;

import java.util.List;

import es.aytos.hibernate.hibernate_dual.modelo.EstadoCivil;
import es.aytos.hibernate.hibernate_dual.modelo.Persona;
import es.aytos.hibernate.hibernate_dual.repositorio.RepositorioPersona;

public class Pruebas {

	public static void main(String[] args) {
		//System.out.println(crearPersona());
		//modificarPersona();
		//eliminarPersona(1);
		consultarPersona(7);
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
	
	private static void modificarPersona() {
		RepositorioPersona.modifiarPersona(1, "PEPE");
	}
	
	private static void eliminarPersona(Integer idPersona) {
		RepositorioPersona.eliminarPersona(idPersona);
	}
	public static void consultarPersona(Integer idPersona) {
		Persona persona = RepositorioPersona.consultarPersona(idPersona);
		System.out.println(persona.getNombre());
		System.out.println(persona.getApellidos());
		System.out.println(persona.getDni());
		System.out.println(persona.getEstadoCivil());
		
	}
	public static void consultar(String nombre, String apellidos, String dni, EstadoCivil estadoCivil) {
		List<Persona> personas = RepositorioPersona.consultar(nombre, apellidos, dni, estadoCivil);
		System.out.println(personas.size());
	}


}
