/**
 * Internship Management Program
 * 
 * @since Oct 10th, 2017
 */
package com.imp.repositories;

import org.springframework.data.repository.CrudRepository;
import com.imp.entities.Program;


/**
 * Repository of internship programs.
 * 
 * @author IT Academy #3
 */
public interface ProgramRepository extends CrudRepository<Program, Integer> {

	// TODO: Define methods.

}

