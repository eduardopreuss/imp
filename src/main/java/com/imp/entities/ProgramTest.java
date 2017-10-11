package com.imp.entities;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.imp.exceptions.CreateDateAfterEndDateException;

public class ProgramTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		try {
			Program test = new Program("Title","This is a test", "ownerBadge", LocalDate.of(2017,1,5), LocalDate.of(2017, 2, 5));
			///assertEquals()
		
		} catch (CreateDateAfterEndDateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
