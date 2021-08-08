package com.fengjin.success.decorator;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author fengjin
 * @Data 2021/8/8
 * @Description 致敬大师，致敬未来的你
 */
public class CoffeeBar {
    public static void main(String[] args) {
        Drink drink = new LongBlack();
        System.out.println("费用1" + drink.cost());
        System.out.println("描述1" + drink.getDes());

        drink = new Milk(drink);
        System.out.println("费用2 加入一份牛奶后" + drink.cost());
        System.out.println("描述2 加入一份牛奶后" + drink.getDes());

        drink = new Cholocate(drink);
        System.out.println("费用2 加入一份巧克力后" + drink.cost());
        System.out.println("描述2 加入一份巧克力后" + drink.getDes());
    }
}
