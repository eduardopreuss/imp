package com.imp.entities;

import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "admnistrators")
@SequenceGenerator(name="SEQ", sequenceName="SEQ_ADM", initialValue = 1, allocationSize = 1)
public class AdministratorData extends BaseEntity{


    public AdministratorData(){
        super();
    }

    public boolean addRole(User user, String role){

        user.setRole(role);
        if(user.getUserRole().getSystemRole().getName().equals(role)){
            return true;
        }
        else{
            return false;
        }
    }

}