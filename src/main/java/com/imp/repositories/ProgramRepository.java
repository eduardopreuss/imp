/**
 * Internship Management Program
 * 
 * @since Oct 10th, 2017
 */
package com.imp.repositories;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.imp.entities.Program;


/**
 * Repository of internship programs.
 * 
 * @author IT Academy #3
 */
public interface ProgramRepository extends CrudRepository<Program, Integer> {

	/**
	 * Finds all programs.
	 * 
	 * @return List of all programs.
	 */
	public List<Program> findAll();

	/**
	 * Finds a program by its id.
	 * 
	 * @param id ID of program to find.
	 * @return Program if found, null otherwise.
	 */
	public Program findById(int id);

	/**
	 * Finds a program by its official name.
	 * 
	 * @param name Name of program to find.
	 * @return Program if found, null otherwise.
	 */
	public Program findByName(String name);

	/**
	 * Finds a program by its alias.
	 * 
	 * @param alias Alias of program to find.
	 * @return Program if found, null otherwise.
	 */
	public Program findByAlias(String alias);

}
