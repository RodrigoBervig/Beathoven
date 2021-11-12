public class Instrument {

	private int numberOfOctaves;

	private int defaultOctave = 5;

	private Octave[] notes;

	private String name;

	public Instrument(String name) {
		this.name = name;
		this.numberOfOctaves = 9;
		this.defaultOctave = 5;
	}

	public int getNumberOfOctaves() {
		return this.numberOfOctaves;
	}

	public int getDefaultOctave(){
		return this.defaultOctave;
	}

	public String getName(){
		return this.name;
	}

	public void setOctave(int octaveOrder, Octave octave) {

	}


	public Octave getOctave(int octaveOrder) {
		return null;
	}

}
