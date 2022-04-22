package opg5;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GuiAddName extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("Gui Demo TextArea");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    // -------------------------------------------------------------------------

    private final TextField txfName = new TextField();
    private final TextArea txaDescription = new TextArea();

    private void initContent(GridPane pane) {
        pane.setGridLinesVisible(false);

        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        // Name
        Label lblName = new Label("Name");
        pane.add(lblName, 0, 0);
        pane.add(txfName, 0, 1);

        // Add name
        Button btnFill = new Button("Add name");
        pane.add(btnFill, 0, 2);
        GridPane.setMargin(btnFill, new Insets(0, 0, 0, 65));
        btnFill.setOnAction(event -> this.addNameAction());

        pane.add(txaDescription, 0, 3);
        txaDescription.setPrefRowCount(7);
        txaDescription.setPrefWidth(200);
        txaDescription.setEditable(false);
  //      txaDescription.setDisable(true);
    }

    // -------------------------------------------------------------------------

    public void addNameAction() {
        txaDescription.appendText(this.getName());
    }

    public String getName() {
        StringBuilder name = new StringBuilder();
        name.append(txfName.getText() + "\n");
        return name.toString();
//        String name = txfName.getText() + "\n";
//        return name;
    }
}
