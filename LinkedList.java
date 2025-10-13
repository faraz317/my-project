import java.util.Scanner;

// Node class - Each box in the chain
class Node {
    int data;    // The value stored
    Node next;   // Pointer to next box
    
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class LinkedList {
    Node head;  // Points to first box
    
    // Add new number to the list
    public void add(int data) {
        Node newNode = new Node(data);  // Create new box
        
        if (head == null) {             // If list is empty
            head = newNode;             // Make this the first box
        } else {
            Node current = head;        // Start from first box
            while (current.next != null) {  // Find the last box
                current = current.next;
            }
            current.next = newNode;     // Connect new box to last box
        }
    }
    
    // Display all numbers in the list
    public void display() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        
        Node current = head;            // Start from first box
        System.out.print("List: ");
        while (current != null) {       // Go through each box
            System.out.print(current.data + " → ");
            current = current.next;     // Move to next box
        }
        System.out.println("NULL");
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList list = new LinkedList();
        
        System.out.print("How many numbers to add? ");
        int n = scanner.nextInt();
        
        System.out.println("Enter " + n + " numbers:");
        for (int i = 0; i < n; i++) {
            int num = scanner.nextInt();
            list.add(num);              // Add to linked list
        }
        
        list.display();                 // Show the chain
        scanner.close();
    }
}