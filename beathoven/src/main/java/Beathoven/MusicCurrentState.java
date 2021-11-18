package Beathoven;

public class MusicCurrentState {

	private static final int defaultOctave = 5;

	private static final int defaultVolume = 50;

	private static final int maxVolume = 127;

	private static final int defaultInstrument = 0;

	private int volume = 50;

	private int octaveOrder = 5;

	private String lastUserInput = "";

	private int instrument = 0;

	public MusicCurrentState() {
	}

	public void setDefaultVolume(){
		this.volume = defaultVolume;
	}

	public void increaseOctaveOrder() {
		int increasedOctave = this.octaveOrder++;

		if (increasedOctave <= 10){
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
		if(this.instrument < 128) {
			this.instrument = instrument;
		}
		else this.instrument = defaultInstrument;
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

	public void setLastUserInput(String input) {
		this.lastUserInput = input;
	}

	public String getLastUserInput(){
		return this.lastUserInput;
	}

}
