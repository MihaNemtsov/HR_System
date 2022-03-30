package Models;

import javafx.geometry.Pos;

import java.util.Date;

public class Post {
    private int id;
    private String title;
    private Date dateEdit;

    public Post() { }

    public Post(int id, String title) {
        this.id = id;
        this.title = title;
        this.dateEdit = new Date();
    }

    public int getId() {
        return id;
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
