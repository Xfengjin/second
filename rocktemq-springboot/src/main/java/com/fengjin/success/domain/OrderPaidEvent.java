package com.fengjin.success.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author: Arno.Feng
 * @date: 2021/5/27
 * @description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderPaidEvent {
    private String orderId;

    private BigDecimal paidMoney;
}
