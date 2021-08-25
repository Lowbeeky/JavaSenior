package com.gan.java1;

/**
 * 使用同步机制将单例模式中的懒汉式改写为线程安全的
 * 面试/笔试中，要求写单例模式，首选写线程安全的
 *
 */
public class BankTest {

}

class Bank {
    private Bank() {

    }

    private static Bank instance = null;

    //使用同步方法的方式
//    public  static synchronized Bank getInstance(){
//        if(instance==null){
//            instance=new Bank();
//        }
//        return instance;
//    }
    //使用同步代码块
    public static Bank getInstance() {
        //方式一:效率稍差
//        synchronized (Bank.class) {
//            if(instance==null){
//                instance=new Bank();
//            }
//            return instance;
//        }
        //方式二：效率更高
        if (instance == null) {
            synchronized (Bank.class) {
                if (instance == null) {
                    instance = new Bank();
                }
            }
        }
        return instance;
    }
}