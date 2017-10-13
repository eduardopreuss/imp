package com.imp.entities;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Digits;

import com.imp.converters.LocalDateAttributeConverter;
import com.imp.enums.EmploymentStatus;

@Entity
@SequenceGenerator(name="SEQ", sequenceName="SEQ_USER", initialValue = 1, allocationSize = 1)
@Table(name ="Users")
public class User extends BaseEntity{
	
	private String badge;
	private String password;
	private String name;
	private String email;
	@Convert(converter = LocalDateAttributeConverter.class)
	private LocalDate birthDate;
	private String country;
	private String state;
	private String city;
	private String address;
	private String addressNumber;
	private String phone;
	private String zipCode;
	private String managerBadge;
	private String managerName;
	private BigDecimal costCenter;
	@Enumerated(EnumType.STRING)
	private EmploymentStatus employmentStatus;
	private boolean administrator;
	private UserRole userRole;
	
	public User() {
	}

	public User(String badge, String password, String name, String email, LocalDate birthDate, String country, String state, String city, String address, String addressNumber, String phone, String zipCode, String managerBadge, String managerName, BigDecimal costCenter, EmploymentStatus employmentStatus, boolean administrator, UserRole userRole) {
		this.badge = badge;
		this.password = password;
		this.name = name;
		this.email = email;
		this.birthDate = birthDate;
		this.country = country;
		this.state = state;
		this.city = city;
		this.address = address;
		this.addressNumber = addressNumber;
		this.phone = phone;
		this.zipCode = zipCode;
		this.managerBadge = managerBadge;
		this.managerName = managerName;
		this.costCenter = costCenter;
		this.employmentStatus = employmentStatus;
		this.administrator = administrator;
		this.userRole = userRole;
	}

	public void setRole(String role) {
		getUserRole().getSystemRole().setName(role);
	}
	
	public String getBadge() {
		return badge;
	}

	public void setBadge(String badge) {
		this.badge = badge;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddressNumber() {
		return addressNumber;
	}

	public void setAddressNumber(String addressNumber) {
		this.addressNumber = addressNumber;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getManagerBadge() {
		return managerBadge;
	}

	public void setManagerBadge(String managerBadge) {
		this.managerBadge = managerBadge;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public BigDecimal getCostCenter() {
		return costCenter;
	}

	public void setCostCenter(BigDecimal costCenter) {
		this.costCenter = costCenter;
	}

	public EmploymentStatus getEmploymentStatus() {
		return employmentStatus;
	}

	public void setEmploymentStatus(EmploymentStatus employmentStatus) {
		this.employmentStatus = employmentStatus;
	}

	public boolean isAdministrator() {
		return administrator;
	}

	public void setAdministrator(boolean administrator) {
		this.administrator = administrator;
	}


	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public UserRole getUserRole() {
		return userRole;
	}

	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}
	
	
}