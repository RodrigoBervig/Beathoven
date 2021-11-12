public class MusicCurrentState {

	private int bpm;

	private int volume;

	private int octaveOrder;

	private MusicalNote lastNotePlayed;

	private Instrument instrument;

	public MusicCurrentState() {

	}

	public void setBPM(int bpm) {
		this.bpm = bpm;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	public void setOctaveOrder(int order) {
		this.octaveOrder = order;
	}

	public void setInstrument(Instrument instrument) {
		this.instrument = instrument;
	}

	public int getBPM() {
		return this.bpm;
	}

	public int getVolume() {
		return this.volume;
	}

	public int getOctaveOrder() {
		return this.octaveOrder;
	}

	public Instrument getInstrument() {
		return this.instrument;
	}

	public void reset() {

	}

}
