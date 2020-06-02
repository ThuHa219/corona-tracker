package edu.hanu.resources;

import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import edu.hanu.model.CovidData;
import edu.hanu.model.FilterBean;
import edu.hanu.service.CoronaVirusServiceImpl;

@Path("/covidDatas")
@Consumes(value = { MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
@Produces(value = { MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
public class CovidDataResource {
	CoronaVirusServiceImpl covidDataService = new CoronaVirusServiceImpl();

	@GET
	@Path("/{covidDataId}")
	public Response get(@PathParam("covidDataId") long covidDataId, @Context UriInfo uriInfo) {
		CovidData entity = covidDataService.get(covidDataId);
		entity.addlink(getUriForSelf(uriInfo), "self");
		entity.addlink(getUriForCases(uriInfo, entity), "cases");
		entity.addlink(getUriForDeath(uriInfo, entity), "deaths");
		entity.addlink(getUriForTest(uriInfo, entity), "tests");
		return Response.ok().entity(entity).build();
	}

	@GET
	public List<CovidData> getAll(@BeanParam FilterBean filterBean) {
		if (filterBean.getStart() >= 0 && filterBean.getSize() > 0) {
			return covidDataService.getPaginated(filterBean.getStart(), filterBean.getSize());
		}
		return covidDataService.getAll();
	}

	@Path("/{covidDataId}/cases")
	public CasesResource getCaseResource() {
		return new CasesResource();
	}

	@Path("/{covidDataId}/deaths")
	public DeathResource getDeathResource() {
		return new DeathResource();
	}
	
	@Path("/{covidDataId}/tests")
	public TestResource getTestResource() {
		return new TestResource();
	}

	private String getUriForSelf(UriInfo uriInfo) {
		String uri = uriInfo.getAbsolutePathBuilder().build().toString();
		return uri;
	}

	private String getUriForCases(UriInfo uriInfo, CovidData covidData) {
		String uri = uriInfo.getBaseUriBuilder()
				.path(CovidDataResource.class)
				.path(CovidDataResource.class, "getCaseResource")
				.path(String.valueOf(covidData.getCases().getId()))
				.resolveTemplate("covidDataId", covidData.getId()).build().toString();
		return uri;
	}

	private String getUriForDeath(UriInfo uriInfo, CovidData covidData) {
		String uri = uriInfo.getBaseUriBuilder()
				.path(CovidDataResource.class)
				.path(CovidDataResource.class, "getDeathResource")
				.path(String.valueOf(covidData.getDeaths().getId()))
				.resolveTemplate("covidDataId", covidData.getId()).build().toString();
		return uri;
	}
	
	private String getUriForTest(UriInfo uriInfo, CovidData covidData) {
		String uri = uriInfo.getBaseUriBuilder()
				.path(CovidDataResource.class)
				.path(CovidDataResource.class, "getTestResource")
				.path(String.valueOf(covidData.getTest().getId()))
				.resolveTemplate("covidDataId", covidData.getId()).build().toString();
		return uri;
	}
}
