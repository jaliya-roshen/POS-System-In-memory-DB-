package lk.itsei.pos.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import lk.itsei.pos.model.Customer;
import lk.itsei.pos.model.Item;
import lk.itsei.pos.model.PlaceOrderForm;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MainFormController {

    @FXML
    private ImageView ImgCustomer;

    @FXML
    private ImageView ImgItem;

    @FXML
    private ImageView ImgSearchOrder;

    @FXML
    private ImageView ImgPlaceOrder;

    public static ArrayList<Item> itemList;
    public static ArrayList<Customer> customerList;
    public static LinkedList<PlaceOrderForm> placeOrderList;

    public MainFormController(){}

    public MainFormController(List<Customer> con_array_customer){

        customerList = (ArrayList<Customer>) con_array_customer;
    }

    public MainFormController(ArrayList<Item> con_array_item){

        itemList = con_array_item;
    }

    public MainFormController(LinkedList <PlaceOrderForm> con_array_placeOrder) {

        placeOrderList =  con_array_placeOrder;
    }

    @FXML
    void btnPlaceOrderClick(MouseEvent event) throws IOException {

        new PlaceOrderFormController(customerList);
        new PlaceOrderFormController(itemList);
        Parent root = FXMLLoader.load(this.getClass().getResource("/lk/itsei/pos/view/PlaceOrderForm.fxml"));
        Scene scene = new Scene(root);
        Stage primartyStage = (Stage) ImgCustomer.getScene().getWindow();
        primartyStage.setScene(scene);


    }

    @FXML
    void customerMouseClick(MouseEvent event) throws IOException {

        Parent root = FXMLLoader.load(this.getClass().getResource("/lk/itsei/pos/view/ManageCustomerForm.fxml"));
        Scene scene = new Scene(root);
        Stage primartyStage = (Stage) ImgCustomer.getScene().getWindow();
        primartyStage.setScene(scene);
    }

    @FXML
    void itemMouseClick(MouseEvent event) throws IOException {

        Parent root = FXMLLoader.load(this.getClass().getResource("/lk/itsei/pos/view/ManageItemForm.fxml"));
        Scene scene = new Scene(root);
        Stage primartyStage = (Stage) ImgCustomer.getScene().getWindow();
        primartyStage.setScene(scene);

    }

    @FXML
    void orderMouseClick(MouseEvent event) throws IOException {

        new SearchOrderFormController(placeOrderList);
        Parent root = FXMLLoader.load(this.getClass().getResource("/lk/itsei/pos/view/SearchOrderForm.fxml"));
        Scene scene = new Scene(root);
        Stage primartyStage = (Stage) ImgCustomer.getScene().getWindow();
        primartyStage.setScene(scene);


    }


}
