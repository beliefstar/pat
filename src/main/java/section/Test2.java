package section;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Created: 17:03 13/01/2019
 * @Author: xzhen
 * @Description: 数字黑洞
 *
 * 我们从6767开始，将得到
 *
 * 7766 - 6677 = 1089
 * 9810 - 0189 = 9621
 * 9621 - 1269 = 8352
 * 8532 - 2358 = 6174
 *
 * 如果N的4位数字全相等，则在一行内输出“N - N = 0000”；
 * 否则将计算的每一步在一行内输出，直到6174作为差出现，输出格式见样例,每行中间没有空行。
 * 注意每个数字按4位数格式输出。
 */
public class Test2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        while (line.length() != 4) {
            line = "0" + line;
        }
        char[] chars = line.toCharArray();
        int res = -1;
        while (6174 != res && res != 0) {
            Arrays.sort(chars);

            int l = parseInt(chars, true);
            int r = parseInt(chars, false);
            res = l - r;

            System.out.printf("%04d - %04d = %04d\n",l, r, res);
            chars = Integer.toString(res).toCharArray();
        }
    }

    private static int parseInt(char[] chars, boolean down) {
        int len = chars.length;
        int res = 0;
        for (int i = 0; i < chars.length; i++) {
            int c = down ? chars[len - i - 1] - '0' : chars[i] - '0';
            res += c * (Math.pow(10, (len - i - 1)));
        }
        return res;
    }
}
