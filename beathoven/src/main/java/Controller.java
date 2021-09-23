import org.jfugue.player.Player;

public class Controller {

	public Controller() {

	}

	public void playMusic(MusicalContent[] music) {

	}

	private class MusicPlayer {

		public MusicPlayer() {
			Player player = new Player();
		}

		public void playNote(MusicalNote note) {

		}

	}

	public enum Commands {

		increaseBPM,

		decreaseBPM,

		increaseOctave,

		decreaseOctave,

		playInstrument,

		increaseVolume,

		decreaseVolume,

		playRandomNote,

		repeateNote;

	}

}
