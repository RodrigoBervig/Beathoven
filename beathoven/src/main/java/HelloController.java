import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

public class HelloController implements Initializable {

    FileChooser fileChooser = new FileChooser();

    public void saveSystem(File file, String content) {
        try {
            PrintWriter printWriter = new PrintWriter(file);
            printWriter.write(content);
            printWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        fileChooser.setInitialDirectory(new File("."));
    }

    @FXML
    private TextArea areaTexto;

    @FXML
    private Label welcomeText;

    @FXML
    void onSendButtonClick(MouseEvent event) {
        File file = fileChooser.showSaveDialog(new Stage());
        if (file != null) {
            saveSystem(file, areaTexto.getText());
        }
    }

    @FXML
    void onSaveMusicButtonClick(MouseEvent event) {
    }

    @FXML
    void onPlayMusicButtonClick(MouseEvent event) {
    }

    @FXML
    void onFileButtonClick(MouseEvent event) {
        File file = fileChooser.showOpenDialog(new Stage());
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                areaTexto.appendText(scanner.nextLine() + "\n");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onHelloButtonClick(ActionEvent event) {

    }

}
