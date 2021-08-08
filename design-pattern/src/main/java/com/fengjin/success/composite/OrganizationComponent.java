package com.fengjin.success.composite;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @author fengjin
 * @Data 2021/8/8
 * @Description 致敬大师，致敬未来的你
 */
@Data
@Slf4j
@AllArgsConstructor
public abstract class OrganizationComponent {
    private String name;
    private String des;

    protected void add(OrganizationComponent organizationComponent) {
        throw new UnsupportedOperationException();
    }

    protected void remove(OrganizationComponent organizationComponent) {
        throw new UnsupportedOperationException();
    }

    protected abstract void print();
}
