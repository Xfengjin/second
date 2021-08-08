package com.fengjin.success.principle.liskov;

/**
 * @author fengjin
 * @Data 2021/6/28
 * @Description 致敬大师，致敬未来的你
 *
 * 里氏替换原则  -- 改进
 */
class Liskov1 {

    public static void main(String[] args) {
        A1 a = new A1();
        System.out.println("11-3=" + a.fun1(11, 3));
        System.out.println("1-8=" + a.fun1(1, 8));

        System.out.println("--------------------");

        B1 b = new B1();
        System.out.println("11-3=" + b.fun1(11, 3));
        System.out.println("1-8=" + b.fun1(1, 8));
        System.out.println("11+3+9=" + b.fun2(11, 3));
    }
}

// 创建更加基础的类
class Base {
    public int fun1(int num1, int num2) {
        return num1 - num2;
    }
}

class A1 extends Base {
    public int fun1(int num1, int num2) {
        return num1 - num2;
    }
}

class B1 extends Base{
    @Override
    public int fun1(int num1, int num2) {
        return num1 + num2;
    }

    public int fun2(int a, int b) {
        return fun1(a, b) + 9;
    }
}
