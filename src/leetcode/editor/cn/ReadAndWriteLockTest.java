package leetcode.editor.cn;

import java.util.Random;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadAndWriteLockTest {
    public static ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    public static int COUNT = 1;

    public static void main(String[] args) {
        //同时读、写
        Runnable read = () -> {
            ReentrantReadWriteLock.ReadLock readLock = lock.readLock();
            readLock.lock();
            try{
                ThreadUtils.sleep(2000);
                System.out.println("我在读数据：" + COUNT);
            }finally {
                readLock.unlock();
            }
        };

        //同时读、写
        Runnable write = () -> {
            ReentrantReadWriteLock.WriteLock writeLock = lock.writeLock();
            writeLock.lock();
            try{
                ThreadUtils.sleep(2000);
                System.out.println("我在写数据：" + COUNT++);
            }finally {
                writeLock.unlock();
            }
        };

        for (int i = 0; i < 100; i++) {
            Random random = new Random();
            int flag = random.nextInt(100);
            if(flag > 20){
                new Thread(read,"read").start();
            }else{
                new Thread(write,"write").start();
            }
        }
    }
}