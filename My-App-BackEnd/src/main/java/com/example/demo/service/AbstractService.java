package com.example.demo.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Abstract;
import com.example.demo.repo.AbstractRepo;


@Service
public class AbstractService {
	
	@Autowired
	private AbstractRepo repo;
	
	
	public Map<String, Iterable<Abstract>> search(String searchTerm) {
		Iterable<Abstract> abstracts = repo.findAll();
		List<Abstract> articlesList = new ArrayList<Abstract>();
		List<Abstract> filterdArticles = new ArrayList<Abstract>();
		abstracts.forEach(articlesList::add);
		
		/*List<Abstract> filterdArticles = articlesList.stream().filter(c -> {
			return c.getTitle().equals(searchTerm);
		}).collect(Collectors.toList());*/
		
		for(Abstract k:articlesList) {
			if(k.getTitle().equals(searchTerm)) {
				System.out.println("ok");
				filterdArticles.add(k);
			}
		}
			
		/*System.out.println(filterdArticles);
		System.out.println(searchTerm);*/
		
		System.out.println(createHashPlural(filterdArticles));

		
		return createHashPlural(filterdArticles);
		
	}

	private Map<String, Iterable<Abstract>> createHashPlural(Iterable<Abstract> abstracts) {
		Map<String, Iterable<Abstract>> response = new HashMap<String, Iterable<Abstract>>();
		response.put("abstracts", abstracts);
		
		System.out.println(response);
		return response;
	}
	

}
