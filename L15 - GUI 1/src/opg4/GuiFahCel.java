package opg4;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GuiFahCel extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("Opgave 1 - Gui navn");
        GridPane pane = new GridPane();
        this.initContent(pane);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    private final TextField txfCelsius = new TextField();
    private final TextField txfFahrenheit = new TextField();
    private final TextField txfFullName = new TextField();

    private void initContent(GridPane pane) {
        pane.setGridLinesVisible(false);
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        // Celsius
        Label lblFirstName = new Label("Celsius:");
        pane.add(lblFirstName, 0, 0);
        pane.add(txfCelsius, 0, 1);

        // Fahrenheit
        Label lblLastName = new Label("Fahrenheit:");
        pane.add(lblLastName, 0, 2);
        pane.add(txfFahrenheit, 0, 3);

        // Convert Celsius to Fahrenheit and the other way around
        Button convert = new Button("Convert");
        pane.add(convert, 0, 4);
        convert.setOnAction(event -> this.convertAction());
    }

    private void convertAction() {
        if (txfCelsius.getText().trim().isEmpty()) {
            double fahrenheit = Double.parseDouble(txfFahrenheit.getText());
            double total = (fahrenheit - 32) * 5/9;
            String celsius = String.format("%.2f", total);
            txfCelsius.setText(celsius);
        }
        else if (txfFahrenheit.getText().trim().isEmpty()) {
            double celsius = Double.parseDouble(txfCelsius.getText());
            double total = celsius * 9/5 + 32;
            String fahrenheit = String.format("%.2f", total);
            txfFahrenheit.setText(fahrenheit);
        }
    }
}