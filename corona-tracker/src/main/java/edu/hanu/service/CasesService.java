package edu.hanu.service;

import java.util.ArrayList;
import java.util.List;

import edu.hanu.dao.CasesDAO;
import edu.hanu.exception.DataNotFoundException;
import edu.hanu.model.Cases;

public class CasesService {

	private CasesDAO dao;
	
	public CasesService() {
		dao = new CasesDAO();
	}
	
	public Cases get(long id) {
		Cases cases = dao.get(id);
		if(cases == null) {
			throw new DataNotFoundException("Can not find case with id: " + id);
		}
		return cases;
	}
	
	public List<Cases> getAll() {
		return dao.getAll();
	}
	
	public List<Cases> getPaginated(int start, int size) {
		ArrayList<Cases> list = new ArrayList<Cases>(dao.getAll());
		if(start + size > list.size()) return new ArrayList<Cases>();
		return ((ArrayList<Cases>) list).subList(start, start + size);
	}
}
