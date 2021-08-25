package com.gan.java;

/**
 * 格式化代码快捷键：Ctrl+Alt+L
 * 存在线程的安全问题，待解决-->同步代码块解决
 * 例子：创建三个窗口买票，总票数为100张
 *
 * 说明：在继承Thread类创建多线程的方式中，慎用this充当同步监视器
 *      考虑使用当前类充当同步监视器
 */
public class WindowTest2 {
    public static void main(String[] args) {
        Window2 t1 = new Window2();
        Window2 t2 = new Window2();
        Window2 t3 = new Window2();

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}

class Window2 extends Thread {
    private static int ticket = 100;
    private static Object obj = new Object();
    @Override
    public void run() {
        while (true) {
            //错误的方式：
            //synchronized (this) { //this:t1,t2,t3
            //正确的方式：
            //Window2.class 是对象且只加载一次，唯一（反射的知识）
            synchronized (Window2.class) { //Class clazz = Window2.class(其中变量不能使用class)
            //synchronized (obj) {
                if (ticket > 0) {
                    try {
                        sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(getName() + ": 卖票，票号为：" + ticket);
                    ticket--;
                } else {
                    break;
                }
            }
        }
    }
}
