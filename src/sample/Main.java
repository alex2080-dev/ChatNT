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



public class Main extends Application {

    Controller controller = new Controller();

    @Override
    public void start(Stage primaryStage) throws Exception{
        System.out.println("start");

        try {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));

      //  Controller controller = new Controller();

        primaryStage.setTitle("ChatNT");
        Scene scene = new Scene(loader.load());

        primaryStage.setScene(scene);
        primaryStage.show();

        loader.setController(controller);

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
