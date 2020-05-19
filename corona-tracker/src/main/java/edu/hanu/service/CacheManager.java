package edu.hanu.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import edu.hanu.dao.CovidDataDAO;
import edu.hanu.model.CovidData;

public class CacheManager {
	private Map<String, String> d = new HashMap<>();
    private Map<String, Long> t = new HashMap<>(); //exp time
    
    private ObjectMapper mapper = new ObjectMapper();
    
    private CovidDataDAO dao;
    
    public CacheManager(CovidDataDAO dao) {
        this.dao = dao;
    }
    
    public boolean invalid(String key) {
        return t.containsKey(key) && expiredTimeValid(t.get(key));
    }

    private boolean expiredTimeValid(Long expiredTime) {
        return System.currentTimeMillis() - expiredTime < 30 * 60 * 1000;
    }
    
    public <T> T get(String key, Class<T> cl) throws Exception {
        if (d.containsKey(key) && t.containsKey(key) && expiredTimeValid(t.get(key))) {
            return mapper.readValue(d.get(key), cl);
        }
        return mapper.readValue(d.get(key), cl);
    }
    
    public <T> T get(String key, TypeReference<T> type) throws Exception {
        if (d.containsKey(key) && t.containsKey(key) && expiredTimeValid(t.get(key))) {
            return mapper.readValue(d.get(key), type);
        }
        List<CovidData> covidDataList = dao.getAllLatest();
        covidDataList.sort((a, b)->b.getCases().getTotal() - a.getCases().getTotal());
        put(key, mapper.writeValueAsString(covidDataList));
        return mapper.readValue(d.get(key), type);
    }
    
    public void put(String k, String v) {
        d.put(k, v);
        t.put(k, System.currentTimeMillis());
    }

    public void put(String k, Object v) {
        try {
            put(k, mapper.writeValueAsString(v));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
