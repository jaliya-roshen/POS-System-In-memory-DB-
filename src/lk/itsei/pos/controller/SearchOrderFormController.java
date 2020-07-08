package lk.itsei.pos.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import lk.itsei.pos.model.PlaceOrderForm;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ResourceBundle;

public class SearchOrderFormController implements Initializable {


    @FXML
    private JFXTextField txtOrderID;

    @FXML
    private TableView<PlaceOrderForm> tblOrderTable;

    @FXML
    private TableColumn<PlaceOrderForm, String> colOrderId;

    @FXML
    private TableColumn<PlaceOrderForm, LocalDate> colOrderDate;

    @FXML
    private TableColumn<PlaceOrderForm, String> colCustomerId;

    @FXML
    private TableColumn<PlaceOrderForm, String> colCustomerName;

    @FXML
    private TableColumn<PlaceOrderForm, Double> colTotal;


    public static LinkedList<PlaceOrderForm> placeList;

    final ObservableList<PlaceOrderForm> data = FXCollections.observableArrayList();

    public SearchOrderFormController() {
    }

    public SearchOrderFormController(LinkedList<PlaceOrderForm> con_array_list) {

        placeList = con_array_list;
    }

    @FXML
    void inputOrderId(KeyEvent event) throws IOException {

        for (PlaceOrderForm p : placeList) {

            if (event.getCode() == KeyCode.ENTER) {

                PlaceOrderForm entry = new PlaceOrderForm(

                        p.getOrderId(),
                        p.getOrderDate(),
                        p.getCustomerId(),
                        p.getCustomerName(),
                        p.getTotal()
                );
                data.add(entry);


            }
        }


    }

    @FXML
    void onRowSelect(MouseEvent event) throws IOException {

        PlaceOrderForm selectedItem = tblOrderTable.getSelectionModel().getSelectedItem();
        FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("/lk/itsei/pos/view/ViewOrderForm.fxml"));
        Parent root =(Parent)fxmlLoader.load();
        ViewOrderFromController controller = fxmlLoader.getController();
        controller.setInitData(selectedItem.getOrderId(),selectedItem.getTotal(),selectedItem.getCustomerId(),selectedItem.getCustomerName(), String.valueOf(selectedItem.getOrderDate()));
        Scene scene = new Scene(root);
        ((Stage)tblOrderTable.getScene().getWindow()).setScene(scene);

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        colOrderId.setCellValueFactory(new PropertyValueFactory<>("OrderId"));
        colOrderDate.setCellValueFactory(new PropertyValueFactory<>("OrderDate"));
        colCustomerId.setCellValueFactory(new PropertyValueFactory<>("CustomerId"));
        colCustomerName.setCellValueFactory(new PropertyValueFactory<>("CustomerName"));
        colTotal.setCellValueFactory(new PropertyValueFactory<>("Total"));
        tblOrderTable.setItems(data);
    }
}
