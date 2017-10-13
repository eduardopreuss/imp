package com.imp.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;


@MappedSuperclass
public class BaseEntity implements Serializable {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="SEQ")
	 @Column(name = "id", updatable = false, nullable = false)
	 private long id;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}




}
