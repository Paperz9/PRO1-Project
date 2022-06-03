package gui;

import controller.Controller;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import model.Kamp;

import javax.imageio.IIOException;
import java.io.File;

public class Gui extends Application {

    public void start(Stage stage) {
        stage.setTitle("Administration af spiller deltagelse");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    //--------------------------------------------------------------------------------

    private final ListView<Kamp> lvwKamp = new ListView<>();
    private final TextField txfSpilleSted = new TextField();
    private final TextField txfSpilleDato = new TextField();
    private final TextField txfSpilleTid = new TextField();

    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(20));
        pane.setHgap(20);
        pane.setVgap(10);
        pane.setGridLinesVisible(false);

        // Kamp
        Label lblKamp = new Label("Kampe:");
        pane.add(lblKamp, 0, 0);
        pane.add(lvwKamp, 0,1,1,3);
        lvwKamp.setPrefWidth(200);
        lvwKamp.setPrefHeight(150);
        lvwKamp.getItems().setAll(Controller.getKamp());

        ChangeListener<Kamp> listener = (ov, o, n) -> this.selectedKampChanged();
        lvwKamp.getSelectionModel().selectedItemProperty().addListener(listener);

        // Spillested
        Label lblSpilleSted = new Label("Spillested:");
        pane.add(lblSpilleSted,2,0);
        pane.add(txfSpilleSted, 3,0);

        // Spilledato
        Label lblSpilleDato = new Label("Spilledato:");
        pane.add(lblSpilleDato,2,1);
        pane.add(txfSpilleDato, 3,1);

        // Spillested
        Label lblSpilleTid = new Label("Spillested:");
        pane.add(lblSpilleTid,2,2);
        pane.add(txfSpilleTid, 3,2);

        // Buttons
        HBox hBox = new HBox();
        pane.add(hBox,3,3);
        Button btnOpret = new Button("Opret");
        Button btnOpdater = new Button("Opdater");
        hBox.getChildren().add(btnOpret);
        hBox.getChildren().add(btnOpdater);
        hBox.setSpacing(10);
        btnOpret.setOnAction(event -> this.opretKampAction());
        btnOpdater.setOnAction(event -> this.opdaterKampAction());

        Button btnLavFil = new Button("Lav fil");
        pane.add(btnLavFil, 3,4);
        btnLavFil.setOnAction(event -> this.lavFilAction());
    }

    private void selectedKampChanged() {
        this.updateControl();
    }

    private void opretKampAction() {
        OpretKampWindow dialog = new OpretKampWindow("Opret Kamp", null);
        dialog.showAndWait();

        // Wait for the modal dialog to close

        lvwKamp.getItems().setAll(Controller.getKamp());
        int index = lvwKamp.getItems().size() - 1;
        lvwKamp.getSelectionModel().select(index);
    }

    private void opdaterKampAction() {
        Kamp kamp = lvwKamp.getSelectionModel().getSelectedItem();
        if (kamp == null)
            return;

        OpretKampWindow dialog = new OpretKampWindow("Opdater Kamp", kamp);
        dialog.showAndWait();

        // Wait for the modal dialog to close

        int selectIndex = lvwKamp.getSelectionModel().getSelectedIndex();
        lvwKamp.getItems().setAll(Controller.getKamp());
        lvwKamp.getSelectionModel().select(selectIndex);
    }

    private void lavFilAction() {
        Kamp kamp = lvwKamp.getSelectionModel().getSelectedItem();
        String fileName = kamp.getSted();
        kamp.spillerHonorar(kamp,fileName);
    }

    public void updateControl() {
        Kamp kamp = lvwKamp.getSelectionModel().getSelectedItem();
        if (kamp != null) {
            txfSpilleSted.setText(kamp.getSted());
            txfSpilleDato.setText(kamp.getDatoFormatted());
            txfSpilleTid.setText(kamp.getTidFormatted());
        }
        else {
            txfSpilleSted.clear();
            txfSpilleDato.clear();
            txfSpilleTid.clear();
        }
    }
}
