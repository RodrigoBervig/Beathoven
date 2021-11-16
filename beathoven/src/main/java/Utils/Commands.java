package Utils;

public class Commands {

    public static final String MODIFY_BPM = "T";
    public static final String INCREASE_OCTAVE = "T+";
    public static final String DECREASE_OCTAVE = "T-";
    public static final String PLAY_INSTRUMENT = "\n";

    public static final String PAUSE = "R";
    public static final String BPM = "T";
    public static final String INSTRUMENT = "I";
    public static final String CHANGE_VOLUME = ":CON(7,";

    //public static final String CHANGE_INSTRUMENT("CHANGE"),

    //TODO: add a regex that checks if the command is of silence type

    public String commandMapping;

    Commands(String value) {
        this.commandMapping = value;
    }

    public String getCommand() {
        return commandMapping;
    }

    public static String changeInstrumentCommand (int instrument){

        return INSTRUMENT + instrument;
    }

    public static String setVolumeCommand(int volume){

        return CHANGE_VOLUME + volume + ")";
    }

}

