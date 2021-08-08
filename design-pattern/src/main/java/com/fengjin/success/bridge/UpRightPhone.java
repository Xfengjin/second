package com.fengjin.success.bridge;

import lombok.extern.slf4j.Slf4j;

/**
 * @author fengjin
 * @Data 2021/8/4
 * @Description 致敬大师，致敬未来的你
 */
@Slf4j
public class UpRightPhone extends Phone {

    public UpRightPhone(Brand brand) {
        super(brand);
    }

    public void open() {
        log.info("直立手机");
        super.open();
    }

    public void close() {
        log.info("直立手机");
        super.close();
    }

    public void call() {
        log.info("直立手机");
        super.call();
    }
}
