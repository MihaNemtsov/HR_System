package models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table (name = "mens")
public class Mens {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "fio")
    private String fio;

    @Column(name = "post_id")
    private int postID;

    @Column(name = "department_id")
    private int departmentID;

    @Column(name = "date_edit")
    private Date dateEdit;

    @Column(name = "role")
    private int role;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id", insertable=false, updatable=false)
    //@JoinColumn(name = "post_id")
    private Post post;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id", insertable=false, updatable=false)
    private Departments department;

    @OneToOne(mappedBy = "men")
    private Departments departments;



    public Mens() { }

    public Mens(String fio, int postID, int departmentID, int role) {
        this.fio = fio;
        this.postID = postID;
        this.departmentID = departmentID;
        dateEdit = new Date();
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public int getPostID() {
        return postID;
    }

    public void setPostID(int postID) {
        this.postID = postID;
    }

    public int getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(int departmentID) {
        this.departmentID = departmentID;
    }

    public Date getDateEdit() {
        return dateEdit;
    }

    public void setDateEdit(Date dateEdit) {
        this.dateEdit = dateEdit;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
}
