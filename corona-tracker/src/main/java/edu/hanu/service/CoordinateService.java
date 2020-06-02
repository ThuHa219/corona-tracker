package edu.hanu.service;

import java.util.ArrayList;
import java.util.List;

import edu.hanu.dao.CoordinateDAO;
import edu.hanu.exception.DataNotFoundException;
import edu.hanu.model.Coordinate;

public class CoordinateService {
	private CoordinateDAO dao;

	public CoordinateService() {
		dao = new CoordinateDAO();
	}

	public Coordinate get(long id) {
		Coordinate coordinate = dao.get(id);
		if (coordinate == null) {
			throw new DataNotFoundException("Can not find the number of coordinate with id: " + id);
		}
		return coordinate;
	}

	public List<Coordinate> getAll() {
		return dao.getAll();
	}

	public List<Coordinate> getPaginated(int start, int size) {
		ArrayList<Coordinate> list = new ArrayList<Coordinate>(dao.getAll());
		if (start + size > list.size())
			return new ArrayList<Coordinate>();
		return ((ArrayList<Coordinate>) list).subList(start, start + size);
	}
}
