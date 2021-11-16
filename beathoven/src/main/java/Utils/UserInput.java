package Utils;

import java.util.regex.Pattern;

public class UserInput {

    public static final String DOUBLE_VOLUME = " ";
    public static final String PLAY_AGOGO = "!";
    public static final String INCREASE_OCTAVE = "?";
    public static final String PLAY_TUBULAR_BELLS = "\n";
    public static final String PLAY_PAN_FLUTE = ";";
    public static final String PLAY_CHURCH_ORGAN = ",";
    public static final String SET_DEFAULT_VOLUME = "-";

    public static boolean isNote(String note){

        return Pattern.compile("[A-G]").matcher(note).find();
    }

    public static boolean isNumber(String note){

        return Pattern.compile("[0-9]").matcher(note).find();
    }

    public static boolean isPlayHarpsichord(String note) {

        return Pattern.compile("[OoIiUu]").matcher(note).find();
    }

}
