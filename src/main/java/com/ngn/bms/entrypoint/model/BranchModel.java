package com.ngn.bms.entrypoint.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "branch_offices")
public class BranchModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String branch_name;
	private String branchInitial;
	private String dzongkhag;
	private String country;
	private String location;
	private int contactNo;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBranch_name() {
		return branch_name;
	}
	public void setBranch_name(String branch_name) {
		this.branch_name = branch_name;
	}
	public String getBranchInitial() {
		return branchInitial;
	}
	public void setBranchInitial(String branchInitial) {
		this.branchInitial = branchInitial;
	}
	public String getDzongkhag() {
		return dzongkhag;
	}
	public void setDzongkhag(String dzongkhag) {
		this.dzongkhag = dzongkhag;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getContactNo() {
		return contactNo;
	}
	public void setContactNo(int contactNo) {
		this.contactNo = contactNo;
	}	
	
}
