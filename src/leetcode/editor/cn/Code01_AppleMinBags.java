package leetcode.editor.cn;

import org.junit.Test;

public class Code01_AppleMinBags {

	// 暴力方法
	public static int minBags(int apple) {
		int i = apple >> 3;
		int j = apple - (i << 3);
		while (i >= 0) {
			if (j % 6 == 0) {
				return i + j / 6;
			} else {
				j += 8;
				i--;
			}
		}
		return -1;
	}

	// 暴力方法在主程序调用后从打印中找的规律我们从而写的更优解
	public static int minBagAwesome(int apple) {
		if ((apple & 1) != 0) { // 如果是奇数，返回-1
			return -1;
		}
		if (apple < 18) {
			return apple == 0 ? 0 : (apple == 6 || apple == 8) ? 1
					: (apple == 12 || apple == 14 || apple == 16) ? 2 : -1;
		}
		return (apple - 18) / 8 + 3;
	}

	public static void main(String[] args) {
		for(int apple = 1; apple < 200;apple++) {
			System.out.println(apple + " : "+ minBags(apple));
		}

	}

	public String whoWin(int n) {
		if (n < 5) {
			return n == 0 || n == 2 ? "后手" : "先手";
		}
		int want = 1;
		while (want <= n) {
			if (whoWin(n - want).equals("后手")) {
				return "先手";
			}
			if (want * 4 > n) {
				break;
			}
			want *= 4;
		}
		return "后手";
	}

	@Test
	public void testWin() {
		for (int i = 0; i < 50; i++) {
			System.out.println(i + whoWin(i));
		}
	}

	public boolean isSum(int n) {
		for (int i = 1; i <= n; i++) {
			int sum = i;
			for (int j = i + 1; j <= n; j++) {
				sum += j;
				if (sum > n) {
					// 这里只需要break，不能return
					break;
				}
				if (sum == n) {
					return true;
				}
			}
		}
		return false;
	}
	// 更优解
	public static boolean isMSum2(int num) {
//
//		return num == (num & (~num + 1));
//
//		return num == (num & (-num));
//
//
//		if (num < 3) {
//			return false;
//		}

		// 判断是不是2的某次方
		// (num & (num - 1)) == 0 那么num是2的某次方
		// (num & (num - 1)) != 0 那么num不是2的某次方
		// 这种高级写法的解释：若num是2的某次方，有1，2，4，8...这些数在二进制上都有一个1
		// 即某个数在二进制上有一个1那么这个数是2的某次方
		return (num & (num - 1)) != 0;
	}

	@Test
	public void testIsSum() {
		for (int i = 1; i < 100; i++) {
			System.out.println(i + "   " + isSum(i) + "   " + isMSum2(i));

		}
	}
}
