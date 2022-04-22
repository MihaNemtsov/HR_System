package com.nemez.company.hrsystem.dto;

import java.util.Date;

public class PostDto {
    private Integer id;
    private String title;
    private Date dateEdit;

    public PostDto(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDateEdit() {
        return dateEdit;
    }

    public void setDateEdit(Date dateEdit) {
        this.dateEdit = dateEdit;
    }
}
