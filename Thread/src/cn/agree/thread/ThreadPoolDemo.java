package cn.agree.thread;

import cn.agree.custthread.MyConcurrentPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolDemo {
    public static void main(String[] args) {
        /*
        *  创建线程池对象
        * */
        ExecutorService service = Executors.newFixedThreadPool(2);
        /*
        *  创建Runnable实例对象
        * */
        MyConcurrentPool r = new MyConcurrentPool();

        // 从线程池中获取线程对象,然后调用r的run方法
        service.submit(r);
        service.submit(r);
        /*
        *  submit方法调用结束后,程序并不终止,是因为线程池
        *  控制了线程的关闭
        *  将使用完的线程又归还到了线程池中
        *
        * */
        service.submit(r);

        service.shutdown();


    }
}
