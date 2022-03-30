package Models;

import java.util.Date;

public class Mens {
    private int id;
    private String fio;
    private int postID;
    private int departmentID;
    private Date dateEdit;
    private int role;

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
