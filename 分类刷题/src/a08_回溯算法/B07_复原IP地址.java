package a08_回溯算法;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: fosss
 * Date: 2023/8/14
 * Time: 16:30
 * Description:
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 * 有效的 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效的 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效的 IP 地址。
 * 示例 1：
 * 输入：s = "25525511135"
 * 输出：["255.255.11.135","255.255.111.35"]
 * 示例 2：
 * 输入：s = "0000"
 * 输出：["0.0.0.0"]
 * 示例 3：
 * 输入：s = "1111"
 * 输出：["1.1.1.1"]
 * 示例 4：
 * 输入：s = "010010"
 * 输出：["0.10.0.10","0.100.1.0"]
 * 示例 5：
 * 输入：s = "101023"
 * 输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
 * 提示：
 * 0 <= s.length <= 3000
 * s 仅由数字组成
 */
public class B07_复原IP地址 {

    public static void main(String[] args) {
        B07_复原IP地址 test = new B07_复原IP地址();
        List<String> res = test.restoreIpAddresses("25525511135");
        System.out.println(res);
    }

    /**
     * 类似于上个题分割回文串
     */
    public List<String> restoreIpAddresses(String s) {
        if (s.length() < 4 || s.length() > 12) return res;//算是剪枝了
        backtracking(s, 0);
        return res;
    }

    List<String> res = new ArrayList<>();
    StringBuilder path = new StringBuilder();
    //记录添加的次数
    int count = 0;

    private void backtracking(String s, int startIndex) {
        //收集到4个数但字符串还没用完
        if (count == 4 && startIndex != s.length()) return;
        //收集了4个符合要求的数
        if (count == 4) {
            //注意这里只要在添加的时候不将最后一个点加上就行，不需要去掉，否则影响了path的长度，回溯时path.delete(path.length() - 2, path.length());出错
            res.add(path.substring(0, path.length() - 1));
            return;
        }

        for (int i = startIndex; i < s.length(); i++) {
            //判断是否符合数字特点，符合的才需要处理
            String substring = s.substring(startIndex, i + 1);
            if (isSuitable(substring)) {
                count++;
                path.append(substring).append('.');
                backtracking(s, i + 1);
                count--;
                //删除添加的东西   substring和点
                path.delete(path.length() - substring.length() - 1, path.length());
            }
        }
    }

    /**
     * 判断是否符合数字特点
     */
    private boolean isSuitable(String s) {
        char[] chars = s.toCharArray();
        //去掉012这种以0开头的情况
        if (chars.length > 1 && chars[0] == '0') return false;
        int sum = 0;
        for (char c : chars) {
            if (c < '0' || c > '9') return false;
            sum *= 10;
            sum += Integer.parseInt(c + "");
            //更新完sum后再进行判断
            if (sum > 255) return false;
        }
        return true;
    }
}
