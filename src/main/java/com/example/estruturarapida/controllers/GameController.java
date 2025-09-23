package com.example.estruturarapida.controllers;

import com.example.estruturarapida.views.GameView;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * Controller: connects UI with GameView and TimeManager.
 */

public class GameController {

    @FXML private Label lblWord;
    @FXML private TextField txtInput;
    @FXML private Label lblTimer;
    @FXML private Label lblLevel;
    @FXML private Label lblMessage;

    private GameView view;
    private TimeManager timer;

    public void initialize() {
        view = new GameView();
        startLevel();
    }

    /**
     * called from Scene Builder → btnValidate → On Action = onValidate
     */
    @FXML
    private void onValidate() {
        validateInput();
    }

    /**
     * called from Scene Builder → btnRestart → On Action = onRestart
     */
    @FXML
    private void onRestart() {
        restartGame();
    }

    /**
     * Makes the TextField validate with Enter
     */
    @FXML
    private void onEnter() {
        validateInput();
    }

    private void startLevel() {
        view.startLevel();
        lblWord.setText(view.getCurrentWord());
        txtInput.clear();
        txtInput.requestFocus();
        lblLevel.setText("Level: " + view.getLevel());

        if (timer != null) timer.stop();
        timer = new TimeManager(view.getTimeForLevel(), this::onTimeUp);
        timer.start(sec -> lblTimer.setText(sec + " s"));
    }

    private void validateInput() {
        timer.stop();
        boolean success = view.validateInput(txtInput.getText());
        if (success) {
            showSuccess();
        } else {
            showFail("Incorrect - Game Over");
        }
    }

    private void onTimeUp() {
        boolean success = view.validateInput(txtInput.getText());
        if (success) {
            showSuccess();
        } else {
            showFail("Time's up - Game Over");
        }
    }

    private void showSuccess() {
        lblMessage.setStyle("-fx-text-fill: green; -fx-font-weight: bold;");
        lblMessage.setText("¡Correct! Next Level");
        startLevel();
    }

    private void showFail(String reason) {
        lblMessage.setStyle("-fx-text-fill: red; -fx-font-weight: bold;");
        lblMessage.setText(reason + " - Levels completed: " + (view.getLevel() - 1));
    }

    private void restartGame() {
        view.reset();
        startLevel();
    }

}