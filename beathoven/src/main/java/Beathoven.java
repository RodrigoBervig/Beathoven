import org.jfugue.player.*;
import org.jfugue.pattern.*;
public class Beathoven {
    public static void main(String[] args) {

        // the control flux is "text field -> (button pressed) -> parser -> controller, repeat"

        TextField textField = new TextField();
        Button button = new Button();
        Parser parser = new Parser();
        Controller controller = new Controller();

        //Button pressed
        controller.playMusic(parser.parseText("A B ; A C o G A B ! C D ? A B C ? A B C"));


        // add a while(true){} loop here
    }
}
