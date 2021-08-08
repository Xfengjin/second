package com.fengjin.success.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fengjin
 * @Data 2021/8/8
 * @Description 致敬大师，致敬未来的你
 */
public class University extends OrganizationComponent {

    List<OrganizationComponent> organizationComponents = new ArrayList<>();

    public University(String name, String des) {
        super(name, des);
    }

    @Override
    protected void add(OrganizationComponent organizationComponent) {
        organizationComponents.add(organizationComponent);
    }

    @Override
    protected void remove(OrganizationComponent organizationComponent) {
        organizationComponents.remove(organizationComponent);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public String getDes() {
        return super.getDes();
    }

    /**
     * 输出university里面的college
     */
    @Override
    protected void print() {
        System.out.println("---------------------" + getName() + "----------------------");
        organizationComponents.forEach(item -> {
            item.print();
        });
    }
}
