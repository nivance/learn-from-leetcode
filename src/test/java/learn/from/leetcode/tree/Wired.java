package learn.from.leetcode.tree;

import java.util.HashMap;

public class Wired {

	public static void main(String[] args) {
		System.out.println(compressString("aabcccccaa"));
		
		float a = 0.125f;
		double b = 0.125d;
		System.out.println((a - b) == 0.0);
		
		double c = 0.8;
		double d = 0.7;
		double e = 0.6;
		System.out.println((c - d) == (d - e));
		Float ff;
		Double dd;
		System.out.println(1.0 / 0);
		System.out.println(0.0 / 0.0);
		
		
//		f(null);
		g(1);
		
		HashMap<String, Integer> map = new HashMap<>(10000);
		
		get("1", "111");
		
		String aa = null;
		
		switch(aa) {
			case "a" :
				System.out.println("a");
			case "b" :
				System.out.println("b");
			default :
				System.out.println("c");
		}
	}
	
	public static void f(String s) {
		System.out.println("f string");
	}
	
	public static void f(Integer i) {
		System.out.println("f Integer");
	}
	
	public static void g(double d) {
		System.out.println("g-double:" + d);
	}
	
	public static void g(Integer i) {
		System.out.println("g-Integer:" + i);
	}
	
	static <String, T, Alibaba> String get(String string, T t) { 
		return string; 
	} 
	
	public static String compressString(String s) {
		StringBuilder sb = new StringBuilder();
		char[] ca = s.toCharArray();
		char t = ca[0];
		int count = 1;
		boolean origin = true;
		for(int i = 1; i < s.length(); i++) {
			if (t == ca[i]) {
				count++;
				origin = false;
			} else {
				sb.append(t).append(count);
				count = 1;
				t = ca[i];
			}
		}
		sb.append(t).append(count);
		return origin ? s : sb.toString();
    }

}
