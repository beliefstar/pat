package section;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * @Created: 9:40 14/01/2019
 * @Author: xzhen
 * @Description: A+B Format
 *
 * in:
 * Each input file contains one test case. Each case contains a pair of integers a and b where −10^6≤a,b≤10^6.
 * The numbers are separated by a space.
 * out:
 * For each test case, you should output the sum of a and b in one line. The sum must be written in the standard format.
 *
 * -1000000 9
 * -999,991
 */
public class Test3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] arr = line.split("\\s");
        BigDecimal n1 = new BigDecimal(arr[0]);
        BigDecimal n2 = new BigDecimal(arr[1]);
        BigDecimal res = n1.add(n2);
        System.out.println(new DecimalFormat(",###").format(res.doubleValue()));
    }

    public static void main3(String[] args) {
        double pi=3.1415927;
        System.out.println(new DecimalFormat("0000").format(pi));
        System.out.println(new DecimalFormat(".#%").format(pi));
    }
}
