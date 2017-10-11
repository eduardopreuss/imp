package com.imp.services;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;

import com.imp.entities.Program;
import com.imp.exceptions.StartDateAfterEndDateException;
import com.imp.repositories.ProgramRepository;

public class ProgramService{
	
	ProgramRepository programRepository;
	
	@Autowired
	public void addProgram(String title, String description, String ownerBadge, LocalDate startDate, LocalDate endDate) throws StartDateAfterEndDateException{
		Program program = new Program(title, description, ownerBadge, startDate, endDate); 
		programRepository.save(program);
	}		
}
