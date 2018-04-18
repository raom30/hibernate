package es.aytos.hibernate.hibernate_dual.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.*;

public class HibernateUtil {
	// CLASE SESSIONFACTORY que nos da sesiones de hibernate es la mas importante ,
	// ESTA CLASE SIEMPRE ES ASI

	private static SessionFactory miFactoria = construirSessionFactory();

	private static SessionFactory construirSessionFactory() {
		try {
			return new Configuration().configure().buildSessionFactory();
		} catch (Exception e) {
			System.out.println("Se ha producido un error obteniendo la factoria de sesiones" + e.getMessage());
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	public static SessionFactory getMiFactoria() {
		return miFactoria;
	}

}
