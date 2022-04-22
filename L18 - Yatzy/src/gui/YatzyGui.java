package gui;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import model.YatzyDice;
import javafx.scene.input.MouseEvent;

public class YatzyGui extends Application {
    private YatzyDice dice = new YatzyDice();

    @Override
    public void start(Stage stage) {
        stage.setTitle("Yatzy");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    // -------------------------------------------------------------------------

    // Shows the face values of the 5 dice.
    private final TextField[] txfValues = new TextField[5];
    // Shows the hold status of the 5 dice.
    private final CheckBox[] cbxHolds = new CheckBox[5];
    // Shows the obtained results.
    // For results not set yet, the possible result of 
    // the actual face values of the 5 dice are shown.
    private final TextField[] txfResults = new TextField[15];
    // Shows points in sums, bonus and total.
    private final TextField txfSumSame = new TextField(), txfBonus = new TextField(),
            txfSumOther = new TextField(), txfTotal = new TextField();

    //private final Label lblRolled = new Label();
    private final Button btnRoll = new Button(" Roll ");

    int[] sums = new int[4];

    private void initContent(GridPane pane) {
        // pane.setGridLinesVisible(true);
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);

        // ---------------------------------------------------------------------

        GridPane dicePane = new GridPane();
        pane.add(dicePane, 0, 0);
        // dicePane.setGridLinesVisible(true);
        dicePane.setPadding(new Insets(10));
        dicePane.setHgap(10);
        dicePane.setVgap(10);
        dicePane.setStyle("-fx-border-color: black");

        // add txfValues, chbHolds, lblRolled and btnRoll
        for (int i = 0; i < txfValues.length; i++) {
            TextField values = new TextField();
            dicePane.add(values, i, 0);
            values.setPrefSize(80, 80);
            values.setText("" + 0);
            values.setFont(new Font("Times New Roman", 25));
            values.setEditable(false);
            txfValues[i] = values;
        }

        // Checkbox for hold action
        for (int i = 0; i < cbxHolds.length; i++) {
            CheckBox cbxHold = new CheckBox();
            dicePane.add(cbxHold, i, 1);
            cbxHold.setText("Hold");
            GridPane.setHalignment(cbxHold, HPos.CENTER);
            cbxHolds[i] = cbxHold;
        }

        // Roll Button
        dicePane.add(btnRoll, 0, 2, 5, 2);
        btnRoll.setPrefSize(100, 60);
        GridPane.setHalignment(btnRoll, HPos.CENTER);
        btnRoll.setFont(new Font("Times New Roman", 23));
        btnRoll.setOnAction(event -> this.rollAction());

        // ---------------------------------------------------------------------

        GridPane scorePane = new GridPane();
        pane.add(scorePane, 0, 1);
        // scorePane.setGridLinesVisible(true);
        scorePane.setPadding(new Insets(10));
        scorePane.setVgap(5);
        scorePane.setHgap(10);
        scorePane.setStyle("-fx-border-color: black");
        int w = 50; // width of the text fields
        String [] lblResults1 =
                {
                "1-s", "2-s", "3-s", "4-s", "5-s", "6-s", "One Pair", "Two Pairs", "Three-same",
                "Four-same", "Full House", "Small Str.", "Large Str.", "Chance", "Yatzy"
                };


        // add labels for results, add txfResults,
        for (int i = 0; i < txfResults.length; i++) {
            int gridRowPosition = i;
            if (i >= 6) {
                gridRowPosition += 2;
            }
            Label results1 = new Label(lblResults1[i]);
            scorePane.add(results1, 0, gridRowPosition);
            TextField results = new TextField();
            scorePane.add(results, 1, gridRowPosition);
            results.setText("" + 0);
            results.setPrefWidth(w);
            results.setEditable(false);
            txfResults[i] = results;


        }
        // add labels and text fields for sums, bonus and total.
        Label sum1 = new Label("Sum");
        scorePane.add(sum1, 2, 5);
        scorePane.add(txfSumSame, 3, 5);
        txfSumSame.setPrefWidth(w);
        txfSumSame.setEditable(false);

        // Bonus if over 63 points
        Label bonus = new Label("Bonus");
        scorePane.add(bonus, 2, 6);
        scorePane.add(txfBonus, 3, 6);
        txfBonus.setPrefWidth(w);
        txfBonus.setEditable(false);

        // Sum of last fields
        Label sum2 = new Label("Sum");
        scorePane.add(sum2, 2, 16);
        scorePane.add(txfSumOther, 3, 16);
        txfSumOther.setPrefWidth(w);
        txfSumOther.setEditable(false);

        // Total
        Label total = new Label("TOTAL");
        scorePane.add(total, 2, 17);
        scorePane.add(txfTotal, 3, 17);
        txfTotal.setPrefWidth(w);
        txfTotal.setEditable(false);

        for (int i = 0; i < txfResults.length; i++) {
            txfResults[i].setOnMouseClicked(event -> this.mouseClicked(event));
        }
    }

