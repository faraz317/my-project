import java.util.*;
import java.net.*;
import java.io.*;

// Thread class to handle each client
class Threading extends Thread {
    private Socket client;

    public Threading(Socket client) {
        this.client = client;
    }

    public void run() {
        try {
            Scanner in = new Scanner(client.getInputStream());
            PrintWriter out = new PrintWriter(client.getOutputStream(), true);
            Scanner console = new Scanner(System.in); // for server input

            while (true) {
                // receive message from client
                if (in.hasNextLine()) {
                    String message = in.nextLine();
                    System.out.println("Client says: " + message);

                    if (message.equalsIgnoreCase("exit")) {
                        out.println("Goodbye!");
                        break;
                    }
                }

                // server can type a reply
                System.out.print("Server: ");
                String reply = console.nextLine();
                out.println(reply);

                if (reply.equalsIgnoreCase("exit")) {
                    break;
                }
            }

            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

// Server class 
public class MultipleClientServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9090);
        System.out.println("Server is running on port 9090...");

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected: " + clientSocket.getInetAddress());

            // start a new thread for this client
            Threading clientThread = new Threading(clientSocket);
            clientThread.start();
        }
    }
}