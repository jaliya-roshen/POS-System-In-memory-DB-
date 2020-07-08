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
import lk.itsei.pos.model.Item;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ManageItemController implements Initializable {


    @FXML
    private JFXTextField txtItemCode;

    @FXML
    private JFXTextField txtDescription;

    @FXML
    private JFXTextField txtUnitPrice;

    @FXML
    private JFXTextField txtquantity;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnDelete;

    @FXML
    private TableView<Item> tblItemTable;

    @FXML
    private TableColumn<Item, String> colItemCode;

    @FXML
    private TableColumn<Item, String> colDescription;

    @FXML
    private TableColumn<Item, Double> colPrice;

    @FXML
    private TableColumn<Item, Integer> colQuantity;

    public static ArrayList<Item> itemArrayList = new ArrayList<>();

    @FXML
    void deleteOnAction(ActionEvent event) {

        ObservableList<Item> allItems, singleItem;
        allItems = tblItemTable.getItems();
        singleItem = tblItemTable.getSelectionModel().getSelectedItems();
        singleItem.forEach(allItems::remove);
    }

    @FXML
    void saveOnAction(ActionEvent event) throws IOException {

        String itemCode = txtItemCode.getText();
        String description = txtDescription.getText();
        Double price = Double.parseDouble(txtUnitPrice.getText());
        Integer quantity = Integer.valueOf(txtquantity.getText());


        if (itemCode.equals("") && (price == null)) {

            new Alert(Alert.AlertType.ERROR, "Please Add Data to Fields", ButtonType.OK).show();

        } else {

            Item item = new Item(

                    txtItemCode.getText(),
                    txtDescription.getText(),
                    Double.parseDouble(txtUnitPrice.getText()),
                    Integer.parseInt(txtquantity.getText())
            );

            tblItemTable.getItems().add(item);
            itemArrayList.add(item);

            new Alert(Alert.AlertType.CONFIRMATION, "Item Added Successfully", ButtonType.OK).show();

            txtItemCode.setText(itemCode);
            txtDescription.setText(description);
            txtUnitPrice.setText(String.valueOf(price));
            txtquantity.setText(String.valueOf(quantity));

            System.out.println(itemArrayList);

        }

        new MainFormController(itemArrayList);
        Parent root = FXMLLoader.load(this.getClass().getResource("/lk/itsei/pos/view/MainForm.fxml"));
        Scene scene = new Scene(root);
        Stage primartyStage = (Stage) txtquantity.getScene().getWindow();
        primartyStage.setScene(scene);
    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {

        colItemCode.setCellValueFactory(new PropertyValueFactory<>("ItemCode"));
        colDescription.setCellValueFactory(new PropertyValueFactory<>("Description"));
        colPrice.setCellValueFactory(new PropertyValueFactory<>("UnitPrice"));
        colQuantity.setCellValueFactory(new PropertyValueFactory<>("Quantity"));
        tblItemTable.setItems(observableItemList);
    }

    ObservableList<Item> observableItemList = FXCollections.observableArrayList(

            new Item("I001", "HPLaptop", 0.0, 2));


}
