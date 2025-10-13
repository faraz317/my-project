import java.util.Scanner;

public class LinearSearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("How many items? ");
        int n = scanner.nextInt();
        
        System.out.println("Which item do u want to search?");
        System.out.println("1.Names");
        System.out.println("2.Numbers");
        System.err.print("Enter choice (1 or 2):");
        int order = scanner.nextInt();
        if(order != 1 && order != 2){
            System.out.println("Invalid choice Try again.");
            scanner.close();
            return;
        }
        int position = -1; 
        

        if(order == 1){
           String[] arr = new String[n];
        System.out.println("Enter " + n + " names:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.next();
        }
        System.out.print("Which name do you want to find? ");
        String target = scanner.next();
        
        for (int i = 0; i < n; i++) {
            if (arr[i] == target) { 
                position = i;         
            }
        } 
        if (position == -1) {
            System.out.println("Item " + target + " not found!");
        } else {
            System.out.println("Item " + target + " found at position " + position);
        }
        
        scanner.close();
        }else{
        int[] arr = new int[n];
        System.out.println("Enter " + n + " numbers:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        
        System.out.print("Which number do you want to find? ");
        int target = scanner.nextInt();
    
        for (int i = 0; i < n; i++) {
            if (arr[i] == target) { 
                position = i;         
            }
        }if (position == -1) {
            System.out.println("Item " + target + " not found!");
        } else {
            System.out.println("Item " + target + " found at position " + position);
        }
        
        scanner.close();

    } 
    }
}