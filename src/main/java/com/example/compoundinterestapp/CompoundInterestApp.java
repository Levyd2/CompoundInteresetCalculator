package com.example.compoundinterestapp;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;



public class CompoundInterestApp extends Application {

    @FXML
    private TextField principalField;

    @FXML
    private TextField rateField;

    @FXML
    private TextField timeFeld;

    @FXML
    private TextField yearsField;

    @FXML
    private Label resultLabel;

    @FXML
    private Button calculateButton;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("calculateur d'intérêts composés");


        //יצירת ממשק
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setHgap(10);
        grid.setVgap(10);

        //שדות קלט
        Label principalLabel = new Label("Montant pricipal (P):");
        TextField principalField = new TextField();
        Label rateLabel = new Label("Taux d'intérêt (%):");
        TextField rateField = new TextField();
        Label timeLabel = new Label("Nombre de calculs cette année (n):");
        TextField timeField = new TextField();
        Label yearsLabel = new Label("Nombre d'années (t):");
        TextField yearsField = new TextField();

        //כפתור לחישוב
        Button calculateButton = new Button("Calcule");
        Label resultLabel = new Label("Resultat:");

        // כפתור ניקוי
        Button clearButton = new Button("nettoyer");

        //הוספת רכיבים לגריד
        grid.add(principalLabel, 0, 0);
        grid.add(principalField, 1, 0);
        grid.add(rateLabel, 0, 1);
        grid.add(rateField, 1, 1);
        grid.add(timeLabel, 0, 2);
        grid.add(timeField, 1, 2);
        grid.add(yearsLabel, 0, 3);
        grid.add(yearsField, 1, 3);
        grid.add(calculateButton, 0, 4);
        grid.add(resultLabel, 1, 4);

        // פעולה בכפתור
        calculateButton.setOnAction(e -> {
            try {
                //קריאת קלט
        double principal = Double.parseDouble(principalField.getText());

        double rate = Double.parseDouble(rateField.getText()) / 100;

        int times = Integer.parseInt(timeField.getText());

        double years = Double.parseDouble(yearsField.getText());

        //חישוב
        double amount = principal * Math.pow((1 + rate / times), times * years);

        // הצגת תוצאה
                resultLabel.setText(String.format("Le montant total est: %.2f", amount));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Veuillez saisir des données valides!");
        }

                });

        //פעולה לכפתור ניקוי שורות
        clearButton.setOnAction(e -> {
            principalField.clear();
            rateField.clear();
            timeField.clear();
            resultLabel.setText("");
        });

        // יצירת סצנה
        Scene scene = new Scene(grid, 400, 250);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Compound Interest Calculator");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}