package module_9.src.main.java.org.example.homework;

import java.io.*;
import java.net.*;
import java.time.LocalTime;
import java.util.*;
import java.util.concurrent.*;

public class Server {
    private static final int PORT = 8080;
    private static final int TIMEOUT = 30;
    private static final Map<String, String> users = new HashMap<>();
    static {
        users.put("user1", "1234");
        users.put("admin", "admin123");
        users.put("madik","777");
    }
    public static void main(String[] args) {
        System.out.println("Сервер запущен...");
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Клиент подключен: " + clientSocket.getInetAddress());
                new Thread(() -> handleClient(clientSocket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void handleClient(Socket clientSocket) {
        try (
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)
        ) {
            out.println("Введите логин:");
            String login = in.readLine();
            out.println("Введите пароль:");
            String password = in.readLine();
            if (!users.containsKey(login) || !users.get(login).equals(password)) {
                out.println("Ошибка аутентификации! Соединение закрыто.");
                clientSocket.close();
                return;
            }
            out.println("Добро пожаловать, " + login + "!");
            ScheduledExecutorService s = Executors.newScheduledThreadPool(1);
            Runnable timeoutTask = () -> {
                try {
                    out.println("Таймаут. Соединение разорвано.");
                    clientSocket.close();
                } catch (IOException ignored) {}
            };
            ScheduledFuture<?> timeoutFuture = s.schedule(timeoutTask, TIMEOUT, TimeUnit.SECONDS);
            String message;
            while ((message = in.readLine()) != null) {
                timeoutFuture.cancel(false);
                timeoutFuture = s.schedule(timeoutTask, TIMEOUT, TimeUnit.SECONDS);
                if (message.equals("/time")) {
                    out.println(LocalTime.now());
                } else if (message.equals("/exit")) {
                    out.println("Отключение...");
                    break;
                } else {
                    out.println("Неизвестная команда.");
                }
            }
            clientSocket.close();
            s.shutdown();
        } catch (IOException e) {
            System.out.println("Клиент отключился.");
        }
    }
}
