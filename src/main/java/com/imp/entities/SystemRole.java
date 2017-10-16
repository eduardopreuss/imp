package com.imp.entities;

import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@SequenceGenerator(name="SEQ", sequenceName="SEQ_USER", initialValue = 1, allocationSize = 1)
@Table(name ="system_roles")
public class SystemRole extends BaseEntity{
	private String name;
	private String symbol;

	public SystemRole() {super();}
	public SystemRole(String name, String symbol) {
		super();
		this.name = name;
		this.symbol = symbol;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

}
