package leetcode.editor.cn;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

public class Main{

    private AtomicInteger count = new AtomicInteger();

    public static void main(String[] args) throws InterruptedException {
        Main main = new Main();
        // 开启两个线程去执行test方法
        for (int i = 0; i < 10; i++) {
            new Thread(main::testWait).start();
        }
        Thread.sleep(1000);
        for (int i = 0; i < 5; i++) {
            main.testNotify();
        }
    }

    private synchronized void testWait() {
        try {
            log("进入了同步方法，开始wait");
            wait();
            log("wait结束");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private synchronized void testNotify() {
        notify();
    }

    private void log(String s) {
        System.out.println(count.incrementAndGet() + " "
                + new Date().toString().split(" ")[3]
                + "\t" + Thread.currentThread().getName() + " " + s);
    }

}
