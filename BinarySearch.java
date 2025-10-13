import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Pre-sorted array (MUST be sorted for binary search!)
        int[] arr = {10, 20, 30, 40, 50, 60, 70, 80, 90};
        int n = arr.length;
        
        // Show the sorted array
        System.out.print("Sorted array: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        
        // Get target from user
        System.out.print("Which number do you want to find? ");
        int target = scanner.nextInt();
        
        // BINARY SEARCH LOGIC
        int left = 0;           // Start of search area
        int right = n - 1;      // End of search area
        int position = -1;      // Secret flag: "not found"
        
        System.out.println("\nSearch process:");
        
        while (left <= right) {
            int middle = (left + right) / 2;    // Find middle position
            
            System.out.println("Checking middle position " + middle + " (value = " + arr[middle] + ")");
            
            if (arr[middle] == target) {
                position = middle;               // Found it!
                System.out.println("Found target " + target + " at position " + middle);
                break;
            }
            else if (arr[middle] < target) {
                left = middle + 1;               // Search RIGHT half
                System.out.println(arr[middle] + " < " + target + ", searching right half");
            }
            else {
                right = middle - 1;              // Search LEFT half  
                System.out.println(arr[middle] + " > " + target + ", searching left half");
            }
        }
        
        // Show final result
        if (position == -1) {
            System.out.println("\nResult: Number " + target + " not found!");
        } else {
            System.out.println("\nResult: Number " + target + " found at position " + position);
        }
        
        scanner.close();
    }
}