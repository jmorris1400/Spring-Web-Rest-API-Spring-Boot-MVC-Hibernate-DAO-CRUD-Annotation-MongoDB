package com.springrest.dao;

import java.util.List;

import com.springrest.model.Employee;

public interface DataDao {

	public boolean addEntity(Employee employee) throws Exception;
	public Employee getEntityById(long id) throws Exception;
	public List<Employee> getEntityList() throws Exception;
	public void deleteEntity(long id) throws Exception;
	public void updateEntity(Employee employee) throws Exception;

}
