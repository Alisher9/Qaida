/*
Name: Alisher Sattarbek
Faculty: Engineering
Course and group: 1EN03D
Description: JavaFX Project - Qaida
Teacher: Shamiluulu Shahriar
 */

package controller;

import Main.Signin;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.RequiredFieldValidator;

import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.stage.Stage;


public class signupFXMLConroller implements Initializable {

    @FXML
    private JFXTextField firstName;

    @FXML
    private JFXTextField lastName;

    @FXML
    private JFXPasswordField password;

    @FXML
    private JFXTextField userName;

    Stage stage;
    static Signin s;

    public void main(Signin s) {
        this.s = s;

    }

    private static Connection conn = null;
    private static PreparedStatement stat = null;
    private static String url = "jdbc:mysql://localhost:3306";
    private static String Password = "root";
    private static String login = "root";
    private static String sqlInsert;

    public static void showError(String msg) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Uupps, error!");
        alert.setHeaderText("There is an error happened!");
        alert.setContentText(msg);
        alert.showAndWait();
    }

    public static void showInfo(String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Sign up ");
        alert.setHeaderText("Information");
        alert.setContentText(msg);
        alert.showAndWait();

    }

    public RequiredFieldValidator validator(String msg) {
        RequiredFieldValidator validator = new RequiredFieldValidator();
        validator.setOpacity(10);
        validator.setMessage(msg);
        return validator;
    }
    private static void insert(String login, String password) throws InvocationTargetException {

        sqlInsert = "INSERT INTO Project.new_table2(login,password) VALUES (?, ?)";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Project?autoReconnect=true&useSSL=false", "root", "Alishsdu99");
            stat = conn.prepareStatement(sqlInsert);
            stat.setString(1, login);
            stat.setString(2, password);

            stat.executeUpdate();
            showInfo(login + " has registered");
            s.signUPClose();
            s.signinWindow();
            System.out.println("Connected");
        } catch (SQLException ex) {
            showError(ex.getMessage());
            System.out.println("Does not connected");
        } catch (Error | Exception ex) {
            showError(ex.getMessage());

        } finally {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Project?autoReconnect=true&useSSL=false", "root", "Alishsdu99");
                Statement st = connection.createStatement();
                st.executeUpdate("insert into Project.new_table2 values('', '');");

                connection.close();
                stat.close();
            } catch (SQLException ex) {
                showError(ex.getMessage());
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
    @FXML
    public void regist(ActionEvent event) {
        // We write this handling if you don't enter anything
        try {
            if (firstName.getText().isEmpty() || lastName.getText().isEmpty()
                    | userName.getText().isEmpty() || password.getText().isEmpty()) {

                firstName.validate();
                lastName.validate();
                userName.validate();
                password.validate();


            } else {

                insert(userName.getText().toString(), password.getText().toString());

            }
        } catch (NumberFormatException c) {
            showError(c.getMessage());
            //
        } catch (NullPointerException cc) {
            showError(" Oh sorry, but you must fill all fields");

        } catch (Error | Exception e) {
            showError(e.getMessage());
        }
    }

    // If you press cancel button then it close SignUp window and retrieve Signin window
    @FXML
    public void cancelAction(ActionEvent event) {
        s.signUPClose();
        s.signinWindow();
    }

    // If you don't fill the blanks, then it gives you info that you must enter smthng
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        firstName.getValidators().add(validator("Please write First Name!"));
        lastName.getValidators().add(validator("Please write Last Name!"));
        userName.getValidators().add(validator("Please write User Name!"));
        password.getValidators().add(validator("Please write  Password!"));

    }

}
