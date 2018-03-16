package test;

public class ReadTester {
	public static void main(String[] args) {
		String s = "abc def ghi";
		String[] st = s.split(" ");
		System.out.println(st[1]);
		
		System.out.println(System.getProperty("user.dir"));
	}
}
