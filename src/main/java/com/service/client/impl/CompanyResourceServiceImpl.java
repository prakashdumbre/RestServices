package com.service.client.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.ws.rs.NotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.client.request.dto.CompanyDto;
import com.client.response.dto.ResponseDto;
import com.service.client.api.CompanyResourceService;
import com.service.dao.CompanyDaoImpl;
import com.service.domain.Company;
import com.service.domain.mapper.DomainMapper;

@Service("companyResourceService")
@Transactional
public class CompanyResourceServiceImpl implements CompanyResourceService {

	@Autowired
	private CompanyDaoImpl companyDao;

	@Autowired
	private DomainMapper<Company, CompanyDto> domainMapper;


	@Override
	public ResponseDto add(CompanyDto companyDto) {
		Company newCompany = (Company) domainMapper.mapToDomain(companyDto, new Company());
		companyDao.save(newCompany);
		ResponseDto response = new ResponseDto();
		response.setCompanyId(newCompany.getCompanyId());
		return response;
	}

	@Override
	public CompanyDto get(Long companyId) {
		throwExceptionIfCompanyIdNull(companyId);
		Company existing = companyDao.getCompany(companyId);
		if(Objects.isNull(existing)) {
			throw new NotFoundException("Company object not found in system.");
		}
		return (CompanyDto) domainMapper.mapToDto(existing, new CompanyDto());
	}

	@Override
	public List<CompanyDto> findAll() {
		List<CompanyDto> allData = new ArrayList<CompanyDto>();
		for(Company company : companyDao.getAll()) {
			allData.add((CompanyDto) domainMapper.mapToDto(company, new CompanyDto()));
		}
		return allData;
	}

	@Override
	public ResponseDto update(Long companyId, CompanyDto companyDto) {
		throwExceptionIfCompanyIdNull(companyId);
		Company existing = companyDao.getCompany(companyId);
		if(Objects.isNull(existing)){
			throw new NotFoundException("Company object not found in system.");
		}
		existing = (Company) domainMapper.mapToDomain(companyDto, existing);
		ResponseDto response = new ResponseDto();
		companyDao.update(existing);
		response.setCompanyId(existing.getCompanyId());
		return response;
 	}

	private void throwExceptionIfCompanyIdNull(Long companyId) {
		if(Objects.isNull(companyId)) {
			throw new IllegalArgumentException("companyId can not be null.");
		}
	}
}
