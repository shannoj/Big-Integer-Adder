package bigadder;

import java.util.NoSuchElementException;

public class LinkedStack implements StackInterface{
	
	private StackNode front;
	
	public LinkedStack() {
		this.front = null;
	}

	public void push(int num) {
			StackNode newNode = new StackNode();
			newNode.data = num;
			newNode.next = front;
			front = newNode;
	}
	
	public int pop() {
		if (front == null) {
			throw new NoSuchElementException();
		} else {
			int result = front.data;
			front = front.next;
			return result;
			}
		}
	
	public int top() {
		if (front == null) {
			throw new NoSuchElementException();
		} else {
			return front.data;
		}		
	}
	
	public boolean isEmpty() {
		return front == null;	
	}
	
	public String toString() {
		if (front == null) {
			return "[]";
		} else {
			String result = "[" + front.data;
			StackNode current = front.next;
			while (current != null) {
				result += ", " + current.data;
				current = current.next;
			}
			result += "]";
			return result;
		}
	}
	
	public int size() {
		int count = 0;
		StackNode current = front;
		while (current != null) {
			count += 1;
			current = current.next;
		}
		return count;
	}
	
}
