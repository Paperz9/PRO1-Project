package opgave1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Gui extends Application {

	@Override
	public void start(Stage stage) {
		GridPane root = this.initContent();
		Scene scene = new Scene(root);

		stage.setTitle("Loops");
		stage.setScene(scene);
		stage.show();
	}

	private GridPane initContent() {
		GridPane pane = new GridPane();
		Canvas canvas = new Canvas(200, 200);
		pane.add(canvas, 0, 0);
		this.drawShapes(canvas.getGraphicsContext2D());
		return pane;
	}

	// ------------------------------------------------------------------------

	private void drawShapes(GraphicsContext gc) {
		// Replace the statement here with your code.
//		gc.strokeLine(10, 10, 150, 80);

		// draw an arrowhead at (100, 75) and (100, 125)
		// opgave 1.c-d
		int v1 = 8; // Arrow height
		int v2 = 20; // Arrow Length

		// opgave 1.a

		int x = 100;
		int y = 75;
		gc.strokeLine(x, y, x + v2, y - v1);
		gc.strokeLine(x, y, x + v2, y + v1);

		y = 125;
		gc.strokeLine(x, y, x + v2, y - v1);
		gc.strokeLine(x, y, x + v2, y + v1);

		// opgave 1.b

		x = 20;
		y = 50;
		gc.strokeLine(x, y, x + v2, y - v1);
		gc.strokeLine(x, y, x + v2, y + v1);
	}
}
