import models.Departments;
import models.Mens;
import services.DepartmentService;
import services.MenService;

public class Main {
    public static void main(String[] args) {

        MenService menService= new MenService();
        Mens mens = menService.findMen(4);

        int x = mens.getDepartmentID();
        Departments departments = new DepartmentService().findDepartment(x);
        System.out.println("ID:" + mens.getId() + "\nFIO: " + mens.getFio() +
                "\nDepartment: " + departments.getName());



    }
}
