package com.imp.entities;

import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Managers")
@SequenceGenerator(name="SEQ", sequenceName="SEQ_MAN", initialValue = 1, allocationSize = 1)
public class ManagerData extends UserData{

    public ManagerData(){
        super();
    }

}