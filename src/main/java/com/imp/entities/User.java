package com.imp.entities;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.ManyToAny;
import org.hibernate.validator.constraints.Email;

import com.imp.converters.LocalDateAttributeConverter;
import com.imp.enums.EmploymentStatus;

@Entity
@SequenceGenerator(name="SEQ", sequenceName="SEQ_USER", initialValue = 1, allocationSize = 1)
@Table(name ="Users")
public class User extends BaseEntity{
	
	@Size (min=7)
    private String badge;
    @Size (min=8, max=13)
	private String password;   
	@NotNull
    @Size (min=6, max=50)
    private String name;
    @NotNull
    @Email
	private String email;
    @NotNull
	@Convert(converter = LocalDateAttributeConverter.class)
	private LocalDate birthDate;
    @NotNull
    @Size (min=4, max=50)
	private String country;
    @NotNull
    @Size (min=4, max=50)
	private String state;
    @NotNull
    @Size (min=4, max=50)
	private String city;
    @NotNull
    @Size (min=4, max=100)
	private String address;
	private String addressNumber;
    @NotNull
    @Size (min=8, max=15)
	private String phone;
    @Size (min=4, max=10) 
    private String zipCode;
    @Size (min=7)
	private String managerBadge;
    @Size (min=6)
	private String managerName; 
	private String costCenter;
	@Enumerated(EnumType.STRING)
	private EmploymentStatus employmentStatus;
	private boolean administrator;
	
	private ArrayList<UserRole> userRole;
	
	private ArrayList<UserData> userData;
	
	public User() {
		super();
	}

	public User(String badge, String password, String name, String email, LocalDate birthDate, String country,
			String state, String city, String address, String addressNumber, String phone, String zipCode,
			String managerBadge, String managerName, String costCenter, EmploymentStatus employmentStatus,
			boolean administrator, ArrayList<UserRole> userRole, ArrayList<UserData> userData) {
		super();
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
		this.userData = userData;
	}



	public List<UserRole> getUserRole() {
		return userRole;
	}



	public void setUserRole(ArrayList<UserRole> userRole) {
		this.userRole = userRole;
	}



	public List<UserData> getUserData() {
		return userData;
	}



	public void setUserData(ArrayList<UserData> userData) {
		this.userData = userData;
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

	public String getCostCenter() {
		return costCenter;
	}

	public void setCostCenter(String costCenter) {
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


	
	
}