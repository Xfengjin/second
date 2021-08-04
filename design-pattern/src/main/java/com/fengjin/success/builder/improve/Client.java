package com.fengjin.success.builder.improve;

/**
 * @author: Arno.Feng
 * @date: 2021/7/29
 * @description:
 */
public class Client {
    public static void main(String[] args) {
        CommonHouse commonHouse = new CommonHouse();
        HighBuilding highBuilding = new HighBuilding();

        HouseDirector houseDirector = new HouseDirector(highBuilding);

        House house = houseDirector.constructHouse();
        StringBuilder stringBuilder = new StringBuilder("hello world");
        System.out.println(stringBuilder);
    }
}
