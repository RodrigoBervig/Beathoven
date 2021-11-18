package Beathoven.Utils;

public class Commands {

    public static final String PAUSE = "R";
    public static final String INSTRUMENT = "I";
    public static final String CHANGE_VOLUME = ":CON(7,";

    public static String changeInstrumentCommand (int instrument){

        return INSTRUMENT + instrument;
    }

    public static String setVolumeCommand(int volume){

        return CHANGE_VOLUME + volume + ")";
    }

}

