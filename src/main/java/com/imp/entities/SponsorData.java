package com.imp.entities;

import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Sponsors")
@SequenceGenerator(name="SEQ", sequenceName="SEQ_SPO", initialValue = 1, allocationSize = 1)
public class SponsorData extends UserData{

    public SponsorData(){
        super();
    }

}