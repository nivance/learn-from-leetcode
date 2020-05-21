package learn.from.leetcode.string;

/**
 * @author nivance
 * @from https://leetcode-cn.com/problems/longest-palindromic-substring/
 * @desc 最长回文子串
 * 		 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 */
public class LongestPalindrome {
	
	public String longestPalindrome(String s) {
		if (s == null || s.length() < 1) {
			return "";
		}
		int start = 0, end = 0;
		for (int i = 0; i < s.length(); i++) {
			int len1 = expandAroundCenter(s, i, i);
			int len2 = expandAroundCenter(s, i, i + 1);
			int len = Math.max(len1, len2);
			if (len > end - start) {
				start = i - (len -1) / 2;
				end = i + len / 2; 
			}
		}
		return s.substring(start, end + 1);
    }

	private int expandAroundCenter(String s, int left, int right) {
		int l = left, r = right;
		while (l >=0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
			l--;
			r++;
		}
		return r - l - 1;
	}
}
