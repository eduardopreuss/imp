/**
 * Internship Management Program
 * 
 * @since Oct 10th, 2017
 */
package com.imp.services;

import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.imp.entities.Program;
import com.imp.exceptions.StartDateAfterEndDateException;
import com.imp.repositories.ProgramRepository;


/**
 * Service for Program class.
 * 
 * @author IT Academy #3
 */
@Component
public class ProgramService {

	private ProgramRepository programRepository;

	/**
	 * Constructs ProgramService using dependency injection of a ProgramRepository.
	 * 
	 * @param programRepository Repository of programs.
	 */
	@Autowired
	public ProgramService(ProgramRepository programRepository) {
		this.programRepository = programRepository;
	}

	/**
	 * Creates a program and save it in the repository.
	 * 
	 * @param title Program's title.
	 * @param description Program's description.
	 * @param ownerBadge Program owner's badge.
	 * @param startDate Program's start date.
	 * @param endDate Program's end date.
	 * @throws StartDateAfterEndDateException
	 */
	public void addProgram(	String title, String description, String ownerBadge, LocalDate startDate,
							LocalDate endDate) throws StartDateAfterEndDateException {
		Program program = new Program(title, description, ownerBadge, startDate, endDate);
		programRepository.save(program);
	}
	
	//TO BE REVIEW
	public void updateProgram(int id, String title, String description, String ownerBadge, LocalDate startDate,
			LocalDate endDate) throws StartDateAfterEndDateException {
		
		Program program = null;
		try {
			program = this.programRepository.findById(id);
		} catch(Exception e) {
			return;
		}
		
		program.setTitle(title);
		program.setDescription(description);
		program.setOwnerBadge(ownerBadge);
		program.setStartDate(startDate);
		program.setEndDate(endDate);
		
		programRepository.save(program);
	}


	/**
	 * Finds all programs.
	 * 
	 * @return List of all programs.
	 */
	public List<Program> findAll() {
		return this.programRepository.findAll();
	}

	/**
	 * Finds a program by its ID.
	 * 
	 * @param id ID of program to find.
	 * @return Program if found, null otherwise.
	 */
	public Program findById(int id) {
		return this.programRepository.findById(id);
	}

	/**
	 * Finds a program by its official title.
	 * 
	 * @param title Title of program to find.
	 * @return Program if found, null otherwise.
	 */
	public Program findByTitle(String title) {
		return this.programRepository.findByTitle(title);
	}

	/**
	 * Finds a program by its owner's badge.
	 * 
	 * @param ownerBadge Owner's badge of program to find.
	 * @return Program if found, null otherwise.
	 */
	public Program findByOwnerBadge(String ownerBadge) {
		return this.programRepository.findByOwnerBadge(ownerBadge);
	}

}
