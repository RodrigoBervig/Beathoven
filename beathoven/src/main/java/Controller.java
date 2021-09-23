import org.jfugue.player.Player;

public class Controller {

	public Controller() {

	}

	public void playMusic(MusicalContent[] music) {

	}

	private enum Commands {

		INCREASE_BPM("BPM+"),
		DECREASE_BPM("BPM-"),
		INCREASE_OCTAVE("T+"),
		DECREASE_OCTAVE("T-"),
		PLAY_INSTRUMENT("\n"),
		INCREASE_VOLUME("+"),
		DECREASE_VOLUME("-"),
		SILENCE(" "),
		PLAY_RANDOM_NOTE("?"),
		REPEAT_NOTE("['O','o','I','i']");
		//TODO: add a regex that checks if the command is of silence type

		public String commandMapping;

		Commands(String value) {
			this.commandMapping = value;
		}

		public String getCommand() {
			return commandMapping;
		}

	}

}
