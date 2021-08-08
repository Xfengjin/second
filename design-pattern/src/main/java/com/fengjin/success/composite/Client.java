package com.fengjin.success.composite;

/**
 * @author fengjin
 * @Data 2021/8/8
 * @Description 致敬大师，致敬未来的你
 */
public class Client {
    public static void main(String[] args) {
        University university = new University("清华大学", "中国顶级的大学");

        College college = new College("计算机学院", "计算机学院");
        College college1 = new College("信息工程学院", "信息工程学院");


        college.add(new Department("软件工程", "软件工程"));
        college.add(new Department("网络工程", "网络工程"));
        college.add(new Department("计算机科学与技术", "计算机科学与技术"));

        college1.add(new Department("通信工程", "通信工程"));
        college1.add(new Department("信息工程", "信息工程"));

        university.add(college);
        university.add(college1);

        university.print();
        System.out.println("====================================================");
        college.print();
    }
}
