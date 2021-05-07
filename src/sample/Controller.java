package sample;

import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.util.Duration;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Controller {

    @FXML
    TextArea mainTextArea;

    @FXML
    TextField mainTextField;

    @FXML
    Button sendBtn;

    @FXML
    public void sendBtnClicked() {

        sendMessage();

    }

    @FXML
    public void onMouseEntered() {

        final FadeTransition fadeIn = new FadeTransition(Duration.millis(200));
        fadeIn.setNode(sendBtn);
        fadeIn.setToValue(1);
        sendBtn.setOnMouseEntered(e -> fadeIn.playFromStart());
        sendBtn.setOpacity(1);
    }

    @FXML
    public void onMouseExited() {

        final FadeTransition fadeOut = new FadeTransition(Duration.millis(200));
        fadeOut.setNode(sendBtn);
        fadeOut.setToValue(0.75);
        sendBtn.setOnMouseExited(e -> fadeOut.playFromStart());
        sendBtn.setOpacity(0.75);

    }

    @FXML
    private void handleTextFieldAction(KeyEvent event) {

        if(mainTextField.getText().equals("<Введите сообщение>")){
            mainTextField.setText("");
        }

        if (event.getCode() == KeyCode.ENTER) sendMessage();

    }

    private void sendMessage() {

        if(!mainTextField.getText().equals("") && !mainTextField.getText().equals("<Введите сообщение>")) {
            Date sendDate = new Date();
            SimpleDateFormat formatForDateNow = new SimpleDateFormat("dd.MM.yyyy'г. ' hh:mm:ss");
            mainTextArea.appendText("Отправлено: " + formatForDateNow.format(sendDate) + "\n" + mainTextField.getText() + "\n");
            mainTextField.setText("");
            sendBtn.setOpacity(0.5);
        }else if(mainTextField.getText().equals("<Введите сообщение>")){
            mainTextField.setText("<Введите сообщение>");
        }else{
            mainTextField.setText("<Введите сообщение>");
        }

    }


}

