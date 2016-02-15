package com.service.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.service.domain.Company;

/**
 * DAO implementation for Company entity
 *
 */
@Repository
public class CompanyDaoImpl implements CompanyDao {

	@PersistenceContext(unitName="testData")
    private EntityManager em;

	@Override
    public Long save(Company company) {
		em.persist(company);
        return company.getCompanyId();
    }

	@Override
    public List<Company> getAll() {
        return em.createQuery("SELECT p FROM Company p", Company.class).getResultList();
    }

	@Override
	public Company getCompany(Long companyId) {
		return em.find(Company.class, companyId);
	}

	@Override
	public Long update(Company company) {
		em.merge(company);
		return company.getCompanyId();
	}
}
