import junit.framework.TestCase;
import models.Departments;

public class Test extends TestCase {
    private DepartmentService dp = new DepartmentService();

    public void testFindDepartment() {
        assertEquals(null, dp.findDepartment(12));
    }

    public void testFindMen() {
        assertEquals(null, new MenService().findMen(13));
    }

    //Заведомо ложный тест
    public void testFindPost() {
        assertEquals(null, new PostService().findPost(1));
    }

    public void testDepartmentSave() {
        Departments departments = new Departments("Univer",2,1);
        assertEquals(0,new DepartmentService().saveDepartment(departments));
    }

    public void testDepartmentDelete() {
        Departments departments = new DepartmentService().findDepartment(7);
        assertEquals(0,new DepartmentService().deleteDepartment(departments));
    }

}
