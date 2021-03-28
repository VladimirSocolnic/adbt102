package game;

import city.cs.engine.*;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class Scrolls extends DynamicBody {
    private static final Shape ScrollDimension = new CircleShape(1);
    private static SoundClip ScrollPick;
    static {
        try {
            ScrollPick = new SoundClip("data/scrollpick.wav");
            System.out.println("Loading books sound");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }

    private static final BodyImage image =
            new BodyImage("data/scroll.png", 2f);
    public Scrolls(World w) {
        super(w, ScrollDimension);
        addImage(image);
    }

    @Override
    public void destroy()
    {
        ScrollPick.play();
        super.destroy();
    }

}

