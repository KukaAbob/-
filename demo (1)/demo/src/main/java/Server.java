import py4j.GatewayServer;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private Socket clientSocket; // сокет для общения
    private ServerSocket server; // серверсокет

    public static void main(String[] args) {
        Server server = new Server();
        // Открываем сервер Py4J на порту 25334
        GatewayServer gatewayServer = new GatewayServer(server, 25334);
        gatewayServer.start();
    }

    public void startServer() {
        try {
            server = new ServerSocket(4004); // серверсокет прослушивает порт 4004
            System.out.println("Server started!");
            clientSocket = server.accept(); // accept() будет ждать пока
            // кто-нибудь не захочет подключиться
            try {
                // установив связь и воссоздав сокет для общения с клиентом можно перейти
                // к созданию потоков ввода/вывода.
                // теперь мы можем принимать сообщения
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                // и отправлять
                BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

                String word = in.readLine(); // ждём пока клиент что-нибудь нам напишет
                System.out.println(word);
                // не долго думая отвечает клиенту
                out.write("Привет, это Сервер! Подтверждаю, вы написали : " + word + "\n");
                out.flush(); // выталкиваем все из буфера

            } finally { // в любом случае сокет будет закрыт
                clientSocket.close();
            }
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}
