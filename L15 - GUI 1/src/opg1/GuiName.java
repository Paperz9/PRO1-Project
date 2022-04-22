package opg1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GuiName extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("Opgave 1 - Gui navn");
        GridPane pane = new GridPane();
        this.initContent(pane);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    private final TextField txfFirstName = new TextField();
    private final TextField txfLastName = new TextField();
    private final TextField txfFullName = new TextField();

    private void initContent(GridPane pane) {
        pane.setGridLinesVisible(false);
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        // First name
        Label lblFirstName = new Label("First name:");
        pane.add(lblFirstName, 0, 0);
        pane.add(txfFirstName, 0, 1);

        // Last name
        Label lblLastName = new Label("Last name:");
        pane.add(lblLastName, 1, 0);
        pane.add(txfLastName, 1, 1);

        // Full name
        Label lblFullName = new Label("Full name:");
        pane.add(lblFullName, 0, 2);
        pane.add(txfFullName, 0,  3, 2, 1);

        // Button to combine first and last name
        Button combine = new Button("Combine");
        pane.add(combine, 0, 4);
        combine.setOnAction(event -> this.combineAction());
    }

    private void combineAction() {
        String fullName = txfFirstName.getText().trim() + " " + txfLastName.getText().trim();
        txfFullName.setText(fullName);
    }
}
