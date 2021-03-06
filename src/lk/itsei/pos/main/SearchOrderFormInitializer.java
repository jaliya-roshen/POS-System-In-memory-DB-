package lk.itsei.pos.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SearchOrderFormInitializer extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {


        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/lk/itsei/pos/view/SearchOrderForm.fxml"));
        Parent root = loader.load();
        Scene mainScene = new Scene(root);
        primaryStage.setScene(mainScene);
        primaryStage.setTitle("search Order");
        primaryStage.setResizable(false);
        primaryStage.show();
        primaryStage.centerOnScreen();

    }
}
