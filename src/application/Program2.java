package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

import java.util.List;

public class Program2 {
    public static void main(String[] args){
        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

        System.out.println("=== TEST 1: Department findById ===");
        Department dep = departmentDao.findById(3);
        System.out.println(dep);

        System.out.println("=== TEST 2: Department findAll ===");
        List<Department> listDep= departmentDao.findAll();
        listDep.forEach(System.out::println);

        System.out.println("=== TEST 3: Department insert ===");
        departmentDao.insert(new Department(null,"Sports"));
        System.out.println("Inserted");

        System.out.println("=== TEST 4: Department update ===");
        departmentDao.update(new Department(2,"Politican"));
        System.out.println("Updated");

        System.out.println("=== TEST 5: Department delete ===");
        departmentDao.deleteById(7);
        System.out.println("Deleted");

    }
}
