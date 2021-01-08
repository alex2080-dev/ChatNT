package sample;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    
   private static final int PORT_CONNECTION = 8189;
   public static Scanner scanner = new Scanner(System.in);
   
   public static void main (String[]  args)
   {

       try (ServerSocket serverSocket = new ServerSocket(PORT_CONNECTION))
       {
           Socket clientSocket = serverSocket.accept();

           DataInputStream in = new DataInputStream(clientSocket.getInputStream());
           DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());
           out.writeUTF("Connection OK");

           while (true) {
               System.out.println("Клиент подключен");

               String messageI = in.readUTF();
               System.out.println(messageI);
               if (messageI.equals("///"))
               {
                   break;
               }

               String messageO = scanner.next();
               System.out.println(messageO);
               out.writeUTF(messageO);


           }

           
           
           
       } catch (IOException e) {
           e.printStackTrace();
       }


   }
   
}
