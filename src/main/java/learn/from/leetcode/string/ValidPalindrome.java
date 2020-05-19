package learn.from.leetcode.string;

/**
 * @author nivance
 * @from https://leetcode-cn.com/problems/valid-palindrome-ii/
 * @desc 验证回文字符串 Ⅱ
 * 		 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 */
public class ValidPalindrome {
	private int subTimes = 1;
	
	public boolean validPalindrome(String s) {
		return isPalindrome(s, 0, s.length() - 1);
	}

	private boolean isPalindrome(String s, int low, int high) {
		if (low < high) {
			if (s.charAt(low) == s.charAt(high)) {
				return isPalindrome(s, ++low, --high);
			} else {
				if (subTimes > 0) {
                    subTimes--;
                    return isPalindrome(s, ++low, high) || isPalindrome(s, --low, --high);
                } else {
                    return false;
                }	
			}
		}
		return true;
	}
	
}
