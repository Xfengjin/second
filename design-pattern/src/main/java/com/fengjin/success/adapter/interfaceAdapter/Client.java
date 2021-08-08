package com.fengjin.success.adapter.interfaceAdapter;

import lombok.extern.slf4j.Slf4j;

/**
 * @author fengjin
 * @Data 2021/8/3
 * @Description 致敬大师，致敬未来的你
 */
@Slf4j
public class Client {
    public static void main(String[] args) {
        AbsAdapter adapter = new AbsAdapter(){
            @Override
            public void m1() {
                log.info("m1");
            }
        };
        adapter.m1();
    }
}
