import java.util.Scanner;
 
public class MiddleOfLinkedList {
 
	public static Node insert(Node head, int data) {
		head.next = new Node(data);
		return head.next;
	}
	
	public static void printMiddle(Node head) {
		
		if(head == null) {
			return;
		}
 
		Node slow = head;
		Node fast = head;
		
		while(fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		
		if(fast.next == null) {
			System.out.println(slow.data);
		} else {
			System.out.println(slow.next.data);
		}
		
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int size = scan.nextInt();
		Node head = new Node(scan.nextInt());
		Node start = head;
		for(int i=1; i<size; i++) {
			head = insert(head, scan.nextInt());
		}
		
		printMiddle(start);
	}
	
}
 
class Node {
	
	int data;
	Node next;
	
	public Node(int data) {
		this.data = data;
		this.next = null;
	}
	
}