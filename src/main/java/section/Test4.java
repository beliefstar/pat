package section;

import java.math.BigDecimal;
import java.util.*;

/**
 * @Created: 11:13 14/01/2019
 * @Author: xzhen
 * @Description: A+B for Polynomials
 *
 * input:
 * Each input file contains one test case. Each case occupies 2 lines, and each line contains the information of a polynomial
 * are the exponents and coefficients, respectively
 *
 * 2 1 2.4 0 3.2  =>   最高指数 指数 系数 指数 系数 ...(length = 最高指数)
 *
 * output:
 * For each test case you should output the sum of A and B in one line, with the same format as the input.
 * Notice that there must be NO extra space at the end of each line. Please be accurate to 1 decimal place.
 *
 * 2 1 2.4 0 3.2
 * 2 2 1.5 1 0.5
 *
 * 3 2 1.5 1 2.9 0 3.2
 */
public class Test4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Node> list = new ArrayList<>();
        int n = 2;
        while (n-- > 0) {
            String line = scanner.nextLine();
            String[] split = line.split("\\s");
            for (int i = 1; i < split.length; i += 2) {
                int i1 = Integer.parseInt(split[i]);
                Node node = new Node(i1, new BigDecimal(split[i + 1]));
                boolean flag = true;
                Iterator<Node> iterator = list.iterator();
                while (iterator.hasNext()) {
                    Node t = iterator.next();
                    if (t.equals(node)) {
                        t.coeffients = t.coeffients.add(node.coeffients);
                        if (t.coeffients.compareTo(BigDecimal.ZERO) == 0) {
                            iterator.remove();
                        }
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    list.add(node);
                }
            }
        }
        list.sort((o1, o2) -> o2.exponents - o1.exponents);
        StringBuilder sb = new StringBuilder();
        sb.append(list.size());
        for (Node node : list) {
            sb.append(" ").append(node.toString());
        }
        System.out.println(sb.toString());
    }

    static class Node {
        int exponents;
        BigDecimal coeffients;
        Node(int e, BigDecimal c) {
            this.exponents = e;
            this.coeffients = c;
        }

        @Override
        public String toString() {
            return exponents + " " + coeffients.doubleValue();
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Node) {
                Node node = (Node) obj;
                return node.exponents == exponents;
            }
            return false;
        }
    }
}
