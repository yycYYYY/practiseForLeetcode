package com.practice.concurrent;

import java.util.Map;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: yyc
 * @Date: 2022/5/31 3:12 下午
 * @Description: TODO:
 */
public class Demo {

    private final AtomicLong exceptTime = new AtomicLong(0L);

    private void test(){
        Map<String, String> skipListMap = new ConcurrentSkipListMap<>();
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        try {
            lock.tryLock(2, TimeUnit.SECONDS);
            condition.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }finally {
            lock.unlock();
        }

    }

    class DemoA extends Thread{
        @Override
        public void run(){
            long time = exceptTime.get() - System.currentTimeMillis();

            if (time <= 0L){
                return;
            }

            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }
    }

    public void test(long time){
        exceptTime.set(System.currentTimeMillis() + time);

        DemoA a = new DemoA();
        DemoA b = new DemoA();
        DemoA c = new DemoA();
        a.start();
        b.start();
        c.start();
    }
}
