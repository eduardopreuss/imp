package com.imp.entities;

import java.time.LocalDate;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.imp.converters.LocalDateAttributeConverter;

@Entity
@SequenceGenerator(name="SEQ", sequenceName="SEQ_USERR", initialValue = 1, allocationSize = 1)
@Table(name ="User Roles")
public class UserRole extends User{
	@Convert(converter = LocalDateAttributeConverter.class)
	private LocalDate startDate;
	@Convert(converter = LocalDateAttributeConverter.class)
	private LocalDate endDate;
	private boolean isActive;
	private SystemRole systemRole;
	
	public UserRole() {super();}
	public UserRole(LocalDate startDate, LocalDate endDate, boolean isActive, SystemRole systemRole) {
		super();
		this.startDate = startDate;
		this.endDate = endDate;
		this.isActive = isActive;
		this.systemRole = systemRole;
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
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public SystemRole getSystemRole() {
		return systemRole;
	}
	public void setSystemRole(SystemRole systemRole) {
		this.systemRole = systemRole;
	}
}
