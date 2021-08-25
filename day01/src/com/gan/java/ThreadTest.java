package com.gan.java;

/**
 * 多线程的创建，方式一，继承于Thread类
 * 1.创建一个继承于Thread类的子类
 * 2.重写Thread类的run()-->将此线程执行的操作声明在run()中
 * 3.创建Thread类的子类的对象
 * 4.通过此对象调用start()
 * <p>
 * 遍历100以内的所有偶数
 */
public class ThreadTest {
    public static void main(String[] args) {
        //快捷键：ctrl+alt+v
        //3.创建Thread类的子类的对象
        MyThread t1 = new MyThread();
        //4.通过此对象调用start():①启动当前线程 ②调用当前线程的run()
        t1.start();
        //问题一：不能直接调用run()方法启动线程
//        t1.run();


        //问题二：再启动一个线程，遍历100以内的偶数
        //不可以让已经start()的线程去执行。会报异常IllegalThreadStateException
        //t1.start();
        //重新创建一个线程对象即可
        MyThread t2 = new MyThread();
        t2.start();

        for (int i = 0; i < 100; i++) {
            if (i % 2 != 0) {
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }
}

//1.创建一个继承于Thread类的子类
class MyThread extends Thread {
    //2.重写Thread类的run()
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }
}
