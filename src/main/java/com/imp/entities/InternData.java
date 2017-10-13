package com.imp.entities;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Interns")
@SequenceGenerator(name="SEQ", sequenceName="SEQ_INT", initialValue = 1, allocationSize = 1)
public class InternData extends BaseEntity{

    private String document;
    private BigDecimal salary;
    private String phone;
    private String university;
    private String major;
    private LocalDate expectedGraduationDate;
    private LocalDate effectiveGraduationDate;
    private LocalDate expectedAdmission;
    private LocalDate effectiveAdmission;

    public InternData(){
        super();
    }
    public InternData(String document, BigDecimal salary, String phone, String university, String major, LocalDate expectedGraduationDate, LocalDate effectiveGraduationDate, LocalDate expectedAdmission, LocalDate effectiveAdmission){
        super();
        this.document = document;
        this.salary = salary;
        this.phone = phone;
        this.university = university;
        this.major = major;
        this.expectedGraduationDate = expectedGraduationDate;
        this.effectiveGraduationDate = effectiveGraduationDate;
        this.expectedAdmission = expectedAdmission;
        this.effectiveAdmission = effectiveAdmission;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public LocalDate getExpectedGraduationDate() {
        return expectedGraduationDate;
    }

    public void setExpectedGraduationDate(LocalDate expectedGraduationDate) {
        this.expectedGraduationDate = expectedGraduationDate;
    }

    public LocalDate getEffectiveGraduationDate() {
        return effectiveGraduationDate;
    }

    public void setEffectiveGraduationDate(LocalDate effectiveGraduationDate) {
        this.effectiveGraduationDate = effectiveGraduationDate;
    }

    public LocalDate getExpectedAdmission() {
        return expectedAdmission;
    }

    public void setExpectedAdmission(LocalDate expectedAdmission) {
        this.expectedAdmission = expectedAdmission;
    }

    public LocalDate getEffectiveAdmission() {
        return effectiveAdmission;
    }

    public void setEffectiveAdmission(LocalDate effectiveAdmission) {
        this.effectiveAdmission = effectiveAdmission;
    }
}