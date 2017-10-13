package com.imp.controllers;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.imp.services.ProgramService;
import com.imp.exceptions.StartDateAfterEndDateException;
import com.imp.controllers.ProgramController;
import com.imp.entities.Program;

@RestController
public class ProgramController {
	ProgramService ps;
	
	@Autowired
	public ProgramController(ProgramService ps) {
		this.ps = ps;
	}
	
	//==================================================================================================	
	
	@PostMapping("/api/createProgram")
	public String createProgram(@RequestParam("title") String title, @RequestParam("description") String description, @RequestParam("ownerBadge") String ownerBadge, @RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate) throws StartDateAfterEndDateException{
		ps.addProgram(title, description, ownerBadge, LocalDate.parse(startDate), LocalDate.parse(endDate));
		return "success";
	}
	
	
	//==================================================================================================
	

	/**
	 * Return an iterable with all Programs in data base
	 * @param model
	 * @return an iterable with all Programs in data base
	 */
	@GetMapping("/api/list/programs")
	public Iterable<Program> listPrograms(Model model) {
		Iterable<Program> programList = ps.findAll();
		return programList;
	}
	
}


