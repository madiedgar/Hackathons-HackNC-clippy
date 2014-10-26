package utils;

public class Test {
	public static void main(String[] args){
		Message m = new Message("1234.auth");
		System.out.println(m.getID());
		System.out.println(m.getMessage());
	}
}
