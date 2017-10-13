package com.imp.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

import com.imp.converters.LocalDateAttributeConverter;
import com.imp.exceptions.StartDateAfterEndDateException;

@SequenceGenerator(name="SEQ", sequenceName="SEQ_PROGRAM", initialValue = 1, allocationSize = 1)
@Entity
public class Program extends BaseEntity {
		String title;
		String description;
		String ownerBadge;
		@Convert(converter = LocalDateAttributeConverter.class)
		LocalDate startDate;
		@Convert(converter = LocalDateAttributeConverter.class)
		LocalDate endDate;
		@ManyToMany
		List<User> programUsers;
	public Program() {
		
	}

	public Program(String title, String description, String ownerBadge, LocalDate startDate, LocalDate endDate) throws StartDateAfterEndDateException {
		super();
		this.title = title;
		this.description = description;
		this.ownerBadge = ownerBadge;
		this.startDate = startDate;
		this.setEndDate(endDate);
		this.programUsers = new ArrayList<User>();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getOwnerBadge() {
		return ownerBadge;
	}

	public void setOwnerBadge(String ownerBadge) {
		this.ownerBadge = ownerBadge;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) throws StartDateAfterEndDateException {
		if(!startDate.isAfter(this.endDate)) {
			this.startDate = startDate;
		}
		else {
			throw new StartDateAfterEndDateException();			
		}
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) throws StartDateAfterEndDateException {
		if(!this.startDate.isAfter(endDate)) {
			this.endDate = endDate;			
		}
		else {
			throw new StartDateAfterEndDateException("The Start Date Need to be before the End Date");
		}
	}

	public List<User> getProgramUsers() {
		return programUsers;
	}

	public void addProgramUsers(User newUser) {
		if(this.programUsers.contains(newUser)) {
			this.programUsers.remove(newUser);
		}
		this.programUsers.add(newUser);
	}
	public void eraseAllProgramUser() {
		this.programUsers.clear();
	}
}
