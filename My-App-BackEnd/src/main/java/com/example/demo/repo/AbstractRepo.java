package com.example.demo.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Abstract;
import com.example.demo.model.User;


@Repository
public interface AbstractRepo extends JpaRepository<Abstract, String>{

	@Query(value = "select * from ARTICLE", nativeQuery = true)
	List<Abstract> findAll();
	
}
