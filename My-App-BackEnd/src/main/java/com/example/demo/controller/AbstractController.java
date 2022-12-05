package com.example.demo.controller;


import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Abstract;
import com.example.demo.model.User;
import com.example.demo.model.UserPrincipal;
import com.example.demo.repo.AbstractRepo;
import com.example.demo.service.AbstractService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AbstractController {
	
	@Autowired
	private AbstractRepo abstractRepo;
	
	
	@PostMapping("/summary")
	public ResponseEntity<Abstract> submitSummary(@RequestBody Abstract summary) {

	//Get year of publication 
	int publication_year = summary.getPublication_date().getYear()+1900;
	
	//Get first_name and last_name of user logged
	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	// assume integrated custom UserDetails called MyCustomUserDetails
	// by default, typically instance of UserDetails
	UserPrincipal userDetails = (UserPrincipal) auth.getPrincipal();
	String FirstName = userDetails.getFistName();
	String LastName = userDetails.getLastName();
	
	System.out.println(FirstName);
	System.out.println(LastName);
	
	//Create citation
	summary.setCitation(LastName + "," + FirstName + " " + "(" + publication_year + ")" + " " + summary.getTitle() + " " + "(Publication No. " + summary.getDoi() + ")" + " " + "[Page No. " + summary.getPage() + "]");
	
	//Create Author
	summary.setAuthor(LastName + " " + FirstName);
	
	return ResponseEntity.ok(abstractRepo.save(summary));
	}
	
	
	/*@GetMapping("/viewAbstract/search ")
    public List<Abstract> search(@RequestParam String search){
        return (List<Abstract>)abstractRepo.search(search);
    }*/
	
	
	@Autowired
	private AbstractService abstractService;
	
	@GetMapping("/search")
	public Map<String, Iterable<Abstract>> search(@RequestParam String search) {
        System.out.println("searchArticles works");
		return abstractService.search(search);
	}
	
	@GetMapping("/viewAbstract")
    public List<Abstract> viewAllArticles(){
        System.out.println("viewArticles works");
        return (List<Abstract>)abstractRepo.findAll();
    }
	
}
