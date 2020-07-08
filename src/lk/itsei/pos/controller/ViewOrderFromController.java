package lk.itsei.pos.controller;


import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.KeyEvent;
import lk.itsei.pos.model.PlaceOrderForm;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;

public class ViewOrderFromController {

    @FXML
    private JFXTextField txtOrderId;

    @FXML
    private JFXDatePicker txtOrderDate;

    @FXML
    private JFXTextField txtCustomerID;

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
    private JFXTextField txtqty;

    @FXML
    private TableView<?> tblviewOrderTable;

    @FXML
    private TableColumn<?, ?> colItemCode;

    @FXML
    private TableColumn<?, ?> colDescription;

    @FXML
    private TableColumn<?, ?> colQty;

    @FXML
    private TableColumn<?, ?> colUnitPrice;

    @FXML
    private TableColumn<?, ?> colTotal;

    @FXML
    private Label lblTotal;

    public ViewOrderFromController() {
    }

    @FXML
    void enterOrderId(KeyEvent event) {


    }

    public void setInitData(String orderID, double orderTotal, String customerId, String customerName, String date){

        txtOrderId.setText(orderID);
        lblTotal.setText(String.valueOf(orderTotal));
        txtCustomerID.setText(customerId);
        txtCustomerName.setText(customerName);
        txtOrderDate.setAccessibleText(date);

    }
}
