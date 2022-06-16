package gui;

import controller.Controller;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.Medarbejder;
import model.Vagt;
import storage.Storage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Gui extends Application {

    public void start(Stage stage) {
        stage.setTitle("");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    //--------------------------------------------------------------------------

    private final ListView<Medarbejder> lvwMedarbejder = new ListView<>();
    private final ListView<Vagt> lvwVagter = new ListView<>();
    private final TextArea txaValgteVagter = new TextArea();

    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(20));
        pane.setHgap(20);
        pane.setVgap(10);
        pane.setGridLinesVisible(false);

        // Medarbejdere
        Label lblMedarbejdere = new Label("Alle medarbejdere");
        pane.add(lblMedarbejdere,0,0);
        pane.add(lvwMedarbejder,0,1, 1, 4);
        lvwMedarbejder.setPrefHeight(200);
        lvwMedarbejder.setPrefWidth(200);
        ChangeListener<Medarbejder> listener1 = (obs, o, n) -> this.tildelVagtAction();

        // Vagter
        Label lblVagter = new Label("Alle vagter");
        pane.add(lblVagter, 1,0);
        pane.add(lvwVagter,1,1,1,4);
        lvwVagter.setPrefWidth(200);
        lvwVagter.setPrefHeight(200);
        ChangeListener<Vagt> listener = (obs, o, n) -> this.selectedChanged();
        lvwVagter.getSelectionModel().selectedItemProperty().addListener(listener);

        // Valgt vagt
        Label lblVagtInfo = new Label("Valgt vagt");
        pane.add(lblVagtInfo,2,0);
        pane.add(txaValgteVagter,2,1,1,4);
        txaValgteVagter.setPrefWidth(200);
        txaValgteVagter.setPrefHeight(200);

        // Tildel vagt
        Button btnTildelVagt = new Button("Tildel vagt");
        pane.add(btnTildelVagt,1,5);
        btnTildelVagt.setOnAction(event -> this.tildelVagtAction());

        // Udskriv vagt til fil
        Button btnUdskriv = new Button("Udskriv vagt til fil");
        pane.add(btnUdskriv,2, 5);
        btnUdskriv.setOnAction(event -> this.udskrivAction());

        this.fillMedarbejdere();
        this.fillVagter();
    }

    //--------------------------------------------------------------------------

    private void selectedChanged() {
        Vagt selected = lvwVagter.getSelectionModel().getSelectedItem();
        if (selected != null)
            this.fillVagtInfo(selected);
    }

    private void fillMedarbejdere() {
        lvwMedarbejder.getItems().clear();
        lvwMedarbejder.getItems().addAll(Storage.getMedarbejdere());
    }

    private void fillVagter() {
        lvwVagter.getItems().clear();
        lvwVagter.getItems().addAll(Storage.getVagter());
    }

    private void fillVagtInfo(Vagt vagt) {
        txaValgteVagter.clear();
        txaValgteVagter.appendText("Navn: " + vagt.getNavn() + "\n");
        txaValgteVagter.appendText("Fra: " + vagt.getFormattedTidFra() + "\n");
        txaValgteVagter.appendText("Til: " + vagt.getFormattedTidTil() + "\n");
        txaValgteVagter.appendText("Tilknyttede medarbejdere:\n");
        for (Medarbejder m : vagt.getMedarbejdere()) {
            txaValgteVagter.appendText(m.getNavn() + " ");
        }
    }

    private void tildelVagtAction() {
        Medarbejder medarbejder = lvwMedarbejder.getSelectionModel().getSelectedItem();
        Vagt vagt = lvwVagter.getSelectionModel().getSelectedItem();
        if (medarbejder != null) {
            try {
                Controller.addMedarbejderTilVagt(medarbejder,vagt);
                this.fillVagtInfo(vagt);
            }
            catch (RuntimeException ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Tildel vagt");
                alert.setHeaderText("Vagt kan ikke tildeles");
                alert.setContentText(medarbejder.getNavn() + " er allerede tilknyttet denne vagt");
                alert.showAndWait();
            }
        }
    }

    // del af S10 (10 p)
    private void udskrivAction() {
        Vagt vagt = lvwVagter.getSelectionModel().getSelectedItem();
        String pathName = "Semesteropgave 2022/src/storage/";
        String fileName = vagt.getNavn();
        File newFile = new File(pathName + fileName + ".txt");
        try (PrintWriter printWriter = new PrintWriter(newFile)) {
            printWriter.println("Navn: " + vagt.getNavn());
            printWriter.println("Fra: " + vagt.getFormattedTidFra());
            printWriter.println("Til: " + vagt.getFormattedTidTil());
            printWriter.println("Tilknyttede medarbejdere:");
            for (Medarbejder m : vagt.getMedarbejdere()) {
                printWriter.print(m.getNavn() + " ");
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
