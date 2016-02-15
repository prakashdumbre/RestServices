package com.service.domain.mapper;

public interface DomainMapper<T, R> {

	public R mapToDto(T source, R destination);

	public T mapToDomain(R source, T destination);
}


