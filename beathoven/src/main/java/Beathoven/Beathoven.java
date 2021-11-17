package Beathoven;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

import org.jfugue.midi.MidiFileManager;
import org.jfugue.pattern.*;

public class Beathoven implements Initializable {

    FileChooser fileChooser = new FileChooser();

    Parser parser = new Parser();
    MusicPlayer musicPlayer = new MusicPlayer();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        fileChooser.setInitialDirectory(new File("."));
    }

    @FXML
    private TextArea textArea;

    @FXML
    void onSaveMusicButtonClick(MouseEvent event) throws IOException {
        Pattern pattern = new Pattern(parser.parseTextToJFugue(textArea.getText()));

        try {
            File filePath = fileChooser.showSaveDialog(new Stage());
            MidiFileManager.savePatternToMidi(pattern, filePath);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    void onPlayMusicButtonClick(MouseEvent event) {
        musicPlayer.playMusic(parser.parseTextToJFugue(textArea.getText()));
    }

    @FXML
    void onFileButtonClick(MouseEvent event) {
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(extFilter);
        File file = fileChooser.showOpenDialog(new Stage());

        try{
            Scanner scanner = new Scanner(file);
            while(scanner.hasNextLine()){
                textArea.setText(scanner.nextLine());
            }
        }catch(FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onHelloButtonClick(ActionEvent event) {

    }

}
