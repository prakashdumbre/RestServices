package com.service.domain;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Owner {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "NAME")
	private String name;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COMPANY_ID" , nullable = false)
	private Company company;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}

	@Override
	public boolean equals(Object otherObj) {
		   if (this == otherObj) {
	            return true;
	        }

	        if (otherObj == null) {
	            return false;
	        }

	        if (otherObj instanceof Owner) {
	        	Owner owner = (Owner) otherObj;
	            return Objects.equals(this.name, owner.getName());
	        }
	        return false;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}
}
