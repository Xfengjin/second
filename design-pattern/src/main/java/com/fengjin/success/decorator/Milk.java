package com.fengjin.success.decorator;

/**
 * @author fengjin
 * @Data 2021/8/8
 * @Description 致敬大师，致敬未来的你
 */
public class Milk extends Decorator {
    public Milk(Drink obj) {
        super(obj);
        setDes("牛奶");
        setPrice(2.0f);
    }
}
