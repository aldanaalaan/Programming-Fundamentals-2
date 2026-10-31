import javafx.application.Application;
import javafx.scene.layout.Pane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ShowImage extends Application{
    @Override
    public void start(Stage primaryStage){
        Pane pane = new HBox(10);
        pane.setPadding(new Insets(5, 5, 5, 5));

        Image image = new Image("resources/origin/avatar_size.png");
        pane.getChildren().add(new ImageView(image));

        ImageView view =new ImageView(image);
        view.setRotate(45);
        view.setFitHeight(300);
        view.setFitWidth(20);
        pane.getChildren().add(view);

        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Image");
        primaryStage.setAlwaysOnTop(true);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
