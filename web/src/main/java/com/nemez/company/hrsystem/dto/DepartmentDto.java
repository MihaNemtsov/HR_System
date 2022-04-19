package com.nemez.company.hrsystem.dto;

import java.util.Date;

public class DepartmentDto {
    private Integer id;
    private String name;
    private Integer parentID;
    private Integer menID;
    private Date dateEdit;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getParentID() {
        return parentID;
    }

    public void setParentID(Integer parentID) {
        this.parentID = parentID;
    }

    public Integer getMenID() {
        return menID;
    }

    public void setMenID(Integer menID) {
        this.menID = menID;
    }

    public Date getDateEdit() {
        return dateEdit;
    }

    public void setDateEdit(Date dateEdit) {
        this.dateEdit = dateEdit;
    }
}
