package com.fengjin.success.principle.inversion;

/**
 * @author: Arno.Feng
 * @date: 2021/6/9
 * @description: 设计模式 - 依赖倒置原则
 */
public class DependencyInversion {

    public static void main(String[] args) {
        Person person = new Person();
        person.receive(new Email());
    }
}

class Email {
    public String getInfo() {
        return "电子邮件信息：hello world";
    }
}

/**
 * 问题分析：
 *  如果获取的不是邮件，而是微信，短信这样的其他消息，则需要增加新的类，并且person需要追加新的接收方法
 */
class Person {
    public void receive(Email email) {
        System.out.println(email.getInfo());
    }
}
