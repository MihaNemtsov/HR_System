package HR_Interface;

import Models.Departmens;
import dao.DepartmentDao;

public class DepartmentService {
    private DepartmentDao departmentDao = new DepartmentDao();

    public Departmens findDepartment(int id) {
        return departmentDao.findById(id);
    }

    public void saveDepartment(Departmens departmens) {
        departmentDao.save(departmens);
    }

    public void deleteDepartment(Departmens departmens) {
        departmentDao.delete(departmens);
    }

    public void updateDepartment(Departmens departmens) {
        departmentDao.update(departmens);
    }
}
