package com.service.dao;

import java.util.List;

import com.service.domain.Company;

public interface CompanyDao {

	Long save(Company company);

	Company getCompany(Long companyId);

	Long update(Company company);

	List<Company> getAll();
}
