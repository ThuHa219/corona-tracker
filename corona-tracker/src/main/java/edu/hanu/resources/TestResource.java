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

import edu.hanu.model.FilterBean;
import edu.hanu.model.Test;
import edu.hanu.service.TestService;

@Path("/tests")
@Consumes(value = { MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
@Produces(value = { MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
public class TestResource {
	TestService testService = new TestService();

	@GET
	@Path("/{testId}")
	public Response getMessage(@PathParam("testId") long testId, @Context UriInfo uriInfo) {
		Test entity = testService.get(testId);
		return Response.ok().entity(entity).build();
	}

	@GET
	public List<Test> getAllMessages(@BeanParam FilterBean filterBean) {
		if (filterBean.getStart() >= 0 && filterBean.getSize() > 0) {
			return testService.getPaginated(filterBean.getStart(), filterBean.getSize());
		}
		return testService.getAll();
	}
}
