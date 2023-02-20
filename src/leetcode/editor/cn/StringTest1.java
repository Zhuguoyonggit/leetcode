package leetcode.editor.cn;

public class StringTest1 {
    private static String str = new String("good");
    char[] ch = {'t','a'};

    public void change(String str,char ch[]){ //这里str是个变量
        //由于str被final修饰，所以不可改变
        System.out.println(str.hashCode());
        str  = "hello";//这里无法修改上面的str
        System.out.println(str.hashCode());
        System.out.println("方法中的："+str);
        System.out.println("方法中的this："+this.str);
        ch[0] = 'a';
    }

    public static void main(String[] args) {
        StringTest1 s1 = new StringTest1();
        System.out.println(str.hashCode());
        s1.change(s1.str,s1.ch);
        System.out.println(s1.str);//good
        str  = "hello";
        System.out.println(str);
        System.out.println(s1.ch);
    }
}
