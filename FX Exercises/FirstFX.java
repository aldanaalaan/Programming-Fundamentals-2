import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FirstFX
 */
public class FirstFX extends Application {

    @Override
    public void start(Stage primaryStage) {
        Button btnOk = new Button("OK");
        Scene scene = new Scene(btnOk, 200, 250);
        primaryStage.setTitle("MyJavaFX");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

}