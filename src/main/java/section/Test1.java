package section;

import java.util.Scanner;

/**
 * @Created: 16:08 12/01/2019
 * @Author: xzhen
 * @Description:
 * 题目描述
 * 令Pi表示第i个素数。现任给两个正整数M <= N <= 10000，请输出PM到PN的所有素数。
 *
 * 输入描述:
 * 输入在一行中给出M和N，其间以空格分隔。
 *
 * 输出描述:
 * 输出从PM到PN的所有素数，每10个数字占1行，其间以空格分隔，但行末不得有多余空格。
 */
public class Test1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String s = scanner.nextLine();
        String[] s1 = s.split(" ");
        if (s1.length != 2) {
            return;
        }
        int m = Integer.parseInt(s1[0]);
        int n = Integer.parseInt(s1[1]);
        int index = 0, print = 0;
        for (int i = 2; true; i++) {
            if (checkNum(i)) {
                index++;
                if (index >= m && index <= n) {
                    if (print % 10 != 0) {
                        System.out.print(" ");
                    }
                    print++;
                    System.out.print(i);
                    if (print % 10 == 0) {
                        System.out.println();
                    }
                }
                else if (index > n) {
                    break;
                }
            }
        }
    }

    private static boolean checkNum(int num) {
        if (num < 4 && num > 0) return true;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
