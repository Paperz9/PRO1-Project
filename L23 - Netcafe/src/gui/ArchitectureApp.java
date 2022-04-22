package gui;

import controller.Controller;

public class ArchitectureApp {
    public static void main(String[] args) {
        Controller.initStorage();
        ArchitectureGui.launch(ArchitectureGui.class);
    }
}
