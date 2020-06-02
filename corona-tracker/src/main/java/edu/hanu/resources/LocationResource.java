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
import edu.hanu.model.Location;
import edu.hanu.service.LocationService;

@Path("/locations")
@Consumes(value = {MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
@Produces(value = {MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
public class LocationResource {
	private LocationService locationService = new LocationService();

	@GET
	@Path("/{locationId}")
	public Response getMessage(@PathParam("locationId") long locationId, @Context UriInfo uriInfo) {
		Location entity = locationService.get(locationId);
		return Response.ok().entity(entity).build();
	}

	@GET
	public List<Location> getAllMessages(@BeanParam FilterBean filterBean) {
		if (filterBean.getStart() >= 0 && filterBean.getSize() > 0) {
			return locationService.getPaginated(filterBean.getStart(), filterBean.getSize());
		}
		return locationService.getAll();
	}
}
