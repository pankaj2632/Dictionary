package com.example.dictionarylookup;

import javafx.fxml.FXML;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class DetailController {

    @FXML
    private Label wordLabel;

    @FXML
    private TextArea wordDetailsText;

    /**
     * This method is called by MainController to set the details
     * of the selected word in the DetailView.
     *
     * @param wordDetails The detailed information of the selected word.
     */
    public void setWordDetails(String wordDetails) {
        // Set the word's details into the TextArea
        wordDetailsText.setText(wordDetails);
    }

    /**
     * Handle the "Back" button click to close the current stage.
     */
    @FXML
    public void handleBackButton() {
        Stage stage = (Stage) wordDetailsText.getScene().getWindow(); // Get the current stage
        stage.close(); // Close the stage
    }
}
