package lk.itsei.pos.controller;

import com.jfoenix.controls.JFXDatePicker;
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
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import lk.itsei.pos.model.Customer;
import lk.itsei.pos.model.Item;
import lk.itsei.pos.model.PlaceOrderForm;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

public class PlaceOrderFormController implements Initializable {

    @FXML
    private JFXTextField txtOrderId;

    @FXML
    private JFXDatePicker txtOrderDate;

    @FXML
    private JFXTextField txtCustomerId;

    @FXML
    private JFXTextField txtCustomerName;

    @FXML
    private JFXTextField txtItemCode;

    @FXML
    private JFXTextField txtItemDescription;

    @FXML
    private JFXTextField txtQtyOnHand;

    @FXML
    private JFXTextField txtUnitPrice;

    @FXML
    private JFXTextField txtEnterQty;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnRemove;

    @FXML
    private TableView<Item> tblPlaceOrderTable;

    @FXML
    private TableColumn<Item, String> colItemCode;

    @FXML
    private TableColumn<Item, String> colDescription;

    @FXML
    private TableColumn<Item, Integer> colQty;

    @FXML
    private TableColumn<Item, Double> colUnitPrice;

    @FXML
    private TableColumn<?, ?> colTotal;

    @FXML
    private Label lblTotal;

    @FXML
    private Button btnPlaceOrder;

    public static ArrayList<Item> List;

    double total = 0;

    public PlaceOrderFormController() {
    }


    public static ArrayList<Customer> customerList;

    public PlaceOrderFormController(List<Customer> customer_array) {

        customerList = (ArrayList<Customer>) customer_array;
    }

    public PlaceOrderFormController(ArrayList<Item> con_array_item) {
        List = con_array_item;
    }

    public static LinkedList<PlaceOrderForm> placeOrderList = new LinkedList<>();

    @FXML
    void btnRemoveOnAction(ActionEvent event) {

        ObservableList<Item> allItems, singleItem;
        allItems = tblPlaceOrderTable.getItems();
        singleItem = tblPlaceOrderTable.getSelectionModel().getSelectedItems();
        singleItem.forEach(allItems::remove);

    }

    @FXML
    void btnSaveOnAction(ActionEvent event) throws IOException {

        Double quantity = Double.valueOf(txtEnterQty.getText());
        Double unit = Double.valueOf(txtUnitPrice.getText());
        total = quantity * unit;

        Item placeOrderItem = new Item(

                txtItemCode.getText(),
                txtItemDescription.getText(),
                Double.parseDouble(txtUnitPrice.getText()),
                Integer.parseInt(txtEnterQty.getText()),
                total

        );

        new Alert(Alert.AlertType.CONFIRMATION, "Place Order Success !", ButtonType.OK).show();
        tblPlaceOrderTable.getItems().add(placeOrderItem);

        String outputTotal = " " + total;


        lblTotal.setText(outputTotal);


    }

    @FXML
    void enterCustomerId(KeyEvent event) {
        for (Customer c : customerList) {

            if (event.getCode() == KeyCode.ENTER) {

                txtCustomerName.setText(c.getCustomerName());
            }
        }


    }


    @FXML
    void addItemCode(KeyEvent event) {
        for (Item i : List) {

            if (event.getCode() == KeyCode.ENTER) {

                txtItemDescription.setText(i.getDescription());
                txtQtyOnHand.setText(String.valueOf(i.getQuantity()));
                txtUnitPrice.setText(String.valueOf(i.getUnitPrice()));
            }
        }
    }

    @FXML
    void placeOrderOnAction(ActionEvent event) throws IOException {

        String orderId = txtOrderId.getText();
        LocalDate localDate = txtOrderDate.getValue();

        double unitPrice = Double.parseDouble(txtUnitPrice.getText());
        int enterQty = Integer.parseInt(txtEnterQty.getText());

        double totalValue = unitPrice * enterQty;

        if (orderId.equals("") && localDate.equals("")) {

            new Alert(Alert.AlertType.ERROR, "Add Mandatory Feilds", ButtonType.OK).show();
        } else {

            PlaceOrderForm placeOrderForm = new PlaceOrderForm(

                    orderId,
                    localDate,
                    txtCustomerId.getText(),
                    txtCustomerName.getText(),
                    txtItemCode.getText(),
                    txtItemDescription.getText(),
                    Integer.parseInt(txtQtyOnHand.getText()),
                    unitPrice,
                    enterQty,
                    totalValue


            );

            placeOrderList.add(placeOrderForm);

            System.out.println(placeOrderList);
        }

        new MainFormController(placeOrderList);
        Parent root = FXMLLoader.load(this.getClass().getResource("/lk/itsei/pos/view/MainForm.fxml"));
        Scene scene = new Scene(root);
        Stage primartyStage = (Stage) txtCustomerName.getScene().getWindow();
        primartyStage.setScene(scene);

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        txtOrderId.setText("Order001");
        colItemCode.setCellValueFactory(new PropertyValueFactory<>("ItemCode"));
        colDescription.setCellValueFactory(new PropertyValueFactory<>("Description"));
        colQty.setCellValueFactory(new PropertyValueFactory<>("Quantity"));
        colUnitPrice.setCellValueFactory(new PropertyValueFactory<>("UnitPrice"));
        colTotal.setCellValueFactory(new PropertyValueFactory<>("Total"));


    }


}
