/*
Name: Alisher Sattarbek
Faculty: Engineering
Course and group: 1EN03D
Description: JavaFX Project - Qaida
Teacher: Shamiluulu Shahriar
 */

package controller;

import Main.Signin;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.RequiredFieldValidator;
import static controller.signupFXMLConroller.showError;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.sql.ResultSet;


public class SigninFXMLController implements Initializable {

    @FXML
    private AnchorPane rootPane;

    @FXML
    private JFXButton signinBTN;

    @FXML
    private JFXButton signupBTN;

    @FXML
    private JFXTextField usernameTF;

    @FXML
    private JFXPasswordField passwordTF;

    private static Connection conn = null;
    private static PreparedStatement stat = null;
    private static String url="jdbc:mysql://localhost:3306";
    private static String Password="root" ;
    private static String login="root";
    private static String sqlInsert;
    ResultSet result;

    public static String usernameforHome="";
    public static String nameforHome="";

    Signin su;
    Stage stage;
    public  void Main( Signin su,Stage stage){
        this.stage=stage;
        this.su = su;

    }

    @FXML
    public void signinAction(ActionEvent event) throws SQLException {
      // Connect to the Database
        String sqlSelect="select * from Project.new_table2 where login = '"+usernameTF.getText().toString()+"' and password='"+passwordTF.getText().toString()+"' ";
       // We use this exception handling to avoid exceptions
        try {
            Thread.sleep(1000);
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Project?autoReconnect=true&useSSL=false", "root", "Alishsdu99");
            stat = conn.prepareStatement(sqlSelect);

            result = stat.executeQuery();

            if (usernameTF.getText().isEmpty() || passwordTF.getText().isEmpty()) {

                usernameTF.validate();
                passwordTF.validate();
            }

            else{

                if (result.next()){
                    if ((result.getString("login")).equals(usernameTF.getText().toString())
                            && (result.getString("password")).equals(passwordTF.getText().toString())) {
                        su.clinicsWindow();
                        su.signInClose();
                    }
                }
                else if (!result.next()) {
                    showError("Sorry,but your username or password is invalid, please try again");
                }
            }
        } catch (SQLException | NullPointerException | ClassNotFoundException | InterruptedException r) {
            showError(r.getMessage());
        } finally{
            try {
            conn.close();
            stat.close();
        }
        catch (SQLException rr) {
            showError(rr.getMessage());
        }
        }
    }

    @FXML
    public void signupAction(ActionEvent event) {
        try {
            su.signInClose();
            su.signupWindow();
        } catch (Exception ignored) {
        }
    }
    public void initialize(URL url, ResourceBundle rb) {

    }

}
