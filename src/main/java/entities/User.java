package entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Digits;

@Entity
@Table(name ="Users")
public class User {
	@Id
	@Digits(fraction = 0, integer = 0)
	private String badge;
	private String username;
	private String password;
	private String name;
	private String email;
	private Integer isActive;
	//private String	manager_badge;
	
	public User(String badge, String username, String password, String name, String email, Integer isActive){
		super();
		this.badge = badge;
		this.username = username;
		this.password = password;
		this.name = name;
		this.email = email;
		this.isActive = isActive;
	}
	
	public User() {
		
	}
	
	public String getBadge() {
		return badge;
	}
	
	public void setBadge(String badge){
		this.badge = badge;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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
	public Integer getIsActive() {
		return isActive;
	}
	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}
		
}
