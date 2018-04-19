package es.aytos.hibernate.hibernate_dual.repositorio;

import org.hibernate.Session;

import es.aytos.hibernate.hibernate_dual.modelo.Cliente;
import es.aytos.hibernate.hibernate_dual.util.HibernateUtil;

public class RepositorioCliente {

	public static Integer crearCliente(Cliente cliente) {
		final Session sesion = HibernateUtil.getMiFactoria().getCurrentSession();

		try {

			sesion.beginTransaction();

			final Integer idCliente = (Integer) sesion.save(cliente);// Almacena esta persona

			sesion.getTransaction().commit(); // Lo guarda en la base de datos

			return idCliente;

		} catch (Exception e) {
			System.out.println("Se ha producido un error insertando la persona: " + e);
			e.printStackTrace();
			throw new RuntimeException();
		} finally {
			sesion.close();
		}
	}

	public static void modificarCliente(Integer idCliente, String nombre) {
		final Session sesion = HibernateUtil.getMiFactoria().getCurrentSession();

		try {

			sesion.beginTransaction();

			final Cliente clienteBBDD = (Cliente) sesion.createQuery("from Usuario USU2 where USU2.idUsuario = :idCliente")
					.setParameter("idCliente", idCliente).uniqueResult();// Almacena esta persona

			
			  //sesion.createQuery("UPDATE Cliente set cli_nom = :nombre where USU_ID = :identificador") 
			 // .setParameter("nombre", nombre)
			 // .setParameter("identificador",idCliente).executeUpdate();
			 

		clienteBBDD.setNombre(nombre);

			sesion.getTransaction().commit(); // Lo guarda en la base de datos

		} catch (Exception e) {
			System.out.println("Se ha producido un error insertando la persona: " + e);
			e.printStackTrace();
			throw new RuntimeException();
		} finally {
			sesion.close();
		}
	}

	
	public static Cliente consultarCliente(Integer idCliente) {
		final Session sesion = HibernateUtil.getMiFactoria().getCurrentSession();

		try {

			sesion.beginTransaction();
			
			return (Cliente)sesion.createQuery("from Usuario USU2 where USU2.IdUsuario = :idCliente")
					.setParameter("idCliente", idCliente).uniqueResult();



		} catch (Exception e) {
			System.out.println("Se ha producido un error insertando la persona: " + e);
			e.printStackTrace();
			throw new RuntimeException();
		}finally {
			sesion.close();
		}
	}
}
