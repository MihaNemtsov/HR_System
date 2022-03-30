package Models;

import java.util.Date;

public class Departmens {
    private int id;
    private String name;
    private int parentID;
    private int menID;
    private Date dateEdit;

    public Departmens() {}

    public Departmens(String name, int parentID, int menID) {
        this.name = name;
        this.parentID = parentID;
        this.menID = menID;
        dateEdit = new Date();
    }

    public int getId() {return id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getParentID() { return parentID; }
    public void setParentID(int parentID) { this.parentID = parentID; }

    public int getMenID() { return menID; }
    public void setMenID(int menID) { this.menID = menID; }

    public Date getDateEdit() { return dateEdit; }
    public void setDateEdit(Date dateEdit) { this.dateEdit = dateEdit; }
}
