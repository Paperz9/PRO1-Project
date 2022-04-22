package opgave2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Gui extends Application {

    @Override
    public void start(Stage stage) {
        Pane root = this.initContent();
        Scene scene = new Scene(root);

        stage.setTitle("Shapes with own name");
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

        Rectangle rectangle = new Rectangle(100, 80, 250, 150);
        pane.getChildren().add(rectangle);
        rectangle.setFill(Color.BLUE);
        rectangle.setStroke(Color.BLUE);

        Text text = new Text(120, 165, "Kasper");
        Font font = new Font("Serif", 70);
        text.setFont(font);
        text.setFill(Color.RED);
        pane.getChildren().add(text);


    }
}
