package sample;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;

import java.security.spec.EncodedKeySpec;

public class Controller {


    @FXML
    public TextField messageArea;
    public TextArea chatArea;

@FXML
    public Button sendMessageButton;
    public AnchorPane pane;


    @FXML
    public void sendingMessage() {

        // Если поле сообщения не пусто - отправляем сообщение в чат, если пусто - приходит сообщение от собеседника
    if (!messageArea.getText().equals("")) {

        chatArea.setText(chatArea.getText() + System.lineSeparator() + System.lineSeparator() + "Я:" + System.lineSeparator() +messageArea.getText());
        messageArea.clear();
        chatArea.positionCaret(chatArea.getText().length());

    } else {
        chatArea.setText(chatArea.getText() + System.lineSeparator() + System.lineSeparator() + "Собеседник:" + System.lineSeparator() + "Привет");
        chatArea.positionCaret(chatArea.getText().length());
    }




}

    public void Entering(KeyEvent keyEvent) {

        if (keyEvent.getCode().getName().equals("Enter")) {

            sendingMessage();


        }

    }
}




