package interfaces;

import models.Departments;

public interface IDepartmentDao {
    public Departments findById(int id);

    public void save(Departments department);

    public void update(Departments department);

    public void delete(Departments department);
}
