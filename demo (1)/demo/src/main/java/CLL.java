import py4j.GatewayServer;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class CLL {
    public static void main(String[] args) {
        CLL app = new CLL();
        // Открываем сервер Py4J на порту 25333
        GatewayServer server = new GatewayServer(app, 25333);
        server.start();
    }

    public String sendMessage(String message) {
        try {
            // Ваш существующий код для общения по сокетам
            Socket clientSocket = new Socket("localhost", 4004);
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

            out.write(message + "\n");
            out.flush();
            String serverWord = in.readLine();

            // Закрываем сокет и потоки
            clientSocket.close();
            in.close();
            out.close();

            return serverWord;
        } catch (IOException e) {
            e.printStackTrace();
            return "Error communicating with the server.";
        }
    }
}