    // -------------------------------------------------------------------------

    // Create an action method for btnRoll's action.
    // Hint: Create small helper methods to be used in the action method.
    public void rollAction() {
        if (dice.getThrowCount() == 0) {
            resetCbxHold();
        }
        if (dice.getThrowCount() < 3) {
            dice.throwDice(heldDice());
            for (int i = 0; i < txfValues.length; i++) {
                txfValues[i].setText("" + dice.getValues()[i]);
            }
            updateResults();
        }
        if (dice.getThrowCount() == 3) {
            btnRoll.setDisable(true);
        }

    }

    void updateResults() {
        int [] res = dice.getResults();
        for (int i = 0; i < txfResults.length; i++) {
            if (!txfResults[i].isDisabled()) {
                txfResults[i].setText("" + res[i]);
            }
        }
    }

    public boolean[] heldDice() {
        boolean[] heldD = new boolean[cbxHolds.length];
        for (int i = 0; i < cbxHolds.length; i++) {
            if(cbxHolds[i].isSelected()) {
                heldD[i] = true;
                cbxHolds[i].setDisable(true);
            }
        }
        return heldD;
    }

    public void resetCbxHold() {
        for (int i = 0; i < cbxHolds.length; i++) {
            cbxHolds[i].setDisable(false);
            cbxHolds[i].setSelected(false);
        }
    }

    public void resetTxfResult() {
        for (int i = 0; i < txfResults.length; i++) {
            if (!txfResults[i].isDisabled()) {
                txfResults[i].setText("" + 0);
            }
        }
    }

    // -------------------------------------------------------------------------

    // Create a method for mouse click on one of the text fields in txfResults.
    // Hint: Create small helper methods to be used in the mouse click method.
    private void mouseClicked(MouseEvent event) {
        if (dice.getThrowCount() != 0) {
            TextField txf = (TextField) event.getSource();
            txf.setDisable(true);
            btnRoll.setDisable(false);
            dice.resetThrowCount();
            resetCbxHold();

            int tempSum = 0;
            int tempSumOther = 0;
            for (int i = 0; i < txfResults.length; i++) {
                if (txfResults[i].isDisabled()) {
                    if (i < 6) {
                        tempSum += Integer.parseInt(txfResults[i].getText());
                    }
                    if (i >= 6) {
                        tempSumOther += Integer.parseInt(txfResults[i].getText());
                    }
                    sums[0] = tempSum;
                    txfSumSame.setText("" + sums[0]);
                    sums[2] = tempSumOther;
                    txfSumOther.setText("" + sums[2]);
                    if (sums[0] >= 63) {
                        sums[1] = 50;
                        txfBonus.setText("" + sums[1]);
                    }
                    sums[3] = sums[0] + sums[1] + sums[2];
                    txfTotal.setText("" + sums[3]);
                }
            }
            resetTxfResult();
        }
    }
}
