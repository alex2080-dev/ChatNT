package sample;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class Server {
    
   private static final int PORT_CONNECTION = 8189;
   private final ArrayList<Socket> clients = new ArrayList<>();
   
   public static void main(String[] args)
   {

       Server server = new Server();

       try (ServerSocket serverSocket = new ServerSocket(PORT_CONNECTION))
       {
           server.serverMessageThread();

           while (true) {
               Socket clientSocket = serverSocket.accept();
               System.out.println("Клиент " + clientSocket.hashCode() + " подключен");
               clientsControl(server, clientSocket);
           }

           
       } catch (IOException e) {
           e.printStackTrace();
       }
   }

    private void serverMessageThread() {
       Thread outThread = new Thread(() -> {
           Scanner scanner = new Scanner(System.in);
           while (true) {

               String messageO = scanner.next();

               try {
                   sendMessageToAll(messageO, null);
               }
               catch (IOException e) {
                   System.err.println("Ошибка рассылки сообщений");
                   e.printStackTrace();
               }

           }

       });

       outThread.setDaemon(true);
       outThread.start();

    }

    private synchronized void sendMessageToAll(String messageO, Socket socket) throws IOException {

        for (Socket client: clients)
        if (client != socket) {
            DataOutputStream out = new DataOutputStream(client.getOutputStream());
            out.writeUTF(socket.hashCode() + " : " + messageO);

        }
    }

    private static synchronized void clientsControl(Server server, Socket socket) throws IOException {

           server.clients.add(socket);
           DataInputStream in = new DataInputStream(socket.getInputStream());

           new Thread(() -> {
               while (true) {
                   try {
                       String message = in.readUTF();
                       if (message.equals("///")) {
                           try {
                               socket.close();
                               server.clients.remove(socket);
                               System.out.println(socket.hashCode() + " вышел");
                               return;
                           } catch (IOException e) {
                               e.printStackTrace();}
                       }
                       System.out.println(socket.hashCode() + " : " + message);
                       server.sendMessageToAll(message, socket);
                   } catch (IOException e) {
                       e.printStackTrace();
                   }
               }

           }).start();

        }

    }





