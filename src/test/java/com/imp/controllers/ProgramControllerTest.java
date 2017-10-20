package com.imp.controllers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import java.time.LocalDate;

import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.imp.application.ImpApplication;
import com.imp.entities.Program;
import com.imp.exceptions.CannotDeleteProgramWithUserAssigned;
import com.imp.exceptions.CannotFindAProgramWithThatId;
import com.imp.exceptions.StartDateAfterEndDateException;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ImpApplication.class)
@Transactional
public class ProgramControllerTest {
	@Autowired
	ProgramController pc;
	Program test;
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Before
    public void before() throws StartDateAfterEndDateException {
    	test = new Program("Title", "Description", "11035489", LocalDate.of(2017, 12, 5), LocalDate.of(2019,12,5));
    }
	
	/**
	 * Test if a program can be create on data base
	 * @throws StartDateAfterEndDateException if the program start date is after the program end date
	 */
	@Test
	public void testCreateProgram() throws StartDateAfterEndDateException {
		Program program = new Program("Title", "Description", "11035489", LocalDate.of(2017, 12, 05), LocalDate.of(2019, 12, 05));
		String result = pc.createProgram(program);
		assertEquals("success",result);
	}

	/**
	 * Test if the programView method return a instance of Program with that id
	 * @throws CannotFindAProgramWithThatId if there is no program with that id
	 */
	@Test
	public void testProgramView() throws  CannotFindAProgramWithThatId {
		try {
			Program program = new Program("Title", "Description", "11035489", LocalDate.of(2017, 12, 05), LocalDate.of(2019, 12, 05));
			pc.createProgram(program);
		} catch (StartDateAfterEndDateException e) {
			fail();
		}
		Long programId = 0l;
		for(Program p :pc.listPrograms()) {
			if(p.getTitle().equals("Title") && p.getDescription().equals("Description")) {
				programId = p.getId();
			}
		}
		Program program = pc.programView(programId);
		
		assertEquals(test.getTitle(), program.getTitle());
		assertEquals(test.getDescription(), program.getDescription());
		assertEquals(test.getOwnerBadge(), program.getOwnerBadge());
		assertEquals(test.getStartDate(), program.getStartDate());
		assertEquals(test.getEndDate(), program.getEndDate());

	}

	/**
	 * test if the listPrograms method return an iterable of Program 
	 */
	@Test
	public void testListPrograms() {
		assertThat(pc.listPrograms());
	}

	/**
	 * Test if a program can be delete throw the method deleteProgram, and if throws an exception when tries to delete
	 *  a program with an id that doesn't matches any program on data base
	 * @throws StartDateAfterEndDateException
	 * @throws CannotDeleteProgramWithUserAssigned
	 * @throws CannotFindAProgramWithThatId
	 */
	@Test
	public void testDeleteProgram() throws StartDateAfterEndDateException, CannotDeleteProgramWithUserAssigned, CannotFindAProgramWithThatId {
		Program program = new Program("Title", "Description", "11035489", LocalDate.of(2017, 12, 05), LocalDate.of(2019, 12, 05));
		pc.createProgram(program);
		Long programId = 0l;
		for(Program p :pc.listPrograms()) {
			if(p.getTitle().equals("Title") && p.getDescription().equals("Description")) {
				programId = p.getId();
			}
		}
		pc.deleteProgram(programId);
		thrown.expect(CannotFindAProgramWithThatId.class);
		pc.deleteProgram(programId);

	}

}
