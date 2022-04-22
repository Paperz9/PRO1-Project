package opg6;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GuiEx6 extends Application {

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
    private final TextArea txaStudentInfo = new TextArea();
    private final TextField txfName = new TextField();
    private final TextField txfAge = new TextField();
    private final CheckBox cbx = new CheckBox();


    private void initContent(GridPane pane) {
        pane.setGridLinesVisible(false);

        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(5);

        // Student info box
        Label lblStudentInfo = new Label("Student info:");
        pane.add(lblStudentInfo, 0, 0);
        pane.add(txaStudentInfo, 0, 1, 2, 1);
        txaStudentInfo.setPrefRowCount(7);
        txaStudentInfo.setPrefWidth(270);
        txaStudentInfo.setEditable(false);

        // Name
        Label lblName = new Label("Name:");
        pane.add(lblName, 0, 2);
        pane.add(txfName, 1, 2);
        GridPane.setMargin(txfName, new Insets(0, 0, 0, 0));

        // Age
        Label lblAge = new Label("Age:");
        pane.add(lblAge, 0, 3);
        pane.add(txfAge, 1, 3);
        GridPane.setMargin(txfAge, new Insets(0, 20, 0, 0));

        // Increase age by 1
        Button incAge = new Button("inc");
        pane.add(incAge, 1, 3);
        GridPane.setMargin(incAge, new Insets(0, 0, 0, 10));
    }
}
