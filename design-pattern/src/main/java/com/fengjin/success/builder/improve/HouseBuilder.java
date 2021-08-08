package com.fengjin.success.builder.improve;

/**
 * @author: Arno.Feng
 * @date: 2021/7/29
 * @description:抽象建造者
 */
public abstract class HouseBuilder {

    protected House house = new House();

    /**
     * 打地基
     */
    public abstract void buildBasic();

    /**
     * 砌墙
     */
    public abstract void buildWall();

    /**
     * 封顶
     */
    public abstract void roofed();

    /**
     * 建造房子
     * @return
     */
    public House buildHouse() {
        return house;
    }
}
