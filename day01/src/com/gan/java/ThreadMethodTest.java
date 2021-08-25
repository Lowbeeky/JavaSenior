package com.gan.java;

/**
 * 测试Thread中的常用方法：
 * 1.start():启动当前线程，调用当前线程的run()
 * 2.run():通常需要重写Thread类的此方法，将创建的线程要执行的操作声明在此方法中
 * 3.currentThread()：静态方法，返回执行当前代码的线程
 * 4.getName()：获取当前线程的名字
 * 5.setName()：设置当前线程的名字
 * 6.yield()：释放当前cpu的执行权
 * 7.join()：在线程a中调用线程b的join()，此时线程a就进入阻塞状态，直到线程b完全执行以后，线程a
 *           才结束阻塞状态。
 * 8.stop()：已过时。当执行此方法时，强制结束当前线程。
 * 9.sleep(long millis)：让当前线程“睡眠”指定的millisecond毫秒。在指定的millisecond毫秒内，
 *                       当前线程是阻塞状态。
 * 10.isAlive()：判断当前线程是
 *
 * 线程的优先级：
 * 1.
 * MIN_PRIORITY=1
 * NORM_PRIORITY=5 -->默认优先级
 * MAX_PRIORITY=10
 * 2.如何获取和设置当前线程的优先级：
 *  getPriority():获取当前线程优先级
 *  setPriority(int p):设置当前线程的优先级
 *  说明：高优先级的线程要抢占低优先级线程cpu的执行权。但只是从概率上，高优先级的线程高概率的情况下被执行
 *       并不意味着只有当高优先级的线程执行完以后，低优先级的线程才执行。
 *
 */
public class ThreadMethodTest {
    public static void main(String[] args) {
        HelloThread h1 = new HelloThread("Thread 1");
        //h1.setName("线程一");
        //设置分线程的优先级
        h1.setPriority(Thread.MAX_PRIORITY);
        h1.start();

        //给主线程命名
        Thread.currentThread().setName("主线程");
        Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
        for (int i = 0; i < 100; i++) {
            if (i % 2 != 0) {
                System.out.println(Thread.currentThread().getName() + ":" +Thread.currentThread().getPriority()+":"+i);
            }

//            if(i==21){
//                try {
//                    h1.join();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
        }
        System.out.println(h1.isAlive());
    }
}

class HelloThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                /*
                因为Thread类的run()没有throws，子类重写方法不能抛出比父类大的异常对象，
                所以此处只能try-catch
                 */
//                try {
//                    sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                System.out.println(Thread.currentThread().getName() + ":" +Thread.currentThread().getPriority()+":"+i);
            }
//            if (i%20==0){
//                this.yield();
//            }
        }
    }
    public HelloThread(String name) {
        super(name);
    }
}
