package Beathoven;

import Beathoven.Utils.Commands;
import Beathoven.Utils.UserInput;

public class Parser {

	MusicCurrentState state = new MusicCurrentState();

	public Parser() {
	}

	public String parseTextToJFugue(String text) {
		String jFugueCommands = "";
		for(int i = 0; i < text.length(); i++) {
			String c = String.valueOf(text.charAt(i));
			jFugueCommands += findCommand(c) + " ";
			state.setLastUserInput(c);
		}

		return jFugueCommands;
	}

	private String findCommand(String c){
		String command = "";
		if(UserInput.isNote(c)){
			command += c + state.getOctaveOrder();
		}
		else if(UserInput.isNumber(c)){
			int newInstrument = state.getInstrument() + Integer.parseInt(c);
			state.setInstrument(newInstrument);
			command = Commands.changeInstrumentCommand(state.getInstrument());
		}
		else if(UserInput.isPlayHarpsichord(c)){
			state.setInstrument(7);
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
				case UserInput.INCREASE_OCTAVE_INPUT_1:
				case UserInput.INCREASE_OCTAVE_INPUT_2:
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
					String lastInput = state.getLastUserInput();
					if(UserInput.isNote(lastInput)){
						command = lastInput + state.getOctaveOrder();
					}
					else command = Commands.PAUSE;
					break;
			}
		}
		return command;
	}

}
