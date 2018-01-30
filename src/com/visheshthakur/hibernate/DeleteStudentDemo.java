package com.visheshthakur.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.visheshthakur.hibernate.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create a session
		Session session = factory.getCurrentSession();
		try {
			int studentId = 4;

			// get a new session and start a transaction
			session = factory.getCurrentSession();
			session.beginTransaction();

			// retrieve a student based on id: primary key
			System.out.println("Getting the student id: " + studentId);

			// Student myStudent = session.get(Student.class, studentId);
			//
			// // delete the student
			// session.delete(myStudent);

			// delete student with id = 3
			session.createQuery("delete from Student where id = 3").executeUpdate();

			// commit transaction
			session.getTransaction().commit();

			System.out.println("Done!");
		} finally {
			factory.close();
		}

	}

}
