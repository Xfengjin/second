package com.fengjin.success.bridge;

import lombok.extern.slf4j.Slf4j;

/**
 * @author fengjin
 * @Data 2021/8/4
 * @Description 致敬大师，致敬未来的你
 */
@Slf4j
public class Vivo implements Brand {
    @Override
    public void open() {
        log.info("Vivo手机开机");
    }

    @Override
    public void close() {
        log.info("Vivo手机关机");
    }

    @Override
    public void call() {
        log.info("Vivo手机打电话");
    }
}
