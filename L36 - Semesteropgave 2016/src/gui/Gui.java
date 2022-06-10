package gui;


import controller.Controller;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.Bane;

import java.time.LocalTime;

public class Gui extends Application {

    public void start(Stage stage) {
        stage.setTitle("Booking af tennisbaner");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    //-------------------------------------------------------------------

    private final TextField txfDato = new TextField();
    private final ListView<Bane> lvwBaner = new ListView<>();
    private final ListView<LocalTime> lvwTider = new ListView<>();

    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(20));
        pane.setHgap(20);
        pane.setVgap(10);
        pane.setGridLinesVisible(false);

        // Dato
        Label lblDato = new Label("Dato:");
        pane.add(lblDato, 0, 0);
        pane.add(txfDato, 0, 1);

        // Bane
        Label lblBane = new Label("Baner");
        pane.add(lblBane, 0,2);
        pane.add(lvwBaner, 0,3,3,5);
        lvwBaner.setPrefHeight(150);
        lvwBaner.setPrefWidth(200);
        lvwBaner.getItems().setAll(Controller.getBaner());

        ChangeListener<Bane> listener = (ov, o, n) -> this.selectedBaneChanged();
        lvwBaner.getSelectionModel().selectedItemProperty().addListener(listener);

        // Ledige tider
        Label lblTider = new Label("Ledige tider:");
        pane.add(lblTider,1,0);
        pane.add(lvwTider, 1,1, 1,5);
        lvwTider.setPrefHeight(150);
        lvwTider.setPrefWidth(200);
    }


    //-----------------------------------------------------------------------

    private void selectedBaneChanged() {
        this.updateControl();
    }

    private void updateControl() {
        Bane bane = lvwBaner.getSelectionModel().getSelectedItem();
    }
}
