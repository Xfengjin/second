package com.fengjin.success.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author: Arno.Feng
 * @date: 2021/7/6
 * @description:
 */
@Data
@AllArgsConstructor
public class Order {
    private Integer orderId;
    private int code;
    private int num;
    private Double price;
}
