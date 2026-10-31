import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MultipleStages extends Application {
  @Override
  public void start(Stage primaryStage) {
    Scene scene = new Scene(new Button("OK"), 200, 250);
    primaryStage.setTitle("MultipleFX");
    primaryStage.setScene(scene);
    primaryStage.setResizable(false);
    primaryStage.show();

    Stage newStage = new Stage();
    newStage.setTitle("New Stage");
    newStage.setScene(new Scene(new Button("Not ok"), 250, 250));
    newStage.setResizable(false);
    newStage.show();
  }

  public static void main(String[] args) {
    Application.launch(args);
  }
}
