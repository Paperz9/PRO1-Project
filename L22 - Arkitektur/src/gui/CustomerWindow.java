package gui;

import controller.Controller;
import javafx.beans.value.ChangeListener;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.geometry.Insets;
import javafx.geometry.HPos;
import model.Company;
import model.Customer;

public class CustomerWindow extends Stage {
    private final Customer customer; // nullable

    public CustomerWindow(String title, Customer customer) {
        this.initStyle(StageStyle.UTILITY);
        this.initModality(Modality.APPLICATION_MODAL);
        this.setResizable(false);

        this.customer = customer;

        this.setTitle(title);
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        this.setScene(scene);
    }

    //---------------------------------------------------------------------------------------

    private final TextField txfName = new TextField();
    private final ListView<Company> lvwCompany = new ListView<>();
    private final Label lblError = new Label();

    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setGridLinesVisible(false);

        // Name of the customer
        Label lblName = new Label("Name");
        pane.add(lblName, 0, 0);
        pane.add(txfName, 0, 1);
        txfName.setPrefWidth(200);

        // List of Companies
        Label lblCompanies = new Label("Companies");
        pane.add(lblCompanies, 0, 2);
        pane.add(lvwCompany, 0, 3, 1, 5);
        lvwCompany.setPrefWidth(200);
        lvwCompany.setPrefHeight(100);
        lvwCompany.getItems().setAll(Controller.getCompanies());

        ChangeListener<Company> listener = (ov, o, n) -> this.selectedCompany();
        lvwCompany.getSelectionModel().selectedItemProperty().addListener(listener);

        Button btnCancel = new Button("Cancel");
        pane.add(btnCancel, 0, 8);
        GridPane.setHalignment(btnCancel, HPos.LEFT);
        btnCancel.setOnAction(event -> this.cancelAction());

        Button btnOK = new Button("OK");
        pane.add(btnOK, 0, 8);
        GridPane.setHalignment(btnOK, HPos.RIGHT);
        btnOK.setOnAction(event -> this.okAction());

        pane.add(lblError, 0, 9);
        lblError.setStyle("-fx-text-fill: red");

        this.initControls();
    }

    private void initControls() {
        if (customer != null) {
            txfName.setText(customer.getName());
            Company company = customer.getCompany();
            if (company != null) {
                lvwCompany.getSelectionModel().select(company);
            }
            else {
                lvwCompany.getSelectionModel().select(0);
            }
        }
        else {
            txfName.clear();
            lvwCompany.getSelectionModel().select(0);
        }
    }

    // --------------------------------------------------------------------------------------

    private void cancelAction() {
        this.hide();
    }

    private void okAction() {
        String name = txfName.getText().trim();
        if (name.length() == 0) {
            lblError.setText("Name is empty");
            return;
        }
        Company company = lvwCompany.getSelectionModel().getSelectedItem();
        if (customer != null) {
            Controller.createCustomer(name);
            Controller.addCustomerToCompany(customer, company);
        }
    }

    private void selectedCompany() {
        this.initControls();
    }
}
