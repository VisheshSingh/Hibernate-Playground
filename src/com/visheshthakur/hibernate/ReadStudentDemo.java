package com.visheshthakur.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.visheshthakur.hibernate.entity.Student;

public class ReadStudentDemo {

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
			Student tempStudent = new Student("Daffy", "Duck", "DaffyDuck@gmail.com");

			// Start a transaction
			session.beginTransaction();

			// save the student object
			System.out.println("Saving the Student...");
			System.out.println(tempStudent);
			session.save(tempStudent);

			// commit the transaction
			session.getTransaction().commit();

			// MY NEW CODE

			// Find out the student's id: primary key
			System.out.println("Saved Student. Generated id: " + tempStudent.getId());

			// get a new session and start a transaction
			session = factory.getCurrentSession();
			session.beginTransaction();

			// retrieve a student based on id: primary key
			System.out.println("\nGeneting student with an ID of " + tempStudent.getId());
			Student myStudent = session.get(Student.class, tempStudent.getId());
			System.out.println("Get complete: " + myStudent);

			// commit transaction
			session.getTransaction().commit();

			System.out.println("Done!");
		} finally {
			factory.close();
		}

	}

}
