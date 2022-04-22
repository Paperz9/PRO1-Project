package opgave3;


import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class PersonInputWindow extends Stage {

    public PersonInputWindow(String title, Stage owner) {
        this.initOwner(owner);
        this.initStyle(StageStyle.UTILITY);
        this.initModality(Modality.APPLICATION_MODAL);
        this.setMinHeight(100);
        this.setMinWidth(200);
        this.setResizable(false);

        this.setTitle(title);
        GridPane pane = new GridPane();
        this.iniContent(pane);

        Scene scene = new Scene(pane);
        this.setScene(scene);
    }

    private final TextField txfName = new TextField();
    private final TextField txfTitle = new TextField();
    private final CheckBox cbx = new CheckBox();

    private Person actualPerson = null;

    public void iniContent(GridPane pane) {
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        // Name
        Label lblName = new Label("Name:");
        pane.add(lblName, 0, 0);
        pane.add(txfName, 1, 0);

        // Title
        Label lblTitle = new Label("Title:");
        pane.add(lblTitle, 0, 1);
        pane.add(txfTitle, 1, 1);

        // Senior checkbox
        Label lblSenior = new Label("Senior");
        pane.add(lblSenior, 1, 3);
        GridPane.setMargin(lblSenior, new Insets(0,0,0,20));
        pane.add(cbx, 1, 3);

        // Cancel button
        HBox buttonBox = new HBox(20);
        pane.add(buttonBox, 1, 4, 2, 4);
        buttonBox.setPadding(new Insets(10, 10, 0, 10));
        buttonBox.setAlignment(Pos.CENTER);

        Button btnCancel = new Button("Cancel");
        buttonBox.getChildren().add(btnCancel);
        btnCancel.setOnAction(event -> this.cancelAction());

        Button btnOK = new Button("OK");
        buttonBox.getChildren().add(btnOK);
        btnOK.setOnAction(event -> this.okAction());

    }

    private void cancelAction() {
        txfName.clear();
        txfName.requestFocus();
        txfTitle.clear();
        actualPerson = null;
        PersonInputWindow.this.hide();
    }

    private void okAction() {
        String name = txfName.getText().trim();
        String title = txfTitle.getText().trim();
        boolean s = cbx.isSelected();

        if (name.length() > 0 && title.length() > 0) {
            actualPerson = new Person(name, title, s);
            txfName.clear();
            txfTitle.clear();
            txfTitle.requestFocus();
            cbx.setSelected(false);
            PersonInputWindow.this.hide();
        } else {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Add person");
            alert.setHeaderText("Information missing");
            alert.setContentText("Type name and title");
            alert.show();
        }
    }

    public Person getActualPerson() {
        return actualPerson;
    }

    public void clearActualPerson () {
        actualPerson = null;
    }
}
