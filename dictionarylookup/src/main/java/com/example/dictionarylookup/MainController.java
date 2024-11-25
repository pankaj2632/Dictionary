package com.example.dictionarylookup;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;

public class MainController {

    @FXML
    private TextField wordInput;

    @FXML
    private Button searchButton;

    @FXML
    private ListView<String> resultsList;

    @FXML
    private Label errorLabel;

    private static final String DICTIONARY_API_URL = "https://api.dictionaryapi.dev/api/v2/entries/en/";

    @FXML
    public void initialize() {
        // Set up event handling for double-click on the ListView
        resultsList.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2) { // Open detail view on double-click
                String selectedWord = resultsList.getSelectionModel().getSelectedItem();
                if (selectedWord != null) {
                    openDetailView(selectedWord);
                }
            }
        });
    }

    @FXML
    public void searchWord() {
        String word = wordInput.getText().trim();
        if (word.isEmpty()) {
            errorLabel.setText("Please enter a word to search.");
            return;
        }

        errorLabel.setText(""); // Clear any previous error messages
        resultsList.getItems().clear(); // Clear previous results

        try {
            // Make an API call to fetch word definitions
            URL url = new URL(DICTIONARY_API_URL + word);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                InputStreamReader reader = new InputStreamReader(connection.getInputStream());
                Gson gson = new Gson();

                Word[] words = gson.fromJson(reader, Word[].class);
                reader.close();

                for (Word wordObj : words) {
                    for (Meaning meaning : wordObj.getMeanings()) {
                        for (Definition definition : meaning.getDefinitions()) {
                            String displayText = meaning.getPartOfSpeech() + ": " + definition.getDefinition();
                            resultsList.getItems().add(displayText);
                        }
                    }
                }

                if (resultsList.getItems().isEmpty()) {
                    errorLabel.setText("No definitions found.");
                }
            } else {
                errorLabel.setText("Error: Unable to fetch definitions. Please try again.");
            }
        } catch (IOException | JsonSyntaxException e) {
            errorLabel.setText("Error: Unable to fetch definitions. Please check your internet connection.");
            e.printStackTrace();
        }
    }

    private void openDetailView(String selectedDefinition) {
        if (selectedDefinition != null) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/dictionarylookup/DetailsView.fxml"));
                Parent detailRoot = loader.load();

                // Pass data to DetailController
                DetailController detailController = loader.getController();
                detailController.setWordDetails(selectedDefinition);

                // Initialize the stage
                Stage detailStage = new Stage();
                detailStage.setTitle("Word Details");
                detailStage.setScene(new Scene(detailRoot, 600, 400)); // Adjust size as needed
                detailStage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
