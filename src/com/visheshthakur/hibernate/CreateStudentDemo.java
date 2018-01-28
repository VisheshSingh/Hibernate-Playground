package com.visheshthakur.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.visheshthakur.hibernate.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create a session
		Session session = factory.getCurrentSession();
		try {
			// use the session object to save java object

			// create student object
			System.out.println("Creating a new student object");
			Student tempStudent = new Student("John", "Doe", "JohnDoe@gmail.com");

			// Start a transaction
			session.beginTransaction();

			// save the student object
			System.out.println("Saving the Student...");
			session.save(tempStudent);

			// commit the transaction
			session.getTransaction().commit();

			System.out.println("Done!");
		} finally {
			factory.close();
		}

	}

}
