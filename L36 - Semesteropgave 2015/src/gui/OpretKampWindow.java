package gui;

import controller.Controller;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Kamp;

import java.time.LocalDate;
import java.time.LocalTime;

public class OpretKampWindow extends Stage {
    private final Kamp kamp; // nullable

    public OpretKampWindow(String title, Kamp kamp) {
        this.initStyle(StageStyle.UTILITY);
        this.initModality(Modality.APPLICATION_MODAL);
        this.setResizable(false);

        this.kamp = kamp;

        this.setTitle(title);
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        this.setScene(scene);
    }

    //--------------------------------------------------------------------------------

    private final TextField txfSpilleSted = new TextField();
    private final DatePicker dpDato = new DatePicker();
    private final TextField txfSpilleTid = new TextField();
    private final Label lblError = new Label();

    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setGridLinesVisible(false);

        Label lblSpilleSted = new Label("Spille sted:");
        pane.add(lblSpilleSted, 0,0);
        pane.add(txfSpilleSted,0,1);

        Label lblDpDato = new Label("Dato:");
        pane.add(lblDpDato,0,2);
        pane.add(dpDato,0,3);
        dpDato.setEditable(false);

        Label lblSpilleTid = new Label("Tid(eg. 14:00)*:");
        pane.add(lblSpilleTid,0,4);
        pane.add(txfSpilleTid,0,5);

        HBox hBox = new HBox();
        pane.add(hBox,0,6);
        Button btnOk = new Button("Ok");
        Button btnCancel = new Button("Cancel");
        hBox.getChildren().add(btnOk);
        hBox.getChildren().add(btnCancel);
        hBox.setSpacing(10);
        btnOk.setOnAction(event -> this.okAction());
        btnCancel.setOnAction(event -> this.cancelAction());

        pane.add(lblError, 0,7);
        lblError.setStyle("-fx-text-fill: red");

        this.initControls();
    }

    private void initControls() {
        if (kamp != null) {
            txfSpilleSted.setText(kamp.getSted());
            dpDato.setValue(kamp.getDato());
            txfSpilleTid.setText(kamp.getTidFormatted());
        }
        else {
            txfSpilleSted.clear();
            txfSpilleTid.clear();
        }
    }

    private void okAction() {
        String name = txfSpilleSted.getText().trim();
        if (name.length() == 0) {
            lblError.setText("Name is empty!");
            return;
        }
        // Dato og tid
        String[] arrOfTid = txfSpilleTid.getText().trim().split(":");
        int hour = Integer.parseInt(arrOfTid[0]);
        int min = Integer.parseInt(arrOfTid[1]);
        LocalTime tid = LocalTime.of(hour,min);

        if (kamp != null)
            // Opdater den valgte kamp
            Controller.opdaterKamp(kamp,name,dpDato.getValue(),tid);
        else {
            // Opretter en ny kamp
            Controller.opretKamp(name,dpDato.getValue(),tid);
        }
        this.hide();
    }

    private void cancelAction() {
        this.hide();
    }
}
