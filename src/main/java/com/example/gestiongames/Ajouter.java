package com.example.gestiongames;

import com.example.gestiongames.dao.impl.GameDaoImpl;
import com.example.gestiongames.entities.Game;
import com.example.gestiongames.service.GameService;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class Ajouter {

    @FXML
    private TextField nameField;
    @FXML
    private TextField developerField;
    @FXML
    private TextField platformField;
    @FXML
    private TextField genreField;
    @FXML
    private TextField releaseYearField;

    @FXML
    private VBox root;

    @FXML
    private TableView gameTable;
    @FXML
    private Button back;

    @FXML
    public void initialize2(ActionEvent event)throws IOException {
            String nom = nameField.getText();
            String nomDeveloppeur = developerField.getText();
            String platforme = platformField.getText();
            String genre = genreField.getText();
            int anneeDeSortie = Integer.parseInt(releaseYearField.getText());


            GameService gameservice1 = new GameService();

            // Ajout d'un jeu
            Game newGame = new Game();

            newGame.setNom(nom);
            newGame.setNomDeveloppeur(nomDeveloppeur);
            newGame.setAnneeDeSortie(anneeDeSortie);
            newGame.setPlateforme(platforme);
            newGame.setGenre(genre);

            gameservice1.save(newGame);

            System.out.println("bien ajoute !!");








        // Effacer les champs du formulaire après l'ajout
            nameField.clear();
            developerField.clear();
            platformField.clear();
            genreField.clear();
            releaseYearField.clear();



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
