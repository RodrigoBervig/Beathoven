public class Parser {

	public Parser() {

	}

	public MusicalContent[] parseText(String text) {
		MusicalContent[] musicContents = new MusicalContent[text.length()];
		for(int i = 0; i < text.length(); i++){
				char c = text.charAt(i);
				MusicalContent content = null;
				MusicalNote nota;
				String[] comm;
				switch (c){
					case 'A':
						nota = new MusicalNote("A");
						content = new MusicalContent(nota);
						break;
					case 'B':
						nota = new MusicalNote("B");
						content = new MusicalContent(nota);
						break;
					case 'C':
						nota = new MusicalNote("C");
						content = new MusicalContent(nota);
						break;
					case 'D':
						nota = new MusicalNote("D");
						content = new MusicalContent(nota);
						break;
					case 'E':
						nota = new MusicalNote("E");
						content = new MusicalContent(nota);
						break;
					case 'F':
						nota = new MusicalNote("F");
						content = new MusicalContent(nota);
						break;
					case 'G':
						nota = new MusicalNote("G");
						content = new MusicalContent(nota);
						break;
					case ' ':
						comm = new String[]{Controller.Commands.INCREASE_DOUBLE_VOLUME.getCommand()};
						content = new MusicalContent(comm);
						break;
					case '!':
						comm = new String[]{Controller.Commands.CHANGE_INSTRUMENT.getCommand(),"AGOGO"}; //MIDI #114 (Agogo)
						content = new MusicalContent(comm);
						break;
					case 'O':
					case 'o':
					case 'I':
					case 'i':
					case 'U':
					case 'u':
						comm = new String[]{Controller.Commands.CHANGE_INSTRUMENT.getCommand(), "HARPSICHORD"}; //MIDI #7 (Harpsichord)
						content = new MusicalContent(comm);
						break;
					case '?':
						comm = new String[]{Controller.Commands.INCREASE_OCTAVE.getCommand()}; //INCREASE OCTAVE
						content = new MusicalContent(comm);
						break;
					case '\n':
						comm = new String[]{Controller.Commands.CHANGE_INSTRUMENT.getCommand(), "TUBULAR_BELLS"}; //MIDI #15 (Tubular Bells)
						content = new MusicalContent(comm);
						break;
					case ';':
						comm = new String[]{Controller.Commands.CHANGE_INSTRUMENT.getCommand(), "PAN_FLUTE"}; //MIDI #76 (Pan Flute)
						content = new MusicalContent(comm);
						break;
					case ',':
						comm = new String[]{Controller.Commands.CHANGE_INSTRUMENT.getCommand(), "CHURCH_ORGAN"}; //MIDI #20 (Church Organ)
						content = new MusicalContent(comm);
						break;
					default:
						if(i > 0){
							if(musicContents[i-1].isMusicalNote()){ //If the last character is a musical note
								comm = new String[]{Controller.Commands.REPEAT_NOTE.getCommand()}; //Repeate note
							}else{
								comm = new String[]{Controller.Commands.SILENCE.getCommand()}; //Silence
							}
						}
				}

				musicContents[i] = content;


		}
		return musicContents;
	}

}
