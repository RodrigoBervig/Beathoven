public class MusicalContent {

	private MusicalNote note;

	private String command;

	public MusicalContent(MusicalNote note) {
		this.note = note;
	}

	public MusicalContent(String command) {
		this.command = command;
	}

	public boolean isMusicalNote() {
		return this.command == null;
	}

}
