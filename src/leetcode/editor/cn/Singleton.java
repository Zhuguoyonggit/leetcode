package leetcode.editor.cn;

public class Singleton {

    static {
        System.out.println("init Singleton class...");
    }

    private static Singleton instance = createInstance();

    private static Singleton createInstance() {
        System.out.println("create singleton instance...");
        return new Singleton();
    }

    private Singleton() {
    }

    public static Singleton getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        Singleton s = null;
        System.out.println(Singleton.class);
        s = Singleton.getInstance(); // create singleton instance...
        System.out.println(s);
    }
}