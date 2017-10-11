package com.imp.entities;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Assert.*;
import com.imp.exceptions.StartDateAfterEndDateException;

public class ProgramTest {

	@Before
	public void before() {
		try {
			Program test = new Program("Title","This is a test", "ownerBadge", LocalDate.of(2017,1,5), LocalDate.of(2017, 2, 5));
		} catch (StartDateAfterEndDateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


	@Test
	public void test() {
		try {
			Program test = new Program("Title","This is a test", "ownerBadge", LocalDate.of(2017,1,5), LocalDate.of(2017, 2, 5));

			assertEquals("Title",test.getTitle());
			assertEquals("This is a test",test.getDescription());
			assertEquals("ownerBadge",test.getOwnerBadge());
			assertEquals(LocalDate.of(2017, 1, 5),test.getStartDate());
			assertEquals(LocalDate.of(2017, 2, 5),test.getEndDate());
			
			test.setTitle("New Title");
			assertEquals("New Title",test.getTitle());
			
			test.setDescription("New Description");
			assertEquals("New Description",test.getDescription());
			
			test.setOwnerBadge("New Owner");
			assertEquals("New Owner",test.getOwnerBadge());
			
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
