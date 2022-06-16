package gui;

import controller.Controller;
import javafx.application.Application;

public class GuiApp {
    public static void main(String[] args) {
        Controller.initStorage();
        Application.launch(Gui.class);
    }
}
