package com.imp.entities;

import java.time.LocalDate;

import javax.persistence.Id;

import com.imp.exceptions.CreateDateAfterEndDateException;

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

	public Program(String title, String description, String ownerBadge, LocalDate startDate, LocalDate endDate) throws CreateDateAfterEndDateException {
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

	public void setOwner(String ownerBadge) {
		this.ownerBadge = ownerBadge;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) throws CreateDateAfterEndDateException {
		if(!this.startDate.isAfter(endDate)) {
			this.endDate = endDate;			
		}
		else {
			throw new CreateDateAfterEndDateException("The Start Date Need to be before the End Date");
		}
	}
}
