package com.imp.controllers;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.imp.services.ProgramService;
import com.imp.exceptions.ProgramNotFoundException;
import com.imp.exceptions.CannotDeleteProgramWithUserAssigned;
import com.imp.exceptions.CannotFindAProgramWithThatId;
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
	
	/**
	 * Creates a program on data base
	 * @param title the program's title
	 * @param description the program's description
	 * @param ownerBadge the program's owner badge
	 * @param startDate the program's start date
	 * @param endDate the program's end date
	 * @return success if the program has been created on data base
	 * @throws StartDateAfterEndDateException if the start date is after the end date
	 */
	@PostMapping("/api/createProgram")
	public String createProgram(@RequestBody Program program) throws StartDateAfterEndDateException{
		ps.addProgram(program);
		return "success";
	}
	
	
	/**
	 * Return an instance of program 
	 * @param id the program's id
	 * @return a program with that id
	 * @throws CannotFindAProgramWithThatId if there is no program with that id
	 */
	@GetMapping("/api/list/programView")
	public Program programView(@RequestParam("id") Long id) throws CannotFindAProgramWithThatId {
			Program programDetailsView = ps.findById(id);
			if(programDetailsView == null) {
				throw new CannotFindAProgramWithThatId("There is no program with that id");
			}
			return programDetailsView;
	}
	
	/**
	 * Return an Iterable with all Programs in data base
	 * @param model
	 * @return an Iterable with all Programs in data base
	 */
	@GetMapping("/api/list/programs")
	public Iterable<Program> listPrograms() {
		Iterable<Program> programList = ps.findAll();
		return programList;
	}
	
	/**
	 * Deletes a program from data base
	 * @param id of the program that will be deleted
	 * @return deleted if the program has been delete or a mensage error
	 * @throws CannotFindAProgramWithThatId 
	 * @throws CannotDeleteProgramWithUserAssigned 
	 */
	@GetMapping("api/delete/program")
	public String deleteProgram(Long id) throws CannotDeleteProgramWithUserAssigned, CannotFindAProgramWithThatId{
		
		this.ps.deleteProgram(id);
		
		return "deleted";
	}
}


