package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;

public class Code05_LowestLexicography {

	// strs中所有字符串全排列，返回所有可能的结果
	public static TreeSet<String> process(String[] strs) {
		TreeSet<String> treeSet = new TreeSet<>();
		if (strs.length == 0) {
			treeSet.add("");
			return treeSet;
		}
		for (int i = 0; i < strs.length; i++) {
			String first = strs[i];
			String[] nexts = removeIndexString(strs, i);
			TreeSet<String> next = process(nexts);
			for (String s : next) {
				treeSet.add(first + s);
			}
		}
		return treeSet;
	}
	public static class MyComparator implements Comparator<String> {
		@Override
		public int compare(String a, String b) {
			return (a + b).compareTo(b + a);
		}
	}

	public static class MyComparator1 implements Comparator<String>{

		@Override
		public int compare(String o1, String o2) {
			return (o1 + o2).compareTo(o2 + o1);
		}
	}
	public static String lowestString2(String[] strs) {
		if (strs == null || strs.length == 0) {
			return null;
		}
		// 对字符串数组进行排序
		Arrays.sort(strs, new MyComparator1());
		String ans = "";
		for (String str : strs) {
			ans += str;
		}
		return ans;

	}

	public static String[] removeIndexString(String[] strs, int i) {
		String[] strings = new String[strs.length - 1];
		int index = 0;
		for (int j = 0; j < strs.length; j++) {
			if (j != i) {
				strings[index++] = strs[j];
			}
		}
		return strings;
	}
}