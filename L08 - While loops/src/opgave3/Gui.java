package opgave3;

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
//		int x1 = 20; // start point: (x1,y1)
//		int y1 = 190;
//		int x2 = 180; // end point: (x2,y2)
//		int y2 = 10;
//		while (x1 <= 180) {
//			gc.strokeLine(x1, y1, x2, y2);
//			x1 = x1 + 40;
//			x2 = x2 - 40;
//		}

		// Figur 1
//		int x = 20;
//		int y1 = 10;
//		int y2 = 190;
//		while (x <= 180) {
//			gc.strokeLine(x, y1, x, y2);
//			x = x + 40;
//		}

		// Figur 2
//		int x1 = 10;
//		int x2 = 190;
//		int y = 20;
//		while (y <= 180) {
//			gc.strokeLine(x1, y, x2, y);
//			y = y + 40;
//		}

		// Figur 3
		int x1 = 95;
		int x2 = 105;
		int y = 20;
		while (y <= 180 && x1 <= 180) {
			gc.strokeLine(x1, y, x2, y);
			x1 = x1 + 20;
			x2 = x2 - 20;
			y = y + 40;
		}
	}
}
