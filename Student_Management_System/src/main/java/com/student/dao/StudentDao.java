package com.student.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.student.dto.Student;

@Repository
public class StudentDao 
{
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("praju");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();
	
	public void saveStudent(Student student)
	{
		et.begin();
		em.persist(student);
		et.commit();
	}
	
	public Student getStudent(int id)
	{
		Student s = em.find(Student.class, id);
		return s;
	}
	
	// This is a method having JPQL query to get all the student details from student table
	// SQL Query -> ("select * from student");
	// JPQL Query -> ("select s from Student s");
	public List<Student> getAllStudents()
	{
		Query query = em.createQuery("select s from Student s");
		List<Student> student = query.getResultList();
		return student;
	}
	
	public void deleteStudent(Student student)
	{
		et.begin();
		em.remove(student);
		et.commit();
	}
	
	public void updateStudent(Student student)
	{
		et.begin();
		em.merge(student);
		et.commit();
	}
}
