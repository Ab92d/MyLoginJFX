package com.example.myloginjfx;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;


public class LoginController {
    @FXML
    private TextField txtUsername;

    @FXML
    private TextField txtPassword;

    @FXML
    private Button btnSignIn;



    /* if statement checks to see whether the text fields contain
       the correct credentials */
    @FXML
    // verification method. checks to see if the username and password entered matches
    // the ones set
    public void onSignInBtnClicked() throws IOException {
        // username and password I've set
        String username = "Amy";
        String password = "123";
        // if the username and password is correct, the scene switches to loggedIn-view
        if(txtUsername.getText().equals(username) && txtPassword.getText().equals(password)){
            Stage stage = (Stage) btnSignIn.getScene().getWindow();
            SceneSwitcher sceneSwitcher = new SceneSwitcher();
            sceneSwitcher.switchScene(stage,"loggedIn-View.fxml", " You're logged in!");

        }
        // if the username and password is incorrect an alert pops up
        else {
            Alert a;
            a = new Alert(Alert.AlertType.ERROR, "Username or Password not recognised!", ButtonType.OK);
            a.showAndWait();
            resetTextFields();
        }
    }

 //   closes down the entire application when cancel is clicked
    @FXML
    public void onExitButtonClicked(){
        Platform.exit();
    }

    // this method resets the text in the text field
    public void resetTextFields(){
        txtUsername.setText("");
        txtPassword.setText("");
        btnSignIn.setDisable(true); // resets the OK button back to reset for continuity
    }

    // using the resetTextFields method, when the user clicks the reset button
    // the text field is cleared
    @FXML
    public void onResetButtonClicked(){
        resetTextFields();
    }


    /* Sign in button set to disabled on view prevents the use of this
        button until both username and password text fields have been
        filled.*/
    public void activateOKButton(){
        if (!txtUsername.getText().isEmpty() && !txtPassword.getText().isEmpty()){
            btnSignIn.setDisable(false);
        }
        else {
            btnSignIn.setDisable(true);
        }
    }



}