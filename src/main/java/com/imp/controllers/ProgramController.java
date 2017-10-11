/*package com.imp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.imp.repositories.ProgramRepository;

@RestController
public class ProgramController {
	ProgramControl pc;
	
	@Autowired
	public ProgramController(ProgramControl pc) {
		this.pc = pc;
	}
	
	//==================================================================================================
	
	//ADD
	@GetMapping("/createProgram")
	public String createProgram(Model model) {
		return "createProgram";
	}
	
	
	@GetMapping("/createProgram")
	public String createProgram(Model model) {
		model.addAttribute("title", this.pc.getTitle());
		model.addAttribute("description", this.pc.getDescription());
		model.addAttribute("ownerBadge", this.pc.getOwnerBadge());
		model.addAttribute("startDate", this.pc.getStartDate());
		model.addAttribute("endDate", this.pc.getEndDate());
	}
	
	
	//==================================================================================================
	
	//search SHOW
	@GetMapping("show/Program")
	public String showProgram(Model model) {
		model.addAttribute("Program", pc.showProgram());
		return "showProgram";
	}
	

}
*/