package learn.from.leetcode.string;

/**
 * @author nivance
 * @from https://leetcode-cn.com/problems/is-subsequence/
 * @desc 给定字符串 s 和 t ，判断 s 是否为 t 的子序列
 */
public class IsSubsequence {
	
	public boolean isSubsequence(String s, String t) {
		int i = 0, j = 0;
		while(i < s.length() && j < t.length()) {
			if (s.charAt(i) == t.charAt(j)) {
				i++;
			}
			j++;
		}
		return i == s.length();
	}

}
