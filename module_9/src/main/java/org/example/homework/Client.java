package module_9.src.main.java.org.example.homework;

import java.io.*;
import java.net.*;
import java.util.Scanner;
import java.util.concurrent.*;

public class Client {
    private static final String SERVER_ADDRESS = "127.0.0.1";
    private static final int PORT = 8080;
    private static final int TIMEOUT = 30;
    public static void main(String[] args) {
        try (Socket socket = new Socket(SERVER_ADDRESS, PORT);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             Scanner scanner = new Scanner(System.in)) {
            ScheduledExecutorService s = Executors.newScheduledThreadPool(1);
            Runnable timeoutTask = () -> {
                System.out.println("Таймаут. Соединение разорвано.");
                System.exit(0);
            };
            ScheduledFuture<?> timeoutFuture = s.schedule(timeoutTask, TIMEOUT, TimeUnit.SECONDS);
            System.out.println(in.readLine());
            String login = scanner.nextLine();
            out.println(login);
            System.out.println(in.readLine());
            String password = scanner.nextLine();
            out.println(password);
            String authResponse = in.readLine();
            System.out.println(authResponse);
            if (authResponse.startsWith("Ошибка")) return;
            while (true) {
                timeoutFuture.cancel(false);
                timeoutFuture = s.schedule(timeoutTask, TIMEOUT, TimeUnit.SECONDS);

                System.out.print("Клиент: ");
                String message = scanner.nextLine();
                out.println(message);
                if (message.equals("/exit")) break;
                String response = in.readLine();
                System.out.println("Сервер: " + response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}