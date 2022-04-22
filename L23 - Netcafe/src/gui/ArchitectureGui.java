package gui;

import controller.Controller;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Seat;
import model.Section;


public class ArchitectureGui extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("Netcafe administration");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    // -----------------------------------------------------------------------------

    private final ListView<Seat> lvwSeats = new ListView<>();
    private final TextField txfNumber = new TextField();
    private final ToggleGroup grpSections = new ToggleGroup();
    private final Label lblError = new Label();

    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setGridLinesVisible(false);
        pane.setPrefWidth(300);

        Label lblSeat = new Label("Pladser:");
        pane.add(lblSeat, 0, 0);
        pane.add(lvwSeats, 0,1, 2, 7);
        lvwSeats.setPrefWidth(200);
        lvwSeats.setPrefHeight(200);
        lvwSeats.getItems().setAll(Controller.getSeats());

        Label lblSection = new Label("Område:");
        pane.add(lblSection, 0, 8);
        VBox vbxButtons = new VBox();
        pane.add(vbxButtons, 1, 8);
        vbxButtons.setPadding(new Insets(0, 0, 0, 50));
        //vbxButtons.setAlignment(Pos.CENTER);


        for (Section section : Section.values()) {
            RadioButton rb = new RadioButton();
            vbxButtons.getChildren().add(rb);
            rb.setText(String.valueOf(section));
            rb.setUserData(section);
            rb.setToggleGroup(grpSections);
        }

        Label lblNumber = new Label("Nummer:");
        pane.add(lblNumber, 0, 9);
        pane.add(txfNumber, 1, 9);

        Button btnOpret = new Button("Opret");
        pane.add(btnOpret, 1, 10);
        btnOpret.setOnAction(event -> this.opretAction());

        pane.add(lblError, 1, 11);
        lblError.setStyle("-fx-text-fill: red");
    }

    private void opretAction() {
        RadioButton rb = (RadioButton) grpSections.getSelectedToggle();
        Section section = (Section) rb.getUserData();
        int number = Integer.parseInt(txfNumber.getText().trim());
        Controller.createSeat(number, section);
        lvwSeats.getItems().setAll(Controller.getSeats());
        txfNumber.clear();
    }
}
