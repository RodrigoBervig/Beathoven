import org.jfugue.player.*;
import org.jfugue.pattern.*;
public class Beathoven {
    public static void main(String[] args) {

        // the control flux is "text field -> (button pressed) -> parser -> controller, repeat"

        TextField textField = new TextField();
        Button button = new Button();
        Parser parser = new Parser();
        MusicPlayer musicPlayer = new MusicPlayer();

        //Button pressed
        musicPlayer.playMusic(parser.parseTextToJFugue("aaaaaaaaaaaa ABABABABAAB aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa CCCCCC"));

        // add a while(true){} loop here
    }
}
