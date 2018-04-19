package es.aytos.hibernate.hibernate_dual.pruebas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import es.aytos.hibernate.hibernate_dual.modelo.Cliente;
import es.aytos.hibernate.hibernate_dual.modelo.DetallePersona;
import es.aytos.hibernate.hibernate_dual.modelo.Direccion;
import es.aytos.hibernate.hibernate_dual.modelo.EstadoCivil;
import es.aytos.hibernate.hibernate_dual.modelo.Persona;
import es.aytos.hibernate.hibernate_dual.modelo.Telefono;
import es.aytos.hibernate.hibernate_dual.repositorio.RepositorioCliente;
import es.aytos.hibernate.hibernate_dual.repositorio.RepositorioPersona;
import es.aytos.hibernate.hibernate_dual.repositorio.RepositorioUsuario;

public class Pruebas {

	public static void main(String[] args) {
		crearPersona("15404157E","raom30");
		crearCliente("12304157E","ert");
		crearPersona("15544157E","ptr");
		crearCliente("11404157E","jama");
		
		//eliminarUsuario(1);
		//eliminarUsuario(4);

		//modificarPersona();
		//modificarCliente();
		
		//consultarPersona(3);
		//consultarCliente(2);
	}
	
	//USUARIO
	private static void eliminarUsuario(Integer idUsuario) {
		RepositorioUsuario.eliminarUsuario(idUsuario);
	}
	//PERSONAS

	private static Integer crearPersona(String dni, String login) {
		final Persona persona = new Persona();
		persona.setNombre("Rafa");
		persona.setApellidos("Alvarez-Ossorio");
		persona.setEdad(25);
		persona.setEstadoCivil(EstadoCivil.VIUDO);
		persona.setDni(dni);
		persona.setFechaAlta(new Date());
		persona.setLogin(login);
		persona.setPassword("123");
		
		final Telefono telefono = new Telefono();
		telefono.setNumTelefono("699781448");
		telefono.setPersona(persona);
		
		final DetallePersona dp = new DetallePersona();
		dp.setDeportista(true);
		dp.setHijos(false);
		dp.setMascota(true);
		
		final Direccion direccion = new Direccion();
		direccion.setProvincia("Ecija");
		direccion.setCodigoPostal("41400");
		direccion.setCalle("C/Nueva");
		direccion.setNumero(5);
		direccion.setBloque(2);
		direccion.setPlanta(1);
		direccion.setPuerta("A");
		direccion.setPersona(Arrays.asList(persona));
		
		dp.setPersona(persona);
		persona.setDetallePersona(dp);
		
		persona.setTelefono(new HashSet<>(Arrays.asList(telefono)));
		persona.setDireccion(Arrays.asList(direccion));
		
		return RepositorioPersona.crearPersona(persona);
	}

	
	private static void modificarPersona() {
		RepositorioPersona.modificarPersona(3, "PEPE");
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
	
	// CLIENTES
	private static Integer crearCliente(String dni, String login) {
		final Cliente persona = new Cliente();
		persona.setNombre("Rafa");
		persona.setApellidos("Alvarez-Ossorio");
		persona.setEdad(25);
		persona.setEstadoCivil(EstadoCivil.VIUDO);
		persona.setDni(dni);
		persona.setFechaAlta(new Date());
		persona.setLogin(login);
		persona.setPassword("123");
		return RepositorioCliente.crearCliente(persona);
	}
	
	private static void modificarCliente() {
		RepositorioCliente.modificarCliente(2, "ANTONIO");
	}
	
	public static void consultarCliente(Integer idCliente) {
		Cliente cliente = RepositorioCliente.consultarCliente(idCliente);
		System.out.println(cliente.getNombre());
		System.out.println(cliente.getApellidos());
		System.out.println(cliente.getDni());
		System.out.println(cliente.getEstadoCivil());
		
	}


}
