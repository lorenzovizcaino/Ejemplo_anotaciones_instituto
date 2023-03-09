package main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import modelo.ContactInfo;
import util.SessionFactoryUtil;

public class Main {

	public static void main(String[] args) {
		SessionFactory sessionFactory = SessionFactoryUtil.getSessionFactory();

		Session session = sessionFactory.openSession();

		{
			System.out.println("-----------Q1: Uso de list() -----------");

			List<ContactInfo> contactos = session.createQuery(" select p.contactInfo from Profesor p ").list();

			for (ContactInfo c : contactos) {
				System.out.println(c);
			}
		}

		

		session.close();

		sessionFactory.close();

	}
}
