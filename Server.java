import java.io.*;
import java.net.*;

public class Server {
    public static void main(String args[]) throws IOException 
    {
        // create a server socket on port number 9090
        ServerSocket serverSocket = new ServerSocket(9090);
        System.out.println("Server is running and waiting for client connection...");

        // Accept incoming client connection
        Socket clientSocket = serverSocket.accept();
        System.out.println("Client connected!");

        // Setup input and output streams for communication with the client
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

        String message;
        
        // Keep receiving messages until client disconnects or sends "exit"
        while ((message = in.readLine()) != null) {
            System.out.println("Client says: " + message);
            
            // Check if client wants to exit
            if (message.equalsIgnoreCase("exit") || message.equalsIgnoreCase("quit")) {
                out.println("Goodbye! Server is closing connection.");
                break;
            }
            
            // Process the message and send response
            String response = processMessage(message);
            out.println(response);
        }

        // Close connections
        clientSocket.close();
        serverSocket.close();
        System.out.println("Server is exiting...");
    }
    
    // Method to process client messages
    private static String processMessage(String message) {
        // Simple processing - convert to uppercase and add prefix
        return ("Server processed: " + message.toUpperCase());
    }
}