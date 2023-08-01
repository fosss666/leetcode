package a06_栈与队列;

import java.util.Stack;

/**
 * @author: fosss
 * Date: 2023/7/31
 * Time: 20:25
 * Description:
 * 根据 逆波兰表示法，求表达式的值。有效的运算符包括 + ,  - ,  * ,  / 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
 * 说明：
 * 整数除法只保留整数部分。 给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
 * 示例 1：
 * 输入: ["2", "1", "+", "3", " * "]
 * 输出: 9
 * 解释: 该算式转化为常见的中缀算术表达式为：((2 + 1) * 3) = 9
 * 示例 2：
 * 输入: ["4", "13", "5", "/", "+"]
 * 输出: 6
 * 解释: 该算式转化为常见的中缀算术表达式为：(4 + (13 / 5)) = 6
 * 示例 3：
 * 输入: ["10", "6", "9", "3", "+", "-11", " * ", "/", " * ", "17", "+", "5", "+"]
 * 输出: 22
 * 解释:该算式转化为常见的中缀算术表达式为：
 * ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
 * = ((10 * (6 / (12 * -11))) + 17) + 5
 * = ((10 * (6 / -132)) + 17) + 5
 * = ((10 * 0) + 17) + 5
 * = (0 + 17) + 5
 * = 17 + 5
 * = 22
 * 逆波兰表达式：是一种后缀表达式，所谓后缀就是指运算符写在后面。
 * 平常使用的算式则是一种中缀表达式，如 ( 1 + 2 ) * ( 3 + 4 ) 。
 * 该算式的逆波兰表达式写法为 ( ( 1 2 + ) ( 3 4 + ) * ) 。
 * 逆波兰表达式主要有以下两个优点：
 * 去掉括号后表达式无歧义，上式即便写成 1 2 + 3 4 + * 也可以依据次序计算出正确结果。
 * 适合用栈操作运算：遇到数字则入栈；遇到运算符则取出栈顶两个数字进行计算，并将结果压入栈中。
 */
public class B05_逆波兰表达式求值 {

    public static void main(String[] args) {
        String[] tokens = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        int res = evalRPN(tokens);
        System.out.println("res = " + res);
    }

    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String s : tokens) {
            if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
                //是运算符就弹出两个数进行运算
                Integer n1 = stack.pop();
                Integer n2 = stack.pop();
                //注意两个数的先后顺序，n1是后进栈的所以应该做运算符后边的数
                if (s.equals("+")) {
                    stack.push(n2 + n1);
                } else if (s.equals("-")) {
                    stack.push(n2 - n1);
                } else if (s.equals("*")) {
                    stack.push(n2 * n1);
                } else if (s.equals("/")) {
                    stack.push(n2 / n1);
                }
            } else {
                //是数字就入栈
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.pop();
    }
}
