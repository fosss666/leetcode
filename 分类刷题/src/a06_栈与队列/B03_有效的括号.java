package a06_栈与队列;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author: fosss
 * Date: 2023/7/31
 * Time: 15:00
 * Description:
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。左括号必须以正确的顺序闭合。注意空字符串可被认为是有效字符串。
 * 示例 1:
 * 输入: "()" 输出: true
 * 示例 2:
 * 输入: "()[]{}" 输出: true
 * 示例 3:
 * 输入: "(]" 输出: false
 * 示例 4:
 * 输入: "([)]" 输出: false
 * 示例 5:
 * 输入: "{[]}" 输出: true
 */
public class B03_有效的括号 {

    /**
     * 不借助map，判断左括号类型然后在栈中添加它对应的右括号
     */
    public boolean isValid2(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < chars.length; i++) {
            //处理是左括号的情况
            if (chars[i] == '(') {
                stack.push(')');
            } else if (chars[i] == '{') {
                stack.push('}');
            } else if (chars[i] == '[') {
                stack.push(']');
            } else {
                //如果是右括号，判断栈是否为空与栈顶元素是否相同，如果相同则出栈，否则直接返回false
                if (stack.isEmpty() || chars[i] != stack.peek()) {
                    return false;
                } else {
                    stack.pop();
                }
            }

        }
        return stack.isEmpty();
    }

    /**
     * 使用哈希表给每个字符起个score，挨个判断括号是否对应
     * 需要注意不能让右括号先进栈
     * 11%  77%
     */
    public boolean isValid(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('(', 1);
        map.put(')', -1);
        map.put('{', 2);
        map.put('}', -2);
        map.put('[', 3);
        map.put(']', -3);
        char[] chars = s.toCharArray();
        //题目考察括号的对应，使用栈比较合适
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            if (!stack.isEmpty() && map.get(stack.peek()) + map.get(chars[i]) == 0) {
                stack.pop();
            } else {
                //需要注意不能让右括号先进栈
                if (map.get(chars[i]) < 0) {
                    return false;
                }
                stack.push(chars[i]);
            }
        }
        //如果栈最终为空，说明字符串中的括号各自都有对应，即字符串是有效的
        return stack.isEmpty();
    }
}












