/**
 * INTERNSHIP MANAGEMENT PROGRAM
 * 
 * @since Oct 16th, 2017
 */
package com.imp.repositories;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import javax.transaction.Transactional;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.imp.application.ImpApplication;
import com.imp.entities.Program;
import com.imp.exceptions.DescriptionMustHaveLessThan400CharactersException;
import com.imp.exceptions.StartDateAfterEndDateException;


/**
 * Unit tests for ProgramRepository interface. Runs in a transaction and
 * rollback after each test.
 * 
 * @author IT Academy #3
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ImpApplication.class)
@Transactional
public class ProgramRepositoryTest {

	@Autowired
	private ProgramRepository programRepository;
	private Program p1;
	private Program p2;
	private Program p3;
	private Program p4;

	/**
	 * Constructs a ProgramRepositoryTest and its programs.
	 * 
	 * @throws StartDateAfterEndDateException
	 * @throws DescriptionMustHaveLessThan400CharactersException 
	 */
	public ProgramRepositoryTest() throws StartDateAfterEndDateException, DescriptionMustHaveLessThan400CharactersException {
		p1 = new Program(	"P1 title", "P1 description", "1111111", LocalDate.of(2014, Month.OCTOBER, 16),
							LocalDate.now());
		p2 = new Program(	"P2 title", "P2 description", "2222222", LocalDate.of(2015, Month.OCTOBER, 16),
							LocalDate.now());
		p3 = new Program(	"P3 title", "P3 description", "3333333", LocalDate.of(2016, Month.OCTOBER, 16),
							LocalDate.now());
		p4 = new Program(	"P4 title", "P4 description", "4444444", LocalDate.of(2017, Month.OCTOBER, 16),
							LocalDate.now());
	}

	/**
	 * Sets up each unit test: saves programs 1-3 into repository.
	 */
	@Before
	public void setUp() {
		Assert.assertEquals(p1, this.programRepository.save(p1));
		Assert.assertEquals(p2, this.programRepository.save(p2));
		Assert.assertEquals(p3, this.programRepository.save(p3));
	}

	/**
	 * Tests if amount of programs in the repository increases and decreases as
	 * programs are added or deleted.
	 */
	@Test
	public void testCount() {
		long initialAmount = this.programRepository.count();

		this.programRepository.save(p4);
		Assert.assertEquals(initialAmount + 1, this.programRepository.count());

		this.programRepository.delete(p1.getId());
		this.programRepository.delete(p2);
		Assert.assertEquals(initialAmount - 1, this.programRepository.count());
	}

	/**
	 * Tests if programs exist in the repository, both already included and new
	 * ones.
	 */
	@Test
	public void testExists() {
		Assert.assertTrue(this.programRepository.exists(p1.getId()));

		this.programRepository.save(p4);
		Assert.assertTrue(this.programRepository.exists(p4.getId()));
	}

	/**
	 * Tests if programs aren't in the repository, including deleting existing ones.
	 */
	@Test
	public void testNotExists() {
		Assert.assertTrue(this.programRepository.exists(p1.getId()));

		this.programRepository.delete(p1);
		Assert.assertFalse(this.programRepository.exists(p1.getId()));
	}

	/**
	 * Tests if programs 1-3 inserted in setUp() method are included in the list of
	 * all programs.
	 */
	@Test
	public void testFindAll() {
		List<Program> allPrograms = this.programRepository.findAll();

		Assert.assertTrue(allPrograms.contains(p1));
		Assert.assertTrue(allPrograms.contains(p2));
		Assert.assertTrue(allPrograms.contains(p3));
		Assert.assertFalse(allPrograms.contains(p4));
	}

	/**
	 * Tests if repository is empty after deleting all programs.
	 */
	@Test
	public void testDeleteAll() {
		Assert.assertNotEquals(0, this.programRepository.count());

		this.programRepository.deleteAll();

		Assert.assertEquals(0, this.programRepository.count());
	}

	/**
	 * Tests if inserted programs are found by their ID and if program 4 is missing.
	 */
	@Test
	public void testFindOne() {
		Assert.assertEquals(p1, this.programRepository.findOne(p1.getId()));
		Assert.assertNotEquals(p2, this.programRepository.findOne(p3.getId()));

		Assert.assertNull(this.programRepository.findOne(p4.getId()));
	}

	/**
	 * Tests if inserted programs are found by their owner's badge and if program 4
	 * is missing.
	 */
	@Test
	public void testFindByOwnerBadge() {
		Assert.assertEquals(p2, this.programRepository.findByOwnerBadge(p2.getOwnerBadge()));
		Assert.assertNotEquals(p3, this.programRepository.findByOwnerBadge(p1.getOwnerBadge()));

		Assert.assertNull(this.programRepository.findByOwnerBadge(p4.getOwnerBadge()));
	}

	/**
	 * Tests if inserted programs are found by their title (ignoring case) and if
	 * program 4 is missing.
	 */
	@Test
	public void testFindByTitleIgnoreCase() {
		Assert.assertEquals(p2, this.programRepository.findByTitleIgnoreCase(p2.getTitle()));
		Assert.assertNotEquals(p3, this.programRepository.findByTitleIgnoreCase(p1.getTitle()));

		Assert.assertNull(this.programRepository.findByTitleIgnoreCase(p4.getTitle()));

		Assert.assertEquals(p1, this.programRepository.findByTitleIgnoreCase(p1.getTitle().toLowerCase()));
		Assert.assertEquals(p1, this.programRepository.findByTitleIgnoreCase(p1.getTitle().toUpperCase()));
	}

}
