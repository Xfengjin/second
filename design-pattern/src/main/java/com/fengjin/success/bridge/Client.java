package com.fengjin.success.bridge;

/**
 * @author fengjin
 * @Data 2021/8/4
 * @Description 致敬大师，致敬未来的你
 */
public class Client {

    public static void main(String[] args) {
        FoldedPhone foldedPhone = new FoldedPhone(new XiaoMI());

        foldedPhone.open();
        foldedPhone.call();
        foldedPhone.close();

        FoldedPhone foldedPhone1 = new FoldedPhone(new Vivo());

        foldedPhone1.open();
        foldedPhone1.call();
        foldedPhone1.close();


        UpRightPhone upRightPhone = new UpRightPhone(new XiaoMI());
        upRightPhone.open();
        upRightPhone.close();
        upRightPhone.call();
    }
}
