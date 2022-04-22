package opgave6;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
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
        Circle circle = new Circle(300, 70, 30);
        pane.getChildren().add(circle);
        circle.setFill(Color.YELLOW);
        circle.setStroke(Color.BLACK);

        Rectangle rectangle = new Rectangle(20, 250, 80, 100);
        pane.getChildren().add(rectangle);
        rectangle.setFill(Color.RED);
        rectangle.setStroke(Color.RED);

        Rectangle rectangle1 = new Rectangle(30, 270, 30, 30);
        pane.getChildren().add(rectangle1);

        Polygon polygon = new Polygon(0, 250, 60, 200, 120, 250);
        pane.getChildren().add(polygon);
        polygon.setFill(Color.GREEN);

        Line line = new Line(0, 350, 350, 350);
        pane.getChildren().add(line);


    }
}
