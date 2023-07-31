package a06_栈与队列;

import java.util.ArrayDeque;
import java.util.LinkedList;

/**
 * @author: fosss
 * Date: 2023/7/31
 * Time: 15:38
 * Description:
 * 给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
 * 在 S 上反复执行重复项删除操作，直到无法继续删除。
 * 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
 * 示例：
 * 输入："abbaca"
 * 输出："ca"
 * 解释：例如，在 "abbaca" 中，我们可以删除 "bb" 由于两字母相邻且相同，这是此时唯一可以执行删除操作的重复项。之后我们得到字符串 "aaca"，其中又只有 "aa" 可以执行重复项删除操作，所以最后的字符串为 "ca"。
 * 提示：
 * 1 <= S.length <= 20000
 * S 仅由小写英文字母组成。
 */
public class B04_删除字符串中的所有相邻重复项 {
    public static void main(String[] args) {
        removeDuplicates4("abbaca");
    }

    /**
     * 双指针，快指针覆盖慢指针
     */
    public static String removeDuplicates4(String s) {
        char[] ch = s.toCharArray();
        int fast = 0;
        int slow = 0;
        while (fast < s.length()) {
            // 直接用fast指针覆盖slow指针的值
            ch[slow] = ch[fast];
            // 遇到前后相同值的，就跳过，即slow指针后退一步，下次循环就可以直接被覆盖掉了
            if (slow > 0 && ch[slow] == ch[slow - 1]) {
                slow--;
            } else {
                slow++;
            }
            fast++;
        }
        return new String(ch, 0, slow);
    }

    /**
     * 直接用字符串当栈
     */
    public String removeDuplicates3(String s) {
        // 将 res 当做栈
        // 也可以用 StringBuilder 来修改字符串，速度更快
        // StringBuilder res = new StringBuilder();
        StringBuffer res = new StringBuffer();
        // top既为 res 的长度又为比较的字符下表
        int top = -1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // 当 top >= 0,即栈中有字符时，当前字符如果和栈中字符相等，弹出栈顶字符，同时 top--
            if (top >= 0 && res.charAt(top) == c) {
                res.deleteCharAt(top);
                top--;
                // 否则，将该字符入栈，同时top++
            } else {
                res.append(c);
                top++;
            }
        }
        return res.toString();
    }

    /**
     * 栈
     */
    public String removeDuplicates2(String S) {
        //ArrayDeque会比LinkedList在除了删除元素这一点外会快一点
        //参考：https://stackoverflow.com/questions/6163166/why-is-arraydeque-better-than-linkedlist
        ArrayDeque<Character> deque = new ArrayDeque<>();
        char ch;
        for (int i = 0; i < S.length(); i++) {
            ch = S.charAt(i);
            if (deque.isEmpty() || deque.peek() != ch) {
                deque.push(ch);
            } else {
                deque.pop();
            }
        }
        String str = "";
        //剩余的元素即为不重复的元素
        while (!deque.isEmpty()) {
            str = deque.pop() + str;//保证各字符是原来的顺序
        }
        return str;
    }

    /**
     * 双端队列
     */
    public String removeDuplicates(String s) {
        char[] chars = s.toCharArray();
        LinkedList<Character> queue = new LinkedList<>();
        for (char c : chars) {
            if (queue.isEmpty() || queue.peekLast() != c) {
                //队列为空或队头元素与c不同
                queue.addLast(c);
            } else {
                //相同则出队列
                queue.pollLast();
            }
        }
        //出队列形成字符串
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            sb.append(queue.poll());
        }
        return sb.toString();
    }
}















