package com.service.client.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.client.request.dto.CompanyDto;
import com.client.rsponse.dto.ResponseDto;
import com.service.client.api.CompanyResourceService;
import com.service.dao.CompanyDaoImpl;
import com.service.domain.Company;
import com.service.domain.mapper.DomainMapper;

@Service("companyResourceService")
public class CompanyResourceServiceImpl implements CompanyResourceService {

	@Autowired
	private CompanyDaoImpl companyDao;

	@Autowired
	private DomainMapper<Company, CompanyDto> domainMapper;

	@Override
	public ResponseDto add(CompanyDto companyDto) {
		Company newCompany = (Company) domainMapper.mapToDomain(companyDto, new Company());
		companyDao.save(newCompany);
		System.out.println("CompanyId = " + newCompany.getCompanyId());
		ResponseDto response = new ResponseDto();
		response.setCompanyId(newCompany.getCompanyId());
		return response;
	}

	@Override
	public CompanyDto get(Long companyId) {
		throwExceptionIfCompanyIdNull(companyId);
		Company existing = companyDao.getCompany(companyId);
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
			//TODO: throw resource not found with 404 status code. need to put user defined exception
			System.out.println("Resource not found with : " + companyId);
		}
		existing = (Company) domainMapper.mapToDomain(companyDto, existing);
		ResponseDto response = new ResponseDto();
		response.setCompanyId(companyDao.update(existing));
		return response;
 	}

	private void throwExceptionIfCompanyIdNull(Long companyId) {
		if(Objects.isNull(companyId)) {
			throw new IllegalArgumentException("companyId can not be null.");
		}
	}
}
