import java.util.*;
import java.net.*;
import java.io.*;

class Threading extends Thread {
    private Socket client;

    public Threading(Socket client) {
        this.client = client;
    }

    public void run() {
        try {
            Scanner in = new Scanner(client.getInputStream());
            PrintWriter out = new PrintWriter(client.getOutputStream(), true);

            while (true) {
                String message = in.nextLine();
                System.out.println("Client says " + message);
                if (message.equals("exit")) {
                    break;
                }
            }
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
public class ServerMultiThreading {
    public static void main(String args[]) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9090);
        System.out.println("Server is running and waiting for client connection...");

        Socket clientSocket = serverSocket.accept();
        System.out.println("Client connected!");

        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

        String message = in.readLine();
        System.out.println("Client says: " + message);

        // Send response to the client
        out.println("Message received by the server.");

        clientSocket.close();
        serverSocket.close();
    }
}