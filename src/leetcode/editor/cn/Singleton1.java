package leetcode.editor.cn;

public class Singleton1 {
    // volatile如果不加可能会出现半初始化的对象
    private static volatile Singleton1 singleton;

    private Singleton1() {

    }

    public static Singleton1 getSingleton() {
        if (singleton == null) {
            synchronized (Singleton1.class) {
                if (singleton == null) {
                    singleton = new Singleton1();
                }
            }
        }
        return singleton;
    }

}