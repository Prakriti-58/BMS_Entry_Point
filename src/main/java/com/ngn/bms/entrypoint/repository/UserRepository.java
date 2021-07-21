package com.ngn.bms.entrypoint.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ngn.bms.entrypoint.model.DAOUser;

public interface UserRepository extends JpaRepository<DAOUser, Long>{

	DAOUser findByUserId(String userId);
	
}
