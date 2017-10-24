package com.imp.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

import org.springframework.beans.factory.annotation.Required;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.imp.converters.LocalDateAttributeConverter;
import com.imp.deserializer.LocalDateDeserializer;
import com.imp.exceptions.DescriptionMustHaveLessThan400CharactersException;
import com.imp.exceptions.StartDateAfterEndDateException;
import com.imp.serializer.LocalDateSerializer;


/**
 * Service for Program class.
 * 
 * @author IT Academy #3
 */
/**
 * @author Felipe_L_Machado
 *
 */
@SequenceGenerator(name = "SEQ", sequenceName = "SEQ_PROGRAM", initialValue = 1, allocationSize = 1)
@Entity
public class Program extends BaseEntity {

	@Column(nullable = false)
	String title;
	@Column(nullable = false)
	String description;
	@Column(nullable = false)
	String ownerBadge;
	@Column(nullable = false)
	@Convert(converter = LocalDateAttributeConverter.class)
	LocalDate startDate;
	@Column(nullable = false)
	@Convert(converter = LocalDateAttributeConverter.class)
	LocalDate endDate;
	@ManyToMany
	List<User> programUsers;

	
	/**
	 * Empty constructor
	 */
	public Program() {
		super();
		this.programUsers = new ArrayList<User>();
	}

	/**
	 * Create an object with all required fields
	 * @param title the Program Title
	 * @param description the Program description
	 * @param ownerBadge the badge of Program's owner
	 * @param startDate the Program's start date
	 * @param endDate the Program's end date
	 * @throws StartDateAfterEndDateException if the end date is earlier than the start date
	 * @throws DescriptionMustHaveLessThan400CharactersException if the description has more than 400 characters
	 */
	public Program(	String title, String description, String ownerBadge, LocalDate startDate, LocalDate endDate) throws StartDateAfterEndDateException, DescriptionMustHaveLessThan400CharactersException {
		super();
		this.title = title;
		this.setDescription(description);
		this.ownerBadge = ownerBadge;
		this.startDate = startDate;
		this.setEndDate(endDate);
		this.programUsers = new ArrayList<User>();
	}

	
	/**
	 * @return the Program's title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * set the Program's title
	 * @param title the new Program's title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the Program's description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Set a new description to the Program
	 * @param description the Program's new description
	 * @throws DescriptionMustHaveLessThan400CharactersException if the description has more than 400 characters
	 */
	public void setDescription(String description) throws DescriptionMustHaveLessThan400CharactersException {
		if(description.length() <= 400) {
			this.description = description;			
		}
		else throw new DescriptionMustHaveLessThan400CharactersException("The desctiption must have less than 400 characters");
	}

	/**
	 * @return the Program's owner badge
	 */
	public String getOwnerBadge() {
		return ownerBadge;
	}

	/**
	 * Set a new owner badge to the Program
	 * @param ownerBadge the new Program's owner badge
	 */
	public void setOwnerBadge(String ownerBadge) {
		this.ownerBadge = ownerBadge;
	}

	/**
	 * @return the Program's start date
	 */
	@JsonSerialize( using = LocalDateSerializer.class)
	public LocalDate getStartDate() {
		return startDate;
	}

	/**
	 * Set a new start date to the program
	 * @param startDate new date of program
	 * @throws StartDateAfterEndDateException if the new start date is after the end date
	 */
	@JsonDeserialize(using = LocalDateDeserializer.class)
	public void setStartDate(LocalDate startDate) throws StartDateAfterEndDateException {
		if(this.endDate != null) {
			if (!startDate.isAfter(this.endDate)) {
				this.startDate = startDate;
			} else {
				throw new StartDateAfterEndDateException("The Start Date Need to be before the End Date");
			}
		}
		else {
			this.startDate = startDate;
		}
	}
	
	/**
	 * @return the Program's end date
	 */
	@JsonSerialize( using = LocalDateSerializer.class)
	public LocalDate getEndDate() {
		return endDate;
	}

	/**
	 * Set a new end date to the program
	 * @param endDate
	 * @throws StartDateAfterEndDateException
	 */
	@JsonDeserialize(using = LocalDateDeserializer.class)
	public void setEndDate(LocalDate endDate) throws StartDateAfterEndDateException {
		if (!this.startDate.isAfter(endDate)) {
			this.endDate = endDate;
		} else {
			throw new StartDateAfterEndDateException("The Start Date Need to be before the End Date");
		}
	}

	/**
	 * @return a list with all user's assigned in this program
	 */
	@JsonIgnore
	public List<User> getProgramUsers() {
		return this.programUsers;
	}

	/**
	 * @param newUser a new user to the program
	 */
	public void addProgramUsers(User newUser) {
		if (!this.programUsers.contains(newUser)) {
			this.programUsers.add(newUser);
		}

	}

	/**
	 * Delete all users from a program
	 */
	public void eraseAllProgramUser() {
		this.programUsers.clear();
	}
}
