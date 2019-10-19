package com.springrest.dao;

import java.util.List;

import javax.transaction.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.springrest.model.Employee;

@Repository
public class DataDaoImpl implements DataDao {

	@Autowired
	SessionFactory sessionFactory;

	Session ses = null;

	@Override
	@Transactional
	public boolean addEntity(Employee employee) throws Exception {
		ses = sessionFactory.openSession();
		ses.save(employee);
		ses.close();
		return false;
	}

	@Override
	@Transactional
	public Employee getEntityById(long id) throws Exception {
		ses = sessionFactory.openSession();
		Employee employee = (Employee) ses.load(Employee.class,
				new Long(id));
		ses.beginTransaction();
		return employee;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public List<Employee> getEntityList() throws Exception {
		ses = sessionFactory.openSession();
		List<Employee> employeeList = ses.createCriteria(Employee.class).list();
		ses.close();
		return employeeList;
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void deleteEntity(long id) throws Exception {
		ses = sessionFactory.getCurrentSession();
		Employee o = (Employee) ses.load(Employee.class, new Long(id));
	//	System.out.println(o);
		//ses.beginTransaction();
		ses.delete(o);
	//	ses.close();
		
	/*	Employee e=new Employee();
		e.setId(id);
		ses.delete(e);
		ses.close();*/
	//	return false;
	}
	@Override
	public void updateEntity(Employee employee)throws Exception {
		ses = sessionFactory.openSession();
		org.hibernate.Transaction tx=ses.beginTransaction();
		ses.update(employee);	
		tx.commit();
		ses.close();
		 }
}
