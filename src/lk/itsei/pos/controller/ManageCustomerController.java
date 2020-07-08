package lk.itsei.pos.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import lk.itsei.pos.model.Customer;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ManageCustomerController implements Initializable {

    @FXML
    private Button btnAddNewCustomer;

    @FXML
    private JFXTextField txtCustomerId;

    @FXML
    private JFXTextField txtCustomerName;

    @FXML
    private JFXTextField txtCustomerAddress;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnDelete;

    @FXML
    private TableView<Customer> tblCustomerTable;

    @FXML
    private TableColumn<Customer, String> colCustomerId;

    @FXML
    private TableColumn<Customer, String> colCustomerName;

    @FXML
    private TableColumn<Customer, String> colCustomerAddress;

    //create a ArrayList to store data about customer
    public ArrayList<Customer> customerArrayList = new ArrayList<>();

    @FXML
    void saveOnAction(ActionEvent event) throws IOException {

        String customerId = txtCustomerId.getText();
        String customerName = txtCustomerName.getText();
        String customerAddress = txtCustomerAddress.getText();

        //check if above textFeilds are empty or not
        if (customerId.equals("") && customerName.equals("")) {

            new Alert(Alert.AlertType.ERROR, "Please Add Data to Fields", ButtonType.OK).show();

            } else {

            Customer customer = new Customer(

                    txtCustomerId.getText(),
                    txtCustomerName.getText(),
                    txtCustomerAddress.getText()
            );

            //Add data to the table
            tblCustomerTable.getItems().add(customer);
            
            //Assign customer object values to ArrayList
            customerArrayList.add(customer);

            new Alert(Alert.AlertType.CONFIRMATION, "Customer Registration Sucessfully", ButtonType.OK).show();

            System.out.println(customerArrayList);

        }

        new MainFormController(customerArrayList);
        Parent root = FXMLLoader.load(this.getClass().getResource("/lk/itsei/pos/view/MainForm.fxml"));
        Scene scene = new Scene(root);
        Stage primartyStage = (Stage) txtCustomerName.getScene().getWindow();
        primartyStage.setScene(scene);


    }

    @FXML
    void deleteOnAction(ActionEvent event) {

        ObservableList<Customer> allCustomers, singleCustomer;
        allCustomers = tblCustomerTable.getItems();
        singleCustomer = tblCustomerTable.getSelectionModel().getSelectedItems();
        singleCustomer.forEach(allCustomers::remove);

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        colCustomerId.setCellValueFactory(new PropertyValueFactory<>("CustomerId"));
        colCustomerName.setCellValueFactory(new PropertyValueFactory<>("CustomerName"));
        colCustomerAddress.setCellValueFactory(new PropertyValueFactory<>("CustomerAddress"));
        tblCustomerTable.setItems(observableList);

    }

    ObservableList<Customer> observableList = FXCollections.observableArrayList(

            new Customer("C001", "Saman", "ratnapura")

    );
}
