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

			// display students
			for (Student tempStudent : theStudents) {
				System.out.println(tempStudent);
			}

			// commit transaction
			session.getTransaction().commit();

			System.out.println("Done!");
		} finally {
			factory.close();
		}

	}

}