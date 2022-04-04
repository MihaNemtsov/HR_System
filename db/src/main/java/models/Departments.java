package models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table (name = "departments")
public class Departments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "parent_id")
    private int parentID;

    @Column(name = "men_id")
    private int menID;

    @Column(name = "date_edit")
    private Date dateEdit;

    @OneToMany(mappedBy = "department")
    private List<Mens> mens;

    @OneToOne
    @JoinColumn(name = "men_id", insertable=false, updatable=false)
    private Mens men;


    public Departments() {}

    public Departments(String name, int parentID, int menID) {
        this.name = name;
        this.parentID = parentID;
        this.menID = menID;
        dateEdit = new Date();
        mens = new ArrayList<Mens>();
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
