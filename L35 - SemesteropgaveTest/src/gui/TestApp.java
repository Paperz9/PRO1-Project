package gui;

import controller.Controller;

public class TestApp {
    public static void main(String[] args) {
        Controller.initStorage();
        Gui.launch(Gui.class);
    }
}
