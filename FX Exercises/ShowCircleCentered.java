import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.paint.Color;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;


public class ShowCircleCentered extends Application {
  @Override
  public void start(Stage primaryStage) {
    Pane pane = new StackPane();

    Circle circle = new Circle();
    circle.setRadius(50);
    circle.setFill(Color.WHITE.darker());
    circle.setStroke(Color.PURPLE.brighter());
    circle.setStrokeWidth(3);

    circle.setCenterX(100);
    circle.setCenterY(100);

    circle.centerXProperty().bind(pane.widthProperty().divide(2));
    circle.centerYProperty().bind(pane.heightProperty().divide(2));

    pane.getChildren().add(circle);

    Label lbl1 = new Label("Dread");
    lbl1.setFont(Font.font("Libron Regular", FontWeight.NORMAL, 20));
    pane.getChildren().add(lbl1);

    Scene scene = new Scene(pane, 200, 200);
    primaryStage.setTitle("Show Circle centered");
    primaryStage.setScene(scene);
    primaryStage.setAlwaysOnTop(true);
    primaryStage.show();
  }

  public static void main(String[] args) {
    System.out.println(Font.getFontNames());
    launch(args);
  }
}
