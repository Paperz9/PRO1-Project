package gui;

import controller.Controller;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import model.Company;
import model.Customer;
import model.Employee;

import java.util.Optional;

public class CompanyPane extends GridPane {
    private final TextField txfName = new TextField();
    private final TextField txfHours = new TextField();
    private final TextArea txaEmployees = new TextArea();
    private final TextArea txaCustomers = new TextArea();
    private final ListView<Company> lvwCompanies = new ListView<>();

    public CompanyPane() {
        this.setPadding(new Insets(20));
        this.setHgap(20);
        this.setVgap(10);
        this.setGridLinesVisible(false);

        // Companies
        Label lblComp = new Label("Companies");
        this.add(lblComp, 0, 0);
        this.add(lvwCompanies, 0, 1, 1, 4);
        lvwCompanies.setPrefWidth(200);
        lvwCompanies.setPrefHeight(200);
        lvwCompanies.getItems().setAll(Controller.getCompanies());

        ChangeListener<Company> listener = (ov, o, n) -> this.selectedCompanyChanged();
        lvwCompanies.getSelectionModel().selectedItemProperty().addListener(listener);

        // Name of the company
        Label lblName = new Label("Name:");
        this.add(lblName, 1, 1);
        this.add(txfName, 2, 1);
        txfName.setEditable(false);

        // Weekly hours
        Label lblHours = new Label("Weekly Hours:");
        this.add(lblHours, 1, 2);
        this.add(txfHours, 2, 2);
        txfHours.setEditable(false);

        // Employees in the company
        Label lblEmployees = new Label("Employees:");
        this.add(lblEmployees, 1, 3);
        GridPane.setValignment(lblEmployees, VPos.BASELINE);
        lblEmployees.setPadding(new Insets(4, 0, 4, 0));

        this.add(txaEmployees, 2, 3);
        txaEmployees.setPrefWidth(200);
        txaEmployees.setPrefHeight(100);
        txaEmployees.setEditable(false);

        // Customers of the company
        Label lblCustomer = new Label("Customer:");
        this.add(lblCustomer, 1, 4);
        GridPane.setValignment(lblCustomer, VPos.BASELINE);
        lblCustomer.setPadding(new Insets(4, 0, 4, 0));

        this.add(txaCustomers, 2, 4);
        txaCustomers.setPrefWidth(200);
        txaCustomers.setPrefHeight(100);

        HBox hbxButtons = new HBox(40);
        this.add(hbxButtons, 0, 5, 3, 1);
        hbxButtons.setPadding(new Insets(10, 0, 0, 0));
        hbxButtons.setAlignment(Pos.BASELINE_CENTER);

        Button btnCreate = new Button("Create");
        hbxButtons.getChildren().add(btnCreate);
        btnCreate.setOnAction(event -> this.createAction());

        Button btnUpdate = new Button("Update");
        hbxButtons.getChildren().add(btnUpdate);
        btnUpdate.setOnAction(event -> this.updateAction());

        Button btnDelete = new Button("Delete");
        hbxButtons.getChildren().add(btnDelete);
        btnDelete.setOnAction(event -> this.deleteAction());

        Button btnCreateCustomer = new Button("Create Customer");
        hbxButtons.getChildren().add(btnCreateCustomer);
        btnCreateCustomer.setOnAction(event -> this.createCustomerAction());

        if (!lvwCompanies.getItems().isEmpty())
            lvwCompanies.getSelectionModel().select(0);
    }

    // -------------------------------------------------------------------------

    private void createAction() {
        CompanyWindow dialog = new CompanyWindow("Create Company", null);
        dialog.showAndWait();

        // Wait for the modal dialog to close

        lvwCompanies.getItems().setAll(Controller.getCompanies());
        int index = lvwCompanies.getItems().size() - 1;
        lvwCompanies.getSelectionModel().select(index);
    }

    private void updateAction() {
        Company company = lvwCompanies.getSelectionModel().getSelectedItem();
        if (company == null)
            return;

        CompanyWindow dialog = new CompanyWindow("Update Company", company);
        dialog.showAndWait();

        // Wait for the modal dialog to close

        int selectIndex = lvwCompanies.getSelectionModel().getSelectedIndex();
        lvwCompanies.getItems().setAll(Controller.getCompanies());
        lvwCompanies.getSelectionModel().select(selectIndex);
    }

    private void deleteAction() {
        Company company = lvwCompanies.getSelectionModel().getSelectedItem();
        if (company == null)
            return;

        if (company.employeesCount() == 0) {
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.initOwner(this.getScene().getWindow());
            alert.setTitle("Delete Company");
            alert.setHeaderText("Are you sure?");
            Optional<ButtonType> result = alert.showAndWait();

            // wait for the modal dialog to close

            if (result.isPresent() && (result.get() == ButtonType.OK)) {
                Controller.deleteCompany(company);
                lvwCompanies.getItems().setAll(Controller.getCompanies());
                this.updateControls();
            }

        } else {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.initOwner(this.getScene().getWindow());
            alert.setTitle("Delete Company");
            alert.setHeaderText("Can't delete a company that has employees");
            alert.show();

            // wait for the modal dialog to close
        }
    }

    public void createCustomerAction() {
        CustomerWindow dialog = new CustomerWindow("Create Customer", null);
        dialog.showAndWait();

        // Wait for the modal dialog to close

        lvwCompanies.getItems().setAll(Controller.getCompanies());
        int index = lvwCompanies.getItems().size() - 1;
        lvwCompanies.getSelectionModel().select(index);
    }

    // -------------------------------------------------------------------------

    private void selectedCompanyChanged() {
        this.updateControls();
    }

    public void updateControls() {
        Company company = lvwCompanies.getSelectionModel().getSelectedItem();
        if (company != null) {
            txfName.setText(company.getName());
            txfHours.setText("" + company.getHours());
            StringBuilder sb = new StringBuilder();
            for (Employee emp : company.getEmployees()) {
                sb.append(emp).append("\n");
            }
            txaEmployees.setText(sb.toString());
            StringBuilder sb1 = new StringBuilder();
            for (Customer cus : company.getCustomers()) {
                sb1.append(cus).append("\n");
            }
            txaCustomers.setText(sb1.toString());

        } else {
            txfName.clear();
            txfHours.clear();
            txaEmployees.clear();
            txaCustomers.clear();
        }
    }
}
