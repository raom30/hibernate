package es.aytos.hibernate.hibernate_dual.repositorio;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import es.aytos.hibernate.hibernate_dual.modelo.EstadoCivil;
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
			
			/*sesion.createQuery("UPDATE Persona set per_nom = :nombre where per_id = :identificador")
			.setParameter("nombre", nombre).setParameter("identificador", idPersona).uniqueResult();*/
			
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
	
	public static void eliminarPersona(Integer idPersona) {
		final Session sesion = HibernateUtil.getMiFactoria().getCurrentSession();

		try {

			sesion.beginTransaction();
			
			sesion.createQuery("DELETE Persona where per_id = :identificador")
			.setParameter("identificador", idPersona).executeUpdate();

			sesion.getTransaction().commit(); // Lo guarda en la base de datos


		} catch (Exception e) {
			System.out.println("Se ha producido un error insertando la persona: " + e);
			e.printStackTrace();
			throw new RuntimeException();
		}finally {
			sesion.close();
		}
	}
	public static Persona consultarPersona(Integer idPersona) {
		final Session sesion = HibernateUtil.getMiFactoria().getCurrentSession();

		try {

			sesion.beginTransaction();
			
			return (Persona)sesion.createQuery("from Persona where per_id = :idPersona").setParameter("idPersona", idPersona).uniqueResult();



		} catch (Exception e) {
			System.out.println("Se ha producido un error insertando la persona: " + e);
			e.printStackTrace();
			throw new RuntimeException();
		}finally {
			sesion.close();
		}
	}
	public static List<Persona> consultar(String nombre, String apellidos, String dni, EstadoCivil estadoCivil) {
		final Session sesion = HibernateUtil.getMiFactoria().getCurrentSession();

		try {

			sesion.beginTransaction();
			
			final StringBuilder sb = new StringBuilder("from Persona Where 1=1");
			if(!nombre.isEmpty()) {
				sb.append("and Per_NOM LIKE :nombre");
			}
			if(!apellidos.isEmpty()) {
				sb.append("and PER_APE like :apellidos");
			}
			if(!dni.isEmpty()) {
				sb.append("AND PER_DNI :dni");
			}
			if(estadoCivil != null) {
				sb.append("AND PER_ECV = :estadoCivil");
			}
			
			final Query<Persona> consulta = sesion.createQuery(sb.toString());
			
			if(!nombre.isEmpty()) {
				consulta.setParameter("nombre", nombre);
			}
			if(!apellidos.isEmpty()) {
				consulta.setParameter("apellidos", apellidos);
			}
			if(!dni.isEmpty()) {
				consulta.setParameter("dni", dni);
			}
			if(estadoCivil != null) {
				consulta.setParameter("estadoCivil", estadoCivil);
			}
			
			

			return consulta.list();


		} catch (Exception e) {
			System.out.println("Se ha producido un error insertando la persona: " + e);
			e.printStackTrace();
			throw new RuntimeException();
		}finally {
			sesion.close();
		}
	}
	
}
