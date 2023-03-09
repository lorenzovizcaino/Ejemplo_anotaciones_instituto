package main;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import modelofk.ComunidadAutonoma;
import modelofk.Modulo;
import modelofk.Profesor;
import modelofk.Provincia;
import util.SessionFactoryUtil;

public class Test_Cascade_N_2_fk {

	public static void main(String[] args) {
		SessionFactory sessionFactory = SessionFactoryUtil.getSessionFactory();

		Session session = sessionFactory.openSession();

		Transaction tx = null;
//		{
//			//Probar la persistencia transitiva con cascade
//
//			try {
//				tx = session.beginTransaction();
//				ComunidadAutonoma ca = new ComunidadAutonoma();
//				ca.setIdCa(2300);
//				ca.setNombre("Mi nueva ca");
//
//				Set<Provincia> provs = new HashSet<>();
//				provs.add(new Provincia(2301, ca, "nueva prov asociada"));
//				ca.setProvincias(provs);
//
//				session.persist(ca);
//
//				tx.commit();
//
//				System.out.println("Se ha terminado la tx con éxito");
//
//			} catch (Exception ex) {
//				System.out.println("Ha ocurrido una exception: " + ex.getMessage());
//				if (tx != null) {
//					tx.rollback();
//				}
//
//			}
//
//		}
		//Probamos orphanRemoval

//		{
//			try {
//				tx = session.beginTransaction();
//				ComunidadAutonoma ca = session.get(ComunidadAutonoma.class, 2300);
//				if (ca != null) {
//					Provincia prov = ca.getProvincias().iterator().next();
//					prov.setComunidadAutonoma(null);
//					ca.getProvincias().remove(prov);
//				}
//				session.persist(ca);
//				tx.commit();
//
//				System.out.println("Se ha terminado la tx con éxito");
//
//			} catch (Exception ex) {
//				System.out.println("Ha ocurrido una exception: " + ex.getMessage());
//				ex.printStackTrace();
//				if (tx != null) {
//					tx.rollback();
//				}
//
//			}
//		}
//
		//Probamos el problema de la N+1 consultas
		{

			List<Profesor> profes = session.createQuery("select p from Profesor p order by p.id").list();
			int contador_profes=0;
			
			for (Profesor profesor : profes) {
				contador_profes++;
				for (Modulo modulo : profesor.getModulos()) {
			
					System.out.println(
							"Profesor" +contador_profes+": " + profesor.getNombre() + " " + profesor.getId() + ": " + modulo.getNombre());
				}
			}

		}



		session.close();

		sessionFactory.close();

	}
}
