package edu.hanu.service;

import java.util.ArrayList;
import java.util.List;

import edu.hanu.dao.LocationDAO;
import edu.hanu.exception.DataNotFoundException;
import edu.hanu.model.Location;

public class LocationService {
	private LocationDAO dao = new LocationDAO();

	public Location get(long id) {
		Location location = dao.get(id);
		if (location == null) {
			throw new DataNotFoundException("Can not find the number of location with id: " + id);
		}
		return location;
	}

	public List<Location> getAll() {
		return dao.getAll();
	}

	public List<Location> getPaginated(int start, int size) {
		ArrayList<Location> list = new ArrayList<Location>(dao.getAll());
		if (start + size > list.size())
			return new ArrayList<Location>();
		return ((ArrayList<Location>) list).subList(start, start + size);
	}
}
