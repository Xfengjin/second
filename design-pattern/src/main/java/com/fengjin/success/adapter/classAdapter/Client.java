package com.fengjin.success.adapter.classAdapter;

import lombok.extern.slf4j.Slf4j;

/**
 * @author fengjin
 * @Data 2021/8/3
 * @Description 致敬大师，致敬未来的你
 */
@Slf4j
public class Client {

    public static void main(String[] args) {
        log.info("类适配器模式");
        Phone phone = new Phone();
        phone.charging(new VoltageAdapter());
    }
}
