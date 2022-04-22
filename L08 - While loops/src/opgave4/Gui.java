package opgave4;

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

		// Figur 1
//		 int x = 100;
//		 int y = 100;
//		 int r = 20;
//		 while (r <= 100) {
//			 gc.strokeOval(x - r, y - r, 2 * r, 2 * r);
//			 r = r + 20;
//		 }

		// Figur 2
//		 int x = 20;
//		 int y = 100;
//		 int r = 20;
//		 while (x <= 90) {
//			 gc.strokeOval(x - r, y - r, 2 * r, 2 * r);
//			 x = x + 10;
//			 r = r + 10;
//		 }

		// Figur 3
		 int x = 20;
		 int y = 20;
		 int figurLength = 160;
		 int figurHeight = 70;
		 while (figurLength >= 20 && x <= 170) {
			 gc.strokeOval(x, y, figurLength, figurHeight);
			 figurLength = figurLength - 20;
			 x = x + 10;

		 }
	}
}
