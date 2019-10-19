package com.springrest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.dao.DataDao;
import com.springrest.model.Employee;

@Service
public class DataServicesImpl implements DataServices {

	@Autowired
	DataDao dataDao;
	
	@Override
	public boolean addEntity(Employee employee) throws Exception {
		return dataDao.addEntity(employee);
	}

	@Override
	public Employee getEntityById(long id) throws Exception {
		return dataDao.getEntityById(id);
	}

	@Override
	public List<Employee> getEntityList() throws Exception {
		return dataDao.getEntityList();
	}

	@Override
	public void deleteEntity(long id) throws Exception {
		dataDao.deleteEntity(id);
	}

	@Override
	public void updateEntity(Employee e)throws Exception
	{
		dataDao.updateEntity(e);
		
	}

	

}
