
/*
Name: Alisher Sattarbek
Faculty: Engineering
Course and group: 1EN03D
Description: JavaFX Project - Qaida
Teacher: Shamiluulu Shahriar
 */
package Main;
//importing needed libraries
import controller.ClinicsMainWindowController;
import controller.SigninFXMLController;
import controller.SubClinicFxmlDocumentController;
import controller.signupFXMLConroller;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class Signin extends Application {
    // We create 5 stages
    static Stage stage1, stage2, stage3, stage4, stage5;
    public String clinicName = "";

    @Override
    public void start(Stage stage) throws Exception {
        this.stage1 = stage;
        signinWindow();
    }
    public void signinWindow() {
        // We use exception handling to avoid exceptions
        try {
            // We write the path of FXML code
            FXMLLoader loader = new FXMLLoader(Signin.class.getResource("/view/FXMLSignInDocument.fxml"));
            // After that we create AnchorPane and add some changes
            AnchorPane pane = loader.load();
            SigninFXMLController controller = loader.getController();
            stage2 = new Stage();
            controller.Main(this, stage2);
            Scene scene = new Scene(pane);
            stage2.setTitle("Sign in");
            scene.getStylesheets().add(Signin.class.getResource("/style/Stylesheet.css").toExternalForm());
            stage2.setResizable(true);
            stage2.setScene(scene);
            stage2.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
      // Signin window
    public void signInClose() {

        stage2.close();
    }
     // Let's consider Signup window
    public void signupWindow() {
        // We use exception handling to avoid this exceptions below
        try {
            FXMLLoader loader = new FXMLLoader(Signin.class.getResource("/view/signUpfxmlDocument.fxml"));
            AnchorPane pane = loader.load();
            signupFXMLConroller controller = loader.getController();
            controller.main(this);
            stage3 = new Stage();
            Scene scene = new Scene(pane);
            scene.getStylesheets().add(Signin.class.getResource("/style/Stylesheet.css").toExternalForm());
            stage3.setTitle("Register");
            stage3.setResizable(false);
            stage3.setScene(scene);
            stage3.initStyle(StageStyle.UNDECORATED);
            stage3.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void signUPClose() {
        stage3.close();
    }

    public void clinicsWindow() {
        // We use exception handling to avoid this exceptions below
        try {
            FXMLLoader loader = new FXMLLoader(Signin.class.getResource("/view/FXMLhomeDocument.fxml"));
            AnchorPane pane = loader.load();
            ClinicsMainWindowController controller = loader.getController();
            stage4 = new Stage();
            controller.main(this, stage4);
            Scene scene = new Scene(pane);
            stage4.setTitle("Home");
            stage4.setResizable(true);
            stage4.setScene(scene);
            stage4.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void clinicsWindowClose() {
        stage4.close();
    }
      // When we open SubClinicWindow
    public void SubClinicWindow() {
        // We use exception handling to avoid this exceptions below
        try {
            FXMLLoader loader = new FXMLLoader(Signin.class.getResource("/view/dentalFxmlDocument.fxml"));
            AnchorPane pane = loader.load();
            SubClinicFxmlDocumentController controller = loader.getController();
            stage5 = new Stage();
            controller.main(this, stage5);
            Scene scene = new Scene(pane);
            scene.getStylesheets().add(Signin.class.getResource("/style/StyleSheet.css").toExternalForm());
            stage5.setTitle(clinicName + " Clinic");
            stage5.setFullScreen(false);
            stage5.setResizable(false);
            stage5.setScene(scene);

            stage5.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
     // When we close SubClinicWndow
    public void SubClinicWindowClose() {
        stage5.close();
    }

}
