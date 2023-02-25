package leetcode.editor.cn;

class WaitTest {

    private static  int num = 10;
    private static final Object MONITOR = new Object();

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            for (int i = 0; ; i++) {
                ThreadUtils.sleep(5);
                minus(1,i);
            }
        });


        Thread t2 = new Thread(() -> {
            for (int i = 0; ; i++) {
                ThreadUtils.sleep(10);
                plus(2,i);
            }
        });

        t1.start();
        t2.start();

        System.out.println("-------------------------------------------------");
    }

    public static void minus(int code,int i){
        synchronized (MONITOR){
            if(num <= 0){
                try {
                    MONITOR.wait(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("这是线程"+code+"--" + --num + "---"+i);
        }
    }

    public static void plus(int code,int i){
        synchronized (MONITOR){

            if(num >= 10){
                MONITOR.notify();
            }

            System.out.println("这是线程"+code+"--" + ++num + "---"+i);
        }
    }

}
class ThreadUtils {

    public static void sleep(int i) {
        try {
            Thread.sleep(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}