package opg2;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GuiTal extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("Opgave 2");
        GridPane pane = new GridPane();
        this.initContent(pane);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    private final TextField txfTal = new TextField();

    private void initContent(GridPane pane) {
        pane.setGridLinesVisible(false);
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        Label lblTal = new Label("Number:");
        pane.add(lblTal, 0, 1);
        pane.add(txfTal, 1,1);
        txfTal.setPrefColumnCount(3);

        Button inc = new Button("Inc");
        pane.add(inc, 2, 1);
        GridPane.setMargin(inc, new Insets(5, 5, 30, 5));
        inc.setOnAction(event -> this.incAction());

        Button dec = new Button("Dec");
        pane.add(dec, 2, 1);
        GridPane.setMargin(dec, new Insets(30, 5, 0, 5));
        dec.setOnAction(event -> this.decAction());
    }

    private void incAction() {
        int inc = Integer.parseInt(txfTal.getText()) + 1;
        txfTal.setText(Integer.toString(inc));
    }

    private void decAction() {
        int dec = Integer.parseInt(txfTal.getText()) - 1;
        txfTal.setText(Integer.toString(dec));
    }
}
