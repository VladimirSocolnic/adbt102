package game;

import city.cs.engine.*;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class RunStone extends DynamicBody {
    private static final Shape RunicStoneDim = new CircleShape(3);
    private static SoundClip PreFinMessage;
    static {
        try {
            PreFinMessage = new SoundClip("data/prefinal.wav");
            System.out.println("Loading books sound");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }

    private static final BodyImage image =
            new BodyImage("data/stone.png", 6f);
    public RunStone(World w) {
        super(w, RunicStoneDim);
        addImage(image);
    }

    @Override
    public void destroy()
    {
        PreFinMessage.play();
        super.destroy();
    }

}

