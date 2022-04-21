package com.nemez.company.hrsystem.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "date_edit")
    private Date dateEdit;

    @OneToMany(mappedBy = "post")
    private List<Mens> men;

    public Post() {
    }

    public Post(String title) {
        this.id = id;
        this.title = title;
        this.dateEdit = new Date();
        men = new ArrayList<Mens>();
    }

    public int getId() {
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
