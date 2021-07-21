package com.ngn.bms.entrypoint.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ngn.bms.entrypoint.model.BranchModel;

@Repository
public interface BranchModelRepo extends JpaRepository<BranchModel, Integer>{

}
