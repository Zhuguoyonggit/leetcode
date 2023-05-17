package leetcode.editor.cn;

import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.LongSupplier;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Code07_ZigZagPrintMaArix {

    public static void main(String[] args) {

        LongStream.generate(new LongSupplier() {

                    long a = 1, b = 0;

                    @Override

                    public long getAsLong() {

                        long tmp = a + b;

                        a = b;

                        return b = tmp;

                    }

                })

                .limit(10)

                .forEach(System.out::println);

        /*1,1,2,3,5,8,13,21,34,55,*/

    }
    public static void print(int[][] arr) {
        if (arr == null) {
            return;
        }
        int ar = 0;
        int ac= 0;
        int br = 0;
        int bc= 0;
        int endR = arr.length - 1;
        int endC = arr[0].length - 1;
        boolean rightDown = false;
        while (ar <= endR) {
            printLevel(ar, ac, br, bc, rightDown,arr);
            // 变化坐标
            ar = ac == endC ? ar + 1 : ar;
            ac = ar == endR ? ac : ac + 1;

            bc = br == endR ? bc + 1 : bc;
            br = br == endR ? br : br + 1;

            rightDown = !rightDown;
        }
    }

    @Test
    public void testReduce() {
        // 按行读取配置文件:
        List<String> props = List.of("profile=native", "debug=true", "logging=warn", "interval=500");
        Map<String, String> map = props.stream()
                // 把k=v转换为Map[k]=v:
                .map(kv -> {
                    String[] ss = kv.split("\\=", 2);
                    return Map.of(ss[0], ss[1]);
                })
                // 把所有Map聚合到一个Map:
                .reduce(new HashMap<String, String>(), (m, kv) -> {
                    m.putAll(kv);
                    return m;
                });
        // 打印结果:
        map.forEach((k, v) -> {
            System.out.println(k + " = " + v);
        });
    }
    public static void printLevel(int ar, int ac, int br, int bc, boolean rightDown, int[][] arr) {
        if (rightDown) {
            while (ar <= br) {
                System.out.println(arr[ar++][ac--]);
            }
        } else {
            while (br >= ar) {
                System.out.println(arr[br--][bc++]);
            }
        }
    }
//    public static void main(String[] args) {
//        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
//        //printMatrixZigZag(matrix);
//
//    }
    class Main {
        public void main() {
            Stream<Integer> natual = Stream.generate(new NatualSupplier());
            // 注意：无限序列必须先变成有限序列再打印:
            natual.limit(200000).forEach(System.out::println);
        }
    }

    @Test
    public void testt() {
        List<String> list = List.of("apple", "Banana", "Blackberry", "Coconut", "Avocado", "Cherry", "Apricots");
        Map<String, List<String>> groups = list.stream()
                .collect(Collectors.groupingBy(s -> s.substring(0, 1), Collectors.toList()));
        System.out.println(groups);
    }
    class NatualSupplier implements Supplier<Integer> {
        int n = 0;
        public Integer get() {
            n++;
            return n;
        }
    }

}
