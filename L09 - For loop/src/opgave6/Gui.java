package opgave6;

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
		String tal1 = "0";
		String tal2 = "5";
		String tal3 = "10";
		int y1 = 165; // Start point: (x, y1)
		int y2 = 175; // End point: (x, y2)
		for (int i = 0; i < 11; i++) {
			int x = 10 + i * 15;
			if (i % 5 == 0) {
				int y3 = y1 - 5;
				int y4 = y2 + 5;
				gc.strokeLine(x, y3, x, y4);
				if (i == 0) {
					int y5 = y2 + 15;
					gc.strokeText(tal1, x, y5);
				}
				else if (i == 5) {
					int y6 = y2 + 15;
					gc.strokeText(tal2, x, y6);
				}
				else {
					int y7 = y2 + 15;
					gc.strokeText(tal3, x, y7);
				}
			}
			gc.strokeLine(x, y1, x, y2);
		}
		int x1 = 180;
		int y = 170;
		gc.strokeLine(0, y, x1, y);
		gc.strokeLine(x1 - 10, y - 6, x1, y);
		gc.strokeLine(x1 - 10, y + 6, x1, y);
	}
}
