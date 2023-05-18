import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FitnessAppApplication extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception { // Az alkalmazás kezdeti felületének betöltése és megjelenítése
        Parent root = FXMLLoader.load(getClass().getResource("menu.fxml"));
        primaryStage.setTitle("Fitness App");
        primaryStage.setScene(new Scene(root, 500, 500));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    } //Az alkalmazás indítása
}
