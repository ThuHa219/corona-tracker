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

import edu.hanu.model.Death;
import edu.hanu.model.FilterBean;
import edu.hanu.service.DeathService;

@Path("/deaths")
@Consumes(value = {MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
@Produces(value = {MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
public class DeathResource {
	DeathService deathService = new DeathService();
	
	@GET
	@Path("/{deathId}")
	public Response getMessage(@PathParam("deathId") long deathId, @Context UriInfo uriInfo) {
		Death entity = deathService.get(deathId);
		return Response.ok()
						.entity(entity)
						.build();
	}
	
	@GET
	public List<Death> getAllMessages(@BeanParam FilterBean filterBean) {
		if (filterBean.getStart() >= 0 && filterBean.getSize() > 0) {
			return deathService.getPaginated(filterBean.getStart(), filterBean.getSize());
		}
		return deathService.getAll();
	}
}
