package com.imp.entities;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.Assert.*;
import com.imp.exceptions.StartDateAfterEndDateException;

/*
public class ProgramTest {

	@Test
	public void test() {
		try {
			Program test = new Program("Title","This is a test", "ownerBadge", LocalDate.of(2017,1,5), LocalDate.of(2017, 2, 5));
			assertEquals("Title",test.getTitle());
		}catch (StartDateAfterEndDateException e) {
			fail();
		}
	}


	@Test
	public void test2() {
		try {
			Program test = new Program("Title","This is a test", "ownerBadge", LocalDate.of(2017,1,5), LocalDate.of(2017, 2, 5));
			assertEquals("This is a test",test.getDescription());
		}catch (StartDateAfterEndDateException e) {
			fail();
		}
	}
	@Test
	public void test3() {
		try {
			Program test = new Program("Title","This is a test", "ownerBadge", LocalDate.of(2017,1,5), LocalDate.of(2017, 2, 5));
			assertEquals("ownerBadge",test.getOwnerBadge());
		}catch (StartDateAfterEndDateException e) {
			fail();
		}
	}
	@Test
	public void test4() {
		try {
			Program test = new Program("Title","This is a test", "ownerBadge", LocalDate.of(2017,1,5), LocalDate.of(2017, 2, 5));
			assertEquals(LocalDate.of(2017, 1, 5),test.getStartDate());
		}catch (StartDateAfterEndDateException e) {
			fail();
		}
	}
	@Test
	public void test5() {
		try {
			Program test = new Program("Title","This is a test", "ownerBadge", LocalDate.of(2017,1,5), LocalDate.of(2017, 2, 5));
			assertEquals(LocalDate.of(2017, 2, 5),test.getEndDate());
		}catch (StartDateAfterEndDateException e) {
			fail();
		}
	}
	@Test
	public void test6() {
		try {
			Program test = new Program("Title","This is a test", "ownerBadge", LocalDate.of(2017,1,5), LocalDate.of(2017, 2, 5));
			test.setTitle("New Title");
			assertEquals("New Title",test.getTitle());
		}catch (StartDateAfterEndDateException e) {
			fail();
		}
	}
	@Test
	public void test7() {
		try {
			Program test = new Program("Title","This is a test", "ownerBadge", LocalDate.of(2017,1,5), LocalDate.of(2017, 2, 5));
			test.setDescription("New Description");
			assertEquals("New Description",test.getDescription());
		}catch (StartDateAfterEndDateException e) {
			fail();
		}
	}
	
	@Test
	public void test8() {
		try {
			Program test = new Program("Title","This is a test", "ownerBadge", LocalDate.of(2017,1,5), LocalDate.of(2017, 2, 5));
			test.setOwnerBadge("New Owner");
			assertEquals("New Owner",test.getOwnerBadge());
		}catch (StartDateAfterEndDateException e) {
			fail();
		}
	}
	
	@Test
	public void test9() {
		try {
			Program test = new Program("Title","This is a test", "ownerBadge", LocalDate.of(2017,1,5), LocalDate.of(2017, 2, 5));
			try {
				test.setEndDate(LocalDate.of(2, 8, 6));
				fail();
			}catch (StartDateAfterEndDateException e2) {
				fail();
			}
		}catch (StartDateAfterEndDateException e) {
			fail();
		}
	}
	
	
			
			try {
				//Test if is possible set a End Date that happened before the Start Date
				test.setEndDate(LocalDate.of(2, 8, 6));
				//Fails if do
				fail();
			}catch (StartDateAfterEndDateException e) {
				//Assert the end date didn't change with the last set
				assertEquals(LocalDate.of(2017, 2, 5),test.getEndDate());
				//Test if is possible set a End Date that happen after the Start Date
				test.setEndDate(LocalDate.of(2017, 8, 6));
				assertEquals(LocalDate.of(2017, 8, 6),test.getEndDate());
				//Test if is possible set a Start Date that happen after the End Date
				try {
					test.setStartDate(LocalDate.of(2017, 8, 7));
					fail();
				}catch (StartDateAfterEndDateException e1) {
					assertEquals(LocalDate.of(2017, 1, 5),test.getStartDate());
					//Test if the Start Date can be set to Before the End Date
					test.setStartDate(LocalDate.of(2017, 8, 5));
					assertEquals(LocalDate.of(2017, 8, 5),test.getStartDate());
				}
			}
			
		
		} catch (StartDateAfterEndDateException e2) {
			fail();
		}
	}
}
 */
