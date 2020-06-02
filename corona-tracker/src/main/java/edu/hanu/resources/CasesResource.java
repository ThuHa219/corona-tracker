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

import edu.hanu.model.Cases;
import edu.hanu.model.FilterBean;
import edu.hanu.service.CasesService;

@Path("/cases")
@Consumes(value = {MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
@Produces(value = {MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
public class CasesResource {
	private CasesService casesService = new CasesService();
	
	@GET
	@Path("/{casesId}")
	public Response getMessage(@PathParam("casesId") long casesId, @Context UriInfo uriInfo) {
		Cases entity = casesService.get(casesId);
		return Response.ok()
						.entity(entity)
						.build();
	}
	
	@GET
	public List<Cases> getAllMessages(@BeanParam FilterBean filterBean) {
		if (filterBean.getStart() >= 0 && filterBean.getSize() > 0) {
			return casesService.getPaginated(filterBean.getStart(), filterBean.getSize());
		}
		return casesService.getAll();
	}
}
