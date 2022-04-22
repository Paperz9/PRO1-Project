package opg3;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GuiInvestment extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("Opgave 3");
        GridPane pane = new GridPane();
        this.initContent(pane);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    private final TextField txfInvest = new TextField();
    private final TextField txfYears = new TextField();
    private final TextField txfInterest = new TextField();
    private final TextField txfFutureValue = new TextField();

    private void initContent(GridPane pane) {
        pane.setGridLinesVisible(false);
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        // Investment
        Label lblInvest = new Label("Investment:");
        pane.add(lblInvest, 0, 1);
        pane.add(txfInvest, 1,1);

        // Years
        Label lblYears = new Label("Years:");
        pane.add(lblYears, 0, 2);
        pane.add(txfYears, 1, 2);

        // Interest
        Label lblInterest = new Label("Interest (%):");
        pane.add(lblInterest, 0, 3);
        pane.add(txfInterest, 1, 3);

        // Future value
        Label lblFutureValue = new Label("Future Value:");
        pane.add(lblFutureValue, 0, 5);
        pane.add(txfFutureValue, 1, 5);

        // Calculate Button
        Button cal = new Button("Calculate");
        pane.add(cal, 1, 4);
    //    GridPane.setMargin(cal, new Insets(0, 0, 0, 40));
        GridPane.setHalignment(cal, HPos.CENTER);
        cal.setOnAction(event -> this.calAction());
    }

    private void calAction() {
        int invest = Integer.parseInt(txfInvest.getText().trim());
        int years = Integer.parseInt(txfYears.getText().trim());
        double interest = Double.parseDouble(txfInterest.getText().trim()) / 100;
        double FutureValue = invest * Math.pow(1 + interest, years);
        String total = String.format("%.2f", FutureValue);
        txfFutureValue.setText(total);
    }
}
