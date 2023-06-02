package com.example.gestiongames;

import com.example.gestiongames.entities.Game;
import com.example.gestiongames.service.GameService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class ModifierController {
    public TextField nomTextField;

    @FXML
    private TextField nomDeveloppeurTextField;
    @FXML
    private TextField anneeDeSortieTextField;
    @FXML
    private TextField plateformeTextField;
    @FXML
    private TextField genreTextField;
    @FXML
    private Button enregistrerButton;
    @FXML
    private Button back;

    private GameService gameService;
    private Game gameToUpdate;

    public ModifierController() {
        // Initialize the GameService
        gameService = new GameService();
    }

    public void setGameToUpdate(Game game) {
        gameToUpdate = game;
        populateFields();
    }

    private void populateFields() {
        nomTextField.setText(gameToUpdate.getNom());
        nomDeveloppeurTextField.setText(gameToUpdate.getNomDeveloppeur());
        anneeDeSortieTextField.setText(Integer.toString(gameToUpdate.getAnneeDeSortie()));
        plateformeTextField.setText(gameToUpdate.getPlateforme());
        genreTextField.setText(gameToUpdate.getGenre());
    }

    @FXML
    private void handleModifierButtonAction() {
        if (gameToUpdate != null) {
            // Update the game with the modified values
            gameToUpdate.setNom(nomTextField.getText());
            gameToUpdate.setNomDeveloppeur(nomTextField.getText());
            gameToUpdate.setAnneeDeSortie(Integer.parseInt(anneeDeSortieTextField.getText()));
            gameToUpdate.setPlateforme(plateformeTextField.getText());
            gameToUpdate.setGenre(genreTextField.getText());

            // Call the update method of GameService
            gameService.update(gameToUpdate);
            System.out.println("modification reussite !!");

           /* // Close the current window
            System.out.println("modification reussite !!");
            Stage stage = (Stage) enregistrerButton.getScene().getWindow();
            stage.close();*/
        }

    }
    @FXML
    private void back(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("affichage.fxml"));
        Parent affichagePage = loader.load();
        Scene affichageScene = new Scene(affichagePage);
        Stage primaryStage = (Stage) back.getScene().getWindow();
        primaryStage.setScene(affichageScene);
        primaryStage.show();
    }

}
