package com.visheshthakur.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.visheshthakur.hibernate.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create a session
		Session session = factory.getCurrentSession();
		try {
			// use the session object to save java object

			// create student object
			System.out.println("Creating 3 student objects");
			Student tempStudent1 = new Student("Paul", "Wall", "PaulWall@gmail.com");
			Student tempStudent2 = new Student("Ane", "Franklin", "AneFranklin@gmail.com");
			Student tempStudent3 = new Student("Roop", "Sethi", "RoopSethi@gmail.com");
			// Start a transaction
			session.beginTransaction();

			// save the student object
			System.out.println("Saving the Students...");
			session.save(tempStudent1);
			session.save(tempStudent2);
			session.save(tempStudent3);

			// commit the transaction
			session.getTransaction().commit();

			System.out.println("Done!");
		} finally {
			factory.close();
		}

	}

}
