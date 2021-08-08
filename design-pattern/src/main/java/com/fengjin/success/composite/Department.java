package com.fengjin.success.composite;

/**
 * @author fengjin
 * @Data 2021/8/8
 * @Description 致敬大师，致敬未来的你
 */
public class Department extends OrganizationComponent {

    public Department(String name, String des) {
        super(name, des);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public String getDes() {
        return super.getDes();
    }

    @Override
    protected void print() {
        System.out.println(getName());
    }
}
