public class MusicalNote {

	private String note;

	// in jfugue, the notation for a MusicalNote is of the form "B5", where B is the note and 5 is the octave
	public MusicalNote(String note) {
		this.note = note;
	}

	public String getNote(){
		return this.note;
	}
	public void setSound(String note, int octave) {
		this.note = note + octave;
	}

	public String getSound() {
		return note;
	}

}
