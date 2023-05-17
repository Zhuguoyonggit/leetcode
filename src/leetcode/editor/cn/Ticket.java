package leetcode.editor.cn;

import java.util.concurrent.locks.ReentrantLock;

public class Ticket implements Runnable{

    private static final ReentrantLock lock = new ReentrantLock();
    private static Integer COUNT = 100;

    String name;

    public Ticket(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        while (Ticket.COUNT > 0) {
            //ThreadUtils.sleep(100);
            // 就在这里
            lock.lock();
            try {
                System.out.println(name + "出票一张，还剩" + Ticket.COUNT-- + "张！");
            } finally {
                lock.unlock();
            }

        }
    }

    public static void main(String[] args) throws Exception {
        Thread one = new Thread(new Ticket("一号窗口"));
        Thread two = new Thread(new Ticket("一号窗口"));
        one.start();
        two.start();
        Thread.sleep(10000);
    }
}