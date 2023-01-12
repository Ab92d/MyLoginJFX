package com.example.myloginjfx;
import com.example.myloginjfx.SceneSwitcher;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

public class LoginController {
    @FXML
    private TextField txtUsername;

    @FXML
    private TextField txtPassword;

    @FXML
    private Button btnSignIn;

    // A series of checks to discover whether the text fields contain
    // the correct information to proceed.
    // Never advise the user that they have incorrectly used the username
    // as this can be used to bruteforce the use of the correct password.

//    public void switchToLoggedInScene() throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(LoginApplication.class.getResource("loggedIn-View.fxml"));
//        Stage stage = (Stage) btnOK.getScene().getWindow();
//        Scene scene = new Scene(fxmlLoader.load(), 200, 400);
//        stage.setTitle("You're logged in");
//        stage.setScene(scene);
//        stage.show();
//    }
    @FXML
    public void onSignInBtnClick() throws IOException {
        // Both of these values will be hidden naturally
        // so it's not good practice to leave username and password on display
        String username = "admin";
        String password = "PaSSword!!!";

        if(txtUsername.getText().toLowerCase().equals(username) && txtPassword.getText().equals(password)){
//            Alert b;
//            b = new Alert(Alert.AlertType.INFORMATION, "Access Granted!", ButtonType.OK);
//            b.showAndWait();
//            resetTextFields();
            Stage stage = (Stage) btnSignIn.getScene().getWindow();
            SceneSwitcher sceneSwitcher = new SceneSwitcher();
            sceneSwitcher.switchScene(stage,"loggedIn-View.fxml", " ");

        }
        else {
            Alert a;
            a = new Alert(Alert.AlertType.ERROR, "Username or Password not recognised!", ButtonType.OK);
            a.showAndWait();
            resetTextFields();

        }
    }

    // This is one method used to close down the application
    // if someone cancels the login process, they are
    // closing down the entire application.
    @FXML
    public void onCancelButtonClick(){
        Platform.exit();
    }

    // Associated with the view's reset button
    @FXML
    public void onResetButtonClick(){
        resetTextFields();
    }

    // ResetTextFields is recycled throughout the application
    // You could simply add the two lines into onResetButtonClick()
    // and use this, and although this is efficient it does not
    // read well.
    public void resetTextFields(){
        txtUsername.setText("");
        txtPassword.setText("");
        btnSignIn.setDisable(true); // resets the OK button back to reset for continuity
    }

    // OK button set to disabled on view prevents the use of this
    // button until both username and password text fields have been
    // filled.
    public void activateOKButton(){
        if (!txtUsername.getText().isEmpty() && !txtPassword.getText().isEmpty()){
            btnSignIn.setDisable(false);
        }
        else {
            btnSignIn.setDisable(true);
        }
    }



}