1. 当运行一个应用程序的时候，就启动了一个进程.
2. 多线程的目的是为了最大限度的利用CPU资源.
3. 实际上，操作系统的多进程实现了多任务并发执行，程序的多线程实现了进程的并发执行。
4. 在Java中，多线程的实现有两种方式：扩展java.lang.Thread类 & 实现java.lang.Runnable接口

// 通过扩展Thread类实现多线程

public class TestMultiThread {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + " 线程运行开始!");
        new MultiSay("A").start();
        new MultiSay("B").start();
        System.out.println(Thread.currentThread().getName() + " 线程运行结束!");
    }
}

class MultiSay extends Thread {
    public MultiSay(String threadName) {
        super(threadName);
    }

    // @override
    public void run() {
        System.out.println(getName() + " 线程运行开始!");
        for (int i = 0; i < 10; i++) {
            System.out.println(i + " " + getName());
            try {
                sleep((int) Math.random() * 10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(getName() + " 线程运行结束!");
    }
}

// 通过实现 Runnable 接口实现多线程
public class TestMultiThread implements Runnable {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + " 线程运行开始!");
        TestMultiThread test = new TestMultiThread();
        Thread A = new Thread(test);
        Thread B = new Thread(test);
        A.start();
        B.start();
        System.out.println(Thread.currentThread().getName() + " 线程运行结束!");
    }

    public void run() {
        System.out.println(Thread.currentThread().getName() + " 线程运行开始!");
        for (int i = 0; i < 5; i++) {
            System.out.println(i + " " + Thread.currentThread().getName());
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + " 线程运行结束!");
    }
}

//Ref:
//http://lavasoft.blog.51cto.com/62575/27069

// extend Thread class
class MyThread extends Thread{
    public void run(){
        System.out.println("this is my thread");
    }
}

MyThread myThread = new MyThread();
myThread.start();

// implement Runnable interface
class MyRunnable implements Runnable{
    public void run(){
        System.out.println("this is the other thread create method");
    }
}

Thread myThread = new Thread(new MyRunnable());
myThread.start();


// should be usually used. 
class MainActivity{
    public static void main(String[] args){
        
        MyThreadA t1 = new MyThreadA("t1");
        t1.start();

        MyThreadB t2 = new MyThreadB("t2");
        t2.start();

    }
}

class MyThreadA extends Thread{
    public MyThreadA(String threadName){
        super(threadName);
    }

    public void run(){
        for(int i = 0; i < 15; i++){
            System.out.println("A " + "--> " + i + " --->" + getName());
        }
    }
}

// while ThreadB do not do the same thing with Thread A; we should recreate another Thread.run().
class MyThreadB extends Thread{
    public MyThreadB(String threadName){
        super(threadName);
    }

    public void run(){
        for(int i = 0; i < 15; i++){
            System.out.println("B " + "--> " + (i+100) + " --->" + getName());
        }
    }
}
