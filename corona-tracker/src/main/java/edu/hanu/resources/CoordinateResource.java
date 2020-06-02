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

import edu.hanu.model.Coordinate;
import edu.hanu.model.FilterBean;
import edu.hanu.service.CoordinateService;

@Path("/coordinates")
@Consumes(value = { MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
@Produces(value = { MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
public class CoordinateResource {
	private CoordinateService coordinateService = new CoordinateService();

	@GET
	@Path("/{coordinateId}")
	public Response getMessage(@PathParam("coordinateId") long coordinateId, @Context UriInfo uriInfo) {
		Coordinate entity = coordinateService.get(coordinateId);
		return Response.ok().entity(entity).build();
	}

	@GET
	public List<Coordinate> getAllMessages(@BeanParam FilterBean filterBean) {
		if (filterBean.getStart() >= 0 && filterBean.getSize() > 0) {
			return coordinateService.getPaginated(filterBean.getStart(), filterBean.getSize());
		}
		return coordinateService.getAll();
	}
}
