package server;

import java.net.ServerSocket;
import java.net.Socket;

public class ServerMain {

    public static void main(String[] args) {

        try {
            ServerSocket serverSocket = new ServerSocket(9999);

            System.out.println("Server đang chạy...");

            while (true) {

                Socket socket = serverSocket.accept();

                System.out.println("Client connected");

                new Thread(new ServerHandler(socket)).start();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}