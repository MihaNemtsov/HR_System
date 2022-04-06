package services;

import implementations.DepartmentDaoImpl;
import models.Departments;


public class DepartmentService {
    private DepartmentDaoImpl departmentDao = new DepartmentDaoImpl();

    public Departments findDepartment(int id) {
        Departments departments = departmentDao.findById(id);
        if( departments != null) {
            return departments;
        }else {
            return null;
        }

    }

    public int saveDepartment(Departments department) {
        if(department == null) {
            return 1;
        }
        else {
            departmentDao.save(department);
            return 0;
        }
    }

    public int deleteDepartment(Departments department) {
        if(department == null) {
            return 1;
        }
        else {
            departmentDao.delete(department);
            return 0;
        }

    }

    public int updateDepartment(Departments department) {
        if(department == null) {
            return 1;
        }
        else {
            departmentDao.update(department);
            return 0;
        }
    }
}
