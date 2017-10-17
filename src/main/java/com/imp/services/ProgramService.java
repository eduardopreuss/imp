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
import com.imp.exceptions.CannotDeleteProgramWithUserAssigned;
import com.imp.exceptions.CannotFindAProgramWithThatId;
import com.imp.exceptions.ProgramNotFoundException;
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
	public void addProgram(	String title, String description, String ownerBadge, LocalDate startDate, LocalDate endDate) throws StartDateAfterEndDateException {
		Program program = new Program(title, description, ownerBadge, startDate,endDate);
		programRepository.save(program);
	}
	
	/**
	 * Update a program on data base with new values
	 * @param id program's id
	 * @param title new program's title
	 * @param description new program's description
	 * @param ownerBadge new program's owner badge
	 * @param startDate new program's start date
	 * @param endDate new program's end date
	 * @throws StartDateAfterEndDateException if the new start date came before the end date
	 * @throws CannotFindAProgramWithThatId if there is no program with that id on data base
	 */
	public void updateProgram(Long id, String title, String description, String ownerBadge, LocalDate startDate,
			LocalDate endDate) throws StartDateAfterEndDateException,CannotFindAProgramWithThatId {
		
		Program program = null;
		
		program = this.programRepository.findById(id);
		
		if(program == null) {
			throw new CannotFindAProgramWithThatId("There is no program with that Id");
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
	public Program findById(Long id) {
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
	
	/**
	 * Delete a program from dataBase, only if there is no users assigned to it
	 * @param programID the program that will be deleted
	 * @throws CannotDeleteProgramWithUserAssigned if there is at least one user assigned to it
	 * @throws CannotFindAProgramWithThatId if there is no program with that id
	 */
	public void deleteProgram(Long programID) throws CannotDeleteProgramWithUserAssigned, CannotFindAProgramWithThatId {
		Program program = this.findById(programID);
		if(program != null) {				
			if(program.getProgramUsers().isEmpty()) {
				this.programRepository.delete(programID);
			}
			else {
				throw new CannotDeleteProgramWithUserAssigned("This Program has Person assigned, please delete this association before delete the Program");
			}
		}
		else {
			throw new CannotFindAProgramWithThatId("There is no program with that Id");
		}
	}

}