package opgave3;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class Gui extends Application {

    @Override
    public void start(Stage stage) {
        Pane root = this.initContent();
        Scene scene = new Scene(root);

        stage.setTitle("Shapes");
        stage.setScene(scene);
        stage.show();
    }

    private Pane initContent() {
        Pane pane = new Pane();
        pane.setPrefSize(400, 400);
        this.drawShapes(pane);
        return pane;
    }

    // ------------------------------------------------------------------------

    private void drawShapes(Pane pane) {
        Circle circle = new Circle(140, 140, 100);
        pane.getChildren().add(circle);
        circle.setFill(Color.WHITE);
        circle.setStroke(Color.BLACK);

        Circle circle1 = new Circle(100, 110,10);
        pane.getChildren().add(circle1);
        circle1.setFill(Color.WHITE);
        circle1.setStroke(Color.BLACK);

        Circle circle2 = new Circle(180, 110,10);
        pane.getChildren().add(circle2);
        circle2.setFill(Color.WHITE);
        circle2.setStroke(Color.BLACK);

        int Y = 175;
        Line line = new Line(100, Y, 190, Y);
        pane.getChildren().add(line);


    }
}
