/*
Name: Alisher Sattarbek
Faculty: Engineering
Course and group: 1EN03D
Description: JavaFX Project - Qaida
Teacher: Shamiluulu Shahriar
 */

package controller;

import Main.Signin;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;


public class NavigationDrawerFXMLController implements Initializable {

    @FXML
    private Label NameLB;

    @FXML
    private Label usernameLB;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        usernameLB.setText(SigninFXMLController.usernameforHome);
        NameLB.setText(SigninFXMLController.nameforHome);
    }

    @FXML
    void exit(ActionEvent event) {

        Signin.clinicsWindowClose();
    }
}
