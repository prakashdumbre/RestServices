package com.service.domain.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.client.request.dto.CompanyDto;
import com.client.request.dto.OwnerDto;
import com.service.domain.Company;
import com.service.domain.Owner;

/** Domain mapper for entity and DTOs. This class helps to convert domain class to dto or vice versa.
 *
 */
//TODO: this can be more enhanced by using spring generic converter. Please refactor me.
@Component
public final class CompanyMapper implements DomainMapper<Company, CompanyDto> {

	@Override
	public CompanyDto mapToDto(Company source, CompanyDto destination) {
		destination.setCompanyId(source.getCompanyId());
		destination.setName(source.getName());
		destination.setAddress(source.getAddress());
		destination.setCountry(source.getCountry());
		destination.setPhoneNumber(source.getPhoneNumber());
		destination.setOwners(getOwnerDtos(source.getOwners()));
		return destination;
	}

	@Override
	public Company mapToDomain(CompanyDto source, Company destination) {
		destination.setName(source.getName());
		destination.setAddress(source.getAddress());
		destination.setCountry(source.getCountry());
		destination.setPhoneNumber(source.getPhoneNumber());
		destination.setOwners(getOwners(destination, source.getOwners()));
		return destination;
	}

	private List<Owner> getOwners(Company destination, List<String> owners) {
		List<Owner> ownerList = new ArrayList<Owner>();
		for(String owner : owners) {
			Owner o = new Owner();
			o.setCompany(destination);
			o.setName(owner);
			ownerList.add(o);
		}
		return ownerList;
	}

	private List<String> getOwnerDtos(List<Owner> owners) {
		List<String> ownersList = new ArrayList<String>();
		for(Owner owner : owners) {
			ownersList.add(owner.getName());
		}
		return ownersList;
	}
}
