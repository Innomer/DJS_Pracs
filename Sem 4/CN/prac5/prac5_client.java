import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class prac5_client {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("localhost", 1234);
        System.out.println("Connected to server: " + socket.getInetAddress().getHostAddress());

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter a message to send to the server: ");
            String message = scanner.nextLine();
            out.println(message);

            // if (message.equals("exit")) {
            //     break;
            // }

            String response = in.readLine();
            System.out.println("Received message from server: " + response);
        }

        in.close();
        out.close();
        socket.close();
    }
}
