package sample;

import javafx.application.Platform;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Network {

    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;

 private int port = 8189;


    public boolean connect() {
        try
        {
            socket = new Socket("localhost",port);
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

            return true;
        }

        catch (IOException io) {
            io.printStackTrace();
            return false;
        }

    }

    public void waitMessages (Controller controller) {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {

                        String message = in.readUTF();

                        Platform.runLater(() -> {
                            controller.appendMessage("Сервер: " + message);
                            System.out.println("Server: " + message);
                        });
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("Соединение потеряно");

                }
            }
        });

        thread.setDaemon(true);
        thread.start();


    }

    public DataInputStream getInputStream() {
        return in;
    }

    public DataOutputStream getOutputStream() {
        return out;
    }

    public void sendMessage(String message) throws IOException {
        getOutputStream().writeUTF(message);

    }

    public void close() {
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
