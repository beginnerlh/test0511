/*
一条包含字母 A-Z 的消息通过以下方式进行了编码：
'A' -> 1
'B' -> 2
...
'Z' -> 26

给定一个只包含数字的非空字符串，请计算解码方法的总数。

示例 1:
输入: "12"
输出: 2
解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。

示例 2:
输入: "226"
输出: 3
解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
        */
//非常类似于斐波那契序列，可以理解为dp[i]=dp[i-1]+dp[i-2]。
// 但是这个是有条件的：如果以i为下标的字符串，i-1位与i位组成的两位数不在10-26之间，那么dp[i-2]就不能加
//如果以i为下标的元素为0，也不能加dp[i-1].

package lianxi0511;

public class test0511 {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.numDecodings("101"));
    }
}

class Solution {
    public int numDecodings(String s) {
        if(s.length() == 0 || s.charAt(0) =='0' ){
            return 0;
        }
        if(s.length() == 1 ){
            return 1;
        }
        int dp1 = 1;//相当于dp[i-2]
        int dp2 = 1;//相当于dp[i-1]
        int result = 0;
        for(int i = 1;i<s.length();i++){
            int i1 = (s.charAt(i - 1) - 48) * 10 + (s.charAt(i) - 48);
            //不能连续出现0
            if(i1 == 0){
                return 0;
            }
            if(i1 >=10 && i1 <=26 ){
                result = dp1;
            }
            if(s.charAt(i) != '0'){
                result += dp2;
            }
            dp1 = dp2;
            dp2 = result;
            result = 0;
        }
        return dp2;
    }
}