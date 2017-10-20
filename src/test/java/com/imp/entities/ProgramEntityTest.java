package com.imp.entities;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.imp.enums.EmploymentStatus;
import com.imp.exceptions.StartDateAfterEndDateException;

public class ProgramEntityTest {
	private Program test;
	private User newUser;
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();

	public ProgramEntityTest(){
		ArrayList<UserRole> roleList = new ArrayList<>();
		ArrayList<UserData> dataList = new ArrayList<>();
		roleList.add(new UserRole());
		dataList.add(new AdministratorData());
		newUser = new User("1152","Abc123","felipe","xyz@hotmail.com",LocalDate.now(),"Brazil","RS","assa","Te","Brazil","RS","Te","Brazil","RS","Te",EmploymentStatus.Regular,true,roleList,dataList);
	}
	@Before
	public void setUp() throws StartDateAfterEndDateException {
		test = new Program("Title","This is a test", "ownerBadge", LocalDate.of(2017,1,5), LocalDate.of(2017, 11, 5));
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
		assertEquals( LocalDate.of(2017, 11, 5) , test.getEndDate());
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
	public void test9() throws StartDateAfterEndDateException{
		thrown.expect(StartDateAfterEndDateException.class);
		test.setEndDate(LocalDate.of(2017, 1, 1));
	}
	
	//Test if is possible change the endDate field throw the setEndDate method, with a endDate that happened after the starDate, if possible success
	@Test
	public void test10() throws StartDateAfterEndDateException {
			test.setEndDate(LocalDate.of(2017, 8, 6));
			assertTrue((test.getEndDate().isAfter(test.getStartDate())));
	}
	
	//Test if is possible change the startDate field throw the setStartDate method, with a startDate that happened after the endDate, if possible fails	
	@Test
	public void test11() throws StartDateAfterEndDateException{
		test.setEndDate(LocalDate.of(2017,3,9));
		thrown.expect(StartDateAfterEndDateException.class);
		test.setStartDate(LocalDate.of(2017, 3, 10));
	}
	
	//Test if is possible change the startDate field throw the setStartDate method, with a startDate that happened before the endDate, if possible success
	@Test
	public void test12() throws StartDateAfterEndDateException {
			test.setStartDate(LocalDate.of(2017, 1, 5));
			assertEquals(LocalDate.of(2017,1,5),(test.getStartDate()));
	}
	
	//Test if is possible change the startDate field throw the setStartDate method, with a startDate that happened in the same day of  the endDate, if possible success
	@Test
	public void test13() {
		try {
			test.setStartDate(LocalDate.of(2017, 2, 5));
			assertEquals(test.getStartDate(),LocalDate.of(2017,2,5));
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
	
	@Test 
	public void test15() {
		test.eraseAllProgramUser();
		test.addProgramUsers(newUser);
		List<User> x = new ArrayList<User>();
		x.add(newUser);
		assertEquals(x,test.getProgramUsers());
	}
	
	@Test 
	public void test16() {
		test.eraseAllProgramUser();
		test.addProgramUsers(newUser);
		List<User> x = new ArrayList<User>();
		x.add(newUser);
		test.addProgramUsers(newUser);
		assertEquals(x,test.getProgramUsers());
	}
	
	@Test 
	public void test17() {
		test.eraseAllProgramUser();
		List<User> x = new ArrayList<User>();
		assertEquals(x,test.getProgramUsers());
	}

}
