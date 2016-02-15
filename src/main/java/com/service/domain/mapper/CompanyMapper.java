package com.service.domain.mapper;

import java.util.ArrayList;

import java.util.List;

import org.springframework.stereotype.Component;

import com.client.request.dto.CompanyDto;
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
		destination.setOwners(getOwnerIds(source.getOwners()));
		return destination;
	}

	@Override
	public Company mapToDomain(CompanyDto source, Company destination) {
		destination.setName(source.getName());
		destination.setAddress(source.getAddress());
		destination.setCountry(source.getCountry());
		destination.setPhoneNumber(source.getPhoneNumber());
		destination.setOwners(getOwners(source.getOwners()));
		return destination;
	}

	private List<Owner> getOwners(List<Long> ownerIds) {
		List<Owner> ownerList = new ArrayList<Owner>();
		for(Long ownerId : ownerIds) {
			Owner o = new Owner();
			o.setId(ownerId);
			ownerList.add(o);
		}
		return ownerList;
	}

	private List<Long> getOwnerIds(List<Owner> owners) {
		List<Long> ownerIds = new ArrayList<Long>();
		for(Owner owner : owners) {
			ownerIds.add(owner.getId());
		}
		return ownerIds;
	}

}
