package network_account;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;

public class RunAccount extends Application {
    public static void main(String[] args){
        launch(args);
    }
    public static Font sofiaPro, sofiaProSmall, bebasKai, bebasKaiMedium;
    @Override
    public void start(Stage primaryStage){
        // Test create account fxml
//        try{
//            Parent root = FXMLLoader.load(RunAccount.class.getResource("/network_fxml/createaccount.fxml"));
//            primaryStage.setTitle("Create New Account");
//            primaryStage.setScene(new Scene(root));
//            primaryStage.setResizable(false);
//            primaryStage.show();
//        } catch(IOException e){
//            System.out.println("Error in using create account fxml");
//        }

//        Test identity fxml
//        try{
//            Parent root = FXMLLoader.load(RunAccount.class.getResource("/network_fxml/identitypane.fxml"));
//            primaryStage.setTitle("IdentityManager Pane");
//            primaryStage.setScene(new Scene(root));
//            primaryStage.setResizable(false);
//            primaryStage.show();
//        } catch(IOException e){
//            System.out.println("Error in using identity fxml");
//        }

////      Test login fxml
//        try {
//            FXMLLoader loader = new FXMLLoader();
//            loader.setLocation(RunAccount.class.getResource("/network_fxml/login.fxml"));
//            Parent root = loader.load();
////            Parent root = FXMLLoader.load(RunAccount.class.getResource("/network_fxml/login.fxml"));
//            primaryStage.setTitle("User Login");
//            primaryStage.setScene(new Scene(root));
//            primaryStage.setResizable(false);
//            primaryStage.show();
//        } catch (IOException e) {
//            System.out.println("Network FXML file not found");
//        }

        IdentityManager identityManager = new IdentityManager();
        identityManager.setStageLogin(primaryStage);
        UserIdentity testIdentity = identityManager.getIdentity();
        System.out.println(testIdentity.getName());
    }
}
