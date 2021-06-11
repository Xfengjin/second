package com.fengjin.success.principle.singleResponsibility;

/**
 * @author: Arno.Feng
 * @date: 2021/6/8
 * @description:
 */
public class SingleResponsibility1 {

    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle();
        vehicle.run("摩托车");
        vehicle.run("汽车");
        vehicle.run("飞机");
    }
}

class Vehicle {
    /**
     * 违反了单一职责原则
     * 根据交通工具的类型的不同分开
     * @param vehicle
     */
    public void run(String vehicle) {
        System.out.println(vehicle + "在公路上运行。。。。。");
    }
}
