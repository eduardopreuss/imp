package com.imp.controllers;

import static org.junit.Assert.*;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.imp.application.ImpApplication;
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ImpApplication.class)
@Transactional
public class ProgramControllerTest {

	@Test
	public void testCreateProgram() {
		
	}

	@Test
	public void testProgramView() {
		fail("Not yet implemented");
	}

	@Test
	public void testListPrograms() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteProgram() {
		fail("Not yet implemented");
	}

}
