package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javax.imageio.IIOException;

import javafx.scene.input.KeyEvent;
import javafx.event.EventHandler;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.io.IOException;


public class Main extends Application {

    Controller controller = new Controller();
    private Network network;

    @Override
    public void start(Stage primaryStage) throws Exception{
        System.out.println("start");

        try {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));



        primaryStage.setTitle("ChatNT");
        Scene scene = new Scene(loader.load());

        primaryStage.setScene(scene);
        primaryStage.show();

            Network network = new Network();
            if (!network.connect()) {
                System.out.println("Failed to connect to server");
            }

            Controller controller = loader.getController();
            controller.setNetwork(network);

            network.sendMessage("ping server");

            network.waitMessages(controller);

            primaryStage.setOnCloseRequest(event -> {
                try {
                    network.sendMessage("///");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                network.close();
            });

        }

        catch (IIOException e) {
            e.printStackTrace();

        }
    }


   @Override
   public void init() throws Exception {
   System.out.println("init");

    }

    @Override
    public void stop() throws Exception {
    System.out.println("stop");

    }

    public static void main(String[] args) {

        launch(args);



    }
}
