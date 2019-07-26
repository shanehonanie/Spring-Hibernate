package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			// create 3 student object
			Student temp0 = new Student("John", "Doe", "test0@test.com");
			Student temp1 = new Student("Mary", "Public", "test1@test.com");
			Student temp2 = new Student("Bonita", "George", "test2@test.com");
			
			// start a transaction
			session.beginTransaction();
			
			// save the student object
			session.save(temp0);
			session.save(temp1);
			session.save(temp2);
			
			// commit transaction
			session.getTransaction().commit();
		}
		finally {
			factory.close();
		}

	}

}
