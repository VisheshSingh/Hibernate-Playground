package com.visheshthakur.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.visheshthakur.hibernate.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create a session
		Session session = factory.getCurrentSession();
		try {
			// start transaction
			session.beginTransaction();

			// query students
			List<Student> theStudents = session.createQuery("from Student").getResultList();

			// diplay the students
			for (Student s : theStudents) {
				System.out.println(s);
			}

			// query students by lastName
			theStudents = session.createQuery("from Student S where S.lastName = 'Sethi'").getResultList();

			// display students
			System.out.println("Students whose lastName is Sethi:");
			displayStudents(theStudents);

			// query students by lastName or firstName
			theStudents = session.createQuery("from Student S where S.lastName = 'Sethi' OR S.firstName='Daffy'")
					.getResultList();

			// display students
			System.out.println("Students whose lastName is Sethi or firstName is Daffy:");
			displayStudents(theStudents);

			// commit transaction
			session.getTransaction().commit();

			System.out.println("Done!");
		} finally {
			factory.close();
		}

	}

	private static void displayStudents(List<Student> theStudents) {
		for (Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

}
