package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class Code04_MaxHappy {

    public static class Employee {
        public int happy;
        public List<Employee> nexts;

        public Employee(int h) {
            happy = h;
            nexts = new ArrayList<>();
        }

    }

    public static int maxHappy1(Employee boss) {
        if (boss == null) {
            return 0;
        }
        return Math.max(process(boss).no, process(boss).yes);
    }

    // 当前来到的节点叫cur，
    // up表示cur的上级是否来，
    // 该函数含义：
    // 如果up为true，表示在cur上级已经确定来，的情况下，cur整棵树能够提供最大的快乐值是多少？
    // 如果up为false，表示在cur上级已经确定不来，的情况下，cur整棵树能够提供最大的快乐值是多少？
    public static class Info{
        public int no;
        public int yes;

        public Info(int no, int yes) {
            this.no = no;
            this.yes = yes;
        }
    }

    public static Info process(Employee boss) {
        if (boss == null) {
            return new Info(0, 0);
        }
        int no = 0;
        int yes = boss.happy;
        for (Employee next : boss.nexts) {
            Info nexts = process(next);
            no += Math.max(nexts.no, nexts.yes);
            yes += nexts.no;
        }
        return new Info(no, yes);
    }
}