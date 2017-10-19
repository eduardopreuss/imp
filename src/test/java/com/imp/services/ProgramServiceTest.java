package com.imp.services;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.ConfigFileApplicationContextInitializer;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.Assert.*;
import org.junit.rules.ExpectedException;

import com.imp.ImpApplicationTests;
import com.imp.application.ImpApplication;
import com.imp.entities.Program;
import com.imp.enums.EmploymentStatus;
import com.imp.exceptions.CannotDeleteProgramWithUserAssigned;
import com.imp.exceptions.CannotFindAProgramWithThatId;
import com.imp.exceptions.ProgramNotFoundException;
import com.imp.exceptions.StartDateAfterEndDateException;
import com.imp.repositories.ProgramRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ImpApplication.class)
@Transactional
public class ProgramServiceTest {
    @Autowired
    ProgramService ps;
    
    Program test;

    @Rule
	public ExpectedException thrown = ExpectedException.none();
    
    @Before
    public void before() throws StartDateAfterEndDateException {
    	test = new Program("Eu", "Sou", "171", LocalDate.of(2016, 5, 8), LocalDate.now());
    }
    /**
     *  Test if a program can be added to the Data Base, and if the methods findByTitle, findById, findByOwnerBadge work correctly
     *  and test if a program can be updated and deleted
     * @throws Exception
     */
    @Test
    public void myTest() throws Exception {
		Program program = new Program("Eu", "Sou", "171", LocalDate.of(2016, 5, 8), LocalDate.now());

    	ps.addProgram(program);
	    Program p2 = ps.findByTitle("Eu");
	    assertEquals(test.getDescription(), p2.getDescription());
	    assertEquals(test.getEndDate(), p2.getEndDate());
	    assertEquals(test.getOwnerBadge(), p2.getOwnerBadge());
	    assertEquals(test.getStartDate(), p2.getStartDate());
	    assertEquals(test.getTitle(), p2.getTitle());

	    Program p3 = ps.findByOwnerBadge("171");
	    assertEquals(test.getDescription(), p3.getDescription());
	    assertEquals(test.getEndDate(), p3.getEndDate());
	    assertEquals(test.getOwnerBadge(), p3.getOwnerBadge());
	    assertEquals(test.getStartDate(), p3.getStartDate());
	    assertEquals(test.getTitle(), p3.getTitle());
	    
	    Long programCod = p2.getId();
	    Program p4 = ps.findById(programCod);
	    
	    assertEquals(test.getDescription(), p4.getDescription());
	    assertEquals(test.getEndDate(), p4.getEndDate());
	    assertEquals(test.getOwnerBadge(), p4.getOwnerBadge());
	    assertEquals(test.getStartDate(), p4.getStartDate());
	    assertEquals(test.getTitle(), p4.getTitle());
	    
	    ps.updateProgram(programCod, "Eu2", "Sou2", "1712", LocalDate.of(2017, 2, 2), LocalDate.of(2017, 5, 5));
	    assertEquals("Sou2", p4.getDescription());
	    assertEquals("Eu2", p4.getTitle());
	    assertEquals("1712", p4.getOwnerBadge());
	    assertEquals(LocalDate.of(2017, 2, 2), p4.getStartDate());
	    assertEquals(LocalDate.of(2017, 5, 5), p4.getEndDate());
	    
	    ps.deleteProgram(programCod);
    }
    
    /**
     * @throws StartDateAfterEndDateException
     * See if a program with invalid data can be added to the data base, this test is suppose to fail
     */
    @Test
    public void test1() throws StartDateAfterEndDateException {
    	thrown.expect(StartDateAfterEndDateException.class);
    	Program p = new Program("Eu", "sou", "172", LocalDate.of(2016, 5, 8), LocalDate.of(2016, 5, 7));
    	ps.addProgram(p);
    	
    	
    }
    
    /**
     * Test delete throws a exception when tries to delete a program that doesn't exist
     * @throws StartDateAfterEndDateException
     * @throws CannotDeleteProgramWithUserAssigned
     * @throws CannotFindAProgramWithThatId
     * @throws ProgramNotFoundException 
     */
    @Test
    public void test2() throws StartDateAfterEndDateException, CannotDeleteProgramWithUserAssigned, CannotFindAProgramWithThatId, ProgramNotFoundException {
    	Program program = new Program("Eu", "sou", "172", LocalDate.of(2016, 5, 8), LocalDate.of(2016, 5, 9));
    	ps.addProgram(program);
    	Program p = ps.findByTitle("Eu");
    	Long idP = p.getId();
    	ps.deleteProgram(idP);
    	thrown.expect(CannotFindAProgramWithThatId.class);
    	ps.deleteProgram(idP);
    	thrown.expect(CannotFindAProgramWithThatId.class);
    	ps.updateProgram(idP, "Eu2", "Sou2", "1712", LocalDate.of(2017, 2, 2), LocalDate.of(2017, 5, 5));

    	
    }
    
    /**
     * Test if throws an exception when tries to update a program with an id that doesn't match with any program on data base
     * @throws StartDateAfterEndDateException
     * @throws CannotDeleteProgramWithUserAssigned
     * @throws CannotFindAProgramWithThatId
     * @throws ProgramNotFoundException
     */
    @Test
    public void testUpdateProgramWithWrongId() throws StartDateAfterEndDateException, CannotDeleteProgramWithUserAssigned, CannotFindAProgramWithThatId, ProgramNotFoundException {
    	Program program = new Program("Eu", "sou", "172", LocalDate.of(2016, 5, 8), LocalDate.of(2016, 5, 9));
    	ps.addProgram(program);
    	Program p = ps.findByTitle("Eu");
    	Long idP = p.getId();
    	ps.deleteProgram(idP);
    	thrown.expect(CannotFindAProgramWithThatId.class);
    	ps.updateProgram(idP, "Eu2", "Sou2", "1712", LocalDate.of(2017, 2, 2), LocalDate.of(2017, 5, 5));

    }
    /**
     * Test if findAll method works
     * @throws StartDateAfterEndDateException
     */
    @Test
    public void test3() throws StartDateAfterEndDateException {
    	Program p1 = new Program("IT", "INTERN PROGRAM", "115486483", LocalDate.of(2018, 5, 20), LocalDate.of(2020, 5, 20));
    	Program p2 = new Program("IT2", "INTERN PROGRAM", "115486483", LocalDate.of(2020, 5, 20), LocalDate.of(2022, 5, 20));
    	Program p3 = new Program("IT3", "INTERN PROGRAM", "115486483", LocalDate.of(2022, 5, 20), LocalDate.of(2024, 5, 20));

    	ps.addProgram(p1);
    	ps.addProgram(p2);
    	ps.addProgram(p3);

    	List <Program> allPrograms = ps.findAll();
    	Boolean p1Found = false;
    	Boolean p2Found = false;
    	Boolean p3Found = false;
    	for(Program p:allPrograms) {

    		if(p.getTitle().equals(p1.getTitle())) {
    			p1Found = true;
    		}
    		if(p.getTitle().equals(p2.getTitle())) {
    			p2Found = true;
    	    }
    		if(p.getTitle().equals(p3.getTitle())) {
    			p3Found = true;
    	    }
    	}
    	
    	assertEquals(true, p1Found);
    	assertEquals(true, p2Found);
    	assertEquals(true, p3Found);

    }
}

