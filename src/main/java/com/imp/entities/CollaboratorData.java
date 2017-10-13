package com.imp.entities;

import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Collaborators")
@SequenceGenerator(name="SEQ", sequenceName="SEQ_COL", initialValue = 1, allocationSize = 1)
public class CollaboratorData extends BaseEntity{

    public CollaboratorData(){
        super();
    }

}