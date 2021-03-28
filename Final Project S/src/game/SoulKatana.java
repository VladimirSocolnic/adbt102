package game;

import city.cs.engine.*;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class SoulKatana extends DynamicBody {
    private static final Shape KatanaDIM = new CircleShape(1.5f);
    private static SoundClip GotoSens;
    static {
        try {
            GotoSens = new SoundClip("data/katana.wav");
            System.out.println("Loading books sound");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }

    private static final BodyImage image =
            new BodyImage("data/katana.png", 4f);
    public SoulKatana(World w) {
        super(w, KatanaDIM);
        addImage(image);
    }

    @Override
    public void destroy()
    {
        GotoSens.play();
        super.destroy();
    }

}

