package com.imp.entities;

import java.time.LocalDate;

import javax.persistence.Id;

import com.imp.exceptions.StartDateAfterEndDateException;

public class Program {
		@Id
		Integer id;
		String title;
		String description;
		String ownerBadge;
		LocalDate startDate;
		LocalDate endDate;
		
	public Program() {
		
	}

	public Program(String title, String description, String ownerBadge, LocalDate startDate, LocalDate endDate) throws StartDateAfterEndDateException {
		super();
		this.title = title;
		this.description = description;
		this.ownerBadge = ownerBadge;
		this.startDate = startDate;
		this.setEndDate(endDate);
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
		throw new StartDateAfterEndDateException();
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
}
