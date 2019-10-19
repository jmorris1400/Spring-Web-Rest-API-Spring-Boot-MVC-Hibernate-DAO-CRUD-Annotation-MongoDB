package com.springrest.services;

import java.util.List;

import com.springrest.model.Employee;

public interface DataServices {
	public boolean addEntity(Employee employee) throws Exception;
	public Employee getEntityById(long id) throws Exception;
	public List<Employee> getEntityList() throws Exception;
	public void deleteEntity(long id) throws Exception;
	public void updateEntity(Employee e) throws Exception;

}
