/*
Name: Alisher Sattarbek
Faculty: Engineering
Course and group: 1EN03D
Description: JavaFX Project - Qaida
Teacher: Shamiluulu Shahriar
 */

package controller;

import Main.Signin;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

@SuppressWarnings("CssUnknownTarget")
public class ClinicsMainWindowController implements Initializable {

    Signin signin;
    Stage stage;
    public static String tableName = "";

    public void main(Signin signin, Stage stage) {
        this.signin = signin;
        this.stage = stage;
    }

    @FXML
    private Pane backgroundPane;

    @FXML
    private JFXDrawer drawer;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        try {
            backgroundPane.setStyle(" -fx-background-image: url(\"/Users/alishersattarbek/Downloads/src/image.png;");

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/navigationDrawerFXML.fxml"));
            AnchorPane pane = loader.load();
            drawer.setSidePane(pane);

            pane.addEventHandler(MouseEvent.MOUSE_PRESSED, (e) -> {
                if (drawer.isShown()) {
                    drawer.close();
                } else {
                    drawer.open();
                }

            });
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    @FXML
    public void OpenClinicWindow0(ActionEvent event) {

            try {

                tableName = "Internalmedicine";
                signin.clinicName = "Internal Medicine";
                signin.SubClinicWindow();
                signin.clinicsWindowClose();
            } catch (Exception ex) {
            }
        }

    @FXML
    public void OpenClinicWindow1(ActionEvent event) {
        try {
            tableName = "Physiotherapy";
            signin.clinicName = "Physiotherapy";
            signin.SubClinicWindow();
            signin.clinicsWindowClose();

        } catch (Exception ex) {
        }
    }

    @FXML
    public void OpenClinicWindow2(ActionEvent event) {
        try {
            tableName = "Neurology";
            signin.clinicName = "Neurology";
            signin.SubClinicWindow();
            signin.clinicsWindowClose();

        } catch (Exception ex) {
        }
    }

    @FXML
    public void OpenClinicWindow3(ActionEvent event) {
        try {
            tableName = "Cardiology";
            signin.clinicName = "cardiology";
            signin.SubClinicWindow();
            signin.clinicsWindowClose();

        } catch (Exception ex) {
        }
    }

    @FXML
    public void OpenClinicWindow4(ActionEvent event) {
        try {
            tableName = "Earnose";
            signin.clinicName = "Ear and Nose";
            signin.SubClinicWindow();
            signin.clinicsWindowClose();

        } catch (Exception ex) {
        }
    }

    @FXML
    public void OpenClinicWindow5(ActionEvent event) {
        try {
            tableName = "Orthopedics";
            signin.clinicName = "Orthopedics";
            signin.SubClinicWindow();
            signin.clinicsWindowClose();

        } catch (Exception ex) {
        }
    }

    @FXML
    public void OpenClinicWindow6(ActionEvent event) {
        try {
            tableName = "Dentalclinic";
            signin.clinicName = "Dental";
            signin.SubClinicWindow();
            signin.clinicsWindowClose();

        } catch (Exception ex) {
        }
    }

    @FXML
    public void OpenClinicWindow7(ActionEvent event) {
        try {
            tableName = "Dermatology";
            signin.clinicName = "Dermatology";
            signin.SubClinicWindow();
            signin.clinicsWindowClose();

        } catch (Exception ex) {
        }
    }

    @FXML
    public void OpenClinicWindow8(ActionEvent event) {
        try {
            tableName = "Ophthalmology";
            signin.clinicName = "Ophthalmology";
            signin.SubClinicWindow();
            signin.clinicsWindowClose();

        } catch (Exception ex) {
        }
    }
}
