public class Octave {

	private int order;

	private MusicalNote[] notes;

	private MusicalNote musicalNote;

	public Octave(int order) {
		this.order = order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public void setNotes(MusicalNote[] notes) {
		System.arraycopy(notes, 0, this.notes, 0, 8);
	}

	public int getOrder() {
		return 0;
	}

	public MusicalNote[] getNotes() {
		return notes;
	}

}
