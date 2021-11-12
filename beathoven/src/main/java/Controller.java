import org.jfugue.player.Player;


public class Controller {

	MusicPlayer musicPlayer = new MusicPlayer();
	MusicCurrentState state = new MusicCurrentState();

	public Controller() {
		//Setting default values
		Instrument piano = new Instrument("PIANO");
		state.setInstrument(piano);
		state.setBPM(100);
		state.setVolume(10200);
		state.setOctaveOrder(5);
	}

	public void playMusic(MusicalContent[] music) {
		String musicParsedToJfugue = "";
		System.out.println(music.length);
		for(int i=0;i<music.length;i++){
			if(music[i].isMusicalNote()){

				MusicalNote note = music[i].getNote();
				System.out.println(note.getNote());
				musicParsedToJfugue += note.getNote(); // Note
				musicParsedToJfugue += state.getOctaveOrder(); // Octave
				musicParsedToJfugue += " ";

			}else{
				String[] command = music[i].getCommand();
				//Change instrument
				if(command[0] == Commands.CHANGE_INSTRUMENT.getCommand()){
					Instrument newInstrument = new Instrument(command[1]);
					state.setInstrument(newInstrument);
					musicParsedToJfugue += "I["+state.getInstrument().getName() +"] ";
				}
				//Increase or set default Octave
				if(command[0] == Commands.INCREASE_OCTAVE.getCommand()){
					int currentOctave = state.getOctaveOrder();
					if(currentOctave == state.getInstrument().getNumberOfOctaves()){
						//Default Octave
						state.setOctaveOrder(state.getInstrument().getDefaultOctave());
					}else {
						//Increase Octave
						state.setOctaveOrder(state.getOctaveOrder() + 1);
					}
				}
			}
		}

		System.out.println(musicParsedToJfugue);
		musicPlayer.playMusic(musicParsedToJfugue);
	}

	public static enum Commands {

		INCREASE_BPM("BPM+"),
		DECREASE_BPM("BPM-"),
		INCREASE_OCTAVE("T+"),
		DECREASE_OCTAVE("T-"),
		PLAY_INSTRUMENT("\n"),
		INCREASE_VOLUME("+"),
		INCREASE_DOUBLE_VOLUME("2*"),
		CHANGE_INSTRUMENT("CHANGE"),
		DECREASE_VOLUME("-"),
		SILENCE("SILENCE"),
		PLAY_RANDOM_NOTE("?"),
		REPEAT_NOTE("REPEATE");
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
