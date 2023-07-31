package a05_双指针法;

/**
 * @author: fosss
 * Date: 2023/7/31
 * Time: 16:31
 * Description:
 * 给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
 * 在 S 上反复执行重复项删除操作，直到无法继续删除。
 * 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
 * 示例：
 * 输入："abbaca"
 * 输出："ca"
 * 解释：例如，在 "abbaca" 中，我们可以删除 "bb" 由于两字母相邻且相同，这是此时唯一可以执行删除操作的重复项。之后我们得到字符串 "aaca"，其中又只有 "aa" 可
 * 提示：
 * 1 <= S.length <= 20000
 * S 仅由小写英文字母组成。
 */
public class B10_删除字符串中的所有相邻重复项 {

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
}
