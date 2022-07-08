package bigadder;
import java.util.Scanner;

public class BigIntegerAdder {
	
	private static void readNumber(LinkedStack s) {
		
		Scanner userInput = new Scanner(System.in);
		System.out.print("Enter a number: ");
		String input = userInput.nextLine();
		
		for (int i = 0; i < input.length(); i++) {
			int x = Character.getNumericValue(input.charAt(i));
			s.push(x);
		}
	}
	
	public static String add(LinkedStack s1, LinkedStack s2) {
		String result = "";
		int sum = 0;
		int carry = 0;
		
		while ((!s1.isEmpty()) && (!s2.isEmpty())) {
			if (carry == 1) {
				sum = 1 + (s1.pop() + s2.pop());
			} 
			if (carry == 0) {
				sum = (s1.pop() + s2.pop());
			}
			if (s1.size() == 0 && s2.size()== 0) {
				int insert = sum;
				Integer.toString(insert);
				result = insert + result;
				return result;
			}
			if (sum > 9) {
				carry = 1;
			} 
			if (sum <= 9) {
				carry = 0;
			}
			int insert = sum % 10;
			Integer.toString(insert);
			result = insert + result;
			sum = 0;
		}
		
		if (s1.isEmpty()) {
			if (carry == 1) {
				int insert = s2.pop() + 1;
				Integer.toString(insert);
				result = insert + result;
				while (!s2.isEmpty()) {
					result = Integer.toString(s2.pop()) + result;
				}
			} 
			if (carry == 0) {
				while (!s2.isEmpty()) {
					result =Integer.toString(s2.pop()) + result;
				}
			}
			return result;
		}
		
		if (s2.isEmpty()) {
			if (carry == 1) {
				int insert = s1.pop() + 1;
				Integer.toString(insert);
				result = insert + result;
				while (!s1.isEmpty()) {
					result = Integer.toString(s1.pop()) + result;
				}
			} 
			if (carry == 0) {
				while (!s1.isEmpty()) {
					result = Integer.toString(s1.pop()) + result;
				}
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		LinkedStack s1 = new LinkedStack();
		LinkedStack s2 = new LinkedStack();
		
		readNumber(s1);
		readNumber(s2);
		
		String result = add(s1, s2);
		
		System.out.println(result);
		
	}
}
