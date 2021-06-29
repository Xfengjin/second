package com.fengjin.success.principle.demeter.improve;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Arno.Feng
 * @date: 2021/6/29
 * @description: 迪米特法则
 */
public class Demeter {
    public static void main(String[] args) {
        SchoolManager schoolManager = new SchoolManager();
        schoolManager.printAllEmployee();

        new CollegeManager().getAllCollegeManageEmployee();
    }
}

@Data
class Employee {
    private String id;
}

@Data
class CollegeEmployee {
    private String id;
}

class CollegeManager {
    public List<CollegeEmployee> getAllEmployee() {
        List<CollegeEmployee> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            CollegeEmployee collegeEmployee = new CollegeEmployee();
            collegeEmployee.setId("学院员工id=" + i);
            list.add(collegeEmployee);
        }
        return list;
    }

    public void getAllCollegeManageEmployee() {
        List<CollegeEmployee> allEmployee = getAllEmployee();
        System.out.println("------------分公司员工------------");
        for (CollegeEmployee e : allEmployee) {
            System.out.println(e.getId());
        }
    }
}

class SchoolManager {
    public List<Employee> getAllEmployee() {
        List<Employee> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Employee employee = new Employee();
            employee.setId("学校总部员工id= " + i);
            list.add(employee);
        }
        return list;
    }

    public void printAllEmployee() {

        List<Employee> list2 = this.getAllEmployee();
        System.out.println("------------学校总部员工------------");
        for (Employee e : list2) {
            System.out.println(e.getId());
        }
    }
}

