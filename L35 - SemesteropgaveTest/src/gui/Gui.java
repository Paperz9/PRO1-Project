package gui;

import controller.Controller;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.Festival;
import model.Frivillig;
import model.Job;

public class Gui extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("Festival");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    private final ListView<Festival> lvwFestival = new ListView<>();
    private final ListView<Job> lvwJobs = new ListView<>();
    private final ListView<Frivillig> lvwFrivillige = new ListView<>();
    private final TextArea txaTildelteJobs = new TextArea();

    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setGridLinesVisible(false);

        GridPane festivalPane = new GridPane();
        pane.add(festivalPane, 0, 0);
        festivalPane.setPadding(new Insets(10));
        festivalPane.setHgap(10);
        festivalPane.setVgap(10);
        festivalPane.add(lvwFestival, 0,1,1,2);
        lvwFestival.setPrefHeight(200);
        lvwFestival.setPrefWidth(200);
        lvwFestival.getItems().setAll(Controller.getFestivaler());
        if(!lvwFestival.getItems().isEmpty()){
            lvwFestival.getSelectionModel().select(0);
            updateControls();
        }

        ChangeListener<Festival> listener = (ov, o, n) -> this.selectedConferenceChanged();
        lvwFestival.getSelectionModel().selectedItemProperty().addListener(listener);

        GridPane jobsPane = new GridPane();
        pane.add(jobsPane, 1, 0);
        jobsPane.setPadding(new Insets(10));
        jobsPane.setHgap(10);
        jobsPane.setVgap(10);
        jobsPane.add(lvwJobs, 0,1,1,2);
        lvwJobs.setPrefHeight(300);
        lvwJobs.setPrefWidth(400);

        GridPane frivilligePane = new GridPane();
        pane.add(frivilligePane, 2, 0);
        frivilligePane.setPadding(new Insets(10));
        frivilligePane.setHgap(10);
        frivilligePane.setVgap(10);
        frivilligePane.add(lvwFrivillige, 0,1,1,2);
        lvwFrivillige.setPrefHeight(200);
        lvwFrivillige.setPrefWidth(200);


    }

    private void selectedConferenceChanged() {
        this.updateControls();
    }

    public void updateControls() {
        if(!lvwFestival.getItems().containsAll(Controller.getFestivaler())) {
            lvwFestival.getItems().setAll(Controller.getFestivaler());
        }
        Festival festival = lvwFestival.getSelectionModel().getSelectedItem();

        if(festival != null){
            lvwJobs.getItems().setAll(Controller.getJobs(festival));
        }
        lvwFrivillige.getItems().setAll(Controller.getFrivillige());
    }
}
