import org.jfugue.player.Player;
import org.jfugue.pattern.Pattern;

public class MusicPlayer {
    Player player;
    public MusicPlayer() {
        player = new Player();
    }

    public void playMusic(String musicText) {
        Pattern pattern = new Pattern(musicText);
        this.player.play(pattern);
    }

}