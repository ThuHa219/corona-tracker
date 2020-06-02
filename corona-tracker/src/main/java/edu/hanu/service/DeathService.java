package edu.hanu.service;

import java.util.ArrayList;
import java.util.List;

import edu.hanu.dao.DeathDAO;
import edu.hanu.exception.DataNotFoundException;
import edu.hanu.model.Death;

public class DeathService {
	private DeathDAO dao;

	public DeathService() {
		dao = new DeathDAO();
	}

	public Death get(long id) {
		Death death = dao.get(id);
		if (death == null) {
			throw new DataNotFoundException("Can not find the number of death with id: " + id);
		}
		return death;
	}

	public List<Death> getAll() {
		return dao.getAll();
	}

	public List<Death> getPaginated(int start, int size) {
		ArrayList<Death> list = new ArrayList<Death>(dao.getAll());
		if (start + size > list.size())
			return new ArrayList<Death>();
		return ((ArrayList<Death>) list).subList(start, start + size);
	}
}
