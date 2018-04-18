package es.aytos.hibernate.hibernate_dual.repositorio;

import org.hibernate.Session;

import es.aytos.hibernate.hibernate_dual.modelo.Persona;
import es.aytos.hibernate.hibernate_dual.util.HibernateUtil;

public class RepositorioPersona {

	public static Integer crearPersona(Persona persona) {
		final Session sesion = HibernateUtil.getMiFactoria().getCurrentSession();

		try {

			sesion.beginTransaction();

			final Integer idPersona = (Integer) sesion.save(persona);// Almacena esta persona

			sesion.getTransaction().commit(); // Lo guarda en la base de datos

			return idPersona;

		} catch (Exception e) {
			System.out.println("Se ha producido un error insertando la persona: " + e);
			e.printStackTrace();
			throw new RuntimeException();
		}finally {
			sesion.close();
		}
	}
	
	public static void modifiarPersona(Integer idPersona, String nombre) {
		final Session sesion = HibernateUtil.getMiFactoria().getCurrentSession();

		try {

			sesion.beginTransaction();

			final Persona personaBBDD = (Persona) sesion.createQuery("from Persona where PER_ID = :idPersona")
					.setParameter("idPersona", idPersona).uniqueResult();// Almacena esta persona
			
			personaBBDD.setNombre(nombre);

			sesion.getTransaction().commit(); // Lo guarda en la base de datos


		} catch (Exception e) {
			System.out.println("Se ha producido un error insertando la persona: " + e);
			e.printStackTrace();
			throw new RuntimeException();
		}finally {
			sesion.close();
		}
	}
}
