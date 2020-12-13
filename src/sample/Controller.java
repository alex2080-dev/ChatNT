package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller {


    @FXML
    public TextField messageArea;
    public TextArea chatArea;


@FXML
    public Button sendMessageButton;


@FXML
    public void sendingMessage() {


    // Если поле сообщения не пусто - отправляем сообщение в чат, если пусто - приходит сообщение от собеседника
    if (!messageArea.getText().toString().equals("")) {

        chatArea.setText(chatArea.getText().toString() + System.lineSeparator() + System.lineSeparator() + "Я:" + System.lineSeparator() +messageArea.getText().toString());
        messageArea.clear();

    } else chatArea.setText(chatArea.getText().toString() + System.lineSeparator() + System.lineSeparator() + "Собеседник:" + System.lineSeparator() + "Привет");


}

}




