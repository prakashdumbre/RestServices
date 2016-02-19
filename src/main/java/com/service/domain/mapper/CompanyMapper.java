package com.service.domain.mapper;

import java.util.HashSet;
import java.util.Set;

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
		destination.setCity(source.getCity());
		destination.setCountry(source.getCountry());
		destination.setPhoneNumber(source.getPhoneNumber());
		destination.setEmail(source.getEmail());
		destination.setOwners(getOwnerDtos(source.getOwners()));
		return destination;
	}

	@Override
	public Company mapToDomain(CompanyDto source, Company destination) {
		destination.setName(source.getName());
		destination.setAddress(source.getAddress());
		destination.setCountry(source.getCountry());
		destination.setPhoneNumber(source.getPhoneNumber());
		destination.setCity(source.getCity());
		destination.setEmail(source.getEmail());
		setOwners(destination, source.getOwners());
		return destination;
	}

	private void setOwners(Company destination, Set<String> owners) {
		Set<Owner> ownerList = new HashSet<Owner>();
		for(String owner : owners) {
			Owner o = new Owner();
			o.setCompany(destination);
			o.setName(owner);
			ownerList.add(o);
		}
		destination.setOwners(ownerList);
	}

	private Set<String> getOwnerDtos(Set<Owner> owners) {
		Set<String> ownersList = new HashSet<String>();
		for(Owner owner : owners) {
			ownersList.add(owner.getName());
		}
		return ownersList;
	}
}
