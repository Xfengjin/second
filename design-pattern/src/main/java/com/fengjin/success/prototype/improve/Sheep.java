package com.fengjin.success.prototype.improve;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * @author fengjin
 * @Data 2021/7/27
 * @Description 致敬大师，致敬未来的你
 */
@Data
@AllArgsConstructor
@ToString
public class Sheep implements Cloneable{
    private String name;
    private int age;
    private String color;

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
