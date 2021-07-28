package com.fengjin.success.prototype.clone;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * @author: Arno.Feng
 * @date: 2021/7/28
 * @description:浅拷贝
 */
@Data
@AllArgsConstructor
@ToString
public class Sheep implements Cloneable {
    private String name;
    private int age;
    private String color;
    private Sheep friend;

    /**
     * 克隆该实例，使用默认的clone方法来完成
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
    protected Object clone() {
        Sheep sheep = null;
        try {
            sheep = (Sheep) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return sheep;
    }
}
