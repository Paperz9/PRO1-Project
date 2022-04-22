package opgave1;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class PersonAdmin extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("ListView Demo1");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    private final TextField txfName = new TextField();
    private final TextField txfTitle = new TextField();
    private final ListView<Person> lvwPersons = new ListView<>();
    private final ArrayList<Person> persons = new ArrayList<>();
    private final CheckBox cbx = new CheckBox();

    private void initContent(GridPane pane) {
        this.initPersons();
        pane.setGridLinesVisible(false);
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

        // Add Person button
        Button addPer = new Button("Add person");
        pane.add(addPer, 2, 3);
        addPer.setOnAction(event -> this.addPersonAction());

        // Persons
        Label lblNames = new Label("Persons:");
        pane.add(lblNames, 0, 4);
        pane.add(lvwPersons, 1, 4, 1, 6);
        lvwPersons.setPrefWidth(200);
        lvwPersons.setPrefHeight(200);
        lvwPersons.getItems().setAll(persons);

        ChangeListener<Person> listener = (ov, oldPerson, newPerson) -> this.selectionChanged();
        lvwPersons.getSelectionModel().selectedItemProperty().addListener(listener);

    }
    private void selectionChanged() {
        Person newPerson = lvwPersons.getSelectionModel().getSelectedItem();
        if (newPerson != null) {
            txfName.setText(newPerson.getName());
            txfTitle.setText(newPerson.getTitle());
        }
        else {
            txfName.clear();
            txfTitle.clear();
        }
    }

    private void initPersons() {
        Boolean s = Boolean.parseBoolean(toString());
        persons.add(new Person("Jens", "Lord", s));
        persons.add(new Person("Hans", "Sir", s));
        persons.add(new Person("Pia", "Dame", s));
    }

    private void addPersonAction() {
        String name = txfName.getText().trim();
        String title = txfTitle.getText().trim();
        if (name.length() > 0) {
            Person p = new Person(name, title, cbx.isSelected());
            persons.add(p);
            lvwPersons.getItems().setAll(persons);
        }
        // Opgave 2
        else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Add person");
            alert.setHeaderText("No name typed");
            alert.setContentText("Type the name of the person");
            alert.show();
        }
    }
}
