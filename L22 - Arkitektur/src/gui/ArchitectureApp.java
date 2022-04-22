package gui;

import controller.Controller;
import javafx.application.Application;
import model.Company;
import model.Customer;
import model.Employee;

public class ArchitectureApp {

    public static void main(String[] args) {
        initStorage();
        Application.launch(ArchitectureGui.class);
    }

    public static void initStorage() {
        Company ibm = Controller.createCompany("IBM", 37);
        Company amd = Controller.createCompany("AMD", 40);
        Company sled = Controller.createCompany("SLED", 45);
        Controller.createCompany("Vector", 32);

        Employee bob = Controller.createEmployee("Bob Dole", 210, 2001);
        Controller.addEmployeeToCompany(bob, ibm);

        Employee alice = Controller.createEmployee("Alice Schmidt", 250, 1990);
        Controller.addEmployeeToCompany(alice, ibm);

        Employee george = Controller.createEmployee("George Down", 150, 1992);
        Controller.addEmployeeToCompany(george, amd);

        Employee rita = Controller.createEmployee("Rita Uphill", 300, 2019);
        Controller.addEmployeeToCompany(rita, sled);

        Controller.createEmployee("John Doe", 100, 1989);

        Customer kasper = Controller.createCustomer("Kasper");
        Controller.addCustomerToCompany(kasper, ibm);

        Customer per = Controller.createCustomer("Per");
        Controller.addCustomerToCompany(per, ibm);

        Customer niels = Controller.createCustomer("Niels");
        Controller.addCustomerToCompany(niels, amd);
        Controller.addCustomerToCompany(niels, ibm);
    }
}
