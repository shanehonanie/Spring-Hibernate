package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			// create a Student object
			Student temp = new Student("Paul", "Wall", "test@test.com");
			
			// start a transaction
			session.beginTransaction();
			
			// save the student object
			session.save(temp);
			
			// commit transaction
			session.getTransaction().commit();
		}
		finally {
			factory.close();
		}

	}

}
