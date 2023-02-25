package leetcode.editor.cn;

public class Singleton {
    // volatile如果不加可能会出现半初始化的对象
    private static volatile Singleton singleton;

    private Singleton() {

    }

    public static Singleton getSingleton() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }

}