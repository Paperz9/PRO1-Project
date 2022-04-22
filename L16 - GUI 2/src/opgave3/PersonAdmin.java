package opgave3;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;

public class PersonAdmin extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("Person administration");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();

        personWindow = new PersonInputWindow("Person information", stage);
    }

    private final ListView<Person> lvwPersons = new ListView<>();
    private final ArrayList<Person> persons = new ArrayList<>();
    private PersonInputWindow personWindow;

    private void initContent(GridPane pane) {
        this.initPersons();
        pane.setGridLinesVisible(false);
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        // Add Person button
        Button addPer = new Button("Add person");
        pane.add(addPer, 1, 1);
        GridPane.setValignment(addPer, VPos.TOP);
        GridPane.setMargin(addPer, new Insets(10, 10, 0, 10));
        addPer.setOnAction(event -> this.addPersonAction());

        // Persons
        Label lblNames = new Label("Persons:");
        pane.add(lblNames, 0, 0);
        pane.add(lvwPersons, 0, 1);
        lvwPersons.setPrefWidth(200);
        lvwPersons.setPrefHeight(200);
        lvwPersons.getItems().setAll(persons);


    }

    private void initPersons() {
        Boolean s = Boolean.parseBoolean(toString());
        persons.add(new Person("Jens", "Lord", s));
        persons.add(new Person("Hans", "Sir", s));
        persons.add(new Person("Pia", "Dame", s));
    }

    private void addPersonAction() {
        personWindow.showAndWait();

        if (personWindow.getActualPerson() != null) {
            persons.add(personWindow.getActualPerson());
            lvwPersons.getItems().setAll(persons);
        }
    }
}
