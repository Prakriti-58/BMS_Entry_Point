package com.ngn.bms.entrypoint.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ngn.bms.entrypoint.model.UserList;

@Repository
public interface UserListRepo extends JpaRepository<UserList, Integer>{

	UserList findByUserId(String username);

}
