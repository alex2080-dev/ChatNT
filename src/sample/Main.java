package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javax.imageio.IIOException;



public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        System.out.println("start");

        try {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));

        Controller controller = new Controller();

        primaryStage.setTitle("ChatNT");
        primaryStage.setScene(new Scene(loader.load()));
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
