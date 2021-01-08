package sample;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class Controller {


    @FXML
    public TextField messageArea;
    public TextArea chatArea;

    private Network network;
    @FXML
    public Button sendMessageButton;
    public AnchorPane pane;


    @FXML
    public void sendingMessage() throws IOException {

        // Если поле сообщения не пусто - отправляем сообщение в чат, если пусто - приходит сообщение от собеседника
    if (!messageArea.getText().equals("")) {

        chatArea.setText(chatArea.getText() + System.lineSeparator() + System.lineSeparator() + "Я:" + System.lineSeparator() +messageArea.getText());
        try {
            network.sendMessage(messageArea.getText());
        } catch (IOException e) {
            e.printStackTrace();
        }
        messageArea.clear();
        chatArea.positionCaret(chatArea.getText().length());

    } else {
        chatArea.setText(chatArea.getText() + System.lineSeparator() + System.lineSeparator() + "Собеседник:" + System.lineSeparator() + "Привет");
        chatArea.positionCaret(chatArea.getText().length());
    }


}

    public void setNetwork(Network network) {
        this.network = network;
    }



    public void Entering(KeyEvent keyEvent) throws IOException {

        if (keyEvent.getCode().getName().equals("Enter")) {

            sendingMessage();


        }

    }

    public void appendMessage(String message) {
        chatArea.appendText(message);
        chatArea.appendText(System.lineSeparator());
    }

}




