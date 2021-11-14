public class MusicCurrentState {

	private static final int defaultOctave = 5;

	private static final int defaultVolume = 50;

	private static final int maxVolume = 127;

	private static final int defaultBpm = 120;

	private int bpm;

	private int volume = 50;

	private int octaveOrder = 5;

	private String lastNotePlayed;

	private int instrument = 0;

	public MusicCurrentState() {
		this.bpm = defaultBpm;

	}

	public void setBPM(int bpm) {
		this.bpm = bpm;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	public void setDefaultVolume(){
		this.volume = defaultVolume;
	}
	public void increaseOctaveOrder() {
		int increasedOctave = this.octaveOrder++;

		if (increasedOctave < 10){
			this.octaveOrder = increasedOctave;
		}
		else{
			this.octaveOrder = defaultOctave;
		}
	}

	public void doubleVolume() {
		int increasedVolume = 2*this.volume;
		if(increasedVolume > maxVolume){
			this.volume = defaultVolume;
		}
		else this.volume = increasedVolume;
	}

	public void setInstrument(int instrument) {
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

	public int getInstrument() {
		return this.instrument;
	}

	public void setLastNotePlayed(String note) {
		this.lastNotePlayed = note;
	}

	public String getLastNotePlayed(){
		return this.lastNotePlayed;
	}

	public void reset() {

	}

	public void increaseBPM(){
		this.bpm += 50;
	}

	public void decreaseBPM(){
		this.bpm -= 50;
		if (this.bpm < 1) this.bpm = defaultBpm;
	}

}
