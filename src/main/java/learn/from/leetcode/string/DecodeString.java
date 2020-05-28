package learn.from.leetcode.string;

import java.util.Stack;

/**
 * @author nivance
 * @from https://leetcode-cn.com/problems/decode-string/
 * @desc 字符串解码
 * 	             给定一个经过编码的字符串，返回它解码后的字符串。编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 * 		 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 * 	            此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 */
public class DecodeString {
	
	public String decodeString(String s){
		if (s == null || s.length() == 0) {
			return s;
		}
		Stack<String> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == ']') {
				String subStr = "";
				String tmpString = stack.pop();
				while (!"[".equals(tmpString)) {
					subStr = tmpString + subStr;
					tmpString = stack.pop();
				}
				int times = Integer.valueOf(stack.pop());
				for (int j = 0; j < times; j++) {
					if (stack.isEmpty()) {
						sb.append(subStr);						
					} else {
						stack.push(subStr);
					}
				}
			} else {
				if (s.charAt(i) <= '9' && s.charAt(i) >= '0') {
					// 找连续数字
					for (int j = i + 1; j < s.length(); j++) {
						if (s.charAt(j) > '9' || s.charAt(j) < '0') {
							stack.push(s.substring(i, j));
							i = j - 1;
							break;
						}
					}
				} else {
					stack.push(String.valueOf(s.charAt(i)));					
				}
			}
		}
		int count = 0;
		while(!stack.isEmpty()) {
			stack.pop();
			count++;
		}
		sb.append(s.substring(s.length() - count, s.length()));
		return sb.toString();
	}

}
