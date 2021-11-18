package Beathoven;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class BeathovenApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(BeathovenApplication.class.getResource("beathoven-view.fxml"));
        System.out.println(BeathovenApplication.class.getResource("beathoven-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Beathoven Application");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        System.out.println(BeathovenApplication.class.getResource("beathoven-view.fxml"));
        launch();
    }
}