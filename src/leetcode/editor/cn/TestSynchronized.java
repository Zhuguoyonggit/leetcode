package leetcode.editor.cn;

public class TestSynchronized {
 
    public volatile boolean flag;//通知什么时候发起新的请求
    
    //拿住锁5秒钟,以便对后面请求锁进行阻塞
    public synchronized void blockWhile(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    //调用该方法时，会被阻塞住
    public synchronized void blockMethod(){
        if (!this.flag){this.flag = true;}
        System.out.println("block Method : " + System.currentTimeMillis());
    }
    
    //执行新的方法
    public synchronized void newMethod(){
        System.out.println("new Method : " + System.currentTimeMillis());
    }
    
    public static void main(String[] args) throws InterruptedException {
        TestSynchronized testSynchronized = new TestSynchronized();
        
        Thread a = new Thread(testSynchronized::blockWhile);
        
        a.start();
        Thread.sleep(10);//确保a线程获得锁
        
        Thread b = new Thread(() -> {
          for (int i = 0; i < 50;i++){
              testSynchronized.blockMethod();
          } 
        });
        
        b.start();//b线程阻塞50个方法请求
        System.out.println("finish block Method : " + System.currentTimeMillis());
        Thread c = new Thread(() -> {
            int i = 0;
            while (true){
                if (testSynchronized.flag){
                    for ( ; i < 50;i++){
                        testSynchronized.newMethod();
                    }
                }
            }
        });
        c.start();//c线程在b线程的阻塞方法执行后，才执行新的调用方法，模拟新请求方法和阻塞队列请求方法竞争效果
    }
}