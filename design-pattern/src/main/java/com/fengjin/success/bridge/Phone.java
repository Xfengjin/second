package com.fengjin.success.bridge;

/**
 * @author fengjin
 * @Data 2021/8/4
 * @Description 致敬大师，致敬未来的你
 */
public abstract class Phone {

    // 组合品牌
    private Brand brand;

    public Phone(Brand brand) {
        this.brand = brand;
    }

    protected void open() {
        this.brand.open();
    }

    protected void close() {
        this.brand.close();
    }

    protected void call() {
        this.brand.call();
    }
}
