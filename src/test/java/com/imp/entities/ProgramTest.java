package com.imp.entities;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.Assert.*;
import org.junit.rules.ExpectedException;

import com.imp.exceptions.StartDateAfterEndDateException;


public class ProgramTest {
	Program test;
	
//	@Rule
//	public ExpectedException thrown = ExpectedException.none();
	
//	@Test
//	public void starteDateBiggerThanEndDate() throws StartDateAfterEndDateException{
//		p.setStartDate(LocalDate.of(2017,4,6));
//		thrown.expect(StartDateAfterEndDateException.class);
//		p.setEndDate(LocalDate.of(2017, 2, 5));
//	}
	
	@Before
	public void setUp() throws StartDateAfterEndDateException {
		test = new Program("Title","This is a test", "ownerBadge", LocalDate.of(2017,1,5), LocalDate.of(2017, 2, 5));
	}

	//Test if the field Title is right on the constructor method
	@Test
	public void test() {
		assertEquals("Title",test.getTitle());
	}

	//Test if the field Description is right on the constructor method
	@Test
	public void test2() {
		assertEquals("This is a test",test.getDescription());
	}
	
	//Test if the field OwnerBadge is right on the constructor method
	@Test
	public void test3() {
		assertEquals("ownerBadge",test.getOwnerBadge());
	}
	
	//Test if the field StartDate is right on the constructor method
	@Test
	public void test4() {
		assertEquals(LocalDate.of(2017, 1, 5),test.getStartDate());
	}
	
	//Test if the field EndDate is right on the constructor method
	@Test
	public void test5() {
		assertEquals(LocalDate.of(2017, 2, 5),test.getEndDate());
	}
	//Test if is possible change the title field throw the setTitle method
	
	@Test
	public void test6() {
		test.setTitle("New Title");
		assertEquals("New Title",test.getTitle());
	}
	
	//Test if is possible change the description field throw the setDescription method
	@Test
	public void test7() {
		test.setDescription("New Description");
		assertEquals("New Description",test.getDescription());
	}
	
	//Test if is possible change the ownerBadge field throw the setOwnerBadge method
	@Test
	public void test8() {
		test.setOwnerBadge("New Owner");
		assertEquals("New Owner",test.getOwnerBadge());
	}
	
	//Test if is possible change the endDate field throw the setEndDate method, with a endDate that happened before the startDate, if is possible fails
	@Test
	public void test9() {
		try {
			test.setEndDate(LocalDate.of(2, 8, 6));
			fail();
		}catch (StartDateAfterEndDateException e2) {
			assertEquals(LocalDate.of(2017, 2, 5),test.getEndDate());
		}
	}
	
	//Test if is possible change the endDate field throw the setEndDate method, with a endDate that happened after the starDate, if possible success
	@Test
	public void test10() {
		try {
			test.setEndDate(LocalDate.of(2017, 8, 6));
			assertTrue((test.getEndDate().isAfter(test.getStartDate())));
		}catch (StartDateAfterEndDateException e2) {
			fail();
		}
	}
	//Test if is possible change the startDate field throw the setStartDate method, with a startDate that happened after the endDate, if possible fails
	@Test
	public void test11() {
		try {
			test.setStartDate(LocalDate.of(2017, 8, 7));
			fail();
		}catch (StartDateAfterEndDateException e2) {
			assertEquals(LocalDate.of(2017, 1, 5),test.getStartDate());
		}
	}
	//Test if is possible change the startDate field throw the setStartDate method, with a startDate that happened before the endDate, if possible success
	@Test
	public void test12() {
		try {
			test.setStartDate(LocalDate.of(2017, 1, 5));
			assertTrue((test.getStartDate().isBefore(test.getEndDate())));
		}catch (StartDateAfterEndDateException e2) {
			fail();
		}
	}
	//Test if is possible change the startDate field throw the setStartDate method, with a startDate that happened in the same day of  the endDate, if possible success
	@Test
	public void test13() {
		try {
			test.setStartDate(LocalDate.of(2017, 2, 5));
			assertEquals(test.getEndDate(),test.getStartDate());
		}catch (StartDateAfterEndDateException e2) {
			fail();
		}
	}
	//Test if is possible change the startDate field throw the setStartDate method, with a startDate that happened in the same day the endDate, if possible success
	@Test
	public void test14() {
		try {
			test.setEndDate(LocalDate.of(2017, 1, 5));
			assertEquals(test.getStartDate(),test.getEndDate());				
		}catch (StartDateAfterEndDateException e2) {
			fail();
		}
	}
}
 