import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class prac5_server {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(1234);
        System.out.println("Server is running on port 1234");
        int numberOfClients=0;
        int counter=0;

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected: " + socket.getInetAddress().getHostAddress());
            numberOfClients++;
            Thread thread = new Thread(() -> {
                try {
                    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);

                    while (true) {
                        String message = in.readLine();
                        if (message == null) {
                            break;
                        }
                        System.out.println("Received message from client: " + message);
                        if(message=="exit"){
                            counter++;   
                            if(counter==numberOfClients){
                                break;
                            }
                        }
                        out.println("Hello from server");
                    }

                    in.close();
                    out.close();
                    socket.close();
                    System.out.println("Client disconnected: " + socket.getInetAddress().getHostAddress());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            thread.start();
        }
    }
}
