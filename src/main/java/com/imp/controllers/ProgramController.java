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

@RestController
public class ProgramController {
	ProgramService ps;
	
	@Autowired
	public ProgramController(ProgramService ps) {
		this.ps = ps;
	}
	
	//==================================================================================================
	
	//ADD
	@GetMapping("/createProgram")
	public String createProgram() {
		return "createProgram";
	}
	
	
	@PostMapping("/createProgram")
	public String createProgram(@RequestParam("title") String title, @RequestParam("description") String description, @RequestParam("ownerBadge") String ownerBadge, @RequestParam("startDate") LocalDate startDate, @RequestParam("endDate") LocalDate endDate, Model model) throws StartDateAfterEndDateException{
		ps.addProgram(title, description, ownerBadge, startDate, endDate);
		return null;
	}
	
	/*
	@GetMapping("/createProgram")
	public String createProgram(Model model) {
		model.addAttribute("title", this.pc.getTitle());
		model.addAttribute("description", this.pc.getDescription());
		model.addAttribute("ownerBadge", this.pc.getOwnerBadge());
		model.addAttribute("startDate", this.pc.getStartDate());
		model.addAttribute("endDate", this.pc.getEndDate());
	}
	
	*/
	//==================================================================================================
	
	//search SHOW
	@GetMapping("show/Program")
	public String showProgram(Model model) {
		//model.addAttribute("Program", pc.showProgram());
		return "showProgram";
	}
	

}
