import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String args[]) throws IOException 
    {
        // create a socket to connect to the server running on localhost at port number 9090
        Socket socket = new Socket("localhost", 9090);
        
        // Setup output stream to send data to the server
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        
        // Setup input stream to receive data from the server
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        
        // Scanner for user input
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Connected to server! Type 'exit' to quit.");
        String userInput;
        
        // Keep sending messages until user types "exit"
        while (true) {
            System.out.print("Enter message: ");
            userInput = scanner.nextLine();
            
            // Send message to server
            out.println(userInput);
            
            // Check if user wants to exit
            if (userInput.equalsIgnoreCase("exit") || userInput.equalsIgnoreCase("quit")) {
                // Receive final goodbye message
                String response = in.readLine();
                System.out.println("Server says: " + response);
                break;
            }
            
            // Receive response from server
            String response = in.readLine();
            System.out.println("Server says: " + response);
        }

        // Close connections
        scanner.close();
        socket.close();
        System.out.println("Client is exiting...");
    }
}