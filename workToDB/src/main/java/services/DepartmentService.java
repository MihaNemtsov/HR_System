package services;

import implementations.DepartmentDaoImpl;
import models.Departments;
import send.MailService;

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
            new MailService().sendMail("hatulmadan144@gmail.com","Save department");
            return 0;
        }
    }

    public int deleteDepartment(Departments department) {
        if(department == null) {
            return 1;
        }
        else {
            departmentDao.delete(department);
            new MailService().sendMail("hatulmadan144@gmail.com","Delete department with id = " + department.getId());
            return 0;
        }

    }

    public int updateDepartment(Departments department) {
        if(department == null) {
            return 1;
        }
        else {
            departmentDao.update(department);
            new MailService().sendMail("hatulmadan144@gmail.com","Update department with id = " + department.getId());
            return 0;
        }
    }
}
