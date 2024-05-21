package dataStruct1;
//TO CHECK IF THE LINKED LIST IS IN THE FORM OF A CYCLE
public class ListCycle {
	Node5 head;
	class Node5{
		String data;
		Node5 next;
		Node5(String data){
			this.data=data;
			next=null;
		}
	}
	void addFirst5(String data) {
		Node5 newNode = new Node5(data);
		if(head==null) {
			head=newNode;
			return;
		}
		newNode.next=head;
		head=newNode;
	}
	void addLast5(String data) {
		Node5 newNode = new Node5(data);
		if(head==null) {
			head=newNode;
			return;
		}
		Node5 currNode = head;
		while(currNode.next!=null) {
			currNode=currNode.next;
		}
		currNode.next=newNode;
	}
	void printList5() {
		if(head==null) {
			System.out.println("It is an empty list");
		}
		Node5 currNode=head;
		while(currNode!=null) {
			System.out.print(currNode.data+"->");
			currNode=currNode.next;
		}
		System.out.println("NULL");
	}
	class Solution5{
		boolean isCycle(Node5 head) {
			if(head==null) {
				return false;
			}
			Node5 hare=head;
			Node5 turtle=head;
			while(hare!=null && hare.next!=null) {
				hare=hare.next.next;
				turtle=turtle.next;
				if(turtle==hare) {
					return true;
				}
			}
			return false;
		}
	    void removeCycle(Node5 head) {
	        if (head == null || head.next == null) {
	            return;
	        }
	        Node5 hare 		= head;
	        Node5 turtle = head;
	        boolean hasCycle = false;
	        while (hare != null && hare.next != null) {
	            hare = hare.next.next;
	            turtle = turtle.next;
	            if (turtle == hare) {
	                hasCycle = true;
	                break;
	            }
	        }
	        if (!hasCycle) {
	            return;
	        }

	        // Move turtle to the head of the list
	        turtle = head;
	        while (turtle.next != hare.next) {
	            turtle = turtle.next;
	            hare = hare.next;
	        }

	        // Remove the cycle by setting hare's next pointer to null
	        hare.next = null;
	    }
	}
	
	public static void main(String args[]) {
		ListCycle obj1 = new ListCycle();
		obj1.addFirst5("is");
		obj1.addFirst5("This");
		obj1.addLast5("a");
		obj1.addLast5("list");
		obj1.printList5();
		ListCycle.Solution5 obj2 = obj1.new Solution5();
		System.out.println(obj2.isCycle(obj1.head));
	}
}
