package com.ngn.bms.entrypoint.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ngn.bms.entrypoint.model.DAOUser;

public interface UserRepositoryForId extends JpaRepository<DAOUser, Integer>{

	DAOUser findByEmpId(int empId);
	
}
