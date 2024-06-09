package com.poonam.daoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.poonam.dao.Studentdao;
import com.poonam.entity.Student;
import com.poonam.exception.ResourceAlreadyExistException;
import com.poonam.exception.ResourceNotExistsException;
import com.poonam.exception.SomethingWentWrongException;
@Component
public class StudentDaoImpl implements Studentdao{
	
	@Autowired
	SessionFactory sf;

	public Student addStudent(Student student) {
		Session session = sf.openSession();
		Transaction t=session.beginTransaction();
		try {

			Student stud = session.get(Student.class, student.getId());

			if (stud == null) {
				session.save(student);
				t.commit();
				
			} else {
				throw new ResourceAlreadyExistException("student already exist");
			}

		} catch (ResourceAlreadyExistException e) {
			throw new ResourceAlreadyExistException("student already exist");
		}

		catch (Exception e) {
			e.printStackTrace();
			throw new SomethingWentWrongException("something went wrong");
		}
		return student;

	}






	public List<Student> getAllStudents() {
		Session session = null;
		List<Student> list = null;
		try {
			session = sf.openSession();
			session.beginTransaction();
			Criteria criteria = session.createCriteria(Student.class);
			list = criteria.list();
			session.getTransaction().commit();		
		} catch (Exception e) {
			e.printStackTrace();
		} 

		return list;
	}

	public String deleteStudent(long id) {
		Session session=sf.openSession();
		Transaction tt=session.beginTransaction(); 
		Student studentdb= session.get(Student.class,id);
		if(studentdb!=null)
		{
			session.delete(studentdb);
            tt.commit();
		}
		else {

			throw new ResourceNotExistsException("Id Not Found");
		}

		return "Delete Successfully";
	}

	public int updateStudent(Student updatedStudent) {
		Session session=sf.openSession();
		Transaction t = session.beginTransaction();
		try
		{
			Student ExistingStudent= session.get(Student.class,updatedStudent.getId());
			if(ExistingStudent!=null) {
				session.evict(ExistingStudent);
				session.update(updatedStudent);
				t.commit(); 
				return 1;

			}
			else
			{
				throw new ResourceNotExistsException("Resource not exist");

			}
		}
		catch(ResourceNotExistsException e){
			e.printStackTrace();
			throw new ResourceNotExistsException("Resource not exist");
		}
	}
}

