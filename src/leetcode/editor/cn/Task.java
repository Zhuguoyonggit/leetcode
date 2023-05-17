package leetcode.editor.cn;

import java.util.concurrent.Callable;

public class Task implements Callable<Long> {
    private long num;
    public Task(long num) {
        this.num = num;
    }

    public static void main(String[] args) {
        byte a = 127;
        byte b = 127;
//        b = (byte) (a + b); // error : cannot convert from int to byte
        b += a; // ok
        System.out.println(b);

    }
    @Override
    public Long call() throws Exception {
        long r = 0;
        for (long n = 1; n <= this.num; n++) {
            r = r + n;
        }
        System.out.println("Result: " + r);
        return r;
    }
}