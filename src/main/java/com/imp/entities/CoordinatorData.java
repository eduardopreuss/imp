package com.imp.entities;

import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Coordinators")
@SequenceGenerator(name="SEQ", sequenceName="SEQ_COO", initialValue = 1, allocationSize = 1)
public class CoordinatorData extends UserData{

    public CoordinatorData(){
        super();
    }

}