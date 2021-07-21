package com.ngn.bms.entrypoint.dao;

import org.springframework.data.repository.CrudRepository;

import com.ngn.bms.entrypoint.model.DAOUser;

public interface UserDaoForId extends CrudRepository<DAOUser, Integer>{

	DAOUser findByEmpId(int empId);
	
}
