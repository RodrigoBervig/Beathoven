import Utils.Commands;
import Utils.UserInput;

public class Parser {

	MusicCurrentState state = new MusicCurrentState();

	public Parser() {
	}

	public String parseTextToJFugue(String text) {
		String jFugueCommands = "";
		for(int i = 0; i < text.length(); i++) {
			String command = "";
			String c = String.valueOf(text.charAt(i));

			if(UserInput.isNote(c)){
				if(i+4 < text.length()){
					if(text.substring(i, i+4).equals(UserInput.DECREASE_BPM)){
						state.decreaseBPM();
						command = Commands.modifyBpm(state.getBPM());
						i += 3;
					}
					else if (text.substring(i, i+4).equals(UserInput.INCREASE_BPM)){
						state.increaseBPM();
						command = Commands.modifyBpm(state.getBPM());
						i += 3;
					}
					else {
						state.setLastNotePlayed(c);
						command += c + state.getOctaveOrder();
					}
				}
				else {
					state.setLastNotePlayed(c);
					command += c + state.getOctaveOrder();
				}
			}
			else if(UserInput.isNumber(c)){
				int newInstrument = state.getInstrument() + Integer.parseInt(c);
				command = Commands.changeInstrumentCommand(newInstrument);
			}
			else if(UserInput.isPlayHarpsichord(c)){
				state.setInstrument(7);
				//HARPSICHORD
				command = Commands.changeInstrumentCommand(7);
			}
			else{
				switch (c) {
					case UserInput.DOUBLE_VOLUME:
						state.doubleVolume();
						command = Commands.setVolumeCommand(state.getVolume());
						break;
					case UserInput.SET_DEFAULT_VOLUME:
						state.setDefaultVolume();
						command = Commands.setVolumeCommand(state.getVolume());
						break;
					case UserInput.PLAY_AGOGO:
						state.setInstrument(114);
						command = Commands.changeInstrumentCommand(114);
						break;
					case UserInput.INCREASE_OCTAVE:
						state.increaseOctaveOrder();
						break;
					case UserInput.PLAY_TUBULAR_BELLS:
						state.setInstrument(15);
						//TUBULAR_BELLS
						command = Commands.changeInstrumentCommand(15);
						break;
					case UserInput.PLAY_PAN_FLUTE:
						state.setInstrument(76);
						//PAN_FLUTE
						command = Commands.changeInstrumentCommand(76);
						break;
					case UserInput.PLAY_CHURCH_ORGAN:
						state.setInstrument(20);
						//CHURCH_ORGAN
						command = Commands.changeInstrumentCommand(20);
						break;
					default:
						command = state.getLastNotePlayed();
						break;
				}
			}
			jFugueCommands += command + " ";
		}

		return jFugueCommands;
	}

}
