package edu.hanu.service;

import java.util.ArrayList;
import java.util.List;

import edu.hanu.dao.TestDAO;
import edu.hanu.exception.DataNotFoundException;
import edu.hanu.model.Test;

public class TestService {
	private TestDAO dao;

	public TestService() {
		dao = new TestDAO();
	}

	public Test get(long id) {
		Test test = dao.get(id);
		if (test == null) {
			throw new DataNotFoundException("Can not find the number of test with id: " + id);
		}
		return test;
	}

	public List<Test> getAll() {
		return dao.getAll();
	}

	public List<Test> getPaginated(int start, int size) {
		ArrayList<Test> list = new ArrayList<Test>(dao.getAll());
		if (start + size > list.size())
			return new ArrayList<Test>();
		return ((ArrayList<Test>) list).subList(start, start + size);
	}
}
