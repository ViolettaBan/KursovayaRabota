package by.vita02.backend;

import by.vita02.backend.service.ManagerService;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
  private static ServerSocket serverSocket;
  private static Socket clientSocket;

  public static void main(String[] args) {
    System.out.println("Старт сервера...");
    try {
      serverSocket = new ServerSocket(8080);
      while (true) {
        clientSocket = serverSocket.accept();
        System.out.println("Новое подключение. IP: "+ clientSocket.getInetAddress());
        Thread query =
            new Thread(
                () -> {
                  ManagerService managerService = new ManagerService();
                  managerService.start(clientSocket);
                },
                "Wow");
        query.start();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}