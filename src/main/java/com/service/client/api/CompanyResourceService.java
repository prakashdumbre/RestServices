package com.service.client.api;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.client.request.dto.CompanyDto;
import com.client.rsponse.dto.ResponseDto;

@Path("/companies")
public interface CompanyResourceService {

    /**
     * Create/Add new company
     *
     * @param companyDto contain company details
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    ResponseDto add(CompanyDto companyDto);

    /**
     * Create/Add new company
     *
     * @param companyDto contain company details
     */
    @Path("/{companyId}/update")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    ResponseDto update(@PathParam("companyId") Long companyId, CompanyDto companyDto);

    /**
     * Get details about the company.
     *
     * @param companyId companyId
     */
    @Path("/{companyId}")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    CompanyDto get(@PathParam("companyId") Long companyId);

    /**
     * Find list of all company.
     *
     */
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    List<CompanyDto> findAll();

}
